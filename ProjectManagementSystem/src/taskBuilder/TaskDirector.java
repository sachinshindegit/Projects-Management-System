
package taskBuilder;

/**
 *
 * @author Sachin Shinde
 */

public class TaskDirector {
    private TaskBuilder builder;
    
    public TaskDirector(){
        this.builder = new ConcreteTaskBuilder();
    }
    
    public TaskBuilder getTaskBuilder(){
        return this.builder;
    }
}
