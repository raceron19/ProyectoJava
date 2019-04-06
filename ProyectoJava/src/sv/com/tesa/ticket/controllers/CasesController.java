/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;

import javax.swing.JTable;
import sv.com.tesa.ticket.beans.SingleCaseBean;
import sv.com.tesa.ticket.models.CasesModel;

/**
 *
 * @author eduar
 */
public class CasesController {
    CasesModel casesModel = new CasesModel();
    public JTable listarCases(){
        try{
            return casesModel.listarCasos();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public SingleCaseBean listarCase(SingleCaseBean beanCase){
        try{
            return casesModel.listarCaso(beanCase);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
