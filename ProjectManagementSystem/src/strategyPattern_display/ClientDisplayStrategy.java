
package strategyPattern_display;

import javax.swing.JPanel;
import views.Client_Home;
/**
 *
 * @author Sachin Shinde
 */

// This claass represents display strategy for Client
public class ClientDisplayStrategy implements DisplayStrategy{

    @Override
    public JPanel displayNextPage() {
        return new Client_Home();
    }
    
}
