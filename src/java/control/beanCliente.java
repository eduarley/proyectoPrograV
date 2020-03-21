/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.SNMPExceptions;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.faces.model.SelectItem;
import model.Usuario;
import model.UsuarioDB;

/**
 *
 * @author Usuario
 */
@Named(value = "beanCliente")
@SessionScoped
public class beanCliente implements Serializable {

    /**
     * Creates a new instance of beanCliente
     */
    
    
    
    LinkedList<Usuario> listaUsuarios = new LinkedList<Usuario>();
    
    String cedula,nombre,direccion,telefono;
    
    String mensaje="";
    
    public beanCliente() {
        /*this.cedula="";
        this.direccion="";
        this.mensaje="";
        this.nombre="";
        this.telefono="";*/
        
    }

    
    
    public String insertarCliente()throws SNMPExceptions, SQLException{
        Usuario usuario = new Usuario(Integer.parseInt(this.cedula), "activo", this.nombre, this.direccion, this.telefono);
        UsuarioDB uDB= new UsuarioDB();
        
        if(uDB.InsertarUsuario(usuario))
            mensaje="Se ha guargado exitosamente!";
        else
             mensaje="Se ha producido un error al guardar!";
        
        
        
        
        /*
        this.cedula="";
        this.direccion="";
        //this.mensaje="";
        this.nombre="";
        this.telefono="";*/
        
        return mensaje;
        
        
         
    }
    
     public String eliminarCliente(Usuario us)throws SNMPExceptions, SQLException{
       
        UsuarioDB uDB= new UsuarioDB();
        
        if(uDB.eliminarUsuario(us))
            mensaje="Se ha desactivado exitosamente!";
        else
             mensaje="Se ha producido un error al desactivar!";
        
        
        return mensaje;
        
        
         
    }
     
     
     
      public String activarCliente(Usuario us)throws SNMPExceptions, SQLException{
        Usuario usuario = new Usuario();
        usuario=us;
        UsuarioDB uDB= new UsuarioDB();
        
        if(uDB.activarUsuario(usuario.getId()))
            mensaje="Se ha desactivado exitosamente!";
        else
             mensaje="Se ha producido un error al desactivar!";
        
        
        return mensaje;
        
        
         
    }
     
     
     
    
    public LinkedList<Usuario> getListaUsuarios() throws SNMPExceptions, SQLException{
        UsuarioDB uDB= new UsuarioDB();
        return uDB.listaObjetosClientes();
    }

    public void setListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
