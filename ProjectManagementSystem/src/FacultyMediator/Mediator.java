package FacultyMediator;

import java.util.ArrayList;

/**
 *
 * @author Sachin Shinde
 */

//This is a mediator interface to implement mediator design pattern
public interface Mediator {
    
    public ArrayList fetchEntityList(String entityType);
    public ArrayList fetchMyProjects();
    public ArrayList fetchMyProjectTasks(String projectId);
}
