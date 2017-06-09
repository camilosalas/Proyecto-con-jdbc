<%-- 
    Document   : actualizarCliente
    Created on : 27/11/2016, 05:31:43 PM
    Author     : CAMILO SALAS
--%>
<jsp:useBean id="clientedto" scope="request" class="com.test.dto.ClienteDTO"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../ProyectoFinal/css/stilo.css">
        <title>Actualizar</title>
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
        <button><a href="direccion?op=listarCliente">ATRAS</a></button>
        <div class="logo"></div>
        <form action="direccion?op=actualizarCliente" method="POST">
        <div class="login-block"> 
            
            <br>
            <h1>Actualizar Cliente</h1>
            <input type="hidden" name="op" value="actualizarCliente">
            <input type="hidden" name="Idclientes" value="<%= clientedto.getIdclientes()%>">
            Cliente <input type="text" name="Nombres" value="<%= clientedto.getNombres()%>"><br>
            Appaterno <input type="text" name="Appaterno" value="<%= clientedto.getAppaterno()%>"><br>
            Dni <input type="text" name="Dni" value="<%= clientedto.getDni()%>"><br>
            <input type="submit"  class="agregar" value="actualizar">
        </div>
        </form>
            
    </body>
</html>
