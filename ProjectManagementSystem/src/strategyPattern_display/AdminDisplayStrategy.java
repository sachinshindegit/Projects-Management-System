
package strategyPattern_display;

import javax.swing.JPanel;
import views.Admin_Home;
import views.Client_Home;
/**
 *
 * @author Sachin Shinde
 */

// This claass represents display strategy for Admin
public class AdminDisplayStrategy implements DisplayStrategy{

    @Override
    public JPanel displayNextPage() {
        return new Admin_Home();
    }
    
}
