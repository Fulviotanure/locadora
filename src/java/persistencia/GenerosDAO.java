/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import modelo.generos;

/**
 *
 * @author sala308b
 */
public class GenerosDAO {
    
    
    
    
    
    
    public static void inserir(generos g) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "INSERT INTO generos (nome, descricao ) " +
                                     "VALUES (?, ?)";

        preparedStatement = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

        
        
        preparedStatement.setString(1, g.getNome());
        preparedStatement.setString(2, g.getDescricao());
      
       
       
        preparedStatement.executeUpdate();  

        rs = preparedStatement.getGeneratedKeys();

        // Busca a chave gerada (id)
        if (rs.next()) {
             g.setCodigo(rs.getInt(1));
         } 
        
        // Fechar conexao
        conn.close();
        
    }  
    
 
    public static ArrayList listar() throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        ArrayList<generos> lista = new ArrayList<>();
                
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "SELECT * FROM generos  ";

        preparedStatement = conn.prepareStatement(SQL);
    
        // Para buscar informações
        rs = preparedStatement.executeQuery();   

        // Verifica se possui dados
        while (rs.next()) {
            
            generos p = new generos();
            
            p.setCodigo(rs.getInt("codigo"));
            p.setDescricao(rs.getString("descricao"));
            p.setNome(rs.getString("nome"));
           
            
           
            lista.add(p);
         } 
        
        // Fechar conexao
        conn.close();
        
        return lista;
    }
    
    
    
}
