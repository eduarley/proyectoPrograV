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
import model.InicioSesion;

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
    private int id;
    private String clave;
    
    public beanInicioSesion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String validar() throws SNMPExceptions{
        InicioSesion inicio= new InicioSesion();
        if(inicio.validarDatos(id, clave)){
            return "faces/index.xhtml";
        }else{
            return "";
        }
    }
    
}
