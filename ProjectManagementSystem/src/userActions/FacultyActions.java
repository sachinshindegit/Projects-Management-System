
package userActions;

import Accounts.Admin;
import Accounts.Student;
import DatabaseConnection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectBuilder.Project;
import projectGroup.ProjectGroup;
import projectGroup.StudentMember;
import projectManagementSystem.ProjectManagementGlobalSession;
import taskBuilder.Task;

/**
 *
 * @author Sachin Shinde
 */
// This class define set of actions for faculty
public class FacultyActions {
    private ProjectGroup projectGroup = null;
    private String projectId = null;
    
    
    public FacultyActions(){
        this.projectGroup = new ProjectGroup();
    }
    
    public FacultyActions(ProjectGroup projectGroup){
        this.projectGroup = projectGroup;
    }
    
    public void setProjectId(String id){
        this.projectId = id;
    }
    
    public String getProjectId(){
        return this.projectId;
    }
    
    // To add project member to the group
    public void addMembers(StudentMember studentMember){
        projectGroup.add(studentMember);
    }
    
    // To remove project member from the group
    public boolean removeMembers(Student student){
        return projectGroup.remove(student);
    }
    
    // To insert members list in the database
    public void addMembersToDatabase(String projectId){
        LinkedList list = projectGroup.membersList;
        StudentMember mem = null;
        for(int i=0;i<list.size();i++){
            mem = (StudentMember)list.get(i);
            try {
                Statement statement=null;
                String sql="";
                ConnectToDatabase connectToDatabase = new ConnectToDatabase();
                Connection connection = connectToDatabase.getConnection();

                statement=connection.createStatement();
                sql="INSERT INTO project_members VALUES('"+projectId+"','"+mem.getStudent().getUserId()+"')";
                statement.executeUpdate(sql);
                System.out.println(sql);
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean registerProject(Project project){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
        try {
                Statement statement=null;
                String sql="";
                ConnectToDatabase connectToDatabase = new ConnectToDatabase();
                Connection connection = connectToDatabase.getConnection();

                statement=connection.createStatement();
                sql="INSERT INTO PROJECT VALUES('"+project.getProjectId()+"','"+project.getProjectName()+
                        "','"+project.getProjectDescription()+"','"+project.getClientId()+"','"+sdf.format(project.getStartDate())+"','"+sdf.format(project.getEndDate())+"','"+ProjectManagementGlobalSession.user_id+"')";
                System.out.println(sql);
                if(statement.executeUpdate(sql) > 0){
                    return true;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
        
    }
    
    // deletes project member from the group
    public void deleteMember(String projectId,String userId){
        try {
            Statement statement=null;
            String sql="";
            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            
            statement=connection.createStatement();
            sql="DELETE FROM project_members WHERE user_id='"+userId+"' and project_id='"+projectId+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // This function is for deleting a project from project table
    public void deleteProject(String projectId){
        try {
            Statement statement=null;
            String sql="";
            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            
            statement=connection.createStatement();
            sql="DELETE FROM project WHERE project_id='"+projectId+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // To update existing project
    
    public boolean updateProject(Project project){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
        try {
                Statement statement=null;
                String sql="";
                ConnectToDatabase connectToDatabase = new ConnectToDatabase();
                Connection connection = connectToDatabase.getConnection();

                statement=connection.createStatement();
                sql="UPDATE project SET project_name='"+project.getProjectName()+"',project_description='"
                        +project.getProjectDescription()+"',client_id='"+project.getClientId()+"',start_date='"+sdf.format(project.getStartDate())+"',end_date='"+sdf.format(project.getEndDate())+"' WHERE project_id='"+project.getProjectId()+"'";
                System.out.println(sql);
                if(statement.executeUpdate(sql) > 0){
                    return true;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
        
    }
    
    public boolean registerTask(Task task){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
        try {
                Statement statement=null;
                String sql="";
                ConnectToDatabase connectToDatabase = new ConnectToDatabase();
                Connection connection = connectToDatabase.getConnection();

                statement=connection.createStatement();
                sql="INSERT INTO task VALUES('"+task.getTaskId()+"','"+task.getTaskDescription()+
                        "','"+task.getProjectId()+"','"+task.getStudentId()+"','"+sdf.format(task.getStartDate())+"','"+sdf.format(task.getEndDate())+"')";
                System.out.println(sql);
                if(statement.executeUpdate(sql) > 0){
                    return true;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
        
    }
    
        // deletes existing task
    public void deleteTask(String taskId){
        try {
            Statement statement=null;
            String sql="";
            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            
            statement=connection.createStatement();
            sql="DELETE FROM task WHERE task_id='"+taskId+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
