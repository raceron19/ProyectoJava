/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;

import sv.com.tesa.ticket.beans.EmployeeBean;
import sv.com.tesa.ticket.models.AccountModel;

/**
 *
 * @author Rodrigo
 */
public class AccountController {
    private AccountModel accountModel = new AccountModel();
    
    public AccountController(){
    
    }
    
    public EmployeeBean getAccount(){
        return(accountModel.cuenta());
    }
    
}
