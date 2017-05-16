<%-- 
    Document   : PainelUsuario
    Created on : 13/04/2017, 10:52:41
    Author     : sala304b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Painel Usuário</h1>
        <hr>
        <h3>ADMINISTRADOR</h3>
        Usuario Logado: ${usuarioAutenticado} <br><br>
        <hr>
           
         <a href="JSP/usuarios.jsp"><input type="submit" value="Cadastrar Usuarios" name="usuarios" /></a><br><br>
         <a href="filmes.jsp"><input type="submit" value="Cadastrar Novos Filmes" name="filmes" /></a><br><br>
         <a href="generos.jsp"><input type="submit" value="Cadastrar Generos" name="generos" /></a><br><br>
         <a href="javascript:history.back()"><input type="button" value="Voltar" name="voltar" /></a>
         <a href="Logout"><input type="button" value="Logout" name="logout" /></a><br><br>
         <a href="JSP/Login_de_usuario.jsp"><input type="button" value="IR A PAGINA DE LOGIN" name="LOGIN" /></a>
    </body>
</html>
