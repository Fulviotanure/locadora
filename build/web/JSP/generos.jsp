<%-- 
    Document   : GenerosServlet
    Created on : 11/05/2017, 10:56:20
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
        <h1>Cadastro de Generos</h1>
        <hr>
         
        <form action="GenerosServlets">
            Nome:
            <input type="text" name="Nome" value="" /><br><br>
            Descrção:
            <input type="text" name="descricao" value="" /><br><br>
             <input type="submit" value="Cadastrar" name="cadastrar" />
                <a href="javascript:history.back()"><input type="button" value="Voltar" name="voltar" /></a><br><br>
        
        
        </form>
        
        
    </body>
</html>
