<%-- 
    Document   : prueba
    Created on : 03-abr-2020, 15:29:28
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core"

      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:p="http://primefaces.org/ui"
      template="/templates/template.xhtml"
      xmlns:a="http://xmlns.jcp.org/jsf/passthrough""
      >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h:form enctype="multipart/form-data">
        <div align="center" class="datagrid">

            <p:growl showDetail="true"/>


            <h:dataTable class="table table-striped table-hover" value="${beanProducto.listaProductos}" var="producto">

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Imagen"></h:outputText>
                    </f:facet>
                    <h:graphicImage style="max-height: 50px;" url="${producto.url}"></h:graphicImage>
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="ID"></h:outputText>
                    </f:facet>
                    <h:outputText value="${producto.id}"></h:outputText>
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Descripción"></h:outputText>
                    </f:facet>
                    <h:outputText value="${producto.descripcion}"></h:outputText>
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Precio"></h:outputText>
                    </f:facet>
                    <h:outputText value="${producto.precio}"></h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Existencias"></h:outputText>
                    </f:facet>
                    <h:outputText value="${producto.existencias}"></h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Tipo"></h:outputText>
                    </f:facet>
                    <h:outputText value="${producto.tipo}"></h:outputText>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Ingredientes"></h:outputText>
                    </f:facet>
                    <h:outputText value="${producto.ingredientes}"></h:outputText>
                </h:column>

                <!---->
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Estado"></h:outputText>
                    </f:facet>
                    <h:outputText value="${producto.estado}"></h:outputText>
                </h:column>
                <!---->


                <h:column>
                    <button type='submit'
                                     value="Eliminar"
                                     class='btn btn-danger'
                                     actionListener="${beanProducto.eliminarProducto(producto)}">
                    </button>
                </h:column>



                <h:column>
                    <button type="button" class="btn btn-primary" >
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Modificar
                    </button>
                </h:column>

            </h:dataTable>
        </div>


    </h:form>
</body>
</html>
