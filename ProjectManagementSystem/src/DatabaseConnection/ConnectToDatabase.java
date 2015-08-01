/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sachin Shinde
 */

// This class creates database connection
public class ConnectToDatabase {
    
   private Connection connection = null;
   
// This method connects to database
   
   public Connection getConnection(){
       try {
           this. connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","sachin123");
       } catch (SQLException ex) {
           Logger.getLogger(ConnectToDatabase.class.getName()).log(Level.SEVERE, null, ex);
       }
       return this.connection;
   }
    
}
