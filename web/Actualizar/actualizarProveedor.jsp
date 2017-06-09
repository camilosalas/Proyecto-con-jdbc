<%-- 
    Document   : actualizarProveedor
    Created on : 04/03/2017, 05:15:35 PM
    Author     : CAMILO SALAS
--%>

<jsp:useBean id="proveedordto" scope="request" class="com.test.dto.ProveedorDTO"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../ProyectoFinal/css/stilo.css">
        <title>Actualizar Proveedor</title>
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
        <button><a href="rutaproveedor?pro=listarprove">ATRAS</a></button>
        <div class="logo"></div>
        <form action="rutaproveedor?pro=actualizarprove" method="POST">
        <div class="login-block">    
        <h1>Actualizar Proveedor</h1>
            <input type="hidden" name="op" value="actualizar">
            <input type="hidden" name="Idproducto" value="<%= proveedordto.getIdproveedor()%>">
            Nombre <input type="text" name="nombre" value="<%= proveedordto.getNombre()%>"><br>
            Apellido <input type="text" name="apellido" value="<%= proveedordto.getApellido()%>"><br>
            Dni <input type="text" name="dni" value="<%= proveedordto.getDni()%>"><br>
            Empresa <input type="text" name="empresa" value="<%= proveedordto.getEmpresa()%>"><br>
            Telefóno <input type="text" name="telefono" value="<%= proveedordto.getTelefono()%>"><br>
            Celular <input type="text" name="celular" value="<%= proveedordto.getCelular()%>"><br>
            Correo <input type="text" name="correo" value="<%= proveedordto.getCorreo()%>"><br>
            <input type="submit"  class="agregar" value="actualizar">
        </div>
        </form>
            
    </body>
</html>
