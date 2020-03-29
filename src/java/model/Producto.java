/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.Blob;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author march
 */
public class Producto {

    private int id, estado, existencias;
    private String descripcion, tipo, ingredientes;
   
    private double precio;

    private byte[] file;
    private Part uploadedFile;

    private BufferedImage img;
 
    private ImageIO image;
    
    public Producto() {

    }

    
    public Producto(String descripcion, Part uploadedFile, double precio, int existencias, String tipo, String ingredientes) {
        this.existencias = existencias;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.uploadedFile= uploadedFile;
        this.precio = precio;
        this.ingredientes= ingredientes;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public ImageIO getImage() {
        return image;
    }

    public void setImage(ImageIO image) {
        this.image = image;
    }

   
   
    
    
}
