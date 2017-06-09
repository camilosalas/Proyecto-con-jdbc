<%-- 
    Document   : PagVenta
    Created on : 07/11/2016, 09:25:31 AM
    Author     : CAMILO SALAS
--%>
<jsp:useBean id="usuarioSesion" scope="session" class="java.lang.String"/>
<jsp:useBean id="rol" scope="session" class="java.lang.String"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--<meta name="description" content="">-->
        <!--<meta name="author" content="">-->

        <title> Ventas  </title>

        <!-- Bootstrap Core CSS -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/estilosdiseno.css">

        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">
        <link href="css/estilosdiseno.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">




    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">Bodega | Brissy</a>

                </div>
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">


                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <%out.println("En Linea: " + usuarioSesion);%><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#"><i class="fa fa-fw fa-user"></i> Perfil</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-envelope"></i> Mensajes</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-gear"></i> Ayuda</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="close"><i class="fa fa-fw fa-power-off"></i> Salir</a>
                            </li>
                        </ul>
                    </li>
                </ul>

                <%
                    if (usuarioSesion.equals("")) {
                        response.sendRedirect("loginBrisis.html");
                    } else {
                        if (!rol.equals("ventas")) {
                            response.sendRedirect("loginBrisis.html");
                        }
                    }
                %>



                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">

                        <li>

                            <a href="#"><i class="fa fa-fw fa-bar-chart-o" data-toggle="modal" data-target="#myModal">

                                </i> Agregar Producto</a>

                        </li>

                        <li>
                            <a href="#"><i class="glyphicon glyphicon-tags"></i> Ventas </a>
                        </li>

                        <li>
                            <a href="redirect?op=vendedor"><span class="glyphicon glyphicon-user"></span> Clientes</a>
                            <!--<a href="usuarios.jsp"><i class="glyphicon glyphicon-user"></i> Clientes</a>-->
                        </li>


                        <!-- reportes -->
                        <li>
                            <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-table"></i> Reportes <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="demo" class="collapse">
                                <li>
                                    <a href="#" class="glyphicon glyphicon-list-alt"> Reporte Ventas</a>
                                </li>
                                <li>
                                    <a href="#" class="glyphicon glyphicon-list-alt"> Reporte Productos</a>
                                </li>
                                <li>
                                    <a href="#" class="glyphicon glyphicon-list-alt"> Reporte stock</a>
                                </li>

                                <li>
                                    <a href="#" class="glyphicon glyphicon-list-alt"> Reporte Ingresos</a>
                                </li>
                            </ul>
                        </li>



                        <li>
                            <a href="agregarPro.html" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> 

                                Consulta <i class="fa fa-fw fa-caret-down"></i></a>


                        </li>

                    </ul>
                </div>


                <!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">

                <style>
                    .carousel-inner > .item > img,
                    .carousel-inner > .item > a > img {
                        width: 70%;
                        margin: auto;
                    } 
                </style>






                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                        <li data-target="#myCarousel" data-slide-to="3"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="img/002.jpg" alt="Chania" width="460" height="345">
                        </div>

                        <div class="item">
                            <img src="img/003.jpg" alt="Chania" width="460" height="345">
                        </div>

                        <div class="item">
                            <img src="img/logo.png" id="logo" alt="Flower" width="460" height="345">
                        </div>

                        <div class="item">
                            <img src="img/006.jpg" alt="Flower" width="460" height="345">
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>







                <div class="container-fluid">


                    <!-- VENTA MODAL AGREGAR PRODUCTO-->
                    <div class="modal fade" id="myModal" role="dialog">
                        <div class="modal-dialog">


                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title" style="text-align: center"> Agregar Producto</h4>
                                </div>


                                <div class="modal-body">

                                    <!-- AGREGAR PRODUCTO -->
                                    <br>
                                    <section id="agregar">
                                        <div class="form-group has-success has-feedback">

                                            <label for="inputSuccess2">Nombre</label>
                                            <input type="text" class="form-control" id="inputSuccess2">

                                            <label for="inputSuccess2">Precio</label>
                                            <input type="text" class="form-control" id="inputSuccess2">


                                            <label for="inputSuccess2">Costo</label>
                                            <input type="text" class="form-control" id="inputSuccess2">

                                            <label for="inputSuccess2">Categoria</label>
                                            <select class="form-control">
                                                <option></option>
                                                <option>Flores</option>
                                                <option>Juguetes</option>
                                                <option>Accesorios</option>
                                            </select>


                                            <label for="inputSuccess2">Codigo</label>
                                            <input type="text" class="form-control" id="inputSuccess2">


                                            <label for="inputSuccess2">Estado</label>
                                            <input type="text" class="form-control" id="inputSuccess2">

                                            <br>
                                            <div class="boton">
                                                <button type="button" class="btn btn-danger">Cancelar</button>
                                                <button type="button" class="btn btn-primary">Guardar</button>
                                            </div>
                                        </div>


                                    </section>

                                </div>


                            </div>
                        </div>
                    </div>




                </div>


            </div>

        </div>

        <footer class="final">

            <div class="redes">
                <a href=""><img src="" alt="" class=""></a>
                <a href=""><img src="" alt="" class=""></a>
                <a href=""><img src="" alt="" class=""></a>
                <a href=""><img src="" alt="" class=""></a>
            </div>

        </footer>



        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>

