/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.DriverManager;

/**
 *
 * @author Hp
 */
public class ConnectionClass {
    
   public java.sql.Connection getConnection() throws Exception{
        
         Class.forName("com.mysql.jdbc.Driver"); 
         java.sql.Connection connection = DriverManager.getConnection(  
                 "jdbc:mysql://localhost:3306/bookshop", "root", "root"); 
       return  connection ;
        
    }
    
}
