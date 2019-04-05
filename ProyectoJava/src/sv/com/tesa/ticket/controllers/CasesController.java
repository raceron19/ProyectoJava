package sv.com.tesa.ticket.controllers;
import sv.com.tesa.ticket.beans.RecentCasesBean;
import sv.com.tesa.ticket.models.RecentCasesModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import sv.com.tesa.ticket.beans.SingleCaseBean;
import sv.com.tesa.ticket.beans.SingleRequestBean;

public class CasesController {
    private RecentCasesBean [] recentCases = null;
    private RecentCasesBean otherCase = null;
    private RecentCasesModel recentCasesModel = new RecentCasesModel();
    public CasesController()
    {
    }
    
    public JTable listarCases(){
        try{
            return recentCasesModel.listarCasos();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public SingleCaseBean listarCase(RecentCasesBean beanCase){
        try{
            return recentCasesModel.listarCaso(beanCase);
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
