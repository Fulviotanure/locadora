<%-- 
    Document   : filmes
    Created on : 11/05/2017, 10:55:08
    Author     : sala308b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Filmes</h1>
        <hr>
        
        <form action="FilmesServlets">
         Titulo:<br>
         <input type="text" name="titulo" value="" /><br><br>
         Genero:<br>
         <select name="genero">
             <option></option>
             <option></option>
         </select><br><br>
         sinopse:<br>
         <textarea name="sinopse" rows="6" cols="20">
         </textarea><br><br>   
         Diretor:<br>
         <input type="text" name="diretor" value="" /><br><br>
         Ano de Lançamento:<br>
         <input type="number" name="ano" max="3000" value="" /><br><br>
         Status:
         <select name="status">
             <option>Ativo</option>
             <option>Inativo</option>
         </select><br><br>
          <input type="submit" value="Cadastrar" name="cadastrar" />
                <a href="javascript:history.back()"><input type="button" value="Voltar" name="voltar" /></a><br><br>
            
        </form>
        
        
        
        
        
    </body>
</html>
