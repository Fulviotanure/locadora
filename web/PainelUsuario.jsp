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
        <a href="javascript:history.back()">Voltar</a><br>
        <a href="Logout">Logout</a><br>
        <h3>Somente usuário Logado terá acesso</h3>
        Bem vindo ${usuarioAutenticado} !<br><br>
        <hr>
         <a href="JSP/usuarios.jsp"><input type="submit" value="Cadastrar Usuarios" name="usuarios" /></a><br><br>
         <a href="JSP/filmes.jsp"><input type="submit" value="Cadastrar Novos Filmes" name="filmes" /></a><br><br>
         <a href="JSP/generos.jsp"><input type="submit" value="Cadastrar Generos" name="generos" /></a><br>
        
    </body>
</html>
