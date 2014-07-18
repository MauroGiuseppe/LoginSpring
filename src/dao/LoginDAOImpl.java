package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.LoginModel;

import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
 
    @Override
    public boolean validate(LoginModel loginModel)
    {
        String SQL = "SELECT * FROM users WHERE userName = '"+loginModel.getUsername()+"' and password = '"+loginModel.getPassword()+"';";
        System.out.println("SQL : "+ SQL);
        Statement stmt;
        try
        {
            stmt = ConnectionDAO.getStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (null!= rs && rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception : "+e.getMessage());
            return false;
        }
    }
}