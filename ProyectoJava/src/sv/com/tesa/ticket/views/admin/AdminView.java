/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.views.admin;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.controllers.AdminDeptController;
/**
 *
 * @author Edu
 */
public class AdminView extends javax.swing.JFrame {

    private AdminDeptView vistaDept;
    
    /**
     * Creates new form Adminview
     * @param logUser
     */
    public AdminView(LoginBean logUser) {
        initComponents();
        labelUsuario.setText("Bienvenido: " + logUser.getNombre());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAdminDept = new javax.swing.JButton();
        btnAdminJefeDept = new javax.swing.JButton();
        bntAdminJefeDes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelUsuario.setText("Bienvenido:");

        jLabel1.setText("Seleccione la opción a realizar:");

        btnAdminDept.setText("Administrar Departamentos");
        btnAdminDept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminDeptActionPerformed(evt);
            }
        });

        btnAdminJefeDept.setText("Administrar Jefes de Departamentos");

        bntAdminJefeDes.setText("Administrar Jefes de Desarrollo");
        bntAdminJefeDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAdminJefeDesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelUsuario)
                    .addComponent(jLabel1)
                    .addComponent(btnAdminDept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdminJefeDept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntAdminJefeDes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelUsuario)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdminDept, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdminJefeDept, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntAdminJefeDes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntAdminJefeDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAdminJefeDesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntAdminJefeDesActionPerformed

    private void btnAdminDeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminDeptActionPerformed
        
        vistaDept = new AdminDeptView();
        vistaDept.setLocationRelativeTo(this);
        vistaDept.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAdminDeptActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAdminJefeDes;
    private javax.swing.JButton btnAdminDept;
    private javax.swing.JButton btnAdminJefeDept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}
