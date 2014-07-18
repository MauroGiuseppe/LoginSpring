package dao;

import model.LoginModel;

public interface LoginDAO {
	 
    public boolean validate(LoginModel loginModel);
}