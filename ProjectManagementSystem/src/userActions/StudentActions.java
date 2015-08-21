
package userActions;

import Accounts.Admin;
import DatabaseConnection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectBuilder.Project;
import taskBuilder.Task;
import views.Admin_UserListPage;

/**
 *
 * @author Sachin Shinde
 */

//This class defines student actions

public class StudentActions {
    
    
    //This method fetches list of projects
    public ArrayList fetchProjets(){
        ArrayList arrayList  = new ArrayList();
        
            PreparedStatement preparedStatement=null;
            ResultSet resultSetLogin = null;


            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            String sql="";

            // To check if the user id already exists
            sql = "SELECT * FROM project WHERE project_id IN (SELECT project_id from project_members where user_id='"+projectManagementSystem.ProjectManagementGlobalSession.user_id+"')";
            
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

        // This method fetches list of tasks
    public ArrayList fetchTasks(){
        ArrayList arrayList  = new ArrayList();
        
            PreparedStatement preparedStatement=null;
            ResultSet resultSetLogin = null;


            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            String sql="";

            // To check if the user id already exists
            sql = "SELECT * FROM task WHERE student_id='"+projectManagementSystem.ProjectManagementGlobalSession.user_id+"'";
            System.out.println(sql);
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSetLogin = preparedStatement.executeQuery();
                Date date = new Date();
                while(resultSetLogin.next()){
                        Task task = new Task();
                        task.setProjectId(resultSetLogin.getNString("project_id"));
                        task.setTaskId(resultSetLogin.getNString("task_id"));
                        task.setStartDate(resultSetLogin.getDate("start_date"));
                        task.setEndDate(resultSetLogin.getDate("end_date"));
                        task.setTaskDescription(resultSetLogin.getNString("task_description"));
                        task.setStudentId(resultSetLogin.getNString("student_id"));
                        
                        if(date.before(task.getEndDate())){
                            arrayList.add(task);
                        }

                        
                    }
                resultSetLogin.close();
            } catch (SQLException ex) {
                Logger.getLogger(Admin_UserListPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        return arrayList;
    }

    public boolean markAsComplete(String taskId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date  = new Date();
	
        try {
                Statement statement=null;
                String sql="";
                ConnectToDatabase connectToDatabase = new ConnectToDatabase();
                Connection connection = connectToDatabase.getConnection();

                statement=connection.createStatement();
                sql="UPDATE task SET end_date='"+sdf.format(date.getDate())+"' WHERE task_id='"+taskId+"'";
                System.out.println(sql);
                if(statement.executeUpdate(sql) > 0){
                    return true;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }

}

    


