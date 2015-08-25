/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Authentication.LogOut;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import projectBuilder.Project;
import projectManagementSystem.ProjectManagementGlobalSession;
import taskBuilder.Task;
import userActions.StudentActions;

/**
 *
 * @author Daryl
 */
public class Student_Home extends javax.swing.JPanel {

    /**
     * Creates new form Student_Home
     */
    StudentActions studentActions;
    LinkedList taskLinkedList = new LinkedList();
    DefaultTableModel projectModel, taskModel;
    public Student_Home() {
        initComponents();
        userLoggedIn.setText("User: "+projectManagementSystem.ProjectManagementGlobalSession.user_id);
        studentActions = new StudentActions();
        taskModel = (DefaultTableModel) taskListTable.getModel();
        ArrayList projectsList = studentActions.fetchProjets();
        Date date = new Date();
        projectModel = (DefaultTableModel)projectListTable.getModel();
        
        for(int i=0;i<projectsList.size();i++){
            Project project = (Project)projectsList.get(i);
            if(date.after(project.getEndDate())){
                String[] str = {project.getProjectId(),project.getProjectDescription(),"Completed"};
                projectModel.insertRow(projectModel.getRowCount(), str);
            }
            if(date.before(project.getStartDate())){
                String[] str = {project.getProjectId(),project.getProjectDescription(),"Up coming Project"};
                projectModel.insertRow(projectModel.getRowCount(), str);
            }
            else if(date.before(project.getEndDate())){
                String[] str = {project.getProjectId(),project.getProjectDescription(),"In progress"};
                projectModel.insertRow(projectModel.getRowCount(), str);
            }
            
        }
        
        populateTasks();
        
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
        logoutButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectListTable = new javax.swing.JTable();
        userLoggedIn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taskListTable = new javax.swing.JTable();
        taskComplete = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        taskPieChart = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flpm_2.PNG"))); // NOI18N

        logoutButton.setText("Log Out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        projectListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Project Id", "Project Description", "Project Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        projectListTable.setGridColor(new java.awt.Color(255, 255, 255));
        projectListTable.setShowHorizontalLines(false);
        projectListTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(projectListTable);

        userLoggedIn.setText("User: ");

        jLabel4.setText("Summary of your Projects:");

        jLabel2.setText("Pending Tasks:");

        taskListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task Id", "Task description", "Project Id", "Task Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        taskListTable.setGridColor(new java.awt.Color(255, 255, 255));
        taskListTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        taskListTable.setShowHorizontalLines(false);
        taskListTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(taskListTable);

        jLabel3.setText("Enter task Id to mark as complete:");

        jButton3.setText("Mark as complete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        taskPieChart.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout taskPieChartLayout = new javax.swing.GroupLayout(taskPieChart);
        taskPieChart.setLayout(taskPieChartLayout);
        taskPieChartLayout.setHorizontalGroup(
            taskPieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        taskPieChartLayout.setVerticalGroup(
            taskPieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(userLoggedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(taskComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(taskPieChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLoggedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(taskComplete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jButton3))
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(taskPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        markComplete();
        populateTasks();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        ProjectManagementGlobalSession.centralPanel.removeAll();
        ProjectManagementGlobalSession.centralPanel.add(new Student_Home());
        ProjectManagementGlobalSession.centralPanel.updateUI();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        LogOut logout = new LogOut();
        logout.logOut();
    }//GEN-LAST:event_logoutButtonActionPerformed
    private void populateTasks(){
        ArrayList taskList = studentActions.fetchTasks();
        
        while(taskModel.getRowCount()!=0 ){
            taskModel.removeRow(taskModel.getRowCount()-1);
        }

        
        Task task = new Task();
        Date currDate = new Date();
        int totalTime = 0;
        int timePassed =0;
        for(int i=0;i<taskList.size();i++){
            task = (Task) taskList.get(i);
            this.taskLinkedList.add(task.getTaskId());
            if(currDate.before(task.getStartDate())){
                String[] str = {task.getTaskId(),task.getTaskDescription(),task.getProjectId(),"Up coming"};
                taskModel.insertRow(taskModel.getRowCount(), str);
            }    
            else{
                String[] str = {task.getTaskId(),task.getTaskDescription(),task.getProjectId(),"In progress"};
                taskModel.insertRow(taskModel.getRowCount(), str);
                timePassed = timePassed + (currDate.getDate() - task.getStartDate().getDate());
            }
            totalTime = totalTime + (task.getEndDate().getDate() - task.getStartDate().getDate());
            
        }
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Task completed", timePassed);
        dataset.setValue("Pending Tasks", totalTime-timePassed);
        JFreeChart taskStatusChart = ChartFactory.createPieChart("Tasks completion status", dataset,true,true,true);
        PiePlot piePlot =  (PiePlot)taskStatusChart.getPlot();
        ChartPanel chartPanel = new ChartPanel(taskStatusChart);
           chartPanel.setSize(323,303);
                chartPanel.setVisible(true);
                //chartPanel.setLocation(500, 200);
                taskPieChart.removeAll();
                taskPieChart.add(chartPanel);
                taskPieChart.updateUI();
                taskPieChart.repaint();
    }
    
    private void markComplete(){
        if(this.taskLinkedList.contains(taskComplete.getText().trim())){
            if(studentActions.markAsComplete(taskComplete.getText().trim())){
                this.taskLinkedList.remove(taskComplete.getText().trim());
                taskComplete.setText("");
                populateTasks();
            }
            else{
                JOptionPane.showMessageDialog(this, "Tasks cannot be updated at this time");
            }
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Invalid task Id");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTable projectListTable;
    private javax.swing.JTextField taskComplete;
    private javax.swing.JTable taskListTable;
    private javax.swing.JPanel taskPieChart;
    private javax.swing.JLabel userLoggedIn;
    // End of variables declaration//GEN-END:variables
}
