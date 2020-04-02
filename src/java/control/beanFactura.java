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
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.model.SelectItem;
import model.Direccion;
import model.Pedido;
import model.Producto;
import model.ProductoDB;
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
    private LinkedList<Producto> listaProductos = new LinkedList<Producto>();
    private String id, tipoPago, iva, descuento, total;
    private Usuario usuario;
    private Pedido pedido;
    private Direccion direccion;
    private Producto productoTemp;
    private LinkedList<SelectItem> comboProductos = new LinkedList();
    
    
    public beanFactura() {
    }
    
    public void agregarProducto(){
        listaProductos.add(productoTemp);
    }

    public LinkedList<SelectItem> getComboProductos() throws SNMPExceptions, SQLException {
        String descripcion="";
        int id=0;
        
        LinkedList<Producto> lista= new LinkedList<Producto>();
        ProductoDB pDB= new ProductoDB();
        
        lista=pDB.listaObjetosProductos();
        
        LinkedList resultList= new LinkedList();
        //resultList.add(new SelectItem(0,"Seleccione Producto"));
        
        for(Iterator iter= lista.iterator();
                iter.hasNext();){
            
            Producto pro= (Producto)iter.next();
            id=pro.getId();
            descripcion=pro.getDescripcion();
            resultList.add(new SelectItem(id,descripcion));
            
        }
        return resultList;
    }

    public void setComboProductos(LinkedList<SelectItem> comboProductos) {
        this.comboProductos = comboProductos;
    }

    public LinkedList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(LinkedList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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

    public Producto getProductoTemp() {
        return productoTemp;
    }

    public void setProductoTemp(Producto productoTemp) {
        this.productoTemp = productoTemp;
    }
}
