<%-- 
    Document   : GenerosServlet
    Created on : 11/05/2017, 10:56:20
    Author     : sala308b
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Generos</h1>
        <hr>
         <div class="erro">${msgErro}</div>
         <div class="erro">${msgsucess}</div>
          <div class="erro">${msgvazio}</div>
         <form method="post"  action="GenerosServlets">
            Nome:<br>
            <input type="text" name="nome" value="" /><br><br>
            Descrção:<br>
            <input type="text" name="descricao" value="" /><br><br>
            <input type="submit" value="Cadastrar" name="cadastrar" />
            
            <a href="javascript:history.back()"><input type="button" value="Voltar" name="voltar" /></a><br><br>
        <a href="Login_de_usuario.jsp"><input type="button" value="IR A PAGINA DE LOGIN" name="LOGIN" /></a>
        
        </form>
        
        
    </body>
</html>
