/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.SNMPExceptions;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.UsuarioDB;
import model.Usuario;
/**
 *
 * @author Usuario
 */
@Named(value = "beanClientes")
@Dependent
public class beanClientes {

    
    
    
    public String lista;
    
    LinkedList<Usuario> listaUsuarios = new LinkedList<Usuario>();
    
    String cedula,nombre,direccion,telefono;

    
    
     public beanClientes() {
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
    
    

    public String getLista()  throws SNMPExceptions, SQLException{
       UsuarioDB uDB= new UsuarioDB();
       return uDB.listaClientes();
       
       
    }

    
    
    
    public void agregarUsuario(String ced, String nom, String dir, String tel)
            throws SNMPExceptions, SQLException{
        
    }
    
    
    
    
    
    
    
    public void setLista(String lista) {
        this.lista = lista;
    }
   
 
    
   
    
    
    
}
