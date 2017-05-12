
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

// Essa classe utiliza o padrao de projetos DAO (Data Access Object)
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import modelo.filmes;
import modelo.generos;
import modelo.usuarios;


public class FilmesDAO {
    
    public static void inserir(filmes f) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "INSERT INTO filmes (titulo, cod_genero, sinopse, diretor,ano_lancamento,"
                + " status, usuario_cadastro, datahora_cadastro) " +
                                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        preparedStatement = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

        
        preparedStatement.setString(1, f.getTitulo());
        preparedStatement.setInt(2, f.getCod_genero());
        preparedStatement.setString(3, f.getSinopse());
        preparedStatement.setString(4, f.getDiretor());
        preparedStatement.setInt(5, f.getAno_lancamento());
        preparedStatement.setString(6, f.getStatus());
        preparedStatement.setString(7, f.getUsuario_cadastro());
        
        // Nao existe tipo de dado java.util.Date no 
        //JDBC entao temos que fazer uma conversao
        Timestamp dataAux = new Timestamp(
                f.getDatahora_cadastro().getTime());
        preparedStatement.setTimestamp(8, dataAux); 
       
       
       
        preparedStatement.executeUpdate();  

        rs = preparedStatement.getGeneratedKeys();

        // Busca a chave gerada (id)
        if (rs.next()) {
             f.setCodigo(rs.getInt(1));
         } 
        
        // Fechar conexao
        conn.close();
        
    }

}
