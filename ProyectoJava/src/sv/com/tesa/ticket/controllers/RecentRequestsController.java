/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;

import java.util.ArrayList;
import sv.com.tesa.ticket.beans.RecentRequestsBean;
import sv.com.tesa.ticket.models.RecentRequestsModel;

/**
 *
 * @author eduar
 */
public class RecentRequestsController 
{
    private RecentRequestsModel recentRequestsModel = new RecentRequestsModel();
    public RecentRequestsController()
    {
        
    }
    public ArrayList<RecentRequestsBean> listarUltimos()
    {
        return recentRequestsModel.recientes();
    }
    public RecentRequestsBean getLastClosed()
    {
        return recentRequestsModel.latestRequets("Cerrado");
    }
    public RecentRequestsBean getLastToAccep()
    {
        return recentRequestsModel.latestRequets("Aprobar");
    }
    public RecentRequestsBean getLastDevelop()
    {
        return recentRequestsModel.latestRequets("Desarrollo");
    }
    public RecentRequestsBean getLastRefused()
    {
        return recentRequestsModel.latestRequets("Rechazado");
    }
}
