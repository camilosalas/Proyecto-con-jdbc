<%-- 
    Document   : AgregarProveedor
    Created on : 02/03/2017, 02:07:46 PM
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
        <button><a href="../rutaproveedor?pro=listarprove">ATRAS</a></button>
        <div class="logo"></div>
        <form action="../rutaproveedor?pro=añadirprove" method="POST">
            <div class="login-block">
                
                <br>
                <h1>Agregar Proveedor</h1>
                <hr>
                <br>
                <input type="hidden" name="op" value="add">
                <input type="text" name="nombre" value="" placeholder="nombre" id="username" required=""/>
                <input type="text" name="apellido" value="" placeholder="apellido" id="password" required=""/>
                <input type="text" name="dni" value="" placeholder="dni" id="password" required=""/>
                <input type="text" name="empresa" value="" placeholder="empresa" id="password" required=""/>
                <input type="text" name="telefono" value="" placeholder="telefono" id="password" required=""/>
                <input type="text" name="celular" value="" placeholder="celular" id="rol" required=""/>
                <input type="text" name="correo" value="" placeholder="correo" id="rol" required=""/>
                <input type="submit" name="Login" class="agregar" value="agregar"/>
                <input type="reset" name="Login" class="cancelar" value="Cancelar"/>
                
            </div>
        </form>
    </body>
</html>




