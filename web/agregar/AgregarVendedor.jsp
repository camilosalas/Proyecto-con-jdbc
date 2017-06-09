<%-- 
    Document   : AgregarUsuario
    Created on : 06/11/2016, 07:30:35 PM
    Author     : CAMILO SALAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="../css/stilo.css">
        <meta charset="UTF-8">
        <title>Ventas</title>
    </head>
    <body>
        <button><a href="../redirection?op=vendedor">ATRAS</a></button>
        <div class="logo"></div>
        <form action="../redirection?op=añadir" method="POST">
            <div class="login-block">
                <h1>Agregar Vendedor</h1>
                <hr>
                <br>
                <input type="hidden" name="op" value="add">
                <input type="text" name="USUARIO" value="" placeholder="Usuario" id="username" required=""/>
                <input type="password" name="CLAVE" value="" placeholder="Clave" id="password" required=""/>
                <input type="text" name="ROL" value="" placeholder="Rol" id="rol" required=""/>
                <input type="submit" name="Login" class="agregar" value="agregar"/>
                <input type="reset" name="Login" class="cancelar" value="Cancelar"/>
                
            </div>
        </form>
    </body>
</html>

