<%-- 
    Document   : principalPrueba
    Created on : 17-mar-2020, 15:26:38
    Author     : Usuario
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>








<jsp:useBean id="sesion" class="control.beanInicioSesion" scope="session"/>
<jsp:setProperty name="sesion" property="nombre" value="${beanInicioSesion.nombre}"/>
<jsp:setProperty name="sesion" property="id" value="${beanInicioSesion.nombre}"/>
<jsp:setProperty name="sesion" property="clave" value="${beanInicioSesion.clave}"/>
<jsp:setProperty name="sesion" property="direccion" value="${beanInicioSesion.direccion}"/>
<jsp:setProperty name="sesion" property="estado" value="${beanInicioSesion.estado}"/>
<jsp:setProperty name="sesion" property="rol" value="${beanInicioSesion.rol}"/>
<jsp:setProperty name="sesion" property="telefono" value="${beanInicioSesion.telefono}"/>



<%

    if (sesion.getNombre().equalsIgnoreCase("")) {
%>
<jsp:forward page="paginaError.xhtml">
    <jsp:param name="error" value="es necesario identificarse"/>
</jsp:forward>
<%
    }
%>








<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html">
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
    </h:head>
    <h:body>






        <div class="py-1 bg-black top">
            <div class="container">
                <div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
                    <div class="col-lg-12 d-block">
                        <div class="row d-flex">
                            <div class="col-md pr-4 d-flex topper align-items-center">
                                <div class="icon mr-2 d-flex justify-content-center align-items-center"><span
                                        class="fa fa-user"></span></div>
                                <span class="text"> <% out.print(sesion.getNombre()); %> </span>
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




                        <li class="nav-item active"><a href="principal.jsp" class="nav-link">Inicio</a></li>

                        <li class="dropdown nav-item">
                            <div class="nav-link"  id="dropdownMenuButton" data-toggle="dropdown"
                                 aria-haspopup="true" aria-expanded="false">
                                Registro
                            </div>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="clientes.xhtml">Clientes</a>
                                <a class="dropdown-item" href="producto.xhtml">Productos</a>
                                <!--<a class="dropdown-item" href="pedir.xhtml">Pedidos</a>-->
                                <a class="dropdown-item" href="despacho.xhtml">Despachos</a>
                            </div>
                        </li>




                        
                        <li class="nav-item"><a href="facturar.xhtml" class="nav-link">Facturar</a></li>

                        <li class="dropdown nav-item">
                            <div class="nav-link"  id="dropdownMenuButton" data-toggle="dropdown"
                                 aria-haspopup="true" aria-expanded="false">
                                Reportes
                            </div>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="reportepedidos.xhtml">Pedidos realizados</a>
                                <a class="dropdown-item" href="reporteventas.xhtml">Ventas</a>

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

                                <a class="dropdown-item" href="perfil.xhtml"><img src="images/usuario.png" height="80" width="80" /></a>
                                <a class="dropdown-item" href="perfil.xhtml"><% out.print(sesion.getNombre()); %></a>

                                <div class="dropdown-divider" href="#"></div>

                                <a href="inicioSesion.xhtml">
                                    <%
                                        
                                        out.print("Salir");
                                        //sesionOK.invalidate();
                                    %>
                                 
                                </a>



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

        
        <div class="ftco-section ftco-counter img" id="section-counter" data-stellar-background-ratio="0.5">
            
            <div class="container">
                <div class="row d-md-flex align-items-center justify-content-center">
                    <div class="col-lg-10">
                        <div class="row d-md-flex align-items-center">
                            
                            <div class="col-md d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18">
                                    <div class="text">
                                        <strong class="number" data-number="1500">0</strong>
                                        <span>Usuarios</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18">
                                    <div class="text">
                                        <strong class="number" data-number="50">0</strong>
                                        <span>Platillos</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18">
                                    <div class="text">
                                        <strong class="number" data-number="20">0</strong>
                                        <span>Años de experiencia</span>
                                    </div>
                                </div>
                            </div>
                           
                        </div>
                    </div>
                </div>
            </div>
        </div>









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
    </h:body>
</html>
