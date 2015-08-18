package userActions;

import Accounts.Account;
import Accounts.Admin;
import DatabaseConnection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import projectBuilder.Project;
import projectManagementSystem.ProjectManagementGlobalSession;
import views.Admin_UserListPage;

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
    
    // This method lists Projects for the admin user based on type (current, completed and upcoming)
    public ArrayList fetchProjects(String projectType){
        ArrayList arrayList  = new ArrayList();
        
            PreparedStatement preparedStatement=null;
            ResultSet resultSetLogin = null;


            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            String sql="";

            // To check if the user id already exists
            sql = "SELECT * FROM project";
            
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSetLogin = preparedStatement.executeQuery();
                Date date = new Date();
                while(resultSetLogin.next()){
                        Project project = new Project();
                        project.setProjectId(resultSetLogin.getNString("project_id"));
                        project.setProjectName(resultSetLogin.getNString("project_name"));
                        project.setProjectDescription(resultSetLogin.getNString("project_description"));
                        project.setClientId(resultSetLogin.getNString("client_id"));
                        project.setFacultyId(resultSetLogin.getNString("faculty_id"));
                        project.setStartDate(resultSetLogin.getDate("start_date"));
                        project.setEndDate(resultSetLogin.getDate("end_date"));
                        
                        switch(projectType){
                            case "current":
                                if(date.before(project.getEndDate()) && date.after(project.getStartDate())){
                                    arrayList.add(project);
                                }
                                break;
                            case "upcoming":
                                if(date.before(project.getStartDate())){
                                    arrayList.add(project);
                                }
                                break;
                            case "completed":
                                if(date.after(project.getEndDate())){
                                    arrayList.add(project);
                                }
                                break;
                            default:
                                
                        }
                        
                    }
                resultSetLogin.close();
            } catch (SQLException ex) {
                Logger.getLogger(Admin_UserListPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        return arrayList;
    }
}
