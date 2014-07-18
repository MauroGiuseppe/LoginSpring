package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import model.LoginModel;

public class LoginController {

	/**
	 * create the loginModel
	 */
	private LoginModel loginModel;

	@Autowired
	private LoginService loginService;

	/**
	 * this method willo load starts when the application starts
	 * 
	 */
	public ModelAndView init() {
		loginModel = new LoginModel();
		return new ModelAndView("login", "loginDetails", loginModel);

	}

	/**
	 * This method will be called when the user submits the login details from
	 * login.jsp page. If there is any error it will be displayed on the same
	 * page, if the user is valid then, will be redirected to success page.
	 * 
	 * @param loginModel
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView login(@ModelAttribute("loginDetails")LoginModel loginModel,BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response) {

		try {
			// Using Spring ValidationUtils class to check for empty fields.
			// This will add the error if any in the bindingResult object
			ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "username","username","USERNAME CAN NOT EMPTY");
			ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "password","password","PASSWORD CAN NOT EMPTY");
			if(bindingResult.hasErrors()){
				/**
				 * return the errors on same page if any error
				 */
				return new ModelAndView("login", "loginDetails", loginModel);
			}else{
				/**
				 * if the user details is validated then redirecting to success page
				 * else returnin the error message on login page
				 */
				if(loginService.validate(loginModel)){
					
					request.getSession().setAttribute("user", loginModel);
					//Creating a redirection view to success page. 
					//This will redirect to UsersController
					RedirectView redirectView = new RedirectView("success.do",true);
					return new ModelAndView(redirectView);
				}else{
					bindingResult.addError(new ObjectError("Invalid", "Invalid credentials "+ "Username or password incorrect. "));
					return new ModelAndView("login","loginDetails",loginModel);
				}
				
			}
		} catch (Exception e) {
			System.out.println("Exception in loginController " + e.getMessage());
			e.printStackTrace();
			return new ModelAndView("login","loginDetails",loginModel);
		}
		
	}

}
