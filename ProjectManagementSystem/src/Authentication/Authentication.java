/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import Accounts.Account;
import Accounts.Admin;
import Accounts.Client;
import Accounts.Faculty;
import Accounts.Student;
import DatabaseConnection.ConnectToDatabase;
import views.Faculty_Home;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectManagementSystem.*;
import strategyPattern_display.DisplayStrategyContext;
import views.Admin_Home;
import views.Client_Home;
import views.IDisplayMessage;
import views.Student_Home;

/**
 *
 * @author Sachin Shinde
 */

// This class is used for user Authentication
public class Authentication {
    
    private String userId;
    private String password;
    private IDisplayMessage currentScreen;
    public Authentication(String userId, String password, IDisplayMessage currentScreen){
        this.userId = userId;
        this.password = password;
        this.currentScreen = currentScreen;
    }
    
    public String getUserId(){
        return this.userId;
    }
    
    // Authenticates the user
    public void authenticate(){
        PreparedStatement preparedStatement=null;
        ResultSet resultSetLogin = null;
        ResultSet resultSetAccount = null;
        boolean loginFlag=false;
        Account loggedInUser=null;
        ConnectToDatabase connectToDatabase = new ConnectToDatabase();
        Connection connection = connectToDatabase.getConnection();
        DisplayStrategyContext displayStrategyContext = null;
        String sql="";
        try {
            // To check if the user id and password are valid
            sql = "SELECT * FROM login WHERE user_id='"+this.userId+"'";
            preparedStatement = connection.prepareStatement(sql);
            resultSetLogin = preparedStatement.executeQuery();
            while(resultSetLogin.next()){
                if(!resultSetLogin.getNString("password").toString().equals(this.password)){
                    break;
                }
                // To fetch account details
                sql="SELECT * FROM accounts WHERE user_id='"+this.userId+"'";
                preparedStatement = connection.prepareStatement(sql);
                resultSetAccount = preparedStatement.executeQuery();
                
                while(resultSetAccount.next()){
                    // Setting the current userid and role in global session
                    projectManagementSystem.ProjectManagementGlobalSession.user_id = this.userId;
                    projectManagementSystem.ProjectManagementGlobalSession.user_role = resultSetAccount.getNString("user_role");
                    loginFlag=true;
                    displayStrategyContext = new DisplayStrategyContext(resultSetAccount.getNString("user_role"));
                    break;
                }
                break;
            } 
            resultSetLogin.close();

            // If user login credentials are valid
            if(loginFlag){
                ProjectManagementGlobalSession.centralPanel.removeAll();
                
                // If the role is admin then navigate to admin screen
                // Admin
                if(ProjectManagementGlobalSession.user_role.equalsIgnoreCase("admin")){
                    // Creating admin object and setting the fields from the fetched table data
                    Admin admin = new Admin();
                    admin.setUserId(resultSetAccount.getNString("user_id"));
                    admin.setUserName(resultSetAccount.getNString("user_name"));
                    admin.setUserEmail(resultSetAccount.getNString("user_email"));
                    admin.setUserPhone(resultSetAccount.getNString("user_phone"));
                    admin.setUserRole(resultSetAccount.getNString("user_role"));
                    
                    // Setting the loggedInUser global variable
                    ProjectManagementGlobalSession.loggedInUser = admin;
                    
                    
                    // Setting the new page
                    ProjectManagementGlobalSession.centralPanel.add(displayStrategyContext.getMyPage());
                    ProjectManagementGlobalSession.centralPanel.updateUI();
                }
                
                // If the role is admin then navigate to Student screen
                // student
                if(ProjectManagementGlobalSession.user_role.equalsIgnoreCase("student")){
                    Student student = new Student(resultSetAccount.getNString("user_id"), 
                            resultSetAccount.getNString("user_name"), 
                            resultSetAccount.getNString("user_role"), 
                            resultSetAccount.getNString("user_email"), 
                            resultSetAccount.getNString("user_phone"));
                     // Setting the loggedInUser global variable
                    ProjectManagementGlobalSession.loggedInUser = student;
                    
                    // Setting the new page
                    ProjectManagementGlobalSession.centralPanel.add(displayStrategyContext.getMyPage());
                    ProjectManagementGlobalSession.centralPanel.updateUI();
                }
                
                // If the role is admin then navigate to faculty screen
                // faculty
                if(ProjectManagementGlobalSession.user_role.equalsIgnoreCase("faculty")){
                    Faculty faculty = new Faculty(resultSetAccount.getNString("user_id"), 
                            resultSetAccount.getNString("user_name"), 
                            resultSetAccount.getNString("user_role"), 
                            resultSetAccount.getNString("user_email"), 
                            resultSetAccount.getNString("user_phone"));
                    
                    
                    // Setting the loggedInUser global variable
                    ProjectManagementGlobalSession.loggedInUser = faculty;
                    
                    // Setting the new page
                    ProjectManagementGlobalSession.centralPanel.add(displayStrategyContext.getMyPage());
                    ProjectManagementGlobalSession.centralPanel.updateUI();
                }
                
                // If the role is admin then navigate to client screen
                // client
                if(ProjectManagementGlobalSession.user_role.equalsIgnoreCase("client")){
                    
                    Client client = new Client(resultSetAccount.getNString("user_id"), 
                            resultSetAccount.getNString("user_name"), 
                            resultSetAccount.getNString("user_role"), 
                            resultSetAccount.getNString("user_email"), 
                            resultSetAccount.getNString("user_phone"));
                    
                    
                    // Setting the loggedInUser global variable
                    ProjectManagementGlobalSession.loggedInUser = client;
                    
                    // Setting the new page
                    ProjectManagementGlobalSession.centralPanel.add(displayStrategyContext.getMyPage());
                    ProjectManagementGlobalSession.centralPanel.updateUI();
                }
                
                resultSetAccount.close();
            }else{
                // If the credentials are invalid then show error message to the user
                currentScreen.displayMessage("Invalid UserID and Password");
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                
        
    }
}
