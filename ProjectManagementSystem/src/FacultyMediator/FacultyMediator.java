package FacultyMediator;

import java.util.ArrayList;
import taskBuilder.Task;

/**
 *
 * @author Sachin Shinde
 */

// This class defines a mediator
public class FacultyMediator implements Mediator{

    @Override
    public ArrayList fetchEntityList(String entityType) {
        
        switch(entityType){
            case "project":
                return new ProjectEntity().getEntityList();
            case "task":
                return new TaskEntity().getEntityList();
            default:
                return null;
        }
    }

    @Override
    public ArrayList fetchMyProjects() {
        return new ProjectEntity().getEntityList();
    }

    @Override
    public ArrayList fetchMyProjectTasks(String projectId) {
        ArrayList temp = new ArrayList();
        temp = new TaskEntity().getEntityList();
        for(int i=0;i<temp.size();i++){
            Task task = (Task)temp.get(i);
            if(task.getProjectId().equalsIgnoreCase(projectId)){
                temp.remove(i);
            }
        }
        return temp;
    }
    
}
