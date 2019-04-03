package sv.com.tesa.ticket.views;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.beans.RecentCasesBean;
import sv.com.tesa.ticket.beans.RecentRequestsBean;
import sv.com.tesa.ticket.controllers.RecentCasesController;
import sv.com.tesa.ticket.controllers.RecentRequestsController;

/**
 *
 * @author Rahmans
 */
public class DashBoardJefeDesarrollo extends javax.swing.JInternalFrame {

    static boolean maximized = true;
    int xMouse;
    int yMouse;
    
    public DashBoardJefeDesarrollo(LoginBean user) {
        initComponents();
        setUndecorated(true);
        switch (LoginBean.getRol()) {
            case "Jefe de área funcional" :
                lblUser.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/JefeFuncional.png").getImage().
                        getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                break;
            case "Empleado de área funcional" :
                lblUser.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/EmpleadoFuncional.png").getImage().
                        getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                break;
            case "Jefe de desarrollo" :
                lblUser.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/JefeDesarrollo.png").getImage().
                        getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                break;
            case "Programador" :
                lblUser.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/Desarrollador.png").getImage().
                        getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                break;
            default:
                throw new AssertionError();
        }
                lblRol.setText(LoginBean.getRol());
                lblUsuario.setText(LoginBean.getNombre());
                lblReciente1.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblReciente2.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblReciente3.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblReciente4.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblReciente4.setHorizontalAlignment(SwingConstants.LEFT);
                lblReciente4.setVerticalAlignment(SwingConstants.CENTER);
                lblReciente5.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblReciente5.setHorizontalAlignment(SwingConstants.LEFT);
                lblReciente5.setVerticalAlignment(SwingConstants.CENTER);
                
                
                lblCasoFinalizado.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblCasoFinalizado.setHorizontalAlignment(SwingConstants.LEFT);
                lblCasoFinalizado.setVerticalAlignment(SwingConstants.CENTER);
                lblCasoDevuelto.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblCasoDevuelto.setHorizontalAlignment(SwingConstants.LEFT);
                lblCasoDevuelto.setVerticalAlignment(SwingConstants.CENTER);
                lblCasoPorAprobar.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblCasoPorAprobar.setHorizontalAlignment(SwingConstants.LEFT);
                lblCasoPorAprobar.setVerticalAlignment(SwingConstants.CENTER);
                lblCasoVencido.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblCasoVencido.setHorizontalAlignment(SwingConstants.LEFT);
                lblCasoVencido.setVerticalAlignment(SwingConstants.CENTER);
                
                
                lblRequestCerrado.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblRequestCerrado.setHorizontalAlignment(SwingConstants.LEFT);
                lblRequestCerrado.setVerticalAlignment(SwingConstants.CENTER);
                lblRequestDesarrollo.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblRequestDesarrollo.setHorizontalAlignment(SwingConstants.LEFT);
                lblRequestDesarrollo.setVerticalAlignment(SwingConstants.CENTER);
                lblRequestPorAprobar.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblRequestPorAprobar.setHorizontalAlignment(SwingConstants.LEFT);
                lblRequestPorAprobar.setVerticalAlignment(SwingConstants.CENTER);
                lblRequestRechazado.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/nodata.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                lblRequestRechazado.setHorizontalAlignment(SwingConstants.LEFT);
                lblRequestRechazado.setVerticalAlignment(SwingConstants.CENTER);
                llenarCasesLabels();
    }

    DashBoardJefeDesarrollo() {
        initComponents();
        setUndecorated(true);
    }
    public void setUndecorated(boolean val)
    {
        setBorder(null);
        ((BasicInternalFrameUI) getUI()).setNorthPane(null);
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
        lblUsuario = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnOpenCases = new javax.swing.JButton();
        lblTimeline = new javax.swing.JLabel();
        btnOtherCases = new javax.swing.JButton();
        lblNews = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        btnRequests = new javax.swing.JButton();
        lblRequest = new javax.swing.JLabel();
        pnlBody = new javax.swing.JPanel();
        jpOpenCases = new javax.swing.JScrollPane();
        pnlOpenCases = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblReciente1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblReciente2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblReciente3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblReciente4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblReciente5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        jpOtherCases = new javax.swing.JScrollPane();
        pnlOtherCases = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblCasoFinalizado = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblCasoDevuelto = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblCasoPorAprobar = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lblCasoVencido = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        lblTodosCasos = new javax.swing.JLabel();
        jpRequests = new javax.swing.JScrollPane();
        pnlRequest = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lblRequestCerrado = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        lblRequestDesarrollo = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        lblRequestPorAprobar = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        lblRequestRechazado = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        lblTodosOtrosCasos = new javax.swing.JLabel();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));

        lblUsuario.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(44, 62, 80));
        lblUsuario.setText("USUARIO");

        lblRol.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRol.setForeground(new java.awt.Color(127, 140, 141));
        lblRol.setText("ROL");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(52, 152, 219));
        jLabel5.setText("Ajustes");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnOpenCases.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnOpenCases.setForeground(new java.awt.Color(44, 62, 80));
        btnOpenCases.setText("Casos Abiertos");
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

        btnOtherCases.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnOtherCases.setForeground(new java.awt.Color(44, 62, 80));
        btnOtherCases.setText("Otros Casos");
        btnOtherCases.setBorder(null);
        btnOtherCases.setContentAreaFilled(false);
        btnOtherCases.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOtherCases.setFocusable(false);
        btnOtherCases.setPreferredSize(new java.awt.Dimension(100, 27));
        btnOtherCases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtherCasesActionPerformed(evt);
            }
        });

        lblNews.setBackground(new java.awt.Color(255, 255, 255));
        lblNews.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNews.setOpaque(true);

        btnRequests.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnRequests.setForeground(new java.awt.Color(44, 62, 80));
        btnRequests.setText("Últimas peticiones");
        btnRequests.setBorder(null);
        btnRequests.setContentAreaFilled(false);
        btnRequests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRequests.setFocusable(false);
        btnRequests.setPreferredSize(new java.awt.Dimension(100, 27));
        btnRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestsActionPerformed(evt);
            }
        });

        lblRequest.setBackground(new java.awt.Color(255, 255, 255));
        lblRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRequest.setOpaque(true);

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 472, Short.MAX_VALUE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTimeline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpenCases, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNews, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOtherCases, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRequests, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addGap(5, 5, 5)
                        .addComponent(lblRol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOpenCases)
                            .addComponent(btnOtherCases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRequests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNews, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblRequest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlBody.setLayout(new java.awt.CardLayout(10, 10));

        jpOpenCases.setBorder(null);

        pnlOpenCases.setBackground(new java.awt.Color(245, 245, 245));
        pnlOpenCases.setLayout(new java.awt.GridLayout(2, 3, 30, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 350));

        jLabel6.setBackground(new java.awt.Color(0, 204, 106));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Reciente");
        jLabel6.setOpaque(true);

        lblReciente1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReciente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReciente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReciente1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpenCases.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setMaximumSize(new java.awt.Dimension(400, 350));

        jLabel7.setBackground(new java.awt.Color(52, 152, 219));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Reciente");
        jLabel7.setOpaque(true);

        lblReciente2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReciente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReciente2, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReciente2, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpenCases.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.setMaximumSize(new java.awt.Dimension(400, 350));

        jLabel8.setBackground(new java.awt.Color(243, 156, 18));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Reciente");
        jLabel8.setOpaque(true);

        lblReciente3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReciente3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReciente3, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReciente3, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpenCases.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setMaximumSize(new java.awt.Dimension(400, 350));

        jLabel9.setBackground(new java.awt.Color(149, 165, 166));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Reciente");
        jLabel9.setOpaque(true);

        lblReciente4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReciente4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReciente4, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReciente4, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpenCases.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.setMaximumSize(new java.awt.Dimension(400, 350));

        jLabel10.setBackground(new java.awt.Color(149, 165, 166));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Reciente");
        jLabel10.setOpaque(true);

        lblReciente5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReciente5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReciente5, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReciente5, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpenCases.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.setMaximumSize(new java.awt.Dimension(400, 350));

        jLabel11.setBackground(new java.awt.Color(149, 165, 166));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Todos");
        jLabel11.setOpaque(true);

        lblTodos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTodos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTodos, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTodos, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpenCases.add(jPanel6);

        jpOpenCases.setViewportView(pnlOpenCases);

        pnlBody.add(jpOpenCases, "card2");

        jpOtherCases.setBorder(null);

        pnlOtherCases.setBackground(new java.awt.Color(245, 245, 245));
        pnlOtherCases.setLayout(new java.awt.GridLayout(2, 3, 30, 30));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(0, 204, 106));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Último Finalizado");
        jLabel19.setOpaque(true);

        lblCasoFinalizado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCasoFinalizado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCasoFinalizado, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOtherCases.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel21.setBackground(new java.awt.Color(52, 152, 219));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Devuelto con Observaciones");
        jLabel21.setOpaque(true);

        lblCasoDevuelto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCasoDevuelto, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCasoDevuelto, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOtherCases.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel23.setBackground(new java.awt.Color(243, 156, 18));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Esperando Aprobación");
        jLabel23.setOpaque(true);

        lblCasoPorAprobar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCasoPorAprobar, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCasoPorAprobar, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOtherCases.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel25.setBackground(new java.awt.Color(149, 165, 166));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Vencido");
        jLabel25.setOpaque(true);

        lblCasoVencido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCasoVencido, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCasoVencido, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOtherCases.add(jPanel10);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel31.setBackground(new java.awt.Color(149, 165, 166));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Todos");
        jLabel31.setOpaque(true);

        lblTodosCasos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTodosCasos, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTodosCasos, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlOtherCases.add(jPanel13);

        jpOtherCases.setViewportView(pnlOtherCases);

        pnlBody.add(jpOtherCases, "card2");

        jpRequests.setBorder(null);

        pnlRequest.setBackground(new java.awt.Color(245, 245, 245));
        pnlRequest.setLayout(new java.awt.GridLayout(2, 3, 30, 30));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        jLabel27.setBackground(new java.awt.Color(0, 204, 106));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Último Finalizado");
        jLabel27.setOpaque(true);

        lblRequestCerrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRequestCerrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRequestCerrado, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlRequest.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel29.setBackground(new java.awt.Color(52, 152, 219));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("En Desarrollo");
        jLabel29.setOpaque(true);

        lblRequestDesarrollo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRequestDesarrollo, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRequestDesarrollo, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlRequest.add(jPanel12);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel33.setBackground(new java.awt.Color(243, 156, 18));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Esperando Aprobación");
        jLabel33.setOpaque(true);

        lblRequestPorAprobar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRequestPorAprobar, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRequestPorAprobar, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlRequest.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel35.setBackground(new java.awt.Color(149, 165, 166));
        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Rechazaso");
        jLabel35.setOpaque(true);

        lblRequestRechazado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRequestRechazado, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRequestRechazado, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlRequest.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel37.setBackground(new java.awt.Color(149, 165, 166));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Todos");
        jLabel37.setOpaque(true);

        lblTodosOtrosCasos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTodosOtrosCasos, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTodosOtrosCasos, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlRequest.add(jPanel16);

        jpRequests.setViewportView(pnlRequest);

        pnlBody.add(jpRequests, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBody, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1018, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtherCasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtherCasesActionPerformed
        lblNews.setBackground(new Color(0,204,106));
        lblRequest.setBackground(new Color(255, 255, 255));
        lblTimeline.setBackground(new Color(255,255,255));
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(jpOtherCases);
        pnlBody.repaint();
        pnlBody.revalidate();
        llenarOtherCasesLabels();
    }//GEN-LAST:event_btnOtherCasesActionPerformed

    private void btnOpenCasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenCasesActionPerformed
        lblTimeline.setBackground(new Color(0,204,106));
        lblRequest.setBackground(new Color(255, 255, 255));
        lblNews.setBackground(new Color(255,255,255));
        
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(jpOpenCases);
        pnlBody.repaint();
        pnlBody.revalidate();
    }//GEN-LAST:event_btnOpenCasesActionPerformed

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel7MouseClicked

    private void btnRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestsActionPerformed
        // TODO add your handling code here:                                         
        lblRequest.setBackground(new Color(0,204,106));    
        lblTimeline.setBackground(new Color(255,255,255));
        lblNews.setBackground(new Color(255,255,255));        
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(pnlRequest);
        pnlBody.repaint();
        pnlBody.revalidate();
        llenarRequestsLabels();
        
    }//GEN-LAST:event_btnRequestsActionPerformed

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    public void llenarCasesLabels()
    {
        RecentCasesController recentCasesController = new RecentCasesController();
        ArrayList<RecentCasesBean> recentCasesBean = recentCasesController.listarUltimos();
        String [] labels = new String [5];
        labels[0]="";        
        labels[1]="";
        labels[2]="";
        labels[3]="";
        labels[4]="";
        for (int i = 0; i < recentCasesBean.size(); i++) 
        {
            if(recentCasesBean.get(i) != null)
            {
                if(i == 0)
                {
                lblReciente1.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                    + "ticket/images/GreenFolder.png").getImage().
                    getScaledInstance(128, 128, 50)));
                }
                if(i == 1)
                {
                lblReciente2.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                    + "ticket/images/BlueFolder.png").getImage().
                    getScaledInstance(128, 128, 50)));
                }
                if(i == 2)
                {
                lblReciente3.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                    + "ticket/images/OrangeFolder.png").getImage().
                    getScaledInstance(128, 128, 50)));
                }
                if(i == 3)
                {
                lblReciente4.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                    + "ticket/images/CornFlowerBlueFolder.png").getImage().
                    getScaledInstance(128, 128, 50)));
                }
                if(i == 3)
                {
                lblReciente4.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                    + "ticket/images/GrayFolder.png").getImage().
                    getScaledInstance(128, 128, 50)));
                }
                labels[i] = "<html><p>" + tab + "<b>ID:</b><br>" + tab +
                    recentCasesBean.get(i).getId() + "</p><p>" + tab + "<b>Título:</b><br>" + tab +
                    recentCasesBean.get(i).getTitulo() + "</p><p>" + tab + "<b>Creado por:</b><br>" + tab +
                    recentCasesBean.get(i).getCreadoPor() + "</p><p>" + tab + "<b>Asignado a:</b><br>" + tab +
                    recentCasesBean.get(i).getAsignadoA() + "</p><p>" + tab + "<b>Deadline:</b><br>" + tab +
                    recentCasesBean.get(i).getLimite() + "</p><p>" + tab + "<b>Procentaje de avance:</b><br>" + tab +
                    recentCasesBean.get(i).getAvance() + "%</p><p>" + tab + "<b>Última modificación:</b><br>" + tab +
                    recentCasesBean.get(i).getUltimoCambio() + "</p></html>";
            }
            else
            {
                break;
            }
        }
        lblReciente1.setText(labels[0]);        
        lblReciente2.setText(labels[1]);
        lblReciente3.setText(labels[2]);
        lblReciente4.setText(labels[3]);
        lblReciente5.setText(labels[4]);
    }
    public void llenarOtherCasesLabels()
    {
        RecentCasesController recentCasesController = new RecentCasesController();
        RecentCasesBean recentCasesBean = recentCasesController.getLastFinalized();
        if(recentCasesBean.getId() != null)
        {
            lblCasoFinalizado.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/GreenFolder.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
            lblCasoFinalizado.setText("<html><p>" + tab + "<b>ID:</b><br>" + tab +
                recentCasesBean.getId() + "</p><p>" + tab + "<b>Título:</b><br>" + tab +
                recentCasesBean.getTitulo() + "</p><p>" + tab + "<b>Creado por:</b><br>" + tab +
                recentCasesBean.getCreadoPor() + "</p><p>" + tab + "<b>Asignado a:</b><br>" + tab +
                recentCasesBean.getAsignadoA() + "</p><p>" + tab + "<b>Deadline:</b><br>" + tab +
                recentCasesBean.getLimite() + "</p><p>" + tab + "<b>Procentaje de avance:</b><br>" + tab +
                recentCasesBean.getAvance() + "%</p><p>" + tab + "<b>Última modificación:</b><br>" + tab +
                recentCasesBean.getUltimoCambio() + "</p></html>");
        }
        
        recentCasesBean = recentCasesController.getLastBack();
        if(recentCasesBean.getId() != null)
        {
            lblCasoDevuelto.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/BlueFolder.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
            lblCasoDevuelto.setText("<html><p>" + tab + "<b>ID:</b><br>" + tab +
                recentCasesBean.getId() + "</p><p>" + tab + "<b>Título:</b><br>" + tab +
                recentCasesBean.getTitulo() + "</p><p>" + tab + "<b>Creado por:</b><br>" + tab +
                recentCasesBean.getCreadoPor() + "</p><p>" + tab + "<b>Asignado a:</b><br>" + tab +
                recentCasesBean.getAsignadoA() + "</p><p>" + tab + "<b>Deadline:</b><br>" + tab +
                recentCasesBean.getLimite() + "</p><p>" + tab + "<b>Procentaje de avance:</b><br>" + tab +
                recentCasesBean.getAvance() + "%</p><p>" + tab + "<b>Última modificación:</b><br>" + tab +
                recentCasesBean.getUltimoCambio() + "</p></html>");
        }
        
        recentCasesBean = recentCasesController.getLastToAccept();
        
        if(recentCasesBean.getId() != null)
        {
            lblCasoPorAprobar.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/OrangeFolder.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
            lblCasoPorAprobar.setText("<html><p>" + tab + "<b>ID:</b><br>" + tab +
                recentCasesBean.getId() + "</p><p>" + tab + "<b>Título:</b><br>" + tab +
                recentCasesBean.getTitulo() + "</p><p>" + tab + "<b>Creado por:</b><br>" + tab +
                recentCasesBean.getCreadoPor() + "</p><p>" + tab + "<b>Asignado a:</b><br>" + tab +
                recentCasesBean.getAsignadoA() + "</p><p>" + tab + "<b>Deadline:</b><br>" + tab +
                recentCasesBean.getLimite() + "</p><p>" + tab + "<b>Procentaje de avance:</b><br>" + tab +
                recentCasesBean.getAvance() + "%</p><p>" + tab + "<b>Última modificación:</b><br>" + tab +
                recentCasesBean.getUltimoCambio() + "</p></html>");
        }
            
        recentCasesBean = recentCasesController.getLastVencido();
        
        if(recentCasesBean.getId() != null)
        {
            lblCasoVencido.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/CornFlowerBlueFolder.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
            lblCasoVencido.setText("<html><p>" + tab + "<b>ID:</b><br>" + tab +
                recentCasesBean.getId() + "</p><p>" + tab + "<b>Título:</b><br>" + tab +
                recentCasesBean.getTitulo() + "</p><p>" + tab + "<b>Creado por:</b><br>" + tab +
                recentCasesBean.getCreadoPor() + "</p><p>" + tab + "<b>Asignado a:</b><br>" + tab +
                recentCasesBean.getAsignadoA() + "</p><p>" + tab + "<b>Deadline:</b><br>" + tab +
                recentCasesBean.getLimite() + "</p><p>" + tab + "<b>Procentaje de avance:</b><br>" + tab +
                recentCasesBean.getAvance() + "%</p><p>" + tab + "<b>Última modificación:</b><br>" + tab +
                recentCasesBean.getUltimoCambio() + "</p></html>");
        }
    }
    public void llenarRequestsLabels()
    {
        RecentRequestsController recentRequestsController = new RecentRequestsController();
        RecentRequestsBean recentRequestsBean = recentRequestsController.getLastClosed();
        if(recentRequestsBean.getId() != null)
        {
            lblRequestCerrado.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/GreenFolder.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
            lblRequestCerrado.setText("<html><p>" + tab + "<b>ID:</b><br>" + tab +
                recentRequestsBean.getId() + "</p><p>" + tab + "<b>Título:</b><br>" + tab +
                recentRequestsBean.getTipo() + "</p><p>" + tab + "<b>Tipo de solicitud:</b><br>" + tab +
                recentRequestsBean.getTitulo() + "</p><p>" + tab + "<b>Creado por:</b><br>" + tab +
                recentRequestsBean.getCreadoPor() + "</p><p>" + tab + "<b>Asignado a:</b><br>" + tab +
                recentRequestsBean.getCreado()+ "</p><p>" + tab + "<b>Fecha de creación:</b><br>" + tab +
                recentRequestsBean.getUltimoCambio() + "</p></html>");
        }
        
        recentRequestsBean = recentRequestsController.getLastDevelop();
        if(recentRequestsBean.getId() != null)
        {
            lblRequestDesarrollo.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/BlueFolder.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
            lblRequestDesarrollo.setText("<html><p>" + tab + "<b>ID:</b><br>" + tab +
                recentRequestsBean.getId() + "</p><p>" + tab + "<b>Título:</b><br>" + tab +
                recentRequestsBean.getTipo() + "</p><p>" + tab + "<b>Tipo de solicitud:</b><br>" + tab +
                recentRequestsBean.getTitulo() + "</p><p>" + tab + "<b>Creado por:</b><br>" + tab +
                recentRequestsBean.getCreadoPor() + "</p><p>" + tab + "<b>Fecha de creación:</b><br>" + tab +
                recentRequestsBean.getCreado()+ "</p><p>" + tab + "<b>Último cambio:</b><br>" + tab +
                recentRequestsBean.getUltimoCambio() + "</p></html>");
        }
        
        recentRequestsBean = recentRequestsController.getLastToAccep();
        
        if(recentRequestsBean.getId() != null)
        {
            lblRequestPorAprobar.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/OrangeFolder.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
            lblRequestPorAprobar.setText("<html><p>" + tab + "<b>ID:</b><br>" + tab +
                recentRequestsBean.getId() + "</p><p>" + tab + "<b>Título:</b><br>" + tab +
                recentRequestsBean.getTipo() + "</p><p>" + tab + "<b>Tipo de solicitud:</b><br>" + tab +
                recentRequestsBean.getTitulo() + "</p><p>" + tab + "<b>Creado por:</b><br>" + tab +
                recentRequestsBean.getCreadoPor() + "</p><p>" + tab + "<b>Asignado a:</b><br>" + tab +
                recentRequestsBean.getCreado()+ "</p><p>" + tab + "<b>Fecha de creación:</b><br>" + tab +
                recentRequestsBean.getUltimoCambio() + "</p></html>");
        }
            
        recentRequestsBean = recentRequestsController.getLastRefused();
        
        if(recentRequestsBean.getId() != null)
        {
            lblRequestRechazado.setIcon(new ImageIcon(new ImageIcon("./src/sv/com/tesa/"
                        + "ticket/images/CornFlowerBlueFolder.png").getImage().
                        getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
            lblRequestRechazado.setText("<html><p>" + tab + "<b>ID:</b><br>" + tab +
                recentRequestsBean.getId() + "</p><p>" + tab + "<b>Título:</b><br>" + tab +
                recentRequestsBean.getTipo() + "</p><p>" + tab + "<b>Tipo de solicitud:</b><br>" + tab +
                recentRequestsBean.getTitulo() + "</p><p>" + tab + "<b>Creado por:</b><br>" + tab +
                recentRequestsBean.getCreadoPor() + "</p><p>" + tab + "<b>Asignado a:</b><br>" + tab +
                recentRequestsBean.getCreado()+ "</p><p>" + tab + "<b>Fecha de creación:</b><br>" + tab +
                recentRequestsBean.getUltimoCambio() + "</p></html>");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOpenCases;
    private javax.swing.JButton btnOtherCases;
    private javax.swing.JButton btnRequests;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jpOpenCases;
    private javax.swing.JScrollPane jpOtherCases;
    private javax.swing.JScrollPane jpRequests;
    private javax.swing.JLabel lblCasoDevuelto;
    private javax.swing.JLabel lblCasoFinalizado;
    private javax.swing.JLabel lblCasoPorAprobar;
    private javax.swing.JLabel lblCasoVencido;
    private javax.swing.JLabel lblNews;
    private javax.swing.JLabel lblReciente1;
    private javax.swing.JLabel lblReciente2;
    private javax.swing.JLabel lblReciente3;
    private javax.swing.JLabel lblReciente4;
    private javax.swing.JLabel lblReciente5;
    private javax.swing.JLabel lblRequest;
    private javax.swing.JLabel lblRequestCerrado;
    private javax.swing.JLabel lblRequestDesarrollo;
    private javax.swing.JLabel lblRequestPorAprobar;
    private javax.swing.JLabel lblRequestRechazado;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblTimeline;
    private javax.swing.JLabel lblTodos;
    private javax.swing.JLabel lblTodosCasos;
    private javax.swing.JLabel lblTodosOtrosCasos;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlMenu;
    protected javax.swing.JPanel pnlOpenCases;
    private javax.swing.JPanel pnlOtherCases;
    private javax.swing.JPanel pnlRequest;
    // End of variables declaration//GEN-END:variables

}
