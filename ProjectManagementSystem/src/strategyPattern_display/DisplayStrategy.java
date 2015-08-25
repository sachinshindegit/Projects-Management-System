
package strategyPattern_display;

import javax.swing.JPanel;

/**
 *
 * @author Sachin Shinde
 */

// This interface is a part of strategy pattern used for restricted view
public interface DisplayStrategy {
    
    public JPanel displayNextPage();
}
