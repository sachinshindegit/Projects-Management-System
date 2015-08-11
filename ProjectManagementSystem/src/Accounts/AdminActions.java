package Accounts;

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

// This class has actions which admin can perform
public class AdminActions {
   // This method is used to create a new user account
    public void createAccount(Account account,String password){
        try {
            Statement statement=null;
            String sql="";
            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            
            statement=connection.createStatement();
            sql="INSERT INTO accounts VALUES('"+account.getUserId()+"','"+account.getUserName()+"','"+account.getUserRole()+"','"+account.getUserEmail()+"','"+account.getUserPhone()+"')";
            statement.executeUpdate(sql);
            sql="INSERT INTO login VALUES('"+account.getUserId()+"','"+password+"')";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // This method is used to update an existing user account
    public void updateAccount(Account account,String password){
        try {
            Statement statement=null;
            String sql="";
            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            
            statement=connection.createStatement();
            sql="UPDATE accounts SET user_name='"+account.getUserName()+"',user_role='"+account.getUserRole()+"',user_email='"+account.getUserEmail()+"', user_phone='"+account.getUserPhone()+"' WHERE user_id='"+account.getUserId()+"'";
            System.out.println(sql);
            statement.executeUpdate(sql);
            sql="UPDATE login SET password='"+password+"' WHERE user_id='"+account.getUserId()+"'";
            System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // This method is used to delete an existing user account
    public void deleteAccount(String userId){
        try {
            Statement statement=null;
            String sql="";
            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            
            statement=connection.createStatement();
            sql="DELETE FROM login WHERE user_id='"+userId+"'";
            statement.executeUpdate(sql);
            sql="DELETE FROM accounts WHERE user_id='"+userId+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
