package service;

import model.LoginModel;

public interface LoginService {
	 
    public boolean validate(LoginModel loginModel);
}