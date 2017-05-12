<%-- 
    Document   : Login_de_usuario
    Created on : 11/05/2017, 11:01:53
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
        <h1>Faça Login</h1>
        <hr>
        
        <div>
            <form>
                Login:<br> 
                <input type="text" name="nome de usuario:" value="" />  <br><br>      
                Senha: <br> 
                <input type="text" name="senha" value="" /> <br><br>
                
                <input type="submit" value="Logar" name="logar" />
                <a href="javascript:history.back()"><input type="button" value="Voltar" name="voltar" /></a><br><br>
                
            </form>    
        </div>
    </body>
</html>
