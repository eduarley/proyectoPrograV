/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author march
 */
public class Factura {
    private int id;
    private Usuario usuario;
    private Pedido pedido;
    private Direccion direccion;
    private TipoPago tipoPago;
    private double iva;
    private double descuento;
    private double subTotal;
    private double total;

    public Factura(int id, Usuario usuario, Pedido pedido, Direccion direccion, TipoPago tipoPago, double iva, double descuento, double subTotal, double total) {
        this.id = id;
        this.usuario = usuario;
        this.pedido = pedido;
        this.direccion = direccion;
        this.tipoPago = tipoPago;
        this.iva = iva;
        this.descuento = descuento;
        this.subTotal = subTotal;
        this.total = total;
    }

    public Factura() {
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
