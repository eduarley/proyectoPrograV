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





        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="faces/principal.jsp">Kraken</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                        aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">










                        <% if (sesion.getNombre().equalsIgnoreCase("")) { %>
                        <li class="nav-item cta"><a href="#" class="nav-link">Regresar</a></li>
                            <% } else { %>



                        <li class="dropdown nav-item">
                            <div class="nav-link"  id="dropdownMenuButton" data-toggle="dropdown"
                                 aria-haspopup="true" aria-expanded="false">
                                Cerrar Sesión
                            </div>
                            <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">

                                <a class="dropdown-item" href="#"><img src="images/usuario.png" height="80" width="80" /></a>
                                <a class="dropdown-item" href="#"><% out.print(sesion.getNombre()); %></a>

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



        

        <section class="ftco-section ftco-no-pt ftco-no-pb contact-section">
            <h2 class="text-center">Perfil</h2>
            <div class="container">
                <div class="row d-flex align-items-stretch no-gutters">
                    <div class="col-md-6 p-5 order-md-last">
                        <h2 class="h4 mb-5 font-weight-bold">Editar Perfil</h2>
                        <form action="#">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Your Name">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Your Email">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Subject">
                            </div>
                            <div class="form-group">
                                <textarea name="" id="" cols="30" rows="7" class="form-control" placeholder="Message"></textarea>
                            </div>
                            <div class="form-group">
                                <input type="submit" value="Send Message" class="btn btn-primary py-3 px-5">
                            </div>
                        </form>
                    </div>
                    <div class="col-md-6 d-flex align-items-stretch">
                        <div>
                            <div class="container">
                                <div class="row justify-content-center mb-5 pb-2">
                                    <div class="col-md-7 text-center heading-section ftco-animate">

                                        
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-8 col-lg-8 ftco-animate">
                                        <div class="staff">
                                            <div class="img" style="background-image: url(images/usuario.png);"></div>
                                            <div class="text pt-4">
                                                <h3>John Smooth</h3>
                                                <span class="position mb-2">Restaurant Owner</span>
                                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                                                <div class="faded">

                                                    <ul class="ftco-social d-flex">
                                                        <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                                                        <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                                                        <li class="ftco-animate"><a href="#"><span class="icon-google-plus"></span></a></li>
                                                        <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
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
