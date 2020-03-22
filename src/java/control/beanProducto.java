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

    private String id, descripcion, precio, existencias, tipo;
    private byte[] imagen;

    //private Image img;
    //private Part img;
    private UploadedFile file;

    private Part image;
    private boolean upladed;

    private String mensaje = "";

    public beanProducto() {
    }

    public void insertarProducto() throws SNMPExceptions, SQLException {

        //if(file!=null){
        //Producto producto = new Producto(this.descripcion, this.imagen, Double.valueOf(this.precio), Integer.parseInt(this.existencias), this.tipo);
        //Producto producto = new Producto(descripcion, img,  Double.valueOf(this.precio), Integer.parseInt(this.existencias), tipo);
        Producto producto = new Producto(descripcion, file, Double.valueOf(this.precio), Integer.parseInt(this.existencias), tipo);
        ProductoDB pDB = new ProductoDB();

        if (producto.getFile() != null) {
            if (pDB.InsertarProducto(producto)) {
                FacesMessage message = new FacesMessage("Éxito", file.getFileName() + " fue guardado con éxito");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesMessage message = new FacesMessage("Error al guardar la imagen ", file.getFileName());
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } else {

        }

        //return mensaje;
    }

    public String eliminarProducto(Producto pro) throws SNMPExceptions, SQLException {

        ProductoDB pDB = new ProductoDB();

        if (pDB.eliminarProducto(pro)) {
            mensaje = "Se ha desactivado exitosamente!";
        } else {
            mensaje = "Se ha producido un error al desactivar!";
        }

        return mensaje;

    }

    public LinkedList<Producto> getListaProductos() throws SNMPExceptions, SQLException {
        ProductoDB pDB = new ProductoDB();
        return pDB.listaObjetosProductos();
    }
    
    
    
    
    
    
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    
    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    
    

    public void doUpload() {
        try {
            InputStream in = image.getInputStream();

            File f = new File("/Users/Usuario/Desktop/" + image.getSubmittedFileName());
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            out.close();
            in.close();

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", f.getAbsolutePath());
            upladed = true;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }
/*
    public void handleFileUpload(FileUploadEvent event) {
        String field = event.getComponent().getId();

        try {
            // Guardamos el fichero 
            reg.put(field, event.getFile().getFileName());
            reg.put(field + "_content", event.getFile().getContents());
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", ex.getLocalizedMessage()));
        }
    }
*/
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

//    
//     public Image getImg() {
//        return img;
//    }
//
//    public void setImg(Image img) {
//        this.img = img;
//    }
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
}
