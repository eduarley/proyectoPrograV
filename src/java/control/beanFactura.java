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
import model.DetPedido;
import model.Direccion;
import model.Pedido;
import model.PedidoDB;
import model.Usuario;

/**
 *
 * @author march
 */
@Named(value = "beanFactura")
@SessionScoped
public class beanFactura implements Serializable {

    /**
     * Creates a new instance of beanFactura
     */
    private int id;
    private Usuario usuario;
    private Pedido pedido;
    private Direccion direccion;
    private String tipoPago;
    private double iva;
    private double descuento;
    private double subTotal;
    private double total;
    private String montoPagado;
    LinkedList<Pedido> listaPedidos = new LinkedList<Pedido>();
    LinkedList<DetPedido> listaDetalles = new LinkedList<DetPedido>();
    
    public beanFactura() {
    }
    
    //AQUÍ SE VA A INSERTAR EL PRODUCTO
    public void insertarFactura(Pedido pedido, Usuario usuario){
        
    }

    public LinkedList<Pedido> getListaPedidos() throws SNMPExceptions, SQLException {
        PedidoDB pDB = new PedidoDB();
        return pDB.listaPedido();
    }

    /*
    public LinkedList<DetPedido> getListaDetalles(Pedido pedido) throws SNMPExceptions, SQLException {
        PedidoDB pDB = new PedidoDB();
        return pDB.listaDetalle(pedido);
    }*/

    public void setListaDetalles(LinkedList<DetPedido> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public void setListaPedidos(LinkedList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public String getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(String montoPagado) {
        this.montoPagado = montoPagado;
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
    
    
}
