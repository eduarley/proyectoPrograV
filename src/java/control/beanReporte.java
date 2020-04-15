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
import model.Factura;
import model.FacturaDB;
import model.Pedido;
import model.PedidoDB;

/**
 *
 * @author march
 */
@Named(value = "beanReporte")
@SessionScoped
public class beanReporte implements Serializable {
    
    
    LinkedList<Pedido> listaPedidosRealizados = new LinkedList<Pedido>();
    LinkedList<Factura> listaVentasContado = new LinkedList<Factura>();
    LinkedList<Factura> listaVentasCredito = new LinkedList<Factura>();
    /**
     * Creates a new instance of beanReporte
     */
    public beanReporte() {
    }

    public LinkedList<Factura> getListaVentasContado() throws SNMPExceptions, SQLException {
        return FacturaDB.listaContadoReporte();
    }

    public void setListaVentasContado(LinkedList<Factura> listaVentasContado) {
        this.listaVentasContado = listaVentasContado;
    }

    public LinkedList<Factura> getListaVentasCredito() throws SNMPExceptions, SQLException {
        return FacturaDB.listaCreditoReporte();
    }

    public void setListaVentasCredito(LinkedList<Factura> listaVentasCredito) {
        this.listaVentasCredito = listaVentasCredito;
    }

    public LinkedList<Pedido> getListaPedidosRealizados() throws SNMPExceptions, SQLException {
        return PedidoDB.listaPedidosReporte();
    }

    public void setListaPedidosRealizados(LinkedList<Pedido> listaPedidosRealizados) {
        this.listaPedidosRealizados = listaPedidosRealizados;
    }
}
