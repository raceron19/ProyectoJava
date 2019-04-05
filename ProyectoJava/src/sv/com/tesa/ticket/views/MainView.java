/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.views;

import java.beans.PropertyVetoException;
import java.util.logging.Level;

import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.beans.RecentCasesBean;

/**
 *
 * @author eduar
 */
public class MainView extends javax.swing.JFrame {
            
    LoginBean loginBean = new LoginBean();
    RequestsView requestsView = new RequestsView(loginBean);
    DashBoardJefes db = new DashBoardJefes(loginBean);
    BinnaclesView view = new BinnaclesView(new RecentCasesBean("DST19895"));

    /**
     * Creates new form NewMDIApplication
     */
    public MainView() {
        initComponents();
        setExtendedState(MainView.MAXIMIZED_BOTH);
         try {
            // TODO add your handling code here:
            if(!DashBoardJefes.isOpen) 
            {
                    desktopPane.add(db);
                    DashBoardJefes.isOpen = true;
            }
                requestsView.setVisible(false);
                view.setVisible(false);
            db.setSelected(true);
            db.setMaximizable(true);
            db.setMaximum(true);
            db.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainView.class.getName()).log(null, ex);
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

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        InicioMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        verSolicitudesMenuItem = new javax.swing.JMenuItem();
        nuevaSolicitudMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 6000));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        desktopPane.setMinimumSize(new java.awt.Dimension(1000, 600));

        menuBar.setMinimumSize(new java.awt.Dimension(1000, 600));

        fileMenu.setMnemonic('f');
        fileMenu.setText("Profile");

        InicioMenuItem.setMnemonic('o');
        InicioMenuItem.setText("Inicio");
        InicioMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(InicioMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Logout");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Solicitudes");

        verSolicitudesMenuItem.setMnemonic('t');
        verSolicitudesMenuItem.setText("Ver solicitudes");
        verSolicitudesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verSolicitudesMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(verSolicitudesMenuItem);

        nuevaSolicitudMenuItem.setMnemonic('y');
        nuevaSolicitudMenuItem.setText("Neuva solicitud");
        editMenu.add(nuevaSolicitudMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed

        formWindowClosing(null);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void verSolicitudesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verSolicitudesMenuItemActionPerformed
        try {
            
                db.setVisible(false);
                view.setVisible(false);
                if(!RequestsView.isOpen) 
            {
                    desktopPane.add(requestsView);
                    RequestsView.isOpen = true;
            }
            requestsView.setSelected(true);
            requestsView.setMaximizable(true);
            requestsView.setMaximum(true);
            requestsView.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainView.class.getName()).log(null, ex);
        }
    }//GEN-LAST:event_verSolicitudesMenuItemActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        try {
            // TODO add your handling code here:
            // TODO add your handling code here:
            
                requestsView.setVisible(false);
                db.setVisible(false);
                if(!BinnaclesView.isOpen) 
            {
                    desktopPane.add(view);
                    BinnaclesView.isOpen = true;
            }
            
            view.setSelected(true);
            view.setMaximizable(true);
            view.setMaximum(true);
            view.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainView.class.getName()).log(null, ex);
        }
    }//GEN-LAST:event_deleteMenuItemActionPerformed
    public void disposeOnPasswordChanged()
    {
        LoginBean loginBean = new LoginBean(0);
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
        this.dispose();
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Integer result = JOptionPane.showConfirmDialog(this, "¿Desea cerrar "
        + "sesión?", "Saliendo", JOptionPane.YES_NO_OPTION, 
        JOptionPane.INFORMATION_MESSAGE, null);
        if(result == JOptionPane.YES_OPTION)
        {
        LoginBean loginBean = new LoginBean(0);
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void InicioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioMenuItemActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
                requestsView.setVisible(false);
                view.setVisible(false);
                if(!DashBoardJefes.isOpen) 
            {
                    desktopPane.add(db);
                    DashBoardJefes.isOpen = true;
            }
            db.setSelected(true);
            db.setMaximizable(true);
            db.setMaximum(true);
            db.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainView.class.getName()).log(null, ex);
        }
    }//GEN-LAST:event_InicioMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem InicioMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem nuevaSolicitudMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem verSolicitudesMenuItem;
    // End of variables declaration//GEN-END:variables

}
