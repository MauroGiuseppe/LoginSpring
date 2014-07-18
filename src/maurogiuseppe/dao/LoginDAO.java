package maurogiuseppe.dao;

import maurogiuseppe.model.LoginModel;

public interface LoginDAO {
	 
    public boolean validate(LoginModel loginModel);
}