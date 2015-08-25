
package strategyPattern_display;

import javax.swing.JPanel;
import views.Faculty_Home;

/**
 *
 * @author Sachin Shinde
 */

// This claass represents display strategy for faculty
public class FacultyDisplayStrategy implements DisplayStrategy{

    @Override
    public JPanel displayNextPage() {
        return new Faculty_Home();
    }
    
}
