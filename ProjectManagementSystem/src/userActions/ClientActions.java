
package userActions;

import DatabaseConnection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectBuilder.Project;
import views.Admin_UserListPage;

/**
 *
 * @author Sachin Shinde
 */

// This class defines set of actions which client can perform
public class ClientActions {
    
    public ArrayList fetchProject(){
        ArrayList arrayList  = new ArrayList();
        
            PreparedStatement preparedStatement=null;
            ResultSet resultSetLogin = null;


            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            String sql="";

            // To check if the user id already exists
            sql = "SELECT * FROM project WHERE client_id='"+projectManagementSystem.ProjectManagementGlobalSession.user_id+"'";
            
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
                        
                        arrayList.add(project);
                    }
                resultSetLogin.close();
            } catch (SQLException ex) {
                Logger.getLogger(Admin_UserListPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        return arrayList;
    }
}

