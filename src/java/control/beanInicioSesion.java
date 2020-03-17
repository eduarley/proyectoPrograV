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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String clave;

    private String id;

    public beanInicioSesion() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String validar() throws SNMPExceptions, SQLException {
        InicioSesion inicio = new InicioSesion();

        try {
            int cedula = Integer.parseInt(id);

            if (inicio.validarDatos(cedula, clave) != null) {
                //return "faces/menu.xhtml";
                //if()
                if (inicio.validarDatos(cedula, clave).getRol().equalsIgnoreCase("admin")) {
                    return "faces/principal.xhtml";
                } else {
                    return "faces/menu.xhtml";
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
