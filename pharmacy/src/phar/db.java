/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana
 */
public class db {
   static Connection con;
   static
   {
       try {
           Class.forName("org.h2.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
       }
           
   }
public static Connection connect() throws SQLException{
            if (con == null){
                con =DriverManager.getConnection("jdbc:h2:file:pher/~/pharmadatabase;","","");
                System.out.println("connected");
            }                
            return con;
    }
    
}
