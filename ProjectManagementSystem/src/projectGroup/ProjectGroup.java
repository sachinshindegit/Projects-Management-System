package projectGroup;

import Accounts.Student;
import java.util.LinkedList;

/**
 *
 * @author Sachin Shinde
 */
public class ProjectGroup implements Member{
    public LinkedList<StudentMember> membersList = new LinkedList<StudentMember>();
    
    // To add a new student as a member to the project group
    public void add(StudentMember studentMember){
        membersList.add(studentMember);
    }
    
    // To remove a student from the project group
    public boolean remove(Student Student){
        StudentMember studentMember = null;
        for(int i=0;i<membersList.size();i++){
            studentMember = membersList.get(i);
            if(Student.getUserId().equalsIgnoreCase(studentMember.getStudent().getUserId())){
                membersList.remove(i);
                return true;
            }
        }
        return false;
    }
    
}
