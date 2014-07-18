package maurogiuseppe.service;

import maurogiuseppe.model.LoginModel;

public interface LoginService {
	 
    public boolean validate(LoginModel loginModel);
}