/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;

import java.util.ArrayList;
import sv.com.tesa.ticket.beans.RecentCasesBean;
import sv.com.tesa.ticket.models.RecentCasesModel;

/**
 *
 * @author eduar
 */
public class RecentCasesController 
{
    private RecentCasesBean otherCase = null;
    private RecentCasesModel recentCasesModel = new RecentCasesModel();
    public RecentCasesController()
    {
        
    }
    public ArrayList<RecentCasesBean> listarUltimos()
    {
        return recentCasesModel.recientes();
    }
    public RecentCasesBean getLastFinalized()
    {
        otherCase = recentCasesModel.otherCases("Finalizado");
        return otherCase;
    }
    public RecentCasesBean getLastBack()
    {
        otherCase = recentCasesModel.otherCases("Aprobar");
        return otherCase;
    }
    public RecentCasesBean getLastVencido()
    {
        otherCase = recentCasesModel.otherCases("Vencido");
        return otherCase;
    }
    public RecentCasesBean getLastToAccept()
    {
        otherCase = recentCasesModel.otherCases("Devuelto");
        return otherCase;
    }
}
