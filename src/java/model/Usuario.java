/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author march
 */

public class Usuario {
   
    private int id, estado;
   
    private String nombre, clave, direccion, telefono, rol;

    public Usuario(int id, int estado, String nombre, String clave, String direccion, String telefono, String rol) {
        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
        this.clave = clave;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rol = rol;
    }

    public Usuario(int id, String clave) {
        this.id = id;
        this.clave = clave;
    }

    public Usuario(int id, int estado, String nombre, String direccion, String telefono) {
        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        
    }

    public Usuario() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
