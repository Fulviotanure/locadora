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
import modelo.usuarios;

/**
 *
 * @author sala308b
 */
public class UsuariosDAO {
    
    
     public static void inserir(usuarios u) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "INSERT INTO usuarios (login, nome, senha, perfil, status) " +
                                     "VALUES (?, ?, ?, ?, ?)";

        preparedStatement = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

        
        
        preparedStatement.setString(1, u.getLogin());
        preparedStatement.setString(2, u.getNome());
        preparedStatement.setString(3, u.getSenha());
        preparedStatement.setString(4, u.getPerfil());
        preparedStatement.setString(5, u.getStatus());
        
       
        preparedStatement.executeUpdate();  
 
        // Fechar conexao
        conn.close();
        
    }  
    
}
