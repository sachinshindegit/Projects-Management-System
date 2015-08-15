
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
    

}
