/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;
import javax.swing.JFrame;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.views.*;
import sv.com.tesa.ticket.views.admin.AdminView;
/**
 *
 * @author Edu
 */
public class MainViewController {
    public static MainView mainView;
    public static EmployeesMainView employeesMainView;
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
                mainView = new MainView();
                mainView.setLocationRelativeTo(null);
                mainView.setExtendedState(JFrame.MAXIMIZED_BOTH);
                mainView.setVisible(true);
               
            case "Empleado de área funcional":
                employeesMainView = new EmployeesMainView();
                employeesMainView.setLocationRelativeTo(null);
                employeesMainView.setExtendedState(JFrame.MAXIMIZED_BOTH);
                employeesMainView.setVisible(true);
                break;
                
            case "Jefe de desarrollo":
                mainView = new MainView();
                mainView.setLocationRelativeTo(null);
                mainView.setExtendedState(JFrame.MAXIMIZED_BOTH);
                mainView.setVisible(true);
                break;
                
            case "Programador":
                employeesMainView = new EmployeesMainView();
                employeesMainView.setLocationRelativeTo(null);
                employeesMainView.setExtendedState(JFrame.MAXIMIZED_BOTH);
                employeesMainView.setVisible(true);
                break;
                
            default:
                break;
        }
    }
    
}
