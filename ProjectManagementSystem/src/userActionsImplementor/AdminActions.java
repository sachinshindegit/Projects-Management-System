package userActionsImplementor;

import Accounts.Account;
import DatabaseConnection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sachin Shinde
 */

// This class implements actions which admin user can perform
public class AdminActions extends UserActions{
    
    
    // This method is used to create a new user account
    public void createAccount(Account account,String password){
        Statement statement=null;
        String sql="";
        ConnectToDatabase connectToDatabase = new ConnectToDatabase();
        Connection connection = connectToDatabase.getConnection();
        try {
            statement=connection.createStatement();
            sql="INSERT INTO accounts VALUES('"+account.getUserId()+"','"+account.getUserName()+"','"+account.getUserRole()+"','"+account.getUserEmail()+"','"+account.getUserPhone()+"')";
            statement.executeQuery(sql);
            sql="INSERT INTO login VALUES('"+account.getUserId()+"','"+password+"')";
            statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AdminActions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
}
