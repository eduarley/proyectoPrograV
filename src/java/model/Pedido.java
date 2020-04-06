/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author march
 */
public class Pedido {
    private int id;
    private Usuario usuario;
    private Direccion direccion;
    private Date fechaEntrega;
    private Time horarioEntrega;
    private String direccionEntrega;
    private double monto;
    private String estado;

    public Pedido(int id, Usuario usuario, Direccion direccion, Date fechaEntrega, Time horarioEntrega, String direccionEntrega, double monto, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.direccion = direccion;
        this.fechaEntrega = fechaEntrega;
        this.horarioEntrega = horarioEntrega;
        this.direccionEntrega = direccionEntrega;
        this.monto = monto;
        this.estado = estado;
    }

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Time getHorarioEntrega() {
        return horarioEntrega;
    }

    public void setHorarioEntrega(Time horarioEntrega) {
        this.horarioEntrega = horarioEntrega;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
