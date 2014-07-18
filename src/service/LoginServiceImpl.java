package service;

import model.LoginModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDAO loginDAO;
 
    public boolean validate(LoginModel loginModel) {
        return loginDAO.validate(loginModel);
    }
 
}