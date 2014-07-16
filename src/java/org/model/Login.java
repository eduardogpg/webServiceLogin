/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author 1020142461
 */
@WebService(serviceName = "Login")
public class Login {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loginUser")
    public boolean loginUser(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password) {
        
        singletonConnection c = singletonConnection.getInstance();
        ResultSet duHast =  c.searUser(userName);
        
        if( duHast == null)
            return false;
        else{
            try {
                String DBPassword = duHast.getString("password");
                if(DBPassword.equals(password))
                    return true;
                else
                    return false;
                
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            
        }
           
    }

}

