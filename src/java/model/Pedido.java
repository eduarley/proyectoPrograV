/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author march
 */
public class Pedido {
    private int id;
    private Usuario usuario;
    private Direccion direccion;
    private String fechaEntrega;
    private String horarioEntrega;
    private String direccionEntrega;
    private double monto;
    private String estado;
    
    private ArrayList<DetPedido> arregloDetPedido= new ArrayList<DetPedido>();
    
    public Pedido(int id, Usuario usuario, Direccion direccion, String fechaEntrega, String horarioEntrega, String direccionEntrega, double monto, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.direccion = direccion;
        this.fechaEntrega = fechaEntrega;
        this.horarioEntrega = horarioEntrega;
        this.direccionEntrega = direccionEntrega;
        this.monto = monto;
        this.estado = estado;
    }

    public Pedido(Usuario usuario, String fechaEntrega, String horarioEntrega, String direccionEntrega, String estado) {
        this.usuario = usuario;
        this.fechaEntrega = fechaEntrega;
        this.horarioEntrega = horarioEntrega;
        this.direccionEntrega = direccionEntrega;
     
        this.estado = estado;
    }

    
    
    public void agregarDetalle(DetPedido det){
        this.arregloDetPedido.add(det);
    }
    
    public Pedido() {
        usuario= new Usuario();
        direccion= new Direccion();
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

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getHorarioEntrega() {
        return horarioEntrega;
    }

    public void setHorarioEntrega(String horarioEntrega) {
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

    public ArrayList<DetPedido> getArregloDetPedido() {
        return arregloDetPedido;
    }

    public void setArregloDetPedido(ArrayList<DetPedido> arregloDetPedido) {
        this.arregloDetPedido = arregloDetPedido;
    }
    
    
}
