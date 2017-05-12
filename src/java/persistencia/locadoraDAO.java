
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


public class locadoraDAO {
    
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
    
   public static void inserir(generos g) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "INSERT INTO filmes (nome, descricao ) " +
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
    
   
 /*   public static Aluno buscar(int id) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        Aluno a = null;
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "SELECT * FROM aluno " +
                " WHERE idaluno = ? ";

        preparedStatement = conn.prepareStatement(SQL);

        preparedStatement.setInt(1, id);
                
        // Para buscar informações
        rs = preparedStatement.executeQuery();   

        // Verifica se possui dados
        if (rs.next()) {
            
            a = new Aluno();
            
            a.setIdAluno(rs.getInt("idaluno"));
            a.setNome(rs.getString("nome"));
            a.setMatricula(rs.getInt("matricula"));
            a.setTel(rs.getString("telefone"));
            
            
            
         } 
        
        // Fechar conexao
        conn.close();
        
        return a;
    }
    
    
    
    
     public static ArrayList listar() throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
       ArrayList<Aluno> lista = new ArrayList();
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "SELECT * FROM aluno ";

        preparedStatement = conn.prepareStatement(SQL);
                
        // Para buscar informações
        rs = preparedStatement.executeQuery();   

        // Verifica se possui dados
        while (rs.next()) {
            
            Aluno a = new Aluno();
            
            a.setIdAluno(rs.getInt("idaluno"));
            a.setNome(rs.getString("nome"));
            a.setMatricula(rs.getInt("matricula"));
            a.setTel(rs.getString("telefone"));
            
            
           lista.add (a); 
            
         } 
        
        // Fechar conexao
        conn.close();
        
        return lista;
    }
    /*
    public static void atualizar(Funcionario f) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "UPDATE tb_funcionario " +
              " SET nome = ?, " +
              " salario = ?, " +
              " dataAdmissao = ?, " +
              " dataDemissao = ? " +
              " WHERE idFuncionario = ? ";

        preparedStatement = conn.prepareStatement(SQL);

        preparedStatement.setString(1, f.getNome());
        preparedStatement.setFloat(2, f.getSalario());
        
        // Nao existe tipo de dado java.util.Date no 
        //JDBC entao temos que fazer uma conversao
        Timestamp dataAux = new Timestamp(
                f.getDataAdmissao().getTime());
        preparedStatement.setTimestamp(3, dataAux);  
        
        if(f.getDataDemissao() == null)
            preparedStatement.setTimestamp(4, null);  
        else{
            dataAux = new Timestamp(
                    f.getDataDemissao().getTime());
            preparedStatement.setTimestamp(4, dataAux);  
        }
        
        preparedStatement.setInt(5, f.getIdFuncionario());
        
        int qtdLinhas = preparedStatement.executeUpdate();  

        if (qtdLinhas == 0) {
            // O certo seria criar uma classe herdada de Exception
             throw new SQLException("Não existe linhas atualizadas");
         } 
        
        // Fechar conexao
        conn.close();
        
    }
    *//*
    public static void excluir(Funcionario f) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "DELETE FROM tb_funcionario " +
              " WHERE idFuncionario = ? ";

        preparedStatement = conn.prepareStatement(SQL);

        preparedStatement.setInt(1, f.getIdFuncionario());
        
        int qtdLinhas = preparedStatement.executeUpdate();  

        if (qtdLinhas == 0) {
            // O certo seria criar uma classe herdada de Exception
             throw new SQLException("Não existe linha para ser excluído");
         } 
        
        // Fechar conexao
        conn.close();
    }
 */   
}
