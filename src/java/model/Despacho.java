/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author march
 */
public class Despacho {
    private int id;
    private int idFactura;
    private Date fechaEnvio;
    private String medio;
    private int estado;

    public Despacho(int id, int idFactura, Date fechaEnvio, String medio, int estado) {
        this.id = id;
        this.idFactura = idFactura;
        this.fechaEnvio = fechaEnvio;
        this.medio = medio;
        this.estado = estado;
    }

    public Despacho() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
