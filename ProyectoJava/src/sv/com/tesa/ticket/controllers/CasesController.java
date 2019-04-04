package sv.com.tesa.ticket.controllers;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sv.com.tesa.ticket.models.CasesModel;
import sv.com.tesa.ticket.beans.CasesBean;
import javax.swing.JTable;

public class CasesController {
    private CasesModel modelcases;
    
    public CasesController(){
        modelcases = new CasesModel();
    }
    
    public JTable listarCases(){
        try{
            return modelcases.listarCasos();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public ResultSet listarCase(CasesBean beanCase){
        try{
            JOptionPane.showMessageDialog(null, "Entre al Controlador");
            return modelcases.listarCaso(beanCase);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    /*public ResultSet llenarRequest(){
        try{
            return modelcases.llenarRequest();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public ResultSet llenarAsigned(){
        try{
            return modelcases.llenarAsigned();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public ResultSet llenarTester(){
        try{
            return modelcases.llenarTester();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public ResultSet llenarEstado(){
        try{
            return modelcases.llenarEstado();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }*/
    
    public boolean modificarCaso(CasesBean beanCase)
    {
        try {
            return modelcases.modificarCaso(beanCase);
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
