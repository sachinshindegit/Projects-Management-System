package FacultyMediator;

import DatabaseConnection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

// This class defines project as an entity
public class ProjectEntity implements Entity{
    
    
    // This method returns a list of entities
    @Override
    public ArrayList getEntityList() {
        ArrayList arrayList = new ArrayList();
        PreparedStatement preparedStatement=null;
            ResultSet resultSetLogin = null;
            boolean loginFlag=false;

            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            String sql="";

            // To check if the user id already exists
            sql = "SELECT * FROM project WHERE faculty_id='"+ProjectManagementGlobalSession.user_id+"'";
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSetLogin = preparedStatement.executeQuery();
                
                while(resultSetLogin.next()){
                    Project  project = new  Project();
                    project.setProjectId(resultSetLogin.getNString("project_id"));
                    project.setProjectName(resultSetLogin.getNString("project_name"));
                    project.setProjectDescription(resultSetLogin.getNString("project_description"));
                    project.setClientId(resultSetLogin.getNString("client_id"));
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
