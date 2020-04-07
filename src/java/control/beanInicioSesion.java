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
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.Usuario;


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
    private String estado;
    private String mensaje;
    

    
    private Usuario usuario;
            
    public beanInicioSesion() {

    }


    /*
    public void consultarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
	final Map session = context.getSessionMap();
	final Usuario user = (Usuario) session.get("usuario");

	if (user != null) {
		try {
			this.usuario=(Usuario)user;
			
		} catch (ClassCastException e) {
			
			
		}
	}else{
		context.invalidateSession();
		
	}
	
	
    }*/
    
    
//    public void ayuda() {
//        FacesMessage message = new FacesMessage("Ayuda", "Estimado Usuario, debe Iniciar Sesión como Cliente para poder realizar un Pedido");
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
    
    
    
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario user) {
        this.usuario = user;
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
                    setMensaje("");
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",inicio.validarDatos(cedula, clave));
                    FacesContext.getCurrentInstance().getExternalContext().redirect("principal.jsp");
                    //return "faces/principal.jsp";
                } else {
                    
                    setMensaje("");
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",inicio.validarDatos(cedula, clave));
                    FacesContext.getCurrentInstance().getExternalContext().redirect("menu.jsp");
                    //return "faces/menu.jsp";
                }

            } else {
                return "";
            }

        } catch (Exception e) {
            setMensaje("No se permiten caracteres en el nombre de usuario");
        }
        setMensaje("Datos incorrectos, \nverifique que su usuario esté activo");
        return "";
    }
    
    
    public void cerrarSesion(){
        this.nombre="";
        this.clave="";
        this.direccion="";
        this.estado="";
        this.id="";
        this.mensaje="";
        this.rol="";
        this.telefono="";
        this.usuario=null;
        
    }

}
