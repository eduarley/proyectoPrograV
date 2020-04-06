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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.Direccion;
import model.DireccionDB;
import model.Producto;
import model.ProductoDB;
import model.Usuario;

/**
 *
 * @author march
 */
@Named(value = "beanPedido")
@SessionScoped
public class beanPedido implements Serializable {

    /**
     * Creates a new instance of beanPedido
     */
    private LinkedList<Producto> listaProductos = new LinkedList<Producto>();
    private String id, tipoPago, iva, descuento, total;
    private Usuario usuario;
    private Direccion direccion;
    private int idProducto;
    private Producto productoTemp= new Producto();
    private LinkedList<SelectItem> comboProductos = new LinkedList();
    private LinkedList<SelectItem> comboDirecciones = new LinkedList();
    
    
    public beanPedido() {
    }
    
    public void ayuda() {
        FacesMessage message = new FacesMessage("Ayuda", "En esta página podrá insertar, modificar, eliminar y consultar pedidos");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void verDetalle() throws SNMPExceptions, SQLException{
        productoTemp= ProductoDB.consultarProducto(idProducto);
    }
    
    public void agregarProducto() throws SNMPExceptions, SQLException{
        productoTemp= ProductoDB.consultarProducto(idProducto);
        listaProductos.add(productoTemp);
    }
    
    //
    public LinkedList<SelectItem> getComboProductos() throws SNMPExceptions, SQLException {
        String descripcion="";
        int id=0;
        
        LinkedList<Producto> lista= new LinkedList<Producto>();
        ProductoDB pDB= new ProductoDB();
        
        lista=pDB.listaObjetosProductos();
        
        LinkedList resultList= new LinkedList();
        resultList.add(new SelectItem(0,"Seleccione un Producto"));
        
        for(Iterator iter= lista.iterator();
                iter.hasNext();){
            
            Producto pro= (Producto)iter.next();
            id=pro.getId();
            descripcion=pro.getDescripcion();
//            resultList.add(new SelectItem(id,descripcion + ", ¢" + pro.getPrecio()));
             resultList.add(new SelectItem(id,descripcion));
            
        }
        return resultList;
    }

    public LinkedList<SelectItem> getComboDirecciones(int idUsuario) throws SNMPExceptions, SQLException {
        String direccion="";
        int id=0;
        
        LinkedList<Direccion> lista= new LinkedList<Direccion>();
        DireccionDB dirDB= new DireccionDB();
        
        lista=dirDB.listaDirecciones(idUsuario);
        
        LinkedList resultList= new LinkedList();
        resultList.add(new SelectItem(0,"Seleccione una Dirección"));
        
        for(Iterator iter= lista.iterator();
                iter.hasNext();){
            
            Direccion dir= (Direccion)iter.next();
            id=dir.getId();
            direccion=dir.getDireccion();
            resultList.add(new SelectItem(id,direccion));
        }
        return resultList;
    }

    public void setComboDirecciones(LinkedList<SelectItem> comboDirecciones) {
        this.comboDirecciones = comboDirecciones;
    }
    
    public void removerProductoDeLista(Producto prod) throws SNMPExceptions, SQLException {
        try {
            listaProductos.remove(prod);
            //getComboProductos();
            FacesMessage message = new FacesMessage("Exito", "Eliminado con éxito");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Error", "Hubo un error");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
   }
    
    public double subtotal(){
        double monto=0;
        for (Producto p : listaProductos) {
            monto+=p.getPrecio();
        }
        return monto;
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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
