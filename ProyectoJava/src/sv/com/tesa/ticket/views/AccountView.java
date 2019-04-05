package sv.com.tesa.ticket.views;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sv.com.tesa.ticket.beans.EmployeeBean;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.controllers.AccountController;
import sv.com.tesa.ticket.controllers.MainViewController;

/**
 *
 * @author Rahmans
 */
public class AccountView extends javax.swing.JDialog {

    EmployeeBean account = new EmployeeBean();
    AccountController ctrlAccount = new AccountController();
    static boolean maximized = true;
    int xMouse;
    int yMouse;
    
    public AccountView() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        setUndecorated(true);
        cargarImagen();
        cargarDatos();
    }
    
    private void cargarImagen(){
        btnSave.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/9016-200.png").getImage().
                        getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
    }
    
    private void cargarDatos(){
        lblUsuario.setText(LoginBean.getNombre());
        lblRol.setText(LoginBean.getRol());
        lblCorreo.setText(LoginBean.getCorreo());
        lblArea.setText(LoginBean.getDepartamento());
        lblEncargado.setText(LoginBean.getJefe());
        
    }

   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        pnlMenu = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        btnDatos = new javax.swing.JButton();
        lblTimeline = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        lblNews = new javax.swing.JLabel();
        pnlBody = new javax.swing.JPanel();
        jpDatos = new javax.swing.JScrollPane();
        pnlDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        lblEncargado = new javax.swing.JLabel();
        jpPassword = new javax.swing.JScrollPane();
        pnlPassword = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtPassActual = new javax.swing.JPasswordField();
        txtPassNueva = new javax.swing.JPasswordField();
        txtPassConfirm = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(681, 561));
        setModal(true);
        setResizable(false);
        setSize(new java.awt.Dimension(681, 561));

        pnlHeader.setBackground(new java.awt.Color(222, 226, 226));
        pnlHeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlHeader.setForeground(new java.awt.Color(255, 255, 255));
        pnlHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderMouseDragged(evt);
            }
        });
        pnlHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderMousePressed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/com/tesa/ticket/images/Exit.png"))); // NOI18N
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusable(false);
        btnExit.setOpaque(true);
        btnExit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/com/tesa/ticket/images/Exit (2).png"))); // NOI18N
        btnExit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/com/tesa/ticket/images/Exit (2).png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblUsuario.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(44, 62, 80));
        lblUsuario.setText("USUARIO");

        lblRol.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRol.setForeground(new java.awt.Color(127, 140, 141));
        lblRol.setText("ROL");

        btnDatos.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnDatos.setForeground(new java.awt.Color(44, 62, 80));
        btnDatos.setText("Datos");
        btnDatos.setBorder(null);
        btnDatos.setContentAreaFilled(false);
        btnDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDatos.setFocusable(false);
        btnDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosActionPerformed(evt);
            }
        });

        lblTimeline.setBackground(new java.awt.Color(0, 204, 106));
        lblTimeline.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblTimeline.setOpaque(true);

        btnChangePassword.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnChangePassword.setForeground(new java.awt.Color(44, 62, 80));
        btnChangePassword.setText("Cambiar Contraseña");
        btnChangePassword.setBorder(null);
        btnChangePassword.setContentAreaFilled(false);
        btnChangePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnChangePassword.setFocusable(false);
        btnChangePassword.setPreferredSize(new java.awt.Dimension(100, 27));
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        lblNews.setBackground(new java.awt.Color(255, 255, 255));
        lblNews.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNews.setOpaque(true);

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDatos)
                                .addGap(60, 60, 60)))
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblNews, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblUsuario)
                .addGap(5, 5, 5)
                .addComponent(lblRol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChangePassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                        .addComponent(btnDatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNews, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlBody.setLayout(new java.awt.CardLayout());

        jpDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpDatos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlDatos.setBackground(new java.awt.Color(245, 245, 245));
        pnlDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Correo:");

        jLabel2.setText("Area:");

        jLabel3.setText("Encargado:");

        lblCorreo.setText("jLabel4");

        lblArea.setText("jLabel5");

        lblEncargado.setText("jLabel6");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(53, 53, 53)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEncargado)
                    .addComponent(lblArea)
                    .addComponent(lblCorreo))
                .addContainerGap(518, Short.MAX_VALUE))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEncargado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(89, 89, 89))
        );

        jpDatos.setViewportView(pnlDatos);

        pnlBody.add(jpDatos, "card2");

        jpPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpPassword.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlPassword.setBackground(new java.awt.Color(245, 245, 245));
        pnlPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPasswordMouseClicked(evt);
            }
        });

        jLabel4.setText("Ingrese contraseña actual:");

        jLabel5.setText("Ingrese contraseña nueva:");

        jLabel6.setText("Confirme contraseña nueva:");

        btnSave.setText("jButton1");
        btnSave.setNextFocusableComponent(txtPassActual);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtPassActual.setNextFocusableComponent(txtPassNueva);

        txtPassNueva.setNextFocusableComponent(txtPassConfirm);

        txtPassConfirm.setNextFocusableComponent(btnSave);

        javax.swing.GroupLayout pnlPasswordLayout = new javax.swing.GroupLayout(pnlPassword);
        pnlPassword.setLayout(pnlPasswordLayout);
        pnlPasswordLayout.setHorizontalGroup(
            pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasswordLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(79, 79, 79)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPasswordLayout.createSequentialGroup()
                        .addComponent(txtPassNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPassActual, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        pnlPasswordLayout.setVerticalGroup(
            pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasswordLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPassNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPassConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jpPassword.setViewportView(pnlPassword);

        pnlBody.add(jpPassword, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBody, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
            .addComponent(pnlHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
        );

        setBounds(0, 0, 678, 600);
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlHeaderMousePressed

    private void pnlHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMouseDragged
        if(maximized){
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - xMouse, y - yMouse);
        }
    }//GEN-LAST:event_pnlHeaderMouseDragged

    private void btnDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosActionPerformed
        lblTimeline.setBackground(new Color(0,204,106));
        
        lblNews.setBackground(new Color(255,255,255));
        
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(jpDatos);
        pnlBody.repaint();
        pnlBody.revalidate();
    }//GEN-LAST:event_btnDatosActionPerformed

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(new Color(232,17,35));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        lblNews.setBackground(new Color(0,204,106));

        lblTimeline.setBackground(new Color(255,255,255));

        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(jpPassword);
        pnlBody.repaint();
        pnlBody.revalidate();
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if((txtPassActual.getPassword() != null && txtPassConfirm.getPassword() != null && txtPassNueva.getPassword() != null) &&
                (!new String(txtPassActual.getPassword()).equals("") && !new String(txtPassConfirm.getPassword()).equals("") && !new String(txtPassNueva.getPassword()).equals("")))
        {
            if(new String(txtPassNueva.getPassword()).equals(new String(txtPassConfirm.getPassword())))
            {
                if(ctrlAccount.actualizarCuenta(new String(txtPassActual.getPassword()), new String(txtPassNueva.getPassword())))
                {
                    JOptionPane.showMessageDialog(this, "Contraseña modificada con éxito");
                    MainViewController.mainView.disposeOnPasswordChanged();
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Error al cambiar la contraseña");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void pnlPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPasswordMouseClicked
        // TODO add your handling code here:
        btnChangePasswordActionPerformed(null);
    }//GEN-LAST:event_pnlPasswordMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnDatos;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jpDatos;
    private javax.swing.JScrollPane jpPassword;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblEncargado;
    private javax.swing.JLabel lblNews;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblTimeline;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlBody;
    protected javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPassword;
    private javax.swing.JPasswordField txtPassActual;
    private javax.swing.JPasswordField txtPassConfirm;
    private javax.swing.JPasswordField txtPassNueva;
    // End of variables declaration//GEN-END:variables

}
