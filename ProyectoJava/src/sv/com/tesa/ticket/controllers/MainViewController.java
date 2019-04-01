/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.views.*;
import sv.com.tesa.ticket.views.admin.AdminView;
/**
 *
 * @author Edu
 */
public class MainViewController {
    
    @SuppressWarnings("FieldMayBeFinal")
    private AdminView vistaAdmin;
    
    public MainViewController()
    {
    }
    
    public void cargarVista(LoginBean logUser)
    {
        switch (logUser.getRol()) {
            case "Administrador":
                vistaAdmin = new AdminView(logUser);
                vistaAdmin.setLocationRelativeTo(null);
                vistaAdmin.setVisible(true);
                break;
                
            case "Jefe de área funcional":
                JefesMainView jefesMainView = new JefesMainView();
                jefesMainView.setLocationRelativeTo(null);
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
