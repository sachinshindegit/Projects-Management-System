
package projectManagementSystem;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.UIManager;
import Accounts.LoggedInUser;
import javax.naming.Context;
import views.IDisplayMessage;
import views.Login_Page;
import views.MainWindow;


/**
 *
 * @author Sachin Shinde
 */
public class ProjectManagementGlobalSession {
    
    public static String user_id; // user ID of the logged in User
    public static String user_role; // role of the logged in user
    public static MainWindow window;
    public static JPanel centralPanel;
    public static LoggedInUser loggedInUser; // To hold the logged in user details
    public static Object context;
    
    
    public ProjectManagementGlobalSession(){
       
    }
    public void loadLoginPage(){
        
    }
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 user_id=null;
                 window=new MainWindow();
                 window.setVisible(true);
                 centralPanel=window.getCentralPanel();
                 centralPanel.setLayout(new java.awt.BorderLayout());
                 window.setResizable(false);
                 window.setLocationRelativeTo(null);
                 
                 centralPanel.add(new Login_Page());
                 
                
            }
        });
    
     }
}
