/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;

import sv.com.tesa.ticket.models.AccountModel;

/**
 *
 * @author Rodrigo
 */
public class AccountController 
{ 
    AccountModel accountModel = new AccountModel();
    public boolean actualizarCuenta(String currentPass, String newPass)
    {
        return accountModel.actualizarCuenta(currentPass, newPass);
    }
}
