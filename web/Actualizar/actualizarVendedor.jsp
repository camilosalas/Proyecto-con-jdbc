 <%-- 
    Document   : actualizarVendedor
    Created on : 07/11/2016, 06:38:56 AM
    Author     : CAMILO SALAS
--%>
<jsp:useBean id="vendedordto" scope="request" class="com.test.dto.VendedorDTO"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../ProyectoFinal/css/stilo.css">
        <title>Actualizar Vendedor</title>
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
        <button><a href="redirection?op=vendedor">ATRAS</a></button>
        <div class="logo"></div>
        <form action="redirection?op=actualizar" method="POST">
        <div class="login-block">    
        <h1>Actualizar Vendedor</h1>
            <input type="hidden" name="op" value="actualizar">
            <input type="hidden" name="ID_VENDEDOR" value="<%= vendedordto.getID_VENDEDOR()%>">
            Vendedor <input type="text" name="USUARIO" value="<%= vendedordto.getUSUARIO()%>"><br>
            Clave <input type="text" name="CLAVE" value="<%= vendedordto.getCLAVE()%>"><br>
            Rol <input type="text" name="ROL" value="<%= vendedordto.getROL()%>"><br>
            <input type="submit"  class="agregar" value="actualizar">
        </div>
        </form>
            
    </body>
</html>
