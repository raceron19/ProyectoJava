package sv.com.tesa.ticket.views;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sv.com.tesa.ticket.beans.BinnaclesBean;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.beans.SingleCaseBean;
import sv.com.tesa.ticket.controllers.BinnaclesController;
import sv.com.tesa.ticket.controllers.CasesController;

public class BinnaclesView extends javax.swing.JDialog {
    static boolean isOpen = false;
    private BinnaclesController binnaclesController;
    private SingleCaseBean singleCaseBean = new SingleCaseBean();
    static boolean maximized = true;
    int xMouse;
    int yMouse;
    
    public BinnaclesView(SingleCaseBean caseBean) {
        
        initComponents();
        setUndecorated(true);
        setModal(true);
        setLocationRelativeTo(null);
        singleCaseBean=caseBean;
        llenarTexbox(singleCaseBean);
        binnaclesController=new BinnaclesController();
                try {
                       jTableBinnacleView.setModel(binnaclesController.mostrarTabla(caseBean.getId()).getModel());
                       jTableBinnacleView.getColumnModel().getColumn(0).setMinWidth(5);
                       jTableBinnacleView.getColumnModel().getColumn(0).setPreferredWidth(6);
                       
                
                } catch (Exception e) {
        }
       
    }

    BinnaclesView() {
        initComponents();
        setUndecorated(true);
    }
    public void iniciarComponentes()
    {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnOpenCases = new javax.swing.JButton();
        lblTimeline = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdCaso = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtAsignado = new javax.swing.JTextField();
        txtEstadoCaso = new javax.swing.JTextField();
        txtFechaEntrega = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        txtProbador = new javax.swing.JTextField();
        txtFechaCreacion = new javax.swing.JTextField();
        txtFechaUpdate = new javax.swing.JTextField();
        txtFechaProduccion = new javax.swing.JTextField();
        btnNuevaBitacora = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtSolicitadoPor = new javax.swing.JTextField();
        btnReAbrir = new javax.swing.JButton();
        pnlBody = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBinnacleView = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1400, 1000));
        setMinimumSize(new java.awt.Dimension(1400, 1000));
        setPreferredSize(new java.awt.Dimension(1400, 1000));
        setSize(new java.awt.Dimension(1400, 1000));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        pnlMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlHeader.setBackground(new java.awt.Color(222, 226, 226));
        pnlHeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlHeader.setForeground(new java.awt.Color(255, 255, 255));
        pnlHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderMouseDragged(evt);
            }
        });
        pnlHeader.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pnlHeaderFocusLost(evt);
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
            .addComponent(btnExit)
        );

        btnOpenCases.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnOpenCases.setForeground(new java.awt.Color(44, 62, 80));
        btnOpenCases.setText("Bitácoras");
        btnOpenCases.setBorder(null);
        btnOpenCases.setContentAreaFilled(false);
        btnOpenCases.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpenCases.setFocusable(false);
        btnOpenCases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenCasesActionPerformed(evt);
            }
        });

        lblTimeline.setBackground(new java.awt.Color(0, 204, 106));
        lblTimeline.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTimeline.setOpaque(true);

        jLabel1.setText("Id del Caso");

        jLabel2.setText("Título");

        jLabel3.setText("Asignado a");

        jLabel4.setText("Estado del caso");

        jLabel6.setText("Fecha de entrega");

        jLabel7.setText("Descripción");

        txtIdCaso.setEditable(false);
        txtIdCaso.setBorder(null);
        txtIdCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCasoActionPerformed(evt);
            }
        });

        txtTitulo.setEditable(false);
        txtTitulo.setBorder(null);

        txtAsignado.setEditable(false);
        txtAsignado.setBorder(null);

        txtEstadoCaso.setEditable(false);
        txtEstadoCaso.setBorder(null);

        txtFechaEntrega.setEditable(false);
        txtFechaEntrega.setBorder(null);
        txtFechaEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaEntregaActionPerformed(evt);
            }
        });

        txtAreaDescripcion.setEditable(false);
        txtAreaDescripcion.setBackground(new java.awt.Color(240, 240, 240));
        txtAreaDescripcion.setColumns(20);
        txtAreaDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtAreaDescripcion);

        jLabel5.setText("Porcentaje de avance");

        jLabel8.setText("Probador");

        jLabel9.setText("Fecah de creación");

        jLabel10.setText("Fecha de actualización");

        jLabel11.setText("Fecha estimada para producción");

        txtPorcentaje.setEditable(false);
        txtPorcentaje.setBorder(null);

        txtProbador.setEditable(false);
        txtProbador.setBorder(null);
        txtProbador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProbadorActionPerformed(evt);
            }
        });

        txtFechaCreacion.setEditable(false);
        txtFechaCreacion.setBorder(null);

        txtFechaUpdate.setEditable(false);
        txtFechaUpdate.setBorder(null);

        txtFechaProduccion.setEditable(false);
        txtFechaProduccion.setBorder(null);

        btnNuevaBitacora.setMnemonic('a');
        btnNuevaBitacora.setText("Agregar Bitácora");
        btnNuevaBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaBitacoraActionPerformed(evt);
            }
        });

        jLabel12.setText("Solicitado por");

        txtSolicitadoPor.setEditable(false);
        txtSolicitadoPor.setBorder(null);

        btnReAbrir.setMnemonic('a');
        btnReAbrir.setText("Volver a abrir caso");
        btnReAbrir.setEnabled(false);
        btnReAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReAbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMenuLayout.createSequentialGroup()
                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4))
                            .addGap(1, 1, 1))
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdCaso)
                            .addComponent(txtTitulo)
                            .addComponent(txtAsignado)
                            .addComponent(txtEstadoCaso)
                            .addComponent(txtFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSolicitadoPor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(txtFechaUpdate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaProduccion, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProbador, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtFechaCreacion))
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReAbrir)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevaBitacora)
                        .addGap(44, 44, 44))))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnOpenCases))
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtProbador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEstadoCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtFechaUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtFechaProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtSolicitadoPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevaBitacora)
                            .addComponent(btnReAbrir))))
                .addGap(37, 37, 37)
                .addComponent(btnOpenCases)
                .addGap(0, 0, 0)
                .addComponent(lblTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlMenu);

        pnlBody.setLayout(new java.awt.CardLayout());

        jTableBinnacleView.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableBinnacleView.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableBinnacleView.setDoubleBuffered(true);
        jTableBinnacleView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBinnacleViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBinnacleView);

        pnlBody.add(jScrollPane1, "card4");

        getContentPane().add(pnlBody);

        setBounds(0, 0, 1016, 765);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenCasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenCasesActionPerformed
        lblTimeline.setBackground(new Color(0,204,106));
        
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(jTableBinnacleView);
        pnlBody.repaint();
        pnlBody.revalidate();
    }//GEN-LAST:event_btnOpenCasesActionPerformed

    private void txtIdCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCasoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCasoActionPerformed

    private void txtFechaEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaEntregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaEntregaActionPerformed

    private void txtProbadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProbadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProbadorActionPerformed

    private void btnNuevaBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaBitacoraActionPerformed
        // TODO add your handling code here:
        NewBinnacleView newBinnacleView = new NewBinnacleView(singleCaseBean.getId());
        newBinnacleView.setVisible(true);
        
    }//GEN-LAST:event_btnNuevaBitacoraActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(new Color(232,17,35));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void pnlHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMouseDragged
        if(maximized){
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - xMouse, y - yMouse);
        }
    }//GEN-LAST:event_pnlHeaderMouseDragged

    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlHeaderMousePressed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_formFocusLost

    private void pnlHeaderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnlHeaderFocusLost
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_pnlHeaderFocusLost

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowLostFocus

    private void jTableBinnacleViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBinnacleViewMouseClicked
        // TODO add your handling code here:
        int fila = jTableBinnacleView.getSelectedRow();
        BinnaclesBean binnaclesBean = new BinnaclesBean();
        DefaultTableModel dtm = (DefaultTableModel)jTableBinnacleView.getModel();
        binnaclesBean.setId(Integer.parseInt(dtm.getValueAt(fila, 0).toString()));
        binnaclesBean.setCaseId(dtm.getValueAt(fila, 1).toString());
        binnaclesBean.setCommentary(dtm.getValueAt(fila, 2).toString());
        binnaclesBean.setCreatedAt(dtm.getValueAt(fila, 3).toString());
        SingleBinnacleView singleBinnacle = new SingleBinnacleView(binnaclesBean);
        singleBinnacle.setVisible(true);
        
    }//GEN-LAST:event_jTableBinnacleViewMouseClicked

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowDeactivated

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        CasesController casesController = new CasesController();
        SingleCaseBean caseBean = casesController.listarCase(this.singleCaseBean);
        llenarTexbox(caseBean);
        binnaclesController=new BinnaclesController();
                try {
                       jTableBinnacleView.setModel(binnaclesController.mostrarTabla(singleCaseBean.getId()).getModel());
                       jTableBinnacleView.getColumnModel().getColumn(0).setMinWidth(5);
                       jTableBinnacleView.getColumnModel().getColumn(0).setPreferredWidth(6);
                       
                
                } catch (Exception e) {
        }
        
    }//GEN-LAST:event_formWindowActivated

    private void btnReAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReAbrirActionPerformed
        // TODO add your handling code here:
        CasesController casesController = new CasesController();
        if(casesController.reOpenCase(singleCaseBean.getId()))
        {
            JOptionPane.showMessageDialog(this, "Fecha de entrega extendida");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Fecha de entrega no extendida");
        }
    }//GEN-LAST:event_btnReAbrirActionPerformed

    private void llenarTexbox(SingleCaseBean bean){
        txtAreaDescripcion.setText(bean.getDescripcion());
        txtAsignado.setText(bean.getAsignadoA());
        txtEstadoCaso.setText(bean.getEstado());
        txtFechaCreacion.setText(bean.getFechaCreacion());
        txtFechaEntrega.setText(bean.getLimite());
        txtFechaProduccion.setText(bean.getProduccion());
        txtFechaUpdate.setText(bean.getUltimoCambio());
        txtIdCaso.setText(bean.getId());
        txtPorcentaje.setText(bean.getAvance().toString() + "%");
        txtProbador.setText(bean.getTester());
        txtSolicitadoPor.setText(bean.getCreadoPor());
        txtTitulo.setText(bean.getTitulo());
        if(bean.getAvance() == 100)
        {
            btnNuevaBitacora.setEnabled(false);
        }
        else
        {
            btnNuevaBitacora.setEnabled(true);
        }
        if(bean.getEstado().equals("Vencido") && LoginBean.getRol().equals("Jefe de desarrollo"))
        {
            btnReAbrir.setEnabled(true);
            btnReAbrir.setVisible(true);
        }
        else
        {
            btnReAbrir.setEnabled(false);
            btnReAbrir.setVisible(false);
        }
    } 
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNuevaBitacora;
    private javax.swing.JButton btnOpenCases;
    private javax.swing.JButton btnReAbrir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableBinnacleView;
    private javax.swing.JLabel lblTimeline;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JTextArea txtAreaDescripcion;
    private javax.swing.JTextField txtAsignado;
    private javax.swing.JTextField txtEstadoCaso;
    private javax.swing.JTextField txtFechaCreacion;
    private javax.swing.JTextField txtFechaEntrega;
    private javax.swing.JTextField txtFechaProduccion;
    private javax.swing.JTextField txtFechaUpdate;
    private javax.swing.JTextField txtIdCaso;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtProbador;
    private javax.swing.JTextField txtSolicitadoPor;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

}
