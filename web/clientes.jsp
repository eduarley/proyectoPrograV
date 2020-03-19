<%-- 
    Document   : clientes
    Created on : 18-mar-2020, 10:19:02
    Author     : Usuario
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"

      xmlns:f="http://java.sun.com/jsf/core" 
      import = "java.util.LinkedList">


    <h:head>
        <title>Kraken | Inicio</title>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

        <!--link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/css?family=Monoton&display=swap" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/css?family=Miss+Fajardose&display=swap" rel="stylesheet"/-->

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css"/>
        <link rel="stylesheet" href="css/animate.css"/>

        <link rel="stylesheet" href="css/owl.carousel.min.css"/>
        <link rel="stylesheet" href="css/owl.theme.default.min.css"/>
        <link rel="stylesheet" href="css/magnific-popup.css"/>

        <link rel="stylesheet" href="css/aos.css"/>

        <link rel="stylesheet" href="css/ionicons.min.css"/>

        <link rel="stylesheet" href="css/bootstrap-datepicker.css"/>
        <link rel="stylesheet" href="css/jquery.timepicker.css"/>


        <link rel="stylesheet" href="css/flaticon.css"/>
        <link rel="stylesheet" href="css/icomoon.css"/>
        <link rel="stylesheet" href="css/style.css"/>


        <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
        <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
    </h:head>
    <h:body>



        <jsp:useBean id="sesion" class="control.beanInicioSesion" scope="session"/>
        <jsp:setProperty name="sesion" property="nombre" value="${beanInicioSesion.nombre}"/>
        <jsp:setProperty name="sesion" property="id" value="${beanInicioSesion.nombre}"/>
        <jsp:setProperty name="sesion" property="clave" value="${beanInicioSesion.clave}"/>
        <jsp:setProperty name="sesion" property="direccion" value="${beanInicioSesion.direccion}"/>
        <jsp:setProperty name="sesion" property="estado" value="${beanInicioSesion.estado}"/>
        <jsp:setProperty name="sesion" property="rol" value="${beanInicioSesion.rol}"/>
        <jsp:setProperty name="sesion" property="telefono" value="${beanInicioSesion.telefono}"/>




        <!--jsp:useBean id="beanC" class="control.beanClientes" scope="session"/-->
        <!--jsp:setProperty name="beanC" property="listaUsuarios" value="${beanClientes.listaUsuarios}"/-->





        <div class="py-1 bg-black top">
            <div class="container">
                <div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
                    <div class="col-lg-12 d-block">
                        <div class="row d-flex">
                            <div class="col-md pr-4 d-flex topper align-items-center">
                                <div class="icon mr-2 d-flex justify-content-center align-items-center"><span
                                        class="fa fa-user"></span></div>
                                <span class="text"> ${beanInicioSesion.nombre} </span>
                            </div>
                            <div class="col-md pr-4 d-flex topper align-items-center">
                                <div class="icon mr-2 d-flex justify-content-center align-items-center"><span
                                        class="icon-paper-plane"></span></div>
                                <span class="text">krakensystem@gmail.com</span>
                            </div>
                            <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right justify-content-end">
                                <p class="mb-0 register-link"><span>Abierto:</span> <span>Lunes - Domingo</span>
                                    <span>8:00AM
                                        - 9:00PM</span></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="faces/principal.jsp">Kraken</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                        aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">




                        <li class="nav-item active"><a href="menu.jsp" class="nav-link">Inicio</a></li>

                        <li class="dropdown nav-item">
                            <div class="nav-link"  id="dropdownMenuButton" data-toggle="dropdown"
                                 aria-haspopup="true" aria-expanded="false">
                                Registro
                            </div>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="#">Clientes</a>
                                <a class="dropdown-item" href="#">Productos</a>
                                <a class="dropdown-item" href="#">Pedidos</a>
                                <a class="dropdown-item" href="#">Despachos</a>
                            </div>
                        </li>





                        <li class="nav-item"><a href="#" class="nav-link">Facturación</a></li>

                        <li class="dropdown nav-item">
                            <div class="nav-link"  id="dropdownMenuButton" data-toggle="dropdown"
                                 aria-haspopup="true" aria-expanded="false">
                                Reportes
                            </div>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="#">Pedidos realizados</a>
                                <a class="dropdown-item" href="#">Ventas</a>

                            </div>
                        </li>





                        <% if (sesion.getNombre().equalsIgnoreCase("")) { %>
                        <li class="nav-item cta"><a href="faces/inicioSesion.xhtml" class="nav-link">Iniciar Sesión</a></li>
                            <% } else { %>



                        <li class="dropdown nav-item">
                            <div class="nav-link"  id="dropdownMenuButton" data-toggle="dropdown"
                                 aria-haspopup="true" aria-expanded="false">
                                Cerrar Sesión
                            </div>
                            <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">

                                <a class="dropdown-item" href="#"><img src="images/usuario.png" height="80" width="80" /></a>
                                <a class="dropdown-item" href="#">${sesion.nombre}</a>

                                <div class="dropdown-divider" href="#"></div>

                                <a href="inicioSesion.xhtml">Salir</a>

                            </div>
                        </li>


                        <% }%>

                    </ul>
                </div>
            </div>
        </nav>
        <!-- fin nav -->

        <section class="hero-wrap hero-wrap-2" style="background-image: url('images/fondo-login.jpg');"
                 data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-end justify-content-center">
                    <div class="col-md-9 ftco-animate text-center">
                        <h1 class="mb-2 bread"><img src="images/logo blanco blanco.png" alt="" style="max-height: 200px;"/>
                        </h1>

                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section">

            <div class="container">




                <!--table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nombre Completo</th>
                            <th scope="col">Dirección</th>
                            <th scope="col">Teléfono</th>
                            <th scope="col">Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row"></th>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>

                    </tbody>
                </table-->











                <div class="container">
                    <div class="panel panel-default">
                        <div class="panel-heading">LISTA DE CLIENTES</div>
                        <div class="table-responsive">
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Nombre Completo</th>
                                        <th scope="col">Dirección</th>
                                        <th scope="col">Teléfono</th>
                                        <th scope="col">Estado</th>				
                                    </tr>
                                </thead>
                                <tbody>

                                    <tr>

                                        ${beanClientes.lista}

                                    </tr>



                                </tbody>	

                            </table>






                            <script type="text/javascript">

                                function eliminar() {
                                        <%
                                        
                                        %>

                                }
                                
                            </script>



                        </div>
                    </div>
                    <!--//////////////////////////////////////////////////////////////////////////////////////////////////-->
                    <button type="button" onclick="ventananuevo();" class="btn btn-success btn-lg" >
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar
                    </button>

                    <button type="submit" class="btn btn-primary btn-lg"  onclick="recargarPagina()"
                            <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Actualizar Tabla
                    </button> 

                    <!--//////////////////////////////////////////////////////////////////////////////////////////////////-->
                </div>








                <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <!--h4 class="modal-title">Nuevo Paciente</h4-->
                            </div>
                            <form role="form"  id= "frmpaciente" name="frmpaciente" onsubmit="Registrarpaciente();
                                    return false">





                                <div class="col-lg-12">               



                                    <div class="form-group">
                                        <label>Cédula</label>
                                        <input  name="cedula" class="form-control" required>
                                    </div>

                                    <div class="form-group">
                                        <label>Nombre Completo</label>
                                        <input  name="nombre" class="form-control" required>
                                    </div>





                                    <div class="form-group">
                                        <label>Dirección</label>
                                        <input  name="direccion"  class="form-control" required>
                                    </div>



                                    <div class="form-group">
                                        <label>Telefono</label>
                                        <input  name="telefono" type="number"  class="form-control" required>
                                    </div>




                                    <button type="submit" class="btn btn-primary btn-lg" button='agregar' onclick="
                                            <%
                                                String cedula = "";
                                                String nombre = "";
                                                String direccion = "";
                                                String telefono = "";

                                                cedula = request.getParameter("cedula");
                                                nombre = request.getParameter("nombre");
                                                direccion = request.getParameter("direccion");
                                                telefono = request.getParameter("telefono");

                                                int respuesta;
                                                try {
                                                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                                                    Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=KrakenBD", "sa", "123456");

                                                    PreparedStatement ps = con.prepareStatement("Insert into usuario values (?,?,'1234',?,?,'Cliente','1')");
                                                    ps.setString(1, cedula);
                                                    ps.setString(2, nombre);
                                                    ps.setString(3, direccion);
                                                    ps.setString(4, telefono);
                                                    respuesta = ps.executeUpdate();
                                                    if (respuesta >= 1) {
                                                        out.println("<script>alert('Se ha guardado exitosamente')</script>");
                                                    } else {
                                                        out.println("<script>alert('Se ha producido un error al guardar')</script>");
                                                    }

                                                } catch (Exception e) {
                                                    out.println("<script>alertt('Se ha producido un error al guardar debido a </script>" + e.getMessage()+"')");
                                                }


                                            %>"


                                            >
                                        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Registrar
                                    </button>


                                </div>







                            </form>




                            <div class="modal-footer">
                            </div>
                        </div>
                    </div>
                </div>



                <!--//////////////////////////////////////////////////-->




            </div>
        </section>









        <footer class="ftco-footer ftco-bg-dark ftco-section">
            <div class="container-fluid px-md-5 px-3">
                <div class="row mb-5">




                </div>
                <div class="row">
                    <div class="col-md-12 text-center">
                        <p>
                            Eduardo Arley | Josué Marchena
                            <ul class="ftco-footer-social list-unstyled  mt-3">
                                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                            </ul>
                        </p>
                        <p>
                            Universidad Técnica Nacional
                            <br></br>
                            <script>
                                        document.write(new Date().getFullYear());
                            </script>
                        </p>
                    </div>
                </div>
            </div>
        </footer>




        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/jquery.timepicker.min.js"></script>
        <script src="js/scrollax.min.js"></script>

        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>






        <script type="text/javascript">

                                        function ventananuevo() {
                                            $('#modal').modal('show');

                                        }
                                        function cambiar() {
                                            $('#modal2').modal('show');

                                        }

                                        function recargarPagina() {
                                            location.reload(true);
                                        }
        </script>





    </h:body>
</html>
