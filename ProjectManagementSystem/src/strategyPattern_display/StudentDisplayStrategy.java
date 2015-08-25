
package strategyPattern_display;

import javax.swing.JPanel;
import views.Student_Home;

/**
 *
 * @author Sachin Shinde
 */

// This claass represents display strategy for student
public class StudentDisplayStrategy implements DisplayStrategy{

    @Override
    public JPanel displayNextPage() {
        return new Student_Home();
    }
    
}
