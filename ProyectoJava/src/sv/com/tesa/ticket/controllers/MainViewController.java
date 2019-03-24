/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.models.LoginModel;
import sv.com.tesa.ticket.views.AdminView;
/**
 *
 * @author Edu
 */
public class MainViewController {
    
    private LoginModel logModel;
    private LoginBean logUser;
    private AdminView vistaAdmin;
    
    public MainViewController()
    {
        logModel = new LoginModel();
    }
    
    public void cargarVista(LoginBean logUser)
    {
        if (logUser.getRol().equals("Administrador")) 
        {
            vistaAdmin = new AdminView();
            vistaAdmin.setSize(500,500);
            vistaAdmin.setVisible(true);
        }
    }
    
}
