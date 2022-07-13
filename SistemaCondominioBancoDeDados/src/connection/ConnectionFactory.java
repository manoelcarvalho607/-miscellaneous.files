/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.mysql.jdbc.Driver;







/**
 *
 * @author visitante
 */
public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/cadastrocliente";
    private static final String USER = "root";
    private static final String PASS = "12345";
  
   
    
    public static Connection getConnection() {
        
        try {
            Class.forName(DRIVER);
            try {
                return DriverManager.getConnection(URL, USER, PASS);
            } catch (SQLException ex) {
               throw new RuntimeException("erro na conexão: ",ex); 
            }
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("erro na conexão: ",ex);
        }
        
    }
    
    
    public static void closeConnection(Connection con) {
        try {
            if(con!=null){
            con.close();
            }
        }catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        
        closeConnection(con);
        
        try {
            
            if(stmt != null){
              stmt.close();  
          
            }
        }catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    
    
      public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        
        closeConnection(con, stmt);
        
        try {
            
            if(rs!= null){
              rs.close();  
          
            }
        }catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
}
