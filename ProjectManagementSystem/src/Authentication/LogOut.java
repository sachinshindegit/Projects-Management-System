
package Authentication;

import views.Login_Page;

/**
 *
 * @author Sachin Shinde
 */

// Logging out
public class LogOut {
    
    // This method will log out the user and navigate back to login screen
    public void logOut(){
        projectManagementSystem.ProjectManagementGlobalSession.user_id=null;
        projectManagementSystem.ProjectManagementGlobalSession.user_role=null;
        projectManagementSystem.ProjectManagementGlobalSession.loggedInUser=null;
        projectManagementSystem.ProjectManagementGlobalSession.centralPanel.removeAll();
        projectManagementSystem.ProjectManagementGlobalSession.centralPanel.add(new Login_Page());
        projectManagementSystem.ProjectManagementGlobalSession.centralPanel.updateUI();
    }
}
