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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.DetPedido;
import model.Direccion;
import model.DireccionDB;
import model.Horario;
import model.HorarioDB;
import model.Pedido;
import model.PedidoDB;
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
    private Horario horario;
    private int idProducto, idDireccion, idHorario;
    private Producto productoTemp = new Producto();
    private LinkedList<SelectItem> comboProductos = new LinkedList();
    private LinkedList<SelectItem> comboDirecciones = new LinkedList();
    private LinkedList<SelectItem> comboHorarios = new LinkedList();

    private String fechaEntrega;
    private String horarioEntrega;
    private String direccionEntrega;

    private int cantidad;

    private ArrayList<DetPedido> arregloDetPedido = new ArrayList<DetPedido>();

    //private ArrayList<Integer> listaCantidad;
    public beanPedido() {
    }

    public void limpiarCombo() {

        this.arregloDetPedido.clear();
    }

    public void realizarPedido(Usuario us) throws SNMPExceptions, SQLException {

        //primero se debe insertar el pedido
        usuario = us;
        PedidoDB pDB = new PedidoDB();
        Pedido pedido = new Pedido(usuario, fechaEntrega, horarioEntrega, direccionEntrega, "");
        double monto = 0;

        //aqui convierto de linkedlist a arraylist
        ArrayList<Producto> arrayProductoTemp = new ArrayList<Producto>();
        for (Producto prod : listaProductos) {
            arrayProductoTemp.add(prod);

        }

        ///////////////////////////////////validaciones//////////////////////
        
        
        
//        for (Producto pr : arrayProductoTemp) {
//            if (pr.getDescripcion().equalsIgnoreCase("")) {
//                FacesMessage message = new FacesMessage("Error", "No se puede elegir la primera opcion.");
//                FacesContext.getCurrentInstance().addMessage(null, message);
//                return;
//            }
//        }

        if (arrayProductoTemp.isEmpty()) {
            FacesMessage message = new FacesMessage("Error", "No se ha seleccionado ningún producto.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return;
        }
        if (direccionEntrega.equalsIgnoreCase("0")) {
            FacesMessage message = new FacesMessage("Error", "No se ha seleccionado ninguna dirección.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return;
        }
        if (horarioEntrega.equalsIgnoreCase("0")) {
            FacesMessage message = new FacesMessage("Error", "No se ha seleccionado ningún horario.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return;
        }
        if (fechaEntrega.equalsIgnoreCase("")) {
            FacesMessage message = new FacesMessage("Error", "No se ha seleccionado ninguna fecha de entrega.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return;
        }
        ///////////////////////////////////fin validaciones//////////////////////////

        DetPedido detalle = null;

        if (pDB.insertarPedido(pedido)) {
            pedido.setId(pDB.ultimoIdInsertado());
            for (Producto producto : arrayProductoTemp) {
                detalle = new DetPedido();
                detalle.setProducto(producto);
                detalle.setIdPedido(pedido.getId());

                detalle.setCantidad(1);
                detalle.setMonto(producto.getPrecio() * 1);
                this.arregloDetPedido.add(detalle);

            }
        } else {
            return;
        }

        for (DetPedido detPed : arregloDetPedido) {
            pedido.agregarDetalle(detPed);
            pedido.setMonto(pedido.getMonto() + detPed.getMonto());
            //pDB.actualizarMontoPedido(pedido);  //hace un update al monto de la factura

        }

        //pDB.actualizarMontoPedido(pedido);  //hace un update al monto de la factura
        if (pDB.InsertarDetallePedido(pedido)) {

            FacesMessage message = new FacesMessage("Éxito", "El pedido se ha registrado con éxito!.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            this.arregloDetPedido.clear();
            //this.listaProductos.clear();
        } else {
            FacesMessage message = new FacesMessage("Error", "Hubo un error al guardar el pedido.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void ayuda() {
        FacesMessage message = new FacesMessage("Ayuda", "En esta página podrá insertar, modificar, eliminar y consultar pedidos");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void verDetalle() throws SNMPExceptions, SQLException {
        productoTemp = ProductoDB.consultarProducto(idProducto);
    }

    public void agregarProducto() throws SNMPExceptions, SQLException {

        productoTemp = ProductoDB.consultarProducto(idProducto);
        listaProductos.add(productoTemp);
    }

    //
    public LinkedList<SelectItem> getComboProductos() throws SNMPExceptions, SQLException {
        String descripcion = "";
        int id = 0;

        LinkedList<Producto> lista = new LinkedList<Producto>();
        ProductoDB pDB = new ProductoDB();

        lista = pDB.listaObjetosProductos();

        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0, "Seleccione un Producto"));

        for (Iterator iter = lista.iterator();
                iter.hasNext();) {

            Producto pro = (Producto) iter.next();
            id = pro.getId();
            descripcion = pro.getDescripcion();
//            resultList.add(new SelectItem(id,descripcion + ", ¢" + pro.getPrecio()));
            resultList.add(new SelectItem(id, descripcion));

        }
        return resultList;
    }

    public LinkedList<SelectItem> getComboDirecciones(int idUsuario) throws SNMPExceptions, SQLException {
        String direccion = "";
        int id = 0;

        LinkedList<Direccion> lista = new LinkedList<Direccion>();
        DireccionDB dirDB = new DireccionDB();

        lista = dirDB.listaDirecciones(idUsuario);

        LinkedList<SelectItem> resultList = new LinkedList<SelectItem>();
        resultList.add(new SelectItem(0, "Seleccione una Dirección"));

        for (Iterator iter = lista.iterator();
                iter.hasNext();) {

            Direccion dir = (Direccion) iter.next();
            id = dir.getId();
            direccion = dir.getDireccion();
            resultList.add(new SelectItem(direccion, direccion));
        }
        return resultList;
    }

    public LinkedList<SelectItem> getComboHorarios(int idUsuario) throws SNMPExceptions, SQLException {
        String horaInicio, horaFin;
        int id = 0;

        LinkedList<Horario> lista = new LinkedList<Horario>();
        HorarioDB horDB = new HorarioDB();

        lista = horDB.listaHorarios(idUsuario);

        LinkedList<SelectItem> resultList = new LinkedList<SelectItem>();
        resultList.add(new SelectItem(0, "Seleccione una Horario"));

        for (Iterator iter = lista.iterator();
                iter.hasNext();) {

            Horario hor = (Horario) iter.next();
            id = hor.getId();
            horaInicio = hor.getHoraInicio();
            horaFin = hor.getHoraFin();
            resultList.add(new SelectItem("De: " + horaInicio + " Hasta: " + horaFin, horaInicio + " --> " + horaFin));
        }
        return resultList;
    }

    public void setComboHorarios(LinkedList<SelectItem> comboHorarios) {
        this.comboHorarios = comboHorarios;
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

    public double subtotal() {
        double monto = 0;

        for (Producto p : listaProductos) {
            monto += p.getPrecio() * 1;
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

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getHorarioEntrega() {
        return horarioEntrega;
    }

    public void setHorarioEntrega(String horarioEntrega) {
        this.horarioEntrega = horarioEntrega;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public int getCantidad() {
        return 1;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

//    public ArrayList<Integer> getListaCantidad() {
//        return listaCantidad;
//    }
//
//    public void setListaCantidad(ArrayList<Integer> listaCantidad) {
//        this.listaCantidad = listaCantidad;
//    }
//
//    
//    
    public ArrayList<DetPedido> getArregloDetPedido() {
        return arregloDetPedido;
    }

    public void setArregloDetPedido(ArrayList<DetPedido> arregloDetPedido) {
        this.arregloDetPedido = arregloDetPedido;
    }
}
