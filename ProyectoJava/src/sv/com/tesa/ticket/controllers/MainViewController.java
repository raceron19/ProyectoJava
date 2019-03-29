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
    private EmpleadoView vistaEmpleado;
    private JefeDesarrolloView vistaJefeDes;
    private JefeFuncionalView vistaJefeFunc;
    private ProgramadorView vistaProgramador;
    
    public MainViewController()
    {
    }
    
    public void cargarVista(LoginBean logUser)
    {
        switch (logUser.getRol()) {
            case "Administrador":
                vistaAdmin = new AdminView(logUser);
                vistaAdmin.setSize(500,500);
                vistaAdmin.setLocationRelativeTo(null);
                vistaAdmin.setVisible(true);
                break;
                
            case "Jefe de área funcional":
                vistaJefeFunc = new JefeFuncionalView();
                vistaJefeFunc.setSize(500,500);
                vistaJefeFunc.setLocationRelativeTo(null);
                vistaJefeFunc.setVisible(true);
                break;
                
            case "Empleado de área funcional":
                vistaEmpleado = new EmpleadoView();
                vistaEmpleado.setSize(500,500);
                vistaEmpleado.setLocationRelativeTo(null);
                vistaEmpleado.setVisible(true);
                break;
                
            case "Jefe de desarrollo":
                vistaJefeDes = new JefeDesarrolloView();
                vistaJefeDes.setSize(500, 500);
                vistaJefeDes.setLocationRelativeTo(null);
                vistaJefeDes.setVisible(true);
                break;
                
            case "Programador":
                vistaProgramador = new ProgramadorView();
                vistaProgramador.setSize(500, 500);
                vistaProgramador.setLocationRelativeTo(null);
                vistaProgramador.setVisible(true);
                break;
                
            default:
                break;
        }
    }
    
}
