package maurogiuseppe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDAO
{
    static Connection conn;
 
    /**
     * This method returns the connection object.
     * @return Connection
     */
    public static Connection getConnection()
    {
        try
        {
            String url = "url";// e.g. jdbc:mysql://localhost:3306/
            String dbName ="db_Name"; // here the name of Database.
            String uname = "uname"; //username
            String pwd = "password"; //password
 
            //MySQL jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            try
            {
                if(null==conn){
                    conn = DriverManager.getConnection(url+dbName,uname,pwd);
                }
            }
            catch (SQLException ex)
            {
                System.out.println("SQL Exception occurred while getting connection object. \nDetails : "+ ex.getMessage());
            }
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Exception occurred while getting connection object. \nDetails : "+ e.getMessage());
        }
        return conn;
    }
 
    /**
     * This method returns the Statement object to execute any SQL query.
     * @return
     */
    public static Statement getStatement()
    {
        Statement stmt = null;
        try
        {
            Connection connection = ConnectionDAO.getConnection();
            stmt=connection.createStatement();
        }
        catch (SQLException e) {
            System.out.println("Exception occurred while getting Statement object. \nDetails : "+ e.getMessage());
        }
        return stmt;
    }
}