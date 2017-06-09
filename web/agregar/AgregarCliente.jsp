<%-- 
    Document   : AgregarCliente
    Created on : 27/11/2016, 05:47:29 PM
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
        <button><a href="../direccion?op=listarCliente">ATRAS</a></button>
        <div class="logo"></div>
        <form action="../direccion?op=añadirCliente" method="POST">
            <div class="login-block">
                
                <br>
                <h1>Agregar Cliente</h1>
                <hr>
                <br>
                <input type="hidden" name="op" value="add">
                <input type="text" name="Nombres" value="" placeholder="Nombres" id="username" required=""/>
                <input type="text" name="Appaterno" value="" placeholder="Appaterno" id="password" required=""/>
                <input type="text" name="Dni" value="" placeholder="Dni" id="rol" required=""/>
                <input type="submit" name="Login" class="agregar" value="agregar"/>
                <input type="reset" name="Login" class="cancelar" value="Cancelar"/>
                
            </div>
        </form>
    </body>
</html>


