<%-- 
    Document   : ventas
    Created on : 27/11/2016, 10:46:57 PM
    Author     : CAMILO SALAS
--%>
<jsp:useBean id="usuarioSesion" scope="session" class="java.lang.String"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Ventas</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/ventas.css"/>

    </head>
    <body>
        <br>
        <div id="menu-wrapper">
            <ul id="hmenu">
                <li><a href="#">INICIO</a></li>
                <li><a href="#">SERVICIOS</a>
                    <ul class="sub-menu">
                        <li><a href="#">Diseño</a></li>
                        <li><a href="#">Impresos</a></li>
                    </ul>
                </li>
                <li><a href="#">SERVICIOS</a>
                    <ul class="sub-menu">
                        <li><a href="#">Diseño</a></li>
                        <li><a href="#">Impresos</a></li>
                    </ul>
                </li>
                <li><a href="#">Contactos</a></li>
                <lu class="nav navbar-nav navbar-right">
                    <li><img src="img/logo.png" alt="tu foto" class="img-circle foto"></li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 

                            <strong><%out.println("En Linea: " + usuarioSesion);%></strong>


                            <span class="glyphicon glyphicon-chevron-down"></span>
                        </a>

                        <ul class="dropdown-menu">
                            <li>
                                <div class="navbar-login">
                                    <div class="row">
                                        <div class="col-lg-4">
                                            <p class="text-center">
                                                <img src="img/logo.png" alt="tu foto" class="img-cicle fotox">
                                            </p>
                                        </div>
                                        <div class="col-lg-8">
                                            <p class="text-left"><strong><%out.println("En Linea: " + usuarioSesion);%></strong></p>
                                            <p class="text-left small">camilosalas615@gmail.com</p>
                                            <p class="text-left">
                                                <a href="#" class="btn btn-primary btn-block btn-sm">Actualizar Datos</a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="navbar-login navbar-login-session">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <p>
                                                <a href="close" class="btn btn-danger btn-block" >Cerrar Sesion</a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </li>

                        </ul>
                    </li>
                </lu>
            </ul>
        </ul> 

    </div>
    <script src="js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>                                    
</body>
</html>
