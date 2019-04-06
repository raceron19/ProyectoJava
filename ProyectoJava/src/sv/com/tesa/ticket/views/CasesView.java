/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.views;
import sv.com.tesa.ticket.controllers.CasesController;
import javax.swing.table.DefaultTableModel;
import sv.com.tesa.ticket.beans.SingleCaseBean;
/**
 *
 * @author Reyes Alexander
 */
public class CasesView extends javax.swing.JInternalFrame {
   private CasesController ctrlCase;
    private SingleCaseBean beanCase;
    public static boolean isOpen = false;
    public static boolean sera = false;
    /**
     * Creates new form CasesView
     */
    public CasesView() {
        initComponents();
        
        beanCase = new SingleCaseBean();
        cargarTabla();
    }
    
    private void cargarTabla(){
        try{
            ctrlCase = new CasesController();
            TableCases.setModel(ctrlCase.listarCases().getModel());
            TableCases.getColumnModel().getColumn(0).setMinWidth(5);
            TableCases.getColumnModel().getColumn(0).setPreferredWidth(6);
        }catch(Exception ex){
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableCases = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        TableCases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableCases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCasesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableCases);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(367, 367, 367))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableCasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCasesMouseClicked
        DefaultTableModel dtm = (DefaultTableModel)TableCases.getModel();
        int fila = TableCases.getSelectedRow();
        beanCase.setId(dtm.getValueAt(fila, 0).toString());
        SingleCaseBean peticionIndividual = ctrlCase.listarCase(beanCase);
        if(!peticionIndividual.getId().equals("")){
                BinnaclesView vistaUnaPeticion = new BinnaclesView(peticionIndividual);
                vistaUnaPeticion.setVisible(true);
        }     
        cargarTabla();
    }//GEN-LAST:event_TableCasesMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
       this.hide();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
                cargarTabla();

    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableCases;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
