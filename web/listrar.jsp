<%-- 
    Document   : listrar
    Created on : 07/11/2016, 07:37:22 AM
    Author     : CAMILO SALAS
--%>
<jsp:useBean id="usuarioSesion" scope="session" class="java.lang.String"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listar</h1>
        I.- La sesion es: ${usuarioSesion}
        <br>
        <%
            if(usuarioSesion.equals("")) {
                response.sendRedirect("loginBrisis.html");
            }
            out.println("II.- La sesion es: "+usuarioSesion+ "<br>");
        %>

        <%="III.- La sesion es: "+usuarioSesion%>
    </body>
</html>
