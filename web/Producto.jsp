<%-- 
    Document   : Producto
    Created on : 28/11/2016, 08:52:52 AM
    Author     : CAMILO SALAS
--%>
<%@page import="com.test.dto.ProductoDTO"%>
<jsp:useBean id="listaProducto" scope="request" type="java.util.List<ProductoDTO>"/>
<jsp:useBean id="usuarioSesion" scope="session" class="java.lang.String"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Productos</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/miestilo1.css">
    <style type="text/css">
        body{
            background-image: url(img/009.jpg)
        }
        
        table{
            border-collapse: collapse;
            width: 100%;
            font-family: "Arial";
            text-align:center; 
        }
        
        th{
            background-color: #a70000;
            color: white;
            padding: 5px;
            text-align: center;
        }
        
        td{
            padding: 5px;       
        }
        
        tr:nth-child(even){
            background-color: #e8e8e8;
        }
        
        tr:nth-child(odd){
            background-color: white;
        }
            
        #header{
            background-color: #18ef07;
            color: white;
        }
    </style>   
    
    </head>
    <body>
        <br>
    <nav class="navbar navbar-default navbar-inverse ">
    <div class="container-fluid">
       <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="PagAdmi.jsp"><span class="glyphicon glyphicon-home"></span><b> Sistema - Tienda </b></a>
      </div>

    
   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
       
        <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-briefcase"></span><strong> Usuario </strong><span class="caret"></span></a>
          <ul class="dropdown-menu">
           <li><a href="UserNew.html"><span class="glyphicon glyphicon-star-empty"></span>Consultas</a></li>    
          </ul>
        </li>  
       </ul>
     
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-briefcase"></span><strong> Productos </strong><span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#"><span class="glyphicon glyphicon-leaf"></span> Nuevo - Producto</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-leaf"></span> Buscar - Producto</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-leaf"></span> Eliminar - Producto</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#"><span class="glyphicon glyphicon-leaf"></span> Reporte - Productos</a></li>
          </ul>
        </li>
      </ul>
      
      <ul class="nav navbar-nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-shopping-cart"></span><strong> Ventas </strong><span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#"><span class="glyphicon glyphicon-hand-right"></span> Reporte de ventas</a></li>
          </ul>
        </li>
      </ul>
      
           
       <ul class="nav navbar-nav navbar-right">
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
        </ul>
     
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav> 
   
     <div class="container">
    <button><a href="agregar/AgregarProducto.jsp">Agregar Producto</a></button>
           <br>
           <br>
           <table align="center">
               <tr><td id="header" colspan="9"><h1>LISTA DE PRODUCTOS</h1></td></tr>
                <tr>
                    <th>ORDEN</th>
                    <th>PRODUCTO</th>
                    <th>PRECIO</th>
                    <th>COSTO</th>
                    <th>UNID_MEDIDA</th>
                    <th>CODIGO</th>
                    <th>ESTADO</th>
                    <th>STOCK</th>
                    <th>OPCIONES</th>
                </tr>
               
           <%
            int count=0;
            for(ProductoDTO u: listaProducto){
                count++;
                
                %>
                <tr>
                    <td><%= count %></td>
                    <td><%= u.getNombre()%></td>
                    <td><%= u.getPrecio()%></td>
                    <td><%= u.getCosto()%></td>
                    <td><%= u.getUnid_medida()%></td>
                    <td><%= u.getCodigo()%></td>
                    <td><%= u.getEstado()%></td>
                    <td><%= u.getStock()%></td>
                        <td><button><a href="rutaproducto?op=encontrarProducto&Idproducto=<%= u.getIdproducto()%>"> Editar </a></button>
                        <button><a href="rutaproducto?op=borrarProducto&Idproducto=<%= u.getIdproducto()%>"> Eliminar </a></button></td>
                </tr>
                
            <% 
            }
            %>
           </table></div><br>
            

<script src="js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
    
    
</body>
</html>
