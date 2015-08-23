package projectState;

import java.util.Date;
import projectBuilder.Project;

/**
 *
 * @author Sachin Shinde
 */

// Deines the projectStatus class which acts as the context for State design pattern
public class ProjectStatus {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    // This method returns the state of a project
    public State findProjectStatus(Project project){
        Date date =  new Date();
        
        if(date.after(project.getStartDate()) && date.before(project.getEndDate())){
            setState(new InProgressState());
        }
        if(date.before(project.getStartDate())){
            setState(new UpComingState());
        }
        if(date.after(project.getEndDate())){
            setState(new CompletedState());
        }
        
        return getState();
    }
    
    
    
    
}
