/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import javax.servlet.http.Part;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author march
 */
public class Producto {

    private int id, estado, existencias;
    private String descripcion, tipo;
    //private byte[] imagen;
    private double precio;
    //private Image img;
//    private UploadedFile file;
    private byte[] file;
    private Part uploadedFile;

    /*
    public Producto(int id, String descripcion, byte[] imagen, double precio, int existencias, String tipo, int estado) {
        this.id = id;
        this.estado = estado;
        this.existencias = existencias;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.imagen = imagen;
        this.precio = precio;
    }
*/
    public Producto() {

    }
/*
    public Producto(String descripcion, byte[] imagen, double precio, int existencias, String tipo) {
        this.existencias = existencias;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.imagen = imagen;
        this.precio = precio;
    }*/

//    public Producto(String descripcion, UploadedFile file, double precio, int existencias, String tipo) {
//        this.existencias = existencias;
//        this.descripcion = descripcion;
//        this.tipo = tipo;
//        this.file= file;
//        this.precio = precio;
//    }
    
    public Producto(String descripcion, Part uploadedFile, double precio, int existencias, String tipo) {
        this.existencias = existencias;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.uploadedFile= uploadedFile;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
/*
    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
*/
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
/*
    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    
    */
//    public UploadedFile getFile() {
//        return file;
//    }
//
//    public void setFile(UploadedFile file) {
//        this.file = file;
//    }

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
