<%-- 
    Document   : usuarios
    Created on : 11/05/2017, 10:58:40
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
        <h1>Cadastro de Usuarios</h1>
        <hr>
        <form action="UsuariosServlet">
        Login:<br>
         <input type="text" name="login" value="" /><br><br>
         Nome:<br>
         <input type="text" name="nome" value="" /><br><br>
         Senha:<br>
         <input type="text" name="senha" value="" /><br><br>
         Perfil:<br>
         <select name="perfil">
             <option>Funcionarios</option>
             <option>Administrador</option>
         </select><br><br>
         Status:<br>
         <select name="status">
             <option>Ativo</option>
             <option>Inativo</option>
         </select><br><br>
          <input type="submit" value="Cadastrar" name="cadastrar" />
                <a href="javascript:history.back()"><input type="button" value="Voltar" name="voltar" /></a><br><br>
         
            
            
            
            
            
        </form>
    </body>
</html>
