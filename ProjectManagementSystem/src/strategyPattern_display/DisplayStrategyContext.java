package strategyPattern_display;

import javax.swing.JPanel;

/**
 *
 * @author Sachin Shinde
 */

// This class acts as a context in the strategy pattern used for restricted view as per user logged in 
public class DisplayStrategyContext {
    private DisplayStrategy strategy;

    public DisplayStrategyContext(String userType){
        
        switch(userType){
            case "admin":
                this.strategy = new AdminDisplayStrategy();
                break;
            case "faculty":
                this.strategy = new FacultyDisplayStrategy();
                break;
            case "client":
                this.strategy = new ClientDisplayStrategy();
                break;
            case "student":
                this.strategy = new StudentDisplayStrategy();
                break;    
            default:
        }
    }    
    
    public JPanel getMyPage(){
        return this.strategy.displayNextPage();
    }
            
    
    
   
    
}
