<%-- 
    Document   : menu
    Created on : 17-mar-2020, 12:15:59
    Author     : Eduardo
--%>

<%@page import="model.Usuario"%>
<%@page import="control.beanInicioSesion"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>


<%
    Usuario usuario = null;
    HttpSession sesionOK = request.getSession();
    if (sesionOK.getAttribute("usuario") != null)
        usuario = (Usuario) session.getAttribute("usuario");
    else
%>






<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html">
    <h:head>
        <title>Kraken | Menú</title>
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

        

        <!--jsp:setProperty name="" property="" value=""/-->
        <div class="py-1 bg-black top">
            <div class="container">
                <div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
                    <div class="col-lg-12 d-block">
                        <div class="row d-flex">
                            <div class="col-md pr-4 d-flex topper align-items-center">


                                <div class="icon mr-2 d-flex justify-content-center align-items-center"><span
                                        class="fa fa-user"></span></div>
                                        <span class="text"> <%
                                            if (sesionOK.getAttribute("usuario") != null)
                                                out.print(usuario.getNombre()); 
                                            else
                                                out.print("No se ha iniciado sesión"); 
                                        %></span>
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
                <a class="navbar-brand" href="faces/menu.jsp">Kraken</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                        aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">


                        <li class="nav-item active"><a href="faces/menu.jsp" class="nav-link">Menu</a></li>


                        <% if (usuario==null) { %>
                        <li class="nav-item cta"><a href="faces/inicioSesion.xhtml" class="nav-link">Iniciar Sesión</a></li>
                            <% } else { %>


                        
                        <li class="dropdown nav-item">
                            <div class="nav-link"  id="dropdownMenuButton" data-toggle="dropdown"
                                 aria-haspopup="true" aria-expanded="false">
                                Cerrar Sesión
                            </div>
                            <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                                
                                <a class="dropdown-item" href="#"><img src="images/usuario.png" height="80" width="80" /></a>
                                <a class="dropdown-item" href="#"><% out.print(usuario.getNombre()); %></a>
                                
                                <div class="dropdown-divider" href="#"></div>
                                
                                <a href="inicioSesion.xhtml">
                                    <%
                                        out.print("Salir");
                                        sesionOK.invalidate();
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
                        <!--p style="color: white">
                        <%= new java.util.Date()%>
                        </p-->
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section">
            <div class="container-fluid px-4">
                <div class="row justify-content-center mb-5 pb-2">
                    <div class="col-md-7 text-center heading-section ftco-animate">
                        <span class="subheading">Menú</span>
                        <h2 class="mb-4">Menú</h2>
                    </div>
                </div>
                

                <div class="row">
                    <div class="col-md-6 col-lg-4 menu-wrap">
                        <div class="heading-menu text-center ftco-animate">
                            <h3>Desayunos</h3>
                            
                        </div>
                        ${beanProducto.listaMenuDesayunos()}
                    </div>

                    <!--Fin desayunos-->


                    <div class="col-md-6 col-lg-4 menu-wrap">
                        <div class="heading-menu text-center ftco-animate">
                            <h3>Almuerzos</h3>
                        </div>
                        ${beanProducto.listaMenuAlmuerzos()}
                    </div>

                    <!--Fin almuerzos-->


                    <div class="col-md-6 col-lg-4 menu-wrap">
                        <div class="heading-menu text-center ftco-animate">
                            <h3>Cenas</h3>
                        </div>
                        ${beanProducto.listaMenuCena()}
                    </div>

                    <!--Fin cenas-->




                </div>
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
    </h:body>
</html>
