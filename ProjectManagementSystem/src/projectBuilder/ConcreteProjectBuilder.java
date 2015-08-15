
package projectBuilder;

/**
 *
 * @author Sachin Shinde
 */

// This class is a concrete implementation for project builder
public class ConcreteProjectBuilder implements ProjectBuilder{

    @Override
    public Project buildProject() {
        return new Project();
    }
    
    
}
