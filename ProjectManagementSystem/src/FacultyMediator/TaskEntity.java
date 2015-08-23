package FacultyMediator;

import DatabaseConnection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectBuilder.Project;
import projectManagementSystem.ProjectManagementGlobalSession;
import taskBuilder.Task;
import views.Admin_UserListPage;

/**
 *
 * @author Sachin Shinde
 */
public class TaskEntity implements Entity{
    
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
            sql="SELECT * FROM task where project_id IN (SELECT project_id from project WHERE faculty_id='"+ProjectManagementGlobalSession.user_id+"')";

            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSetLogin = preparedStatement.executeQuery();
                
                while(resultSetLogin.next()){
                    Task  task = new  Task();
                    task.setProjectId(resultSetLogin.getNString("project_id"));
                    task.setTaskId(resultSetLogin.getNString("task_id"));
                    task.setTaskDescription(resultSetLogin.getNString("task_description"));
                    task.setStudentId(resultSetLogin.getNString("student_id"));
                    task.setStartDate(resultSetLogin.getDate("start_date"));
                    task.setEndDate(resultSetLogin.getDate("end_date"));
                    
                    arrayList.add(task);

                    }
                resultSetLogin.close();
            } catch (SQLException ex) {
                Logger.getLogger(Admin_UserListPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            return arrayList;
    }
}
