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
    private String tipoPago;
    private double iva;
    private double descuento;
    private double subTotal;
    private double total;
    private String estadoDespacho;

    public Factura(int idUsuario, int idPedido, String direccion, String tipoPago, double iva, double descuento, double subTotal, double total) {
        this.usuario= new Usuario();
        this.pedido= new Pedido();
        this.direccion= new Direccion();
        this.usuario.setId(idUsuario);
        this.pedido.setId(idPedido);
        this.direccion.setDireccion(direccion);
        this.tipoPago = tipoPago;
        this.iva = iva;
        this.descuento = descuento;
        this.subTotal = subTotal;
        this.total = total;
    }

    public Factura() {
        this.usuario= new Usuario();
        this.pedido= new Pedido();
        this.direccion= new Direccion();
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

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
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

    public String getEstadoDespacho() {
        return estadoDespacho;
    }

    public void setEstadoDespacho(String estadoDespacho) {
        this.estadoDespacho = estadoDespacho;
    }
}
