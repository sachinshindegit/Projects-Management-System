/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Accounts.Account;
import Accounts.Faculty;
import Authentication.LogOut;
import DatabaseConnection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projectBuilder.Project;
import projectManagementSystem.ProjectManagementGlobalSession;

/**
 *
 * @author Daryl
 */
public class Faculty_Home extends javax.swing.JPanel {

    /**
     * Creates new form Faculty_Home
     */
    DefaultTableModel model;
    public Faculty_Home() {
        initComponents();
        Faculty faculty = (Faculty)ProjectManagementGlobalSession.loggedInUser;
        userLoggedIn.setText("User: "+ ProjectManagementGlobalSession.user_id);
        PreparedStatement preparedStatement=null;
            ResultSet resultSetLogin = null;
            boolean loginFlag=false;

            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            String sql="";

            // To check if the user id already exists
            sql = "SELECT * FROM project WHERE faculty_id='"+ProjectManagementGlobalSession.user_id+"'";
            model=(DefaultTableModel)projectListTable.getModel();
            model.setRowCount(0);
            
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSetLogin = preparedStatement.executeQuery();
                while(resultSetLogin.next()){
                        
                        String[] s={resultSetLogin.getNString("project_id"),resultSetLogin.getNString("project_name"),resultSetLogin.getNString("client_id")};
                        model.insertRow(model.getRowCount(),s);
                    }
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        userLoggedIn = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        projectListTable = new javax.swing.JTable();
        createNewProjectButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        projectIdViewDetails = new javax.swing.JTextField();
        viewProjectDetailsButton = new javax.swing.JButton();
        displayMessage = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("jMenu3");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setPreferredSize(new java.awt.Dimension(900, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flpm_2.PNG"))); // NOI18N

        userLoggedIn.setText("User: ");

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Log out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        projectListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Project Id", "Project Name", "Client Id"
            }
        ));
        projectListTable.setRowSelectionAllowed(false);
        projectListTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(projectListTable);

        createNewProjectButton.setText("Create New Project ");
        createNewProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewProjectButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("My Projects:");

        jLabel3.setText("Project ID:");

        projectIdViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectIdViewDetailsActionPerformed(evt);
            }
        });

        viewProjectDetailsButton.setText("View Project Details");
        viewProjectDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProjectDetailsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(userLoggedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(viewProjectDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(projectIdViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(createNewProjectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(displayMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLoggedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectIdViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viewProjectDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createNewProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(displayMessage)
                .addGap(40, 40, 40)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void projectIdViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectIdViewDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectIdViewDetailsActionPerformed

    private void createNewProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewProjectButtonActionPerformed
        ProjectManagementGlobalSession.centralPanel.removeAll();
        ProjectManagementGlobalSession.centralPanel.add(new NewProject());
        ProjectManagementGlobalSession.centralPanel.updateUI();
    }//GEN-LAST:event_createNewProjectButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        LogOut logout = new LogOut();
        logout.logOut();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        ProjectManagementGlobalSession.centralPanel.removeAll();
        ProjectManagementGlobalSession.centralPanel.add(new Faculty_Home());
        ProjectManagementGlobalSession.centralPanel.updateUI();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void viewProjectDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProjectDetailsButtonActionPerformed
        if(validateSearchItem()){
            ProjectManagementGlobalSession.centralPanel.removeAll();
            ProjectManagementGlobalSession.centralPanel.add(new Faculty_Project_Update());
            ProjectManagementGlobalSession.centralPanel.updateUI();
        }
    }//GEN-LAST:event_viewProjectDetailsButtonActionPerformed
    
    private boolean validateSearchItem(){
        if(projectIdViewDetails.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(this, "Enter project Id to be searched");
            return false;
        }
            PreparedStatement preparedStatement=null;
            ResultSet resultSetLogin = null;
            boolean loginFlag=false;
            Account loggedInUser=null;
            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            String sql="";
            
            
            try {
                // To check if the project Id already exists
                sql = "SELECT * FROM project WHERE project_id='"+projectIdViewDetails.getText().trim()+"' and faculty_id='"+ProjectManagementGlobalSession.user_id+"'";
                preparedStatement = connection.prepareStatement(sql);
                resultSetLogin = preparedStatement.executeQuery();
                Project project = new Project();
                while(resultSetLogin.next()){
                    loginFlag=true;
                    project.setProjectId(resultSetLogin.getNString("project_id"));
                    project.setProjectName(resultSetLogin.getNString("project_name"));
                    project.setClientId(resultSetLogin.getNString("client_id"));
                    project.setProjectDescription(resultSetLogin.getNString("project_description"));
                        project.setStartDate(resultSetLogin.getDate("start_date"));
                        project.setEndDate(resultSetLogin.getDate("end_date"));
                    project.setFacultyId(ProjectManagementGlobalSession.user_id);
                    ProjectManagementGlobalSession.context = project;

                    
                }

                if(loginFlag){
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(this, "Project Id is invalid or you do not have permissions to access this project details");
                }
                } catch (SQLException ex) {
                Logger.getLogger(Admin_NewAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNewProjectButton;
    private javax.swing.JLabel displayMessage;
    private javax.swing.JButton homeButton;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField projectIdViewDetails;
    private javax.swing.JTable projectListTable;
    private javax.swing.JLabel userLoggedIn;
    private javax.swing.JButton viewProjectDetailsButton;
    // End of variables declaration//GEN-END:variables
}
