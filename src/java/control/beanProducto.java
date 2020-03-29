/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.SNMPExceptions;
import java.awt.Image;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.faces.model.SelectItem;
import model.Producto;
import model.ProductoDB;

import java.io.FileOutputStream;
import java.io.InputStream;

import java.io.File;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;

import org.primefaces.model.UploadedFile;

/**
 *
 * @author march
 */
@Named(value = "beanProducto")
@SessionScoped
public class beanProducto implements Serializable {

    /**
     * Creates a new instance of beanProducto
     */
    LinkedList<Producto> listaProductos = new LinkedList<Producto>();

    private String id, descripcion, precio, existencias, tipo, ingredientes, mensaje,url;

   
    
    
    public beanProducto() {
    }

    public void insertarProducto() throws SNMPExceptions, SQLException {

        Producto producto = new Producto(Integer.parseInt(this.existencias), descripcion, tipo, ingredientes, Double.valueOf(this.precio), this.url);
        ProductoDB pDB = new ProductoDB();

        if (pDB.InsertarProducto(producto)) {
            
            FacesMessage message = new FacesMessage("Éxito", "Guardado con éxito");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage("Error al guardar la imagen.!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public String eliminarProducto(Producto pro) throws SNMPExceptions, SQLException {

        ProductoDB pDB = new ProductoDB();

        if (pDB.eliminarProducto(pro)) {
            mensaje = "Se ha eliminado exitosamente!";
        } else {
            mensaje = "Se ha producido un error al eliminar!";
        }

        return mensaje;

    }

    public LinkedList<Producto> getListaProductos() throws SNMPExceptions, SQLException {
        ProductoDB pDB = new ProductoDB();
        return pDB.listaObjetosProductos();
    }

    public String listaMenuDesayunos() throws SNMPExceptions, SQLException {
        ProductoDB pDB = new ProductoDB();
        String menu="";
        if(pDB.listaMenuDesayuno().equalsIgnoreCase("")){
            menu+="<h3 class=\"text-center\">No hay desayunos registrados</h3>";
        }else{
            menu+=pDB.listaMenuDesayuno();
        }
        return menu;
    }

    public String listaMenuAlmuerzos() throws SNMPExceptions, SQLException {
        ProductoDB pDB = new ProductoDB();
        String menu="";
        if(pDB.listaMenuAlmuerzo().equalsIgnoreCase("")){
            menu+="<h3 class=\"text-center\">No hay almuerzos registrados</h3>";
        }else{
            menu+=pDB.listaMenuAlmuerzo();
        }
        return menu;
        //return pDB.listaMenuAlmuerzo();
    }

    public String listaMenuCena() throws SNMPExceptions, SQLException {
        ProductoDB pDB = new ProductoDB();
        String menu="";
        if(pDB.listaMenuCena().equalsIgnoreCase("")){
            menu+="<h3 class=\"text-center\">No hay cenas registrados</h3>";
        }else{
            menu+=pDB.listaMenuCena();
        }
        return menu;
    }

    public void setListaProductos(LinkedList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getExistencias() {
        return existencias;
    }

    public void setExistencias(String existencias) {
        this.existencias = existencias;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
