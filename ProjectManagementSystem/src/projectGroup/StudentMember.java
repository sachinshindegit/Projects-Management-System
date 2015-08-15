package projectGroup;

import Accounts.Student;

/**
 *
 * @author Sachin Shinde
 */


public class StudentMember implements Member{
    
    private Student student=null;
    public StudentMember(Student student){
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
}
