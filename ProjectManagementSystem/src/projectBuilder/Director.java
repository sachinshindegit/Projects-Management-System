package projectBuilder;

/**
 *
 * @author Sachin Shinde
 */

// This class acts as a director to build project in builder pattern
public class Director {
    private ProjectBuilder projectBuilder;
    
    public Director(){
        this.projectBuilder = new ConcreteProjectBuilder();
    }
    public ProjectBuilder getProjectBuilder(){
        return this.projectBuilder;
    }
}
