<%-- 
    Document   : AgregarProducto
    Created on : 05/12/2016, 11:54:09 AM
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
        <button><a href="../rutaproducto?op=lisProducto">ATRAS</a></button>
        <div class="logo"></div>
        <form action="../rutaproducto?op=añadirProducto" method="POST">
            <div class="login-block">
                
                <br>
                <h1>Agregar Producto</h1>
                <hr>
                <br>
                <input type="hidden" name="op" value="add">
                <input type="text" name="Nombre" value="" placeholder="Nombre" id="username" required=""/>
                <input type="text" name="Precio" value="" placeholder="Precio" id="password" required=""/>
                <input type="text" name="Costo" value="" placeholder="Costo" id="password" required=""/>
                <input type="text" name="Unid_medida" value="" placeholder="Unid_medida" id="password" required=""/>
                <input type="text" name="Codigo" value="" placeholder="Codigo" id="password" required=""/>
                <input type="text" name="Estado" value="" placeholder="Estado" id="rol" required=""/>
                <input type="text" name="Stock" value="" placeholder="Stock" id="rol" required=""/>
                <input type="submit" name="Login" class="agregar" value="agregar"/>
                <input type="reset" name="Login" class="cancelar" value="Cancelar"/>
                
            </div>
        </form>
    </body>
</html>



