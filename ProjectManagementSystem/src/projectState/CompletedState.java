
package projectState;

/**
 *
 * @author Sachin Shinde
 */

// This class defines the completed state of a project
public class CompletedState implements State{

    @Override
    public String printState() {
        return "Completed";
    }
    
}
