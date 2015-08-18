
package views;

import Accounts.Account;
import Accounts.Faculty;
import Accounts.Student;
import Authentication.LogOut;
import DatabaseConnection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projectBuilder.Director;
import projectBuilder.Project;
import projectBuilder.ProjectBuilder;
import projectGroup.ProjectGroup;
import projectGroup.StudentMember;
import projectManagementSystem.ProjectManagementGlobalSession;
import userActions.FacultyActions;

/**
 *
 * @author Daryl
 */
public class Faculty_Project_Update extends javax.swing.JPanel {

    /**
     * Creates new form NewProject
     */
    Project project = null;
    ProjectGroup projectGroup =null;
    DefaultTableModel membersModel;
    LinkedList membersLinkedList = new LinkedList();
    public Faculty_Project_Update() {
            initComponents();
                    Faculty faculty = (Faculty)ProjectManagementGlobalSession.loggedInUser;
                    userLoggedIn.setText("User: "+ faculty.getUserName());
            project = (Project) ProjectManagementGlobalSession.context;
            projectId.setText(project.getProjectId());
            projectName.setText(project.getProjectName());
            projectDescription.setText(project.getProjectDescription());
            startDate.setDate(project.getStartDate());
            endDate.setDate(project.getEndDate());
            clientId.setText(project.getClientId());
            Date date = new Date();
            if(date.after(project.getEndDate())){
                projectStatus.setText("Completed");
            }
            else{
                projectStatus.setText("In progress");
            }
            populateMembersTable();
      
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectDescription = new javax.swing.JTextArea();
        projectName = new javax.swing.JTextField();
        projectId = new javax.swing.JTextField();
        clientId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        updateProjectButton = new javax.swing.JButton();
        deleteProject = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        userLoggedIn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        projectStatus = new javax.swing.JTextField();
        homeButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        startDate = new com.toedter.calendar.JDateChooser();
        endDate = new com.toedter.calendar.JDateChooser();
        deleteMemberButton = new javax.swing.JButton();
        addMembersButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        membersListTable = new javax.swing.JTable();
        createTaskButton = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flpm.PNG"))); // NOI18N

        jLabel3.setText("Project Name :");

        jLabel4.setText("Project Id :");

        jLabel5.setText("Client  Id :");

        jLabel6.setText("Project Description :");

        jLabel7.setText("Start Date :");

        projectDescription.setColumns(20);
        projectDescription.setRows(5);
        jScrollPane1.setViewportView(projectDescription);

        projectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectNameActionPerformed(evt);
            }
        });

        projectId.setEnabled(false);

        jLabel9.setText("End Date :");

        updateProjectButton.setText("Update Project ");
        updateProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProjectButtonActionPerformed(evt);
            }
        });

        deleteProject.setText("Delete Project ");
        deleteProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProjectActionPerformed(evt);
            }
        });

        jButton4.setText("Track Project ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        userLoggedIn.setText("User : ");

        jLabel2.setText("Project Status:");

        projectStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectStatusActionPerformed(evt);
            }
        });

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        deleteMemberButton.setText("Delete Selected member");
        deleteMemberButton.setEnabled(false);
        deleteMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMemberButtonActionPerformed(evt);
            }
        });

        addMembersButton.setText("Add members");
        addMembersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMembersButtonActionPerformed(evt);
            }
        });

        membersListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Members"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        membersListTable.setShowHorizontalLines(false);
        membersListTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(membersListTable);

        createTaskButton.setText("Create Task");
        createTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTaskButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(projectName, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(projectId, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(projectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userLoggedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clientId, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(endDate, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                    .addComponent(startDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteProject, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(deleteMemberButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(addMembersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createTaskButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLoggedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clientId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteMemberButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addMembersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteProject, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void projectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectNameActionPerformed

    private void updateProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProjectButtonActionPerformed
        FacultyActions fac = new FacultyActions();
        if(validateInputs()){
            Director director = new Director();
            ProjectBuilder  projectBuilder = director.getProjectBuilder();
            Project project = projectBuilder.buildProject();
            project.setProjectId(projectId.getText().trim());
            project.setProjectName(projectName.getText().trim());
            project.setProjectDescription(projectDescription.getText().trim());
            project.setClientId(clientId.getText().trim());
            project.setStartDate(startDate.getDate());
            project.setEndDate(endDate.getDate());
            
            if(fac.updateProject(project)){
                JOptionPane.showMessageDialog(this, "Project successfully updated");
            }else{
                JOptionPane.showMessageDialog(this, "Project cannot be updated at this time");
            }
        }    
    }//GEN-LAST:event_updateProjectButtonActionPerformed

    private void deleteProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProjectActionPerformed
        FacultyActions fac = new FacultyActions();
        int reply = JOptionPane.showConfirmDialog(this, "Do you want to delete this project?");
        if(reply==0){
            fac.deleteProject(projectId.getText().trim());
            ProjectManagementGlobalSession.centralPanel.removeAll();
            ProjectManagementGlobalSession.centralPanel.add(new Faculty_Home());
            ProjectManagementGlobalSession.centralPanel.updateUI();
        }
        
        
    }//GEN-LAST:event_deleteProjectActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void projectStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectStatusActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        ProjectManagementGlobalSession.centralPanel.removeAll();
        ProjectManagementGlobalSession.centralPanel.add(new Faculty_Home());
        ProjectManagementGlobalSession.centralPanel.updateUI();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        LogOut logout = new LogOut();
        logout.logOut();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void deleteMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMemberButtonActionPerformed
        FacultyActions fac = new FacultyActions();
        if(membersListTable.getSelectedRow() > 0){
            String studentId = membersLinkedList.get(membersListTable.getSelectedRow()).toString();
            int reply = JOptionPane.showConfirmDialog(this, "Do you want you remove "+studentId+" from the Project group?");
            if(reply==0){
                fac.deleteMember(projectId.getText().trim(), studentId);
                membersLinkedList.remove(membersListTable.getSelectedRow());
                membersModel.removeRow(membersListTable.getSelectedRow());
            }    
            
        }
    }//GEN-LAST:event_deleteMemberButtonActionPerformed

    private void addMembersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMembersButtonActionPerformed
        FacultyActions facultyActions = new FacultyActions();
        facultyActions.setProjectId(projectId.getText());
        ProjectManagementGlobalSession.context = facultyActions;
        JOptionPane.showMessageDialog(this,new Add_members());
        populateMembersTable();
        
    }//GEN-LAST:event_addMembersButtonActionPerformed

    private void createTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTaskButtonActionPerformed
        Project project = new Project();
        project.setProjectId(projectId.getText());
        project.setStartDate(startDate.getDate());
        project.setEndDate(endDate.getDate());
        project.setClientId(clientId.getText());
        project.setProjectDescription(projectDescription.getText());

        ProjectManagementGlobalSession.centralPanel.removeAll();
        ProjectManagementGlobalSession.centralPanel.add(new CreateTask(project, membersLinkedList));
        ProjectManagementGlobalSession.centralPanel.updateUI();
    }//GEN-LAST:event_createTaskButtonActionPerformed

    private void populateMembersTable(){
        try {
            String sql = "Select * from project_members where project_id='"+project.getProjectId()+"'";
            
            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            projectGroup = new ProjectGroup();
            Student student = null;
            membersModel = (DefaultTableModel)membersListTable.getModel();
            while(membersModel.getRowCount() > 0){
                membersModel.removeRow(membersModel.getRowCount()-1);
            }
            while(resultSet.next()){
                membersLinkedList.add(resultSet.getNString("user_id"));
                student = new Student(resultSet.getNString("user_id"), null, null, null, null);
                projectGroup.add(new StudentMember(student));
                String[] s = {resultSet.getNString("user_id")};
                membersModel.insertRow(membersModel.getRowCount(), s);
            }
            if(membersLinkedList.size() > 0){
                deleteMemberButton.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Faculty_Project_Update.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    // To validate inputs
    public boolean validateInputs(){

            if(projectId.getText().trim().length()<1 || projectName.getText().trim().length()<1 || projectDescription.getText().trim().length()<1 || clientId.getText().trim().length()<1 || 
                    startDate.getDate().toString().length() < 1 || endDate.getDate().toString().length() < 1){
                JOptionPane.showMessageDialog(this, "Enter all the values");
                return false;
            }
            PreparedStatement preparedStatement=null;
            ResultSet resultSetLogin, resultSetClient = null;
            boolean loginFlag=false;
            Account loggedInUser=null;
            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            String sql="";
            
            
            try {
                // TO check whether client id is valid
                sql="SELECT * FROM accounts where user_id='"+clientId.getText().trim()+"' and user_role='client'";
                System.out.println("client check "+sql);
                preparedStatement = connection.prepareStatement(sql);
                resultSetClient = preparedStatement.executeQuery();
                while(resultSetClient.next()){
                    loginFlag=true;
                }
                if(!loginFlag){
                    JOptionPane.showMessageDialog(this, "Invalid client Id");
                    return false;
                }
                
                // Date validation
                if(startDate.getDate().after(endDate.getDate())){
                    JOptionPane.showMessageDialog(this, "Start date should be prior to end date");
                    return false;
                }
                
                
                } catch (SQLException ex) {
                Logger.getLogger(Admin_NewAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMembersButton;
    private javax.swing.JTextField clientId;
    private javax.swing.JButton createTaskButton;
    private javax.swing.JButton deleteMemberButton;
    private javax.swing.JButton deleteProject;
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTable membersListTable;
    private javax.swing.JTextArea projectDescription;
    private javax.swing.JTextField projectId;
    private javax.swing.JTextField projectName;
    private javax.swing.JTextField projectStatus;
    private com.toedter.calendar.JDateChooser startDate;
    private javax.swing.JButton updateProjectButton;
    private javax.swing.JLabel userLoggedIn;
    // End of variables declaration//GEN-END:variables
}
