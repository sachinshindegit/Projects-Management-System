package views;

import Accounts.Student;
import DatabaseConnection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import projectGroup.StudentMember;
import projectManagementSystem.ProjectManagementGlobalSession;
import userActions.FacultyActions;

/**
 *
 * @author Sachin Shinde
 */
public class Add_members extends javax.swing.JPanel {

    /**
     * Creates new form Add_members
     */
    DefaultTableModel model, selectedStudents;
    ArrayList studentIdList = null;
    LinkedList addedStudentList = null;
    FacultyActions facultyActions = null;
    public Add_members() {
        initComponents();
        this.studentIdList = new ArrayList();
        this.addedStudentList = new LinkedList();
        facultyActions = (FacultyActions)ProjectManagementGlobalSession.context;
        ProjectManagementGlobalSession.context=null;
        PreparedStatement preparedStatement=null;
            ResultSet resultSetLogin = null;
            boolean loginFlag=false;

            ConnectToDatabase connectToDatabase = new ConnectToDatabase();
            Connection connection = connectToDatabase.getConnection();
            String sql="";

            // To check if the user id already exists
            sql = "SELECT a.user_id,a.user_name,a.user_email,a.user_phone FROM accounts a WHERE a.user_role='student' and a.user_id NOT IN (SELECT p.user_id "
                    + "FROM project_members p WHERE p.project_id='"+facultyActions.getProjectId()+"')";
            model=(DefaultTableModel)studentListTable.getModel();
            model.setRowCount(0);
            
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSetLogin = preparedStatement.executeQuery();
                while(resultSetLogin.next()){
                        studentIdList.add(resultSetLogin.getNString("user_id"));
                        //studentIdList.add(resultSetLogin.getNString("user_id"));
                        String[] s={resultSetLogin.getNString("user_id"),resultSetLogin.getNString("user_name"),resultSetLogin.getNString("user_email"),resultSetLogin.getNString("user_phone")};
                        model.insertRow(model.getRowCount(),s);
                    }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        studentListTable = new javax.swing.JTable();
        addStudent = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        addMemberButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        selectedStudentsTable = new javax.swing.JTable();
        removeAddedMemberButton = new javax.swing.JButton();
        confirmMembersButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        studentListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student Id", "Name", "Email", "Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentListTable.setRowSelectionAllowed(false);
        studentListTable.setShowHorizontalLines(false);
        studentListTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(studentListTable);

        jLabel1.setText("Student Id:");

        addMemberButton.setText("Add as member");
        addMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberButtonActionPerformed(evt);
            }
        });

        selectedStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Added"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        selectedStudentsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(selectedStudentsTable);

        removeAddedMemberButton.setText("Remove member");
        removeAddedMemberButton.setEnabled(false);
        removeAddedMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAddedMemberButtonActionPerformed(evt);
            }
        });

        confirmMembersButton.setText("Confirm Members");
        confirmMembersButton.setEnabled(false);
        confirmMembersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmMembersButtonActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(confirmMembersButton, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(removeAddedMemberButton, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(addMemberButton, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(addStudent))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(addStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addMemberButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeAddedMemberButton)
                        .addGap(18, 18, 18)
                        .addComponent(confirmMembersButton))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberButtonActionPerformed
        selectedStudents = (DefaultTableModel)selectedStudentsTable.getModel();
        //selectedStudents.setRowCount(0);
        StudentMember member = null;
        if(validateStudentId(addStudent.getText().trim())){
            String[] studentIdToAdd = {addStudent.getText().trim()};
            selectedStudents.insertRow(selectedStudents.getRowCount(), studentIdToAdd);
            Student student = new Student(addStudent.getText().trim(),null,null,null,null);
            addedStudentList.add(addStudent.getText().trim());
            member = new StudentMember(student);
            facultyActions.addMembers(member);
            removeAddedMemberButton.setEnabled(true);
            confirmMembersButton.setEnabled(true);
            addStudent.setText("");
        }
        else{
            addStudent.setText("Invalid Student ID");
        }
        
    }//GEN-LAST:event_addMemberButtonActionPerformed

    private void removeAddedMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAddedMemberButtonActionPerformed
        if(selectedStudentsTable.getSelectedRow() >=0){
            Student student = new Student(addedStudentList.get(selectedStudentsTable.getSelectedRow()).toString(),null,null,null,null);
            addedStudentList.remove(selectedStudentsTable.getSelectedRow());
            selectedStudents.removeRow(selectedStudentsTable.getSelectedRow());
            facultyActions.removeMembers(student);
            
         }
        if(this.addedStudentList.size() < 1){
            removeAddedMemberButton.setEnabled(false);
            confirmMembersButton.setEnabled(false);
         }
    }//GEN-LAST:event_removeAddedMemberButtonActionPerformed

    private void confirmMembersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmMembersButtonActionPerformed
        facultyActions.addMembersToDatabase(facultyActions.getProjectId());
        JOptionPane.showMessageDialog(this, "Members added successfully to this project");
        addMemberButton.setEnabled(false);
        removeAddedMemberButton.setEnabled(false);
        confirmMembersButton.setEnabled(false);
    }//GEN-LAST:event_confirmMembersButtonActionPerformed
    // Mehtod to check whether student id is already added in the list or not
    private boolean validateStudentId(String id){
        if(this.studentIdList.contains(id) && !this.addedStudentList.contains(id)){
            return true;
        }
        else{
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMemberButton;
    private javax.swing.JTextField addStudent;
    private javax.swing.JButton confirmMembersButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton removeAddedMemberButton;
    private javax.swing.JTable selectedStudentsTable;
    private javax.swing.JTable studentListTable;
    // End of variables declaration//GEN-END:variables
}
