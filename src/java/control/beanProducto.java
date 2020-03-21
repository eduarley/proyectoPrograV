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
import javax.faces.model.SelectItem;
import model.Producto;
import model.ProductoDB;

/**
 *
 * @author march
 */
@Named(value = "beanProducto")
@SessionScoped
public class beanProducto implements Serializable {

    /**
     * Creates a new instance of beanProducto
     */
    LinkedList<Producto> listaProductos = new LinkedList<Producto>();

    private String id, descripcion, precio, existencias, tipo;
    private byte[] imagen;

    private String mensaje = "";

    public beanProducto() {
    }

    public String insertarProducto() throws SNMPExceptions, SQLException {
        Producto producto = new Producto(this.descripcion, this.imagen, Double.valueOf(this.precio), Integer.parseInt(this.existencias), this.tipo);
        ProductoDB pDB = new ProductoDB();

        if (pDB.InsertarProducto(producto)) {
            mensaje = "Se ha guargado exitosamente!";
        } else {
            mensaje = "Se ha producido un error al guardar!";
        }

        return mensaje;

    }

    public String eliminarProducto(Producto pro) throws SNMPExceptions, SQLException {

        ProductoDB pDB = new ProductoDB();

        if (pDB.eliminarProducto(pro)) {
            mensaje = "Se ha desactivado exitosamente!";
        } else {
            mensaje = "Se ha producido un error al desactivar!";
        }

        return mensaje;

    }

    public LinkedList<Producto> getListaProductos() throws SNMPExceptions, SQLException {
        ProductoDB pDB = new ProductoDB();
        return pDB.listaObjetosProductos();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getExistencias() {
        return existencias;
    }

    public void setExistencias(String existencias) {
        this.existencias = existencias;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
