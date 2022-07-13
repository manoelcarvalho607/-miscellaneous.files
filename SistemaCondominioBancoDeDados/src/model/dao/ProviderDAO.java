/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;



import java.sql.Connection;
import connection.ConnectionFactory;
//import java.awt.List;
import java.util.List;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Provider;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author visitante
 */
public class ProviderDAO {
    
    
    public void create(Provider p) {
        
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO cadastro_fornecedor (empresa,Colaborador,Cpf,morador,obs) VALUES (?,?,?,?,?)");
            stmt.setString(1,p.getEmpresa());
            stmt.setString(2,p.getColaborador());
            stmt.setInt(3,p.getCpf());
            stmt.setString(4,p.getMorador());
            stmt.setString(5,p.getObs());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso no BD!");
            
        }catch (SQLException ex){
           // Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao salvar no BD: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
        
    }
    
    
    public List<Provider> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        List<Provider> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cadastro_fornecedor");
           rs = stmt.executeQuery();
            
           while (rs.next()){
               
               Provider cliente = new Provider();
               
               cliente.setId(rs.getInt("ID"));
               cliente.setEmpresa(rs.getString("Empresa"));
               cliente.setColaborador(rs.getString("Colaborador"));
               cliente.setCpf(rs.getInt("Cpf"));
               cliente.setMorador(rs.getString("Morador"));
               cliente.setObs(rs.getString("obs"));
               
               clientes.add(cliente);
               
           }
           
            
        } catch (SQLException ex) {
            //Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar dados do BD: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes;
    }
    
    
      public void upDate(Provider p) {
        
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        
        
        try {
            stmt = con.prepareStatement("UPDATE cadastro_fornecedor SET  empresa = ? ,colaborador = ?, cpf = ? ,morador = ?,obs = ? WHERE ID = ? ");
           
            stmt.setString(1,p.getEmpresa());
            stmt.setString(2,p.getColaborador());
            stmt.setInt(3,p.getCpf());
            stmt.setString(4,p.getMorador());
           // stmt.setString(5, p.getDataFormatada());
           // stmt.setDate(5, (Date) p.getData());
           // stmt.setInt(6,p.getQtd());
            stmt.setString(5,p.getObs());
            stmt.setInt(6,p.getId());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso no BD!");
            
        }catch (SQLException ex){
           // Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao salvar no BD: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
        
    }
      
       public void delete(Provider p) {
        
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        
        
        try {
            stmt = con.prepareStatement("DELETE FROM cadastrocliente WHERE ID = ?");
           
          
            stmt.setInt(1,p.getId());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com sucesso no BD!");
            
        }catch (SQLException ex){
           // Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao excluir no BD: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
        
    }
       
        public List<Provider> readForDesc(String desc){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        List<Provider> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cadastro_fornecedor WHERE empresa LIKE ?");
            stmt.setString(1, "%"+desc+"%");
           rs = stmt.executeQuery();
            
           while (rs.next()){
               
               Provider cliente = new Provider();
               
               cliente.setId(rs.getInt("id"));
               cliente.setEmpresa(rs.getString("empresa"));
               cliente.setColaborador(rs.getString("colaborador"));
               cliente.setCpf(rs.getInt("cpf"));
               cliente.setMorador(rs.getString("morador"));
               cliente.setHora(rs.getString("obs"));
               
               clientes.add(cliente);
               
           }
           
            
        } catch (SQLException ex) {
            //Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar dados do BD: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes;
    }
    
    
    
}
