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
import model.Factura;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.FacturaDB;

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
    private double montoPagado;
    private double vuelto;
    LinkedList<Pedido> listaPedidos = new LinkedList<Pedido>();
    LinkedList<DetPedido> listaDetalles = new LinkedList<DetPedido>();
    private Pedido pedidoFrame;

    public beanFactura() {
        pedidoFrame = new Pedido();
        montoPagado = 0;
    }

    //AQUÍ SE VA A INSERTAR EL PRODUCTO
    public void insertarFactura() throws SNMPExceptions, SQLException {
        if (montoPagado < total) {
            FacesMessage message = new FacesMessage("Estimado Usuario", "Debe pagar con un monto MAYOR al TOTAL A CANCELAR");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            Factura fac = new Factura(pedidoFrame.getUsuario().getId(), pedidoFrame.getId(), pedidoFrame.getDireccionEntrega(), "efectivo", iva, descuento, subTotal, total);
            if (FacturaDB.insertarFactura(fac)) {

                for (DetPedido detPed : getListaDetalles()) {
                    int idFactura = FacturaDB.ultimoIdInsertado();
                    FacturaDB.insertarDetalle(detPed, idFactura);
                }
                
                if (FacturaDB.facturado(pedidoFrame)) {
                    double cambio = montoPagado - total;
                    FacesMessage message = new FacesMessage("Estimado Cliente", "El pedido se facturó correctamente, su cambio es: " + cambio + "colones");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            } else {
                FacesMessage message = new FacesMessage("¡UPS!", "Ocurrió un error, no pudo registrarse la factura");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
    }

    public void insertarCXC() throws SNMPExceptions, SQLException {
        Factura fac = new Factura(pedidoFrame.getUsuario().getId(), pedidoFrame.getId(), pedidoFrame.getDireccionEntrega(), "efectivo", iva, descuento, subTotal, total);
        if (FacturaDB.insertarFactura(fac)) {
            for (DetPedido detPed : getListaDetalles()) {
                int idFactura = FacturaDB.ultimoIdInsertado();
                FacturaDB.insertarDetalle(detPed, idFactura);
            }
            if (FacturaDB.facturado(pedidoFrame) && FacturaDB.insertarCXC(fac)) {
                FacesMessage message = new FacesMessage("Estimado Cliente", "a Cuenta por Cobrar se generó correctamente");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesMessage message = new FacesMessage("¡UPS!", "Ocurrió un error, no se pudo generar la Cuenta por Cobrar");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return;
            }
        } else {
            FacesMessage message = new FacesMessage("¡UPS!", "Ocurrió un error, no se pudo generar la Cuenta por Cobrar");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void ayuda() {
        if (pedidoFrame.getId() != 0) {
            FacesMessage message = new FacesMessage("Estimado Usuario", "Ha seleccionado el pedido " + this.pedidoFrame.getId());
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage("Estimado Usuario", "Primero debe seleccionar un Pedido de la Lista");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public LinkedList<Pedido> getListaPedidos() throws SNMPExceptions, SQLException {
        PedidoDB pDB = new PedidoDB();
        return pDB.listaPedido();
    }

    public LinkedList<DetPedido> getListaDetalles() throws SNMPExceptions, SQLException {
        PedidoDB pDB = new PedidoDB();
        return pDB.listaDetalle(pedidoFrame);
    }

    public Pedido getPedidoFrame() {
        return pedidoFrame;
    }

    public void setPedidoFrame(Pedido pedidoFrame) {
        this.pedidoFrame = pedidoFrame;

        //AQUÍ LLENAMOS LOS MONTOS DE LA FACTURA, SE ACTUALIZAN AUTOMÁTICAMENTE DEPENDIENDO DEL PEDIDO QUE SE SELECCIONE
        subTotal = this.pedidoFrame.getMonto();
        descuento = subTotal * 0.10;
        iva = subTotal * 0.13;
        this.total = subTotal - descuento + iva;
       

        FacesMessage message = new FacesMessage("Estimado Cliente", "Ha seleccionado el pedido " + this.pedidoFrame.getId());
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }

    public void setListaDetalles(LinkedList<DetPedido> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public void setListaPedidos(LinkedList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
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

    public double getVuelto() {
        return vuelto;
    }

    public void setVuelto(double vuelto) {
        this.vuelto = vuelto;
    }
}
