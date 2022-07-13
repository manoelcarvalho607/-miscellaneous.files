
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
import javax.swing.JOptionPane;
//import model.bean.Usuario;


/**
 *
 * @author manoel.carvalho
 */
public class UsuarioDAO {
    
    
    public boolean checkLogin(String Login, String Senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE Login = ? and Senha = ?");
            stmt.setString(1, Login);
            stmt.setString(2, Senha);
            
            
            
           rs = stmt.executeQuery();
            
           /*
           while (rs.next()){
               
               Usuario usuario = new Usuario();
               
               usuario.setId(rs.getInt("ID"));
               usuario.setLogin(rs.getString("Login"));
               usuario.setSenha(rs.getString("Senha"));
              
               
               
               
           }
           
            */
           
           if (rs.next()){
               
               
               check = true;
            
           }
           
           
           
           
        } catch (SQLException ex) {
            //Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar dados do BD: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return check;
    }
}
