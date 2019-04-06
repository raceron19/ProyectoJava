/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;

import java.util.HashMap;
import javax.swing.JTable;
import sv.com.tesa.ticket.beans.CaseBean;
import org.apache.log4j.Logger;
import sv.com.tesa.ticket.beans.SingleCaseBean;
import sv.com.tesa.ticket.models.CasesModel;

/**
 *
 * @author eduar
 */
public class CasesController {
    
    CasesModel casesModel;
    
    public CasesController()
    {
        casesModel = new CasesModel();
    }
    public JTable listarCases(){
        try{
            return casesModel.listarCasos();
        } catch(Exception ex){
            Logger.getLogger(CasesController.class).error(ex);
            return null;
        }
    }
    public SingleCaseBean listarCase(SingleCaseBean beanCase){
        try{
            return casesModel.listarCaso(beanCase);
        }catch(Exception ex){
            Logger.getLogger(CasesController.class).error(ex);
            return null;
        }
    }
    
    public HashMap<Integer,String> listarEmpleadosACargo()
    {
        try {
            return casesModel.listarEmpleadosACargo();
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean ingresarEmpledado(CaseBean caso)
    {
        try {
            return casesModel.ingresarCaso(caso);
        } catch (Exception ex)
        {
            Logger.getLogger(CasesController.class).error(ex);
            return false;
        }
    }
    public boolean reOpenCase(String caseId){
        try{
            return casesModel.reOpenCase(caseId);
        }catch(Exception ex){
            Logger.getLogger(CasesController.class).error(null, ex);
            return false;
        }
    }
}
