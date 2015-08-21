
package views;

import DatabaseConnection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.action.ActionButton;
import projectBuilder.Project;
import projectManagementSystem.ProjectManagementGlobalSession;

/**
 *
 * @author Sachin Shinde
 */
public class Project_Status extends javax.swing.JPanel {

    /**
     * Creates new form Project_Status
     */
    public Project_Status() {
        initComponents();
    }
    
    public Project_Status(Project project) {
        initComponents();
        projectNameHead.setText("Project: "+project.getProjectName());
        
        // This code displays status bar
        Date currentDate = new Date();
        Date startDate = project.getStartDate();
        Date endDate = project.getEndDate();

        
    
        if(currentDate.before(endDate)){
            int max = endDate.getDate()- startDate.getDate();
            projectStatusBar.setMaximum((int)max);
            int actualVal = currentDate.getDate()- startDate.getDate();
            projectStatusBar.setValue((int)actualVal);
        }
        else{
            projectStatusBar.setMaximum(100);
            projectStatusBar.setValue(100);
        }
        projectStatusBar.setStringPainted(true);
        
        //end
        
        
        // Code to display pie chart
        PreparedStatement preparedStatement=null;
            ResultSet resultSetLogin = null;


            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            String sql="";

            // To check if the user id already exists
            sql = "SELECT * FROM task WHERE project_id='"+project.getProjectId()+"'";

            DefaultPieDataset dataset = new DefaultPieDataset();
            
            
            LinkedList idList = new LinkedList();
            ArrayList countList = new ArrayList();
            int index = 0;
            int sum = 0;
            
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSetLogin = preparedStatement.executeQuery();
                tasksPanel.setVisible(true);
                tasksPanel.setAutoscrolls(true);
                while(resultSetLogin.next()){
                    JLabel j = new JLabel(resultSetLogin.getNString("task_id")+":");
                    j.setEnabled(true);
                    j.setVisible(true);
                    j.setSize(200,20);
                    tasksPanel.add(j);
                    JProgressBar jProgressBar = new JProgressBar();
                    if(currentDate.before(resultSetLogin.getDate("end_date"))){
                        jProgressBar.setMaximum(resultSetLogin.getDate("end_date").getDate()-resultSetLogin.getDate("start_date").getDate());
                        jProgressBar.setValue(currentDate.getDate()-resultSetLogin.getDate("start_date").getDate());
                    }
                    else{
                        jProgressBar.setMaximum(100);
                        jProgressBar.setValue(100);
                    }
                    jProgressBar.setStringPainted(true);
                    jProgressBar.setVisible(true);
                    jProgressBar.setEnabled(true);
                    jProgressBar.setSize(250, 20);


                    tasksPanel.add(jProgressBar);


                    sum = 0;
                        if(idList.contains(resultSetLogin.getNString("student_id"))){
                            index = idList.indexOf(resultSetLogin.getNString("student_id"));
                            sum = (Integer)countList.get(index) + 1;
                            countList.set(index, sum);
                        }
                        else{
                            countList.add(new Integer(1));
                            idList.add(resultSetLogin.getNString("student_id"));
                        }

                    }
                    
                    tasksPanel.updateUI();
                for(int i=0;i<idList.size();i++){
                    String s = idList.get(i).toString();
                    dataset.setValue(s, (Integer)countList.get(i));
                }
                JFreeChart projectStatusChart = ChartFactory.createPieChart("Project tasks distribution", dataset,true,true,true);
  
                PiePlot piePlot =  (PiePlot)projectStatusChart.getPlot();
                ChartPanel chartPanel = new ChartPanel(projectStatusChart);
                chartPanel.setSize(350,350);
                chartPanel.setVisible(true);
                chartPanel.setLocation(500, 200);

                this.add(chartPanel);
                this.updateUI();
                resultSetLogin.close();
            } catch (SQLException ex) {
                Logger.getLogger(Admin_UserListPage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        projectNameHead = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        projectStatusBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        tasksPanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(900, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flpm_2.PNG"))); // NOI18N

        projectNameHead.setText("Project: ");

        jLabel2.setText("Project completion status: ");

        jLabel3.setText("Tasks Status:");

        tasksPanel.setAutoscrolls(true);
        tasksPanel.setPreferredSize(new java.awt.Dimension(350, 352));
        tasksPanel.setLayout(new java.awt.GridLayout(0, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(projectNameHead)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(projectStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tasksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(projectNameHead)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(projectStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(tasksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel projectNameHead;
    private javax.swing.JProgressBar projectStatusBar;
    private javax.swing.JPanel tasksPanel;
    // End of variables declaration//GEN-END:variables
}
