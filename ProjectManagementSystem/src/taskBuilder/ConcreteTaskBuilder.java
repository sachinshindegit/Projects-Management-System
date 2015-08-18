
package taskBuilder;

import projectBuilder.Project;

/**
 *
 * @author Sachin Shinde
 */
public class ConcreteTaskBuilder implements TaskBuilder{

    @Override
    public Task buildTask() {
        return new Task();
    }
    
}
