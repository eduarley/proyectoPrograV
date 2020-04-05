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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    String cedula, nombre, direccion, telefono;

    String mensaje = "";

    public beanCliente() {
        /*this.cedula="";
        this.direccion="";
        this.mensaje="";
        this.nombre="";
        this.telefono="";*/

    }

    public void insertarCliente() throws SNMPExceptions, SQLException {
        Usuario usuario = new Usuario(Integer.parseInt(this.cedula), "activo", this.nombre, this.direccion, this.telefono);
        UsuarioDB uDB = new UsuarioDB();

        try {
            if (uDB.InsertarUsuario(usuario)) {
                FacesMessage message = new FacesMessage("El usuario " + usuario.getNombre() + " se ha registrado correctamente");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesMessage message = new FacesMessage("Error al registrar");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Hubo una falla: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }
    
    public void ayuda() {
        FacesMessage message = new FacesMessage("Ayuda", "En esta página podrá insertar, modificar, eliminar y consultar usuarios");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void modificarCliente() throws SNMPExceptions, SQLException {
        Usuario usuario = new Usuario(Integer.parseInt(this.cedula), "activo", this.nombre, this.direccion, this.telefono);
        UsuarioDB uDB = new UsuarioDB();

        try {
            if (uDB.InsertarUsuario(usuario)) {
                FacesMessage message = new FacesMessage("El usuario " + usuario.getNombre() + " se ha registrado correctamente");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesMessage message = new FacesMessage("Error al registrar");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Hubo una falla: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void eliminarCliente(Usuario us) throws SNMPExceptions, SQLException {

        UsuarioDB uDB = new UsuarioDB();

        try {
            if (uDB.eliminarUsuario(us)) {
                FacesMessage message = new FacesMessage("El usuario " + us.getNombre() + " ha sido desactivado correctamente");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesMessage message = new FacesMessage("Error al desactivar");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Hubo una falla: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void activarCliente(Usuario us) throws SNMPExceptions, SQLException {
        UsuarioDB uDB = new UsuarioDB();

        try {
            if (uDB.activarUsuario(us.getId())) {
                FacesMessage message = new FacesMessage("El usuario " + us.getNombre() + " ha sido activado correctamente");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesMessage message = new FacesMessage("Error al activar");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Hubo una falla: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public LinkedList<Usuario> getListaUsuarios() throws SNMPExceptions, SQLException {
        UsuarioDB uDB = new UsuarioDB();
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
