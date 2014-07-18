package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ApplicationModel;
import model.LoginModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	private LoginModel loginModel;
	
	 /**
     * This method will be called from LoginController if the user is validated.
     * @param request
     * @param response
     * @return
     */
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response){
		ApplicationModel applicationModel = new ApplicationModel();
		loginModel=(LoginModel) request.getSession().getAttribute("user");
		applicationModel.setLoginModel(loginModel);
		return new ModelAndView("success","applicationModel",applicationModel);
	}

}
