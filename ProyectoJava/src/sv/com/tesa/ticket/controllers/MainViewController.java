/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;
import java.awt.Component;
import javax.swing.JFrame;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.views.*;
import sv.com.tesa.ticket.views.admin.AdminView;
/**
 *
 * @author Edu
 */
public class MainViewController {
    public static JefesMainView jefesMainView;
    public static AdminView vistaAdmin;
    
    public MainViewController()
    {
    }
    
    public void cargarVista(LoginBean logUser)
    {
        switch (LoginBean.getRol()) {
            case "Administrador":
                vistaAdmin = new AdminView(logUser);
                vistaAdmin.setLocationRelativeTo(null);
                vistaAdmin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                vistaAdmin.setVisible(true);
                break;
                
            case "Jefe de área funcional":
                jefesMainView = new JefesMainView();
                jefesMainView.setLocationRelativeTo(null);
                jefesMainView.setExtendedState(JFrame.MAXIMIZED_BOTH);
                jefesMainView.setVisible(true);
                break;
               
            case "Empleado de área funcional":
                break;
                
            case "Jefe de desarrollo":
                break;
                
            case "Programador":
                break;
                
            default:
                break;
        }
    }
    
}
