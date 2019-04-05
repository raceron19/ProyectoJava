package sv.com.tesa.ticket.controllers;
import sv.com.tesa.ticket.models.RecentCasesModel;
import javax.swing.JTable;
import sv.com.tesa.ticket.beans.SingleCaseBean;

public class CasesController {
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
    public SingleCaseBean listarCase(SingleCaseBean beanCase){
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

}
