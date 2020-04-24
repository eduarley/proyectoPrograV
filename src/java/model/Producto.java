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
   
    private String EstadoString;
    
    private double precio;

    private String url;
    
    public Producto() {

    }

    public Producto(int existencias, String descripcion, String tipo, String ingredientes, double precio, String url) {
        this.existencias = existencias;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.url = url;
    }
    
    public Producto(int id, int existencias, String descripcion, String tipo, String ingredientes, double precio, String url) {
        this.id= id;
        this.existencias = existencias;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.url = url;
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

 

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEstadoString() {
        return EstadoString;
    }

    public void setEstadoString(String EstadoString) {
        this.EstadoString = EstadoString;
    }

    
   
    
    
}
