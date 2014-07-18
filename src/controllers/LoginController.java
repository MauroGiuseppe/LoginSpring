package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView init(){
		loginModel=new LoginModel();
		return new ModelAndView("login","loginDetails",loginModel);
		
	}
	
	public ModelAndView login(){
		
	}
	

}
