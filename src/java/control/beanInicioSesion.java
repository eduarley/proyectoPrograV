/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.InicioSesion;
import DAO.SNMPExceptions;
import java.sql.SQLException;


/**
 *
 * @author march
 */
@Named(value = "beanInicioSesion")
@SessionScoped
public class beanInicioSesion implements Serializable {

    /**
     * Creates a new instance of beanInicioSesion
     */
    //private int id;
    private String id;
    private String nombre;
    private String clave;
    private String direccion;
    private String telefono;
    private String rol;
    private int estado;
    

    
    //private Usuario user;
            
    public beanInicioSesion() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
   
    

    public String validar() throws SNMPExceptions, SQLException {
        InicioSesion inicio = new InicioSesion();

        
       
    
        try {
            
         
            int cedula = Integer.parseInt(id);
            
            
            
            
            
            
            
             this.clave=inicio.validarDatos(cedula, clave).getClave();
             this.direccion=inicio.validarDatos(cedula, clave).getDireccion();
             this.estado=inicio.validarDatos(cedula, clave).getEstado();
             this.id=String.valueOf(cedula);
             this.nombre=inicio.validarDatos(cedula, clave).getNombre();
             this.rol=inicio.validarDatos(cedula, clave).getRol();
             this.telefono=inicio.validarDatos(cedula, clave).getTelefono();
             
            
            
            
            
            if (inicio.validarDatos(cedula, clave) != null) {
                
                if (inicio.validarDatos(cedula, clave).getRol().equalsIgnoreCase("admin")) {
                    return "faces/principal.jsp";
                } else {
                    //return "faces/menu.xhtml";
                    return "faces/menu.jsp";
                }

            } else {
                return "";
            }

        } catch (Exception e) {
            //poner alerta que no la cedula deben ser digitos
        }
        return "";
    }

}
