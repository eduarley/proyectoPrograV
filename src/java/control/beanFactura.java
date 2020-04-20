/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.SNMPExceptions;
import java.io.IOException;
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
    LinkedList<Pedido> listaPedidosFacturados = new LinkedList<Pedido>();
    LinkedList<DetPedido> listaDetallePedido = new LinkedList<DetPedido>();
    LinkedList<DetPedido> listaCXC = new LinkedList<DetPedido>();
    private Pedido pedidoFrame;

    LinkedList<DetPedido> listaResultadoPedido = new LinkedList<DetPedido>(); //esta muestra los detalles del pedido en la pagina consultarDetalle.xhtml

    public beanFactura() {
        pedidoFrame = new Pedido();
        montoPagado = 0;
    }

    public void mostrarDetalleFactura(Pedido pedido) throws SNMPExceptions, SQLException, IOException {
        PedidoDB pDB = new PedidoDB();
        
        listaDetallePedido.clear();
        //this.setListaDetalles(pDB.listaDetallePedidoPorPedidoLinkedList(pedido));
        this.setListaResultadoPedido(pDB.listaDetallePedidoPorPedidoLinkedList(pedido));
        this.setPedidoFrame(pedido);
        FacesContext.getCurrentInstance().getExternalContext().redirect("facturarDetalle.xhtml");

    }

    //AQUÍ SE VA A INSERTAR LA FACTURA
    public void insertarFactura() throws SNMPExceptions, SQLException, IOException {
        if (pedidoFrame != null) {
            if (montoPagado < total) {
                FacesMessage message = new FacesMessage("Estimado Usuario", "Debe pagar con un monto MAYOR al TOTAL A CANCELAR");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                String pago="";
                if(pedidoFrame.getEstado().equalsIgnoreCase("pendiente")){
                    pago="contado";
                }else{
                    pago="credito";
                }
                Factura fac = new Factura(pedidoFrame.getUsuario().getId(), pedidoFrame.getId(), pedidoFrame.getDireccionEntrega(), pago, iva, descuento, subTotal, total);
                if (FacturaDB.insertarFactura(fac)) {

                    
                    int idFactura = FacturaDB.ultimoIdInsertado();
                    fac.setId(idFactura);
                    for (DetPedido detPed : getListaDetalles()) {                       
                        FacturaDB.insertarDetalle(detPed, idFactura);
                    }

                    if (FacturaDB.facturado(pedidoFrame.getId())) {
                        double cambio = montoPagado - total;
                        limpiar();
                        FacesMessage message = new FacesMessage("Estimado Cliente", "El pedido se facturó correctamente, su cambio es: " + cambio + "colones");
                        FacesContext.getCurrentInstance().addMessage(null, message);
                       // FacesContext.getCurrentInstance().getExternalContext().redirect("facturar.xhtml");
                    }
                } else {
                    FacesMessage message = new FacesMessage("¡UPS!", "Ocurrió un error, no pudo registrarse la factura");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            }
        }
    }

    
    public void insertarCXC() throws SNMPExceptions, SQLException {
        if (pedidoFrame != null) {
            Factura fac = new Factura(pedidoFrame.getUsuario().getId(), pedidoFrame.getId(), pedidoFrame.getDireccionEntrega(), "efectivo", iva, descuento, subTotal, total);
            if (FacturaDB.insertarFactura(fac)) {
                
                
                int idFactura = FacturaDB.ultimoIdInsertado();
                fac.setId(idFactura);
                for (DetPedido detPed : getListaDetalles()) {
                    
                    FacturaDB.insertarDetalle(detPed, idFactura);
                }
                if (FacturaDB.facturado(fac.getId()) && FacturaDB.insertarCXC(fac) && FacturaDB.actualizarACXC(pedidoFrame)) {
                    limpiar();
                    
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

    }

    public void limpiar() {
        pedidoFrame = null;
        descuento = 0;
        subTotal = 0;
        total = 0;
        iva = 0;
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

    public LinkedList<Pedido> getListaPedidosFacturados() throws SNMPExceptions, SQLException {
        PedidoDB pDB = new PedidoDB();
        return pDB.listaPedidosFacturados();
    }

    public void setListaPedidosFacturados(LinkedList<Pedido> listaPedidosFacturados) {
        this.listaPedidosFacturados = listaPedidosFacturados;
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
        this.listaDetallePedido = listaDetalles;
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

    public LinkedList<DetPedido> getListaDetallePedido() {
        return listaDetallePedido;
    }

    public void setListaDetallePedido(LinkedList<DetPedido> listaDetallePedido) {
        this.listaDetallePedido = listaDetallePedido;
    }

    public LinkedList<DetPedido> getListaResultadoPedido() {
        return listaResultadoPedido;
    }

    public void setListaResultadoPedido(LinkedList<DetPedido> listaResultadoPedido) {
        this.listaResultadoPedido = listaResultadoPedido;
    }

    public LinkedList<DetPedido> getListaCXC() throws SNMPExceptions, SQLException {
        PedidoDB pDB = new PedidoDB();
        return pDB.listaPedidosFacturados();
        
    }

    public void setListaCXC(LinkedList<DetPedido> listaCXC) {
        this.listaCXC = listaCXC;
    }
    
    
}
