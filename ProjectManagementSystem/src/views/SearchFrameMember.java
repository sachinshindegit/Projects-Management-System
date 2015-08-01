/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Daryl
 */

package views;
import views.SearchMemberName;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
*
* 
*/
public class SearchFrameMember  extends JFrame{
   private static final long serialVersionUID = 1L;
   private JFrame f;

   public SearchFrameMember() {
   //Don't create a new JFrame, you're already creating a TestFrame!
       //call all methods on the TestFrame, not the JFrame
       setVisible(true);
       setSize(1000, 800);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       JPanel p1 = new SearchMemberName();
       p1.setVisible(true);
       add(p1);
   }

   
   public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
                new SearchFrameMember();
           }
       });
   }
   
}
