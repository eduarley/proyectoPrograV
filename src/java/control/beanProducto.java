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

    private String id, descripcion, precio, existencias, tipo, ingredientes;
  
    private Part uploadedFile;
    private byte[] file;


    public beanProducto() {
    }

    public void insertarProducto() throws SNMPExceptions, SQLException {
        
        //this.file=  uploadedFile.getSubmittedFileName();
        Producto producto = new Producto(descripcion, uploadedFile, Double.valueOf(this.precio), Integer.parseInt(this.existencias), tipo, ingredientes);
        ProductoDB pDB = new ProductoDB();

            if (pDB.InsertarProducto(producto)) {
                //FacesMessage message = new FacesMessage("Éxito", file.getFileName() + " fue guardado con éxito");
                FacesMessage message = new FacesMessage("Éxito", "Guardado con éxito");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesMessage message = new FacesMessage("Error al guardar la imagen.!");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
     
    }

    
    
    
    /*
    public String eliminarProducto(Producto pro) throws SNMPExceptions, SQLException {

        ProductoDB pDB = new ProductoDB();

        if (pDB.eliminarProducto(pro)) {
            mensaje = "Se ha desactivado exitosamente!";
        } else {
            mensaje = "Se ha producido un error al desactivar!";
        }

        return mensaje;

    }
*/
    public LinkedList<Producto> getListaProductos() throws SNMPExceptions, SQLException {
        ProductoDB pDB = new ProductoDB();
        return pDB.listaObjetosProductos();
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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    
}
