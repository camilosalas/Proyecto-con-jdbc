<%-- 
    Document   : actualizarProducto
    Created on : 29/11/2016, 12:45:43 PM
    Author     : CAMILO SALAS
--%>

<jsp:useBean id="productodto" scope="request" class="com.test.dto.ProductoDTO"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../ProyectoFinal/css/stilo.css">
        <title>Actualizar Producto</title>
        <style>
            body{
                background-image: url(../ProyectoFinal/img/003.jpg);
                font-family: "Arial";
                text-align: center;
                color: #ffffff;
            }
            
            h1{
                color: blue;
            }
        </style>
        
    </head>
    <body>
        <button><a href="rutaproducto?op=lisProducto">ATRAS</a></button>
        <div class="logo"></div>
        <form action="rutaproducto?op=actualizarPro" method="POST">
        <div class="login-block">    
        <h1>Actualizar Producto</h1>
            <input type="hidden" name="op" value="actualizar">
            <input type="hidden" name="Idproducto" value="<%= productodto.getIdproducto()%>">
            Nombre <input type="text" name="Nombre" value="<%= productodto.getNombre()%>"><br>
            Precio <input type="text" name="Precio" value="<%= productodto.getPrecio()%>"><br>
            Costo <input type="text" name="Costo" value="<%= productodto.getCosto()%>"><br>
            Unid_medida <input type="text" name="Unid_medida" value="<%= productodto.getUnid_medida()%>"><br>
            Codigo <input type="text" name="Codigo" value="<%= productodto.getCodigo()%>"><br>
            Estado <input type="text" name="Estado" value="<%= productodto.getEstado()%>"><br>
            Stock <input type="text" name="Stock" value="<%= productodto.getStock()%>"><br>
            <input type="submit"  class="agregar" value="actualizar">
        </div>
        </form>
            
    </body>
</html>
