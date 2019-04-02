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
                vistaAdmin.setLocationRelativeTo(null);
                vistaAdmin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                vistaAdmin.setVisible(true);
                break;
                
            case "Jefe de área funcional":
                vistaJefeFunc = new JefeFuncionalView(logUser);
                vistaJefeFunc.setLocationRelativeTo(null);
                vistaJefeFunc.setExtendedState(JFrame.MAXIMIZED_BOTH);
                vistaJefeFunc.setVisible(true);
                break;
                
            case "Empleado de área funcional":
                vistaEmpleado = new EmpleadoView();
                vistaEmpleado.setLocationRelativeTo(null);
                vistaEmpleado.setExtendedState(JFrame.MAXIMIZED_BOTH);
                vistaEmpleado.setVisible(true);
                break;
                
            case "Jefe de desarrollo":
                vistaJefeDes = new JefeDesarrolloView();
                vistaJefeDes.setLocationRelativeTo(null);
                vistaEmpleado.setExtendedState(JFrame.MAXIMIZED_BOTH);
                vistaJefeDes.setVisible(true);
                break;
                
            case "Programador":
                vistaProgramador = new ProgramadorView();
                vistaProgramador.setLocationRelativeTo(null);
                vistaEmpleado.setExtendedState(JFrame.MAXIMIZED_BOTH);
                vistaProgramador.setVisible(true);
                break;
                
            default:
                break;
        }
    }
    
}
