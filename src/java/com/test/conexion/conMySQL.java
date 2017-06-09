/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.conexion;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author CAMILO SALAS
 */
public class conMySQL {
    
   private static Connection conn;

   
   
    public conMySQL() {
        
    }
    
    public static Connection getConexion(){
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn= DriverManager.getConnection("jdbc:mysql://localhost/dbllave","root","admin");
            
           
            
        } catch (Exception e) {
            System.out.println("ERROR CONEXION: "+e.getMessage());
        }
        return conn;
    }
    
    
    
}

    

