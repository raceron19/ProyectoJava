/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.views;
import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.beans.RequestBean;
import sv.com.tesa.ticket.controllers.RequestController;
/**
 *
 * @author Edu
 */
public class NewRequestView extends javax.swing.JDialog {

    /**
     * Creates new form NewRequestView
     */
    private RequestBean peticion;
    private HashMap<Integer,String> mapPeticiones;
    private RequestController ctrlPeticion;
    
    public NewRequestView(LoginBean logUser) {
        initComponents();
        ctrlPeticion = new RequestController();
        mapPeticiones = ctrlPeticion.listarTiposPeticion();
        setModal(true);
        setLocationRelativeTo(null);
        cargarCbBoxPeticiones();
        lblImage.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/NuevoTicket.png").getImage().
                        getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbBoxTipoPeticion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescripcion = new javax.swing.JTextArea();
        btnIgresarCaso = new javax.swing.JButton();
        btnIgresarCaso1 = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTitulo = new javax.swing.JTextArea();

        setTitle("Nueva petición");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setText("Tipo de petición:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("Titulo:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setText("Descripción:");

        cbBoxTipoPeticion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtAreaDescripcion.setColumns(20);
        txtAreaDescripcion.setLineWrap(true);
        txtAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtAreaDescripcion);

        btnIgresarCaso.setText("Crear Peticion");
        btnIgresarCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgresarCasoActionPerformed(evt);
            }
        });

        btnIgresarCaso1.setText("Cancelar");
        btnIgresarCaso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgresarCaso1ActionPerformed(evt);
            }
        });

        txtTitulo.setColumns(20);
        txtTitulo.setLineWrap(true);
        txtTitulo.setRows(5);
        jScrollPane3.setViewportView(txtTitulo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIgresarCaso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIgresarCaso1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cbBoxTipoPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbBoxTipoPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIgresarCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIgresarCaso1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIgresarCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgresarCasoActionPerformed
        // TODO add your handling code here:
        
        if (!txtTitulo.getText().equals("") || !txtAreaDescripcion.getText().equals("")) {
            peticion = new RequestBean();
            mapPeticiones.keySet().stream().filter((idMap) -> (mapPeticiones.get(idMap).equals(cbBoxTipoPeticion.getSelectedItem()) )).forEachOrdered((idMap) -> {
                peticion.setRequestType(idMap);
            });
            peticion.setDepartment(LoginBean.getDepartamento());
            peticion.setTitle(txtTitulo.getText());
            peticion.setDescription(txtAreaDescripcion.getText());
            peticion.setCreatedBy(LoginBean.getId());

            if (ctrlPeticion.ingresarPeticion(peticion)) 
            {
                JOptionPane.showMessageDialog(this, "Nueva peticion creada","Exito",
                        JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error al ingresar la peticion","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "El titulo y la descripcion estan vacios","Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIgresarCasoActionPerformed

    private void btnIgresarCaso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgresarCaso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIgresarCaso1ActionPerformed

    private void cargarCbBoxPeticiones()
    {
        cbBoxTipoPeticion.removeAllItems();
        mapPeticiones.keySet().forEach((id) -> {
            cbBoxTipoPeticion.addItem(mapPeticiones.get(id));
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIgresarCaso;
    private javax.swing.JButton btnIgresarCaso1;
    private javax.swing.JComboBox<String> cbBoxTipoPeticion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextArea txtAreaDescripcion;
    private javax.swing.JTextArea txtTitulo;
    // End of variables declaration//GEN-END:variables
}
