/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;;
/**
 *
 * @author 1020142461
 */
public class DataBaseConnection {
  
    private com.mysql.jdbc.Connection myConnection;
    private com.mysql.jdbc.Statement statemen;
    private final String dataBase ="KrabProtocol";
    private final String userDataBase="wawser";//"root";
    private final String password="h7u7zDTYUzS6pAXB";//"KJvnje1S7XW73jvEd01E";
    

    
    public DataBaseConnection(){
        
      try {
            Class.forName("org.gjt.mm.mysql.Driver");
            myConnection = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://89.32.144.231:3306/"+dataBase, userDataBase, password);//Make the connection with the dataBase
            statemen = (com.mysql.jdbc.Statement) myConnection.createStatement(); //Make the Statement
        }catch (ClassNotFoundException ex) {
            System.out.println("We have a problem with the connection "+  ex);
        }catch (SQLException ex) {
            System.out.println("We have a problem with the connection "+ ex);
        }
        
    }
    
    public ResultSet searchUser(String userName){
        try{
            ResultSet result = this.statemen.executeQuery("SELECT password FROM users WHERE userName='"+userName+"'");
            if(!result.next()){
                    System.out.println("No hay resultados que coincidan con la búsqueda.");
                    return null;
                }
                return result;
         
        }catch(SQLException ex){
            return null;
        }
    }
    
    public void closeConnection(){
        try {
            this.statemen.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
    

