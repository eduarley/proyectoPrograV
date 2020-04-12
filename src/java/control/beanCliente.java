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
import model.Direccion;
import model.DireccionDB;
import model.Horario;
import model.HorarioDB;
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
    LinkedList<Direccion> listaDirecciones = new LinkedList<Direccion>();
    LinkedList<Horario> listaHorarios = new LinkedList<Horario>();
    String cedula, nombre, direccion, telefono, horaInicioTemp, horaFinTemp;

    String mensaje = "";

    String DireccionTemporal;

    Usuario usuarioEditar= new Usuario();

    public beanCliente() {
        /*this.cedula="";
        this.direccion="";
        this.mensaje="";
        this.nombre="";
        this.telefono="";*/
//        FacesMessage message = new FacesMessage("Ayuda", "En esta página podrá insertar, modificar, eliminar y consultar usuarios");
//        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void insertarCliente() throws SNMPExceptions, SQLException {
        Usuario usuario = new Usuario(Integer.parseInt(this.cedula), "activo", this.nombre, this.direccion, this.telefono);
        UsuarioDB uDB = new UsuarioDB();

        try {
            if (uDB.InsertarUsuario(usuario)) {
                FacesMessage message = new FacesMessage("Éxito", "El usuario " + usuario.getNombre() + " se ha registrado correctamente");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesMessage message = new FacesMessage("Error", "Error al registrar");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Error", "Hubo una falla: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void ayuda() {
        FacesMessage message = new FacesMessage("Ayuda", "En esta página podrá insertar, modificar, eliminar y consultar usuarios");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void modificarCliente() throws SNMPExceptions, SQLException {
        
        
        try {
            if (UsuarioDB.editarUsuario(usuarioEditar)) {
                FacesMessage message = new FacesMessage("Éxito", "Datos actualizados!");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesMessage message = new FacesMessage("Error", "Error al actualizar");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Error", "Error al actualizar");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void eliminarCliente(Usuario us) throws SNMPExceptions, SQLException {

        UsuarioDB uDB = new UsuarioDB();

        try {
            if (uDB.eliminarUsuario(us)) {
                FacesMessage message = new FacesMessage("Éxito", "El usuario " + us.getNombre() + " ha sido desactivado correctamente");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesMessage message = new FacesMessage("Error", "Error al desactivar");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Error", "Hubo una falla: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void activarCliente(Usuario us) throws SNMPExceptions, SQLException {
        UsuarioDB uDB = new UsuarioDB();

        try {
            if (uDB.activarUsuario(us.getId())) {
                FacesMessage message = new FacesMessage("Éxito", "El usuario " + us.getNombre() + " ha sido activado correctamente");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesMessage message = new FacesMessage("Error", "Error al activar");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Error", "Hubo una falla: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void insertarDireccion(int idUsuario) {
        DireccionDB dDB = new DireccionDB();
        Direccion dir = new Direccion();

        dir.setDireccion(DireccionTemporal);
        dir.setIdUsuario(idUsuario);

        try {
            dDB.InsertarDireccion(dir);
            FacesMessage message = new FacesMessage("Éxito", "La dirección se insertó exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Error", "La dirección no se pudo insertar");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void eliminarDireccion(Direccion direccion) {
        DireccionDB dDB = new DireccionDB();

        try {
            dDB.eliminarDireccion(direccion);
            FacesMessage message = new FacesMessage("Éxito", "La dirección se ha eliminado exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Error", "La dirección no se pudo eliminar");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void eliminarHorario(Horario hora) {
        DireccionDB dDB = new DireccionDB();

        try {
            dDB.eliminarHorario(hora);
            FacesMessage message = new FacesMessage("Éxito", "El horario se ha eliminado exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Error", "El horario no se pudo eliminar");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void insertarHorario(int idUsuario) {

        HorarioDB hDB = new HorarioDB();
        Horario h = new Horario();

        h.setIdUsuario(idUsuario);
        h.setHoraInicio(horaInicioTemp);
        h.setHoraFin(horaFinTemp);

        try {
            hDB.InsertarHorario(h);
            FacesMessage message = new FacesMessage("Éxito", "El horario se insertó exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Error", "El horario no se pudo insertar");
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

    public LinkedList<Direccion> getListaDirecciones(int idUsuario) throws SNMPExceptions, SQLException {
        UsuarioDB uDB = new UsuarioDB();
        return uDB.listaDirecciones(idUsuario);
    }

    public void setListaDirecciones(LinkedList<Direccion> listaDirecciones) {
        this.listaDirecciones = listaDirecciones;
    }

    public String getDireccionTemporal() {
        return DireccionTemporal;
    }

    public void setDireccionTemporal(String DireccionTemporal) {
        this.DireccionTemporal = DireccionTemporal;
    }

    public LinkedList<Horario> getListaHorarios(int idUsuario) throws SNMPExceptions, SQLException {
        HorarioDB hDB = new HorarioDB();
        return hDB.listaHorarios(idUsuario);
    }

    public void setListaHorarios(LinkedList<Horario> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }

    public String getHoraInicioTemp() {
        return horaInicioTemp;
    }

    public void setHoraInicioTemp(String horaInicioTemp) {
        this.horaInicioTemp = horaInicioTemp;
    }

    public String getHoraFinTemp() {
        return horaFinTemp;
    }

    public void setHoraFinTemp(String horaFinTemp) {
        this.horaFinTemp = horaFinTemp;
    }

    public Usuario getUsuarioEditar() {
        return usuarioEditar;
    }

    public void setUsuarioEditar(Usuario usuarioEditar) {
        this.usuarioEditar = usuarioEditar;
    }

}
