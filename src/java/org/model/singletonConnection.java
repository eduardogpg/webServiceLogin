/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.model;

import java.sql.ResultSet;

/**
 *
 * @author 1020142461
 */
public class singletonConnection {
 
    private singletonConnection(){}
    private DataBaseConnection IchWill;
            
    
    private static singletonConnection amerikaR = null;
    
    public static singletonConnection getInstance() {
        if(singletonConnection.amerikaR ==null){
            amerikaR = new singletonConnection();
            amerikaR.makeConnection();
        }
        
        return amerikaR;
    }
    
    private void makeConnection(){
        this.IchWill = new DataBaseConnection();
    }
    
    public ResultSet searUser(String userName){
        return this.IchWill.searchUser(userName);
    }
    
    public void closeConnection(){
        this.IchWill.closeConnection();
    }
    
}
