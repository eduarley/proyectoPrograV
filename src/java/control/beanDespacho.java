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
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Despacho;
import model.DespachoDB;
import model.DetPedido;
import model.Factura;
import model.FacturaDB;
import model.Pedido;
import model.PedidoDB;

/**
 *
 * @author march
 */
@Named(value = "beanDespacho")
@SessionScoped
public class beanDespacho implements Serializable {

    /**
     * Creates a new instance of beanDespacho
     */
    LinkedList<Factura> listaSinDespachar = new LinkedList<Factura>();
    LinkedList<Factura> listaDespachado = new LinkedList<Factura>();
    LinkedList<DetPedido> listaDetalles = new LinkedList<DetPedido>();
    private Factura facturaFrame;
    private String fechaEnvio;
    private String medio;

    public beanDespacho() {
        facturaFrame = new Factura();
    }

    /*
    //AQUÍ SE VA A INSERTAR EL DESPACHO   ------ NOTA: EL MÉTODO TIENE ERRORES PORQUE ESTABA MODIFICÁNDOLO CUANDO EMPEZÓ LA RAYERÍA
    public void insertarFactura() throws SNMPExceptions, SQLException, IOException {
        Despacho des = new Despacho(facturaFrame.getId(), fechaEnvio, medio, 1);
        if (DespachoDB.insertarDespacho(des)) {

            int idDespacho = DespachoDB.ultimoIdInsertado();
            des.setId(idDespacho);
            for (DetPedido detPed : getListaDetalles()) {
                DespachoDB.insertarDetalleDespacho(detPed, idDespacho);
            }

            if (DespachoDB.actualizarEstadoDespacho(facturaFrame.getId())) {
                limpiar();
                FacesMessage message = new FacesMessage("Estimado Usuario", "La factura se despachó correctamente");
                FacesContext.getCurrentInstance().addMessage(null, message);
                // FacesContext.getCurrentInstance().getExternalContext().redirect("facturar.xhtml");
            }
        } else {
            FacesMessage message = new FacesMessage("¡UPS!", "Ocurrió un error, no pudo registrarse el despacho");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
     */
    public void insertarDespacho() throws SNMPExceptions, SQLException {
        Despacho des = new Despacho();
        des.setIdFactura(facturaFrame.getId());
        des.setFechaEnvio(fechaEnvio);
        des.setMedio(medio);
        des.setEstado("Despachado");

        if (des.getMedio()==null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Estimado Usuario", "Debe seleccionar un medio de envio"));
            return;
        }
        
        
        
         if (des.getFechaEnvio().equalsIgnoreCase("") ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Estimado Usuario", "Debe completar la fecha con el formato dd/MM/yyyy"));
            return;
        }

        if (DespachoDB.insertarDespacho(des)) {
            int idDespacho = DespachoDB.ultimoIdInsertado();
            des.setId(idDespacho);
            for (DetPedido detPed : getListaDetalles()) {
                DespachoDB.insertarDetalleDespacho(detPed, idDespacho);
            }

            if (DespachoDB.actualizarEstadoDespacho(facturaFrame.getId())) {
                limpiar();
                FacesMessage message = new FacesMessage("Estimado Usuario", "La factura se despachó correctamente");
                FacesContext.getCurrentInstance().addMessage(null, message);

            }

        } else {
            FacesMessage message = new FacesMessage("¡UPS!", "Ocurrió un error, no pudo registrarse el despacho");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void mostrarDetalleDespacho(Factura f) throws IOException {
        this.facturaFrame = f;
        FacesContext.getCurrentInstance().getExternalContext().redirect("despachoDetalle.xhtml");
    }
//    

    public void limpiar() {
        facturaFrame = null;
        fechaEnvio = "";
        medio = "";
    }

    public LinkedList<Factura> getListaSinDespachar() throws SNMPExceptions, SQLException {
        return DespachoDB.listaSinDespachar();
    }

    public void setListaSinDespachar(LinkedList<Factura> listaSinDespachar) {
        this.listaSinDespachar = listaSinDespachar;
    }

    public LinkedList<Factura> getListaDespachado() throws SNMPExceptions, SQLException {
        return DespachoDB.listaDespachados();
    }

    public void setListaDespachado(LinkedList<Factura> listaDespachado) {
        this.listaDespachado = listaDespachado;
    }

    public LinkedList<DetPedido> getListaDetalles() throws SNMPExceptions, SQLException {
        PedidoDB pDB = new PedidoDB();
        return pDB.listaDetalle(facturaFrame.getPedido());
    }

    public void setListaDetalles(LinkedList<DetPedido> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public Factura getFacturaFrame() {
        return facturaFrame;
    }

    public void setFacturaFrame(Factura facturaFrame) {
        this.facturaFrame = facturaFrame;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

}
