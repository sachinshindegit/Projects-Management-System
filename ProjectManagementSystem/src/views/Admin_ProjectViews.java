/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import projectBuilder.Project;
import userActions.AdminActions;

/**
 *
 * @author Sachin Shinde
 */
public class Admin_ProjectViews extends javax.swing.JPanel {

    /**
     * Creates new form Admin_ProjectViews
     */
     DefaultTableModel model;
    public Admin_ProjectViews() {
        initComponents();
    }
    public Admin_ProjectViews(String type){
        initComponents();
        AdminActions adminActions = new AdminActions();
        ArrayList list = adminActions.fetchProjects(type);
        model=(DefaultTableModel)projectListTable.getModel();
        for(int i=0;i<list.size();i++){
            Project project = (Project) list.get(i);
            String[] str = {project.getProjectId(),project.getProjectName(),project.getProjectDescription(),project.getClientId(),project.getFacultyId()};
            model.insertRow(model.getRowCount(), str);
        }
        projectsType.setText(type.toString().toUpperCase()+" PROJECTS");
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
        projectListTable = new javax.swing.JTable();
        projectsType = new javax.swing.JLabel();

        projectListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Project Id", "Project Name", "Project Description", "Client Id", "Faculty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(projectListTable);

        projectsType.setText("Table: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectsType)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(projectsType)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable projectListTable;
    private javax.swing.JLabel projectsType;
    // End of variables declaration//GEN-END:variables
}
