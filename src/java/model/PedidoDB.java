/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.AccesoDatos;
import DAO.SNMPExceptions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author march
 */
public class PedidoDB {

    public int ultimoIdInsertado() throws SNMPExceptions, SQLException {
        String select = "";
        int id = 0;

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "select max(id) as id from pedido ";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                Producto pro = new Producto();

                id = rsPA.getInt("id");

            }

            rsPA.close(); // cierra conexion
            return id;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }

    }

    public boolean insertarPedido(Pedido pedido)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {

            //InsertarDetallePedido(pedido);
            AccesoDatos acceso = new AccesoDatos();

            strSQL
                    = "INSERT INTO PEDIDO(idUsuario,fechaEntrega,horarioEntrega,direccionEntrega,monto,estado)"
                    + "VALUES ("
                    + "'" + pedido.getUsuario().getId() + "','"
                    + "" + pedido.getFechaEntrega() + "','"
                    + "" + pedido.getHorarioEntrega() + "','"
                    + "" + pedido.getDireccionEntrega() + "','"
                    + "" + pedido.getMonto() + "','"
                    + "pendiente')";

            //Se ejecuta la sentencia SQL
            acceso.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }

    public boolean InsertarDetallePedido(Pedido p)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        /*
        ArrayList<DetPedido> listaSinRepetidos = new ArrayList<DetPedido>();

        Map<Integer, DetPedido> mapDetalle = new HashMap<Integer, DetPedido>(p.getArregloDetPedido().size());

        for (DetPedido d : p.getArregloDetPedido()) {
            mapDetalle.put(d.getIdPedido(), d);
            
            
        }
        
        //creo una lista que no tiene repetidos
        for (Entry<Integer, DetPedido> d : mapDetalle.entrySet()) {
            listaSinRepetidos.add(d.getValue());
            System.out.println(d.getValue());
        }
         */
        try {

            AccesoDatos acceso = new AccesoDatos();

            for (DetPedido detalle : p.getArregloDetPedido()) {
                strSQL
                        = "INSERT INTO DetPedido"
                        + " VALUES ("
                        + "'" + p.getId() + "','"
                        + "" + detalle.getProducto().getId() + "','"
                        + "" + 1 + "','" //esta era la cantidad
                        + "" + detalle.getMonto() + "'); ";

                acceso.ejecutaSQL(strSQL);
            }
            actualizarMontoPedido(p);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }

    }

    public boolean actualizarMontoPedido(Pedido p)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {

            AccesoDatos acceso = new AccesoDatos();

            strSQL
                    = "update pedido set monto='" + p.getMonto() + "' where id='" + p.getId() + "'";

            acceso.ejecutaSQL(strSQL);

            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }

    public LinkedList listaPedido() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Pedido> lista = new LinkedList<Pedido>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "select p.id, p.idUsuario, u.nombre, p.fechaEntrega, p.horarioEntrega, p.direccionEntrega, p.monto, p.estado from Pedido p, Usuario u where idUsuario=u.id and p.estado='" + "pendiente" + "'or p.estado='cxc' ";
                    //"select p.id, p.idUsuario, u.nombre, p.fechaEntrega, p.horarioEntrega, p.direccionEntrega, p.monto, p.estado from Pedido p, Usuario u where idUsuario=u.id";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                Pedido ped = new Pedido();

                ped.setId(rsPA.getInt("id"));
                ped.getUsuario().setId(rsPA.getInt("idUsuario"));
                ped.getUsuario().setNombre(rsPA.getString("nombre"));
       //         ped.getUsuario().setNombre(UsuarioDB.seleccionarNombre(ped.getUsuario().getId()));
                
                ped.setFechaEntrega(rsPA.getString("fechaEntrega"));
                ped.setHorarioEntrega(rsPA.getString("horarioEntrega"));
                ped.setDireccionEntrega(rsPA.getString("direccionEntrega"));
                ped.setMonto(rsPA.getDouble("monto"));
                ped.setEstado(rsPA.getString("estado"));

                lista.add(ped);

            }

            rsPA.close(); // cierra conexion
            return lista;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }

    }
    
    
    
    
    public LinkedList listaPedidosFacturados() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Pedido> lista = new LinkedList<Pedido>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "select p.id, p.idUsuario, u.nombre, p.fechaEntrega, p.horarioEntrega, p.direccionEntrega, p.monto, p.estado from Pedido p, Usuario u where p.estado='" + "cancelado" + "' and idUsuario=u.id";
                    //"select p.id, p.idUsuario, u.nombre, p.fechaEntrega, p.horarioEntrega, p.direccionEntrega, p.monto, p.estado from Pedido p, Usuario u where idUsuario=u.id";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                Pedido ped = new Pedido();

                ped.setId(rsPA.getInt("id"));
                ped.getUsuario().setId(rsPA.getInt("idUsuario"));
                ped.getUsuario().setNombre(rsPA.getString("nombre"));
       //         ped.getUsuario().setNombre(UsuarioDB.seleccionarNombre(ped.getUsuario().getId()));
                
                ped.setFechaEntrega(rsPA.getString("fechaEntrega"));
                ped.setHorarioEntrega(rsPA.getString("horarioEntrega"));
                ped.setDireccionEntrega(rsPA.getString("direccionEntrega"));
                ped.setMonto(rsPA.getDouble("monto"));
                ped.setEstado(rsPA.getString("estado"));

                lista.add(ped);

            }

            rsPA.close(); // cierra conexion
            return lista;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }

    }
        
        
        
    public ArrayList<DetPedido> listaDetallePedidoPorPedido(Pedido pedido) 
            throws SNMPExceptions, SQLException {
        String select = "";
        ArrayList<DetPedido> lista = new ArrayList<DetPedido>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = //"select id, idUsuario.nombre as [usuario], fechaEntrega, horarioEntrega, direccionEntrega, monto, estado from Pedido";
                    "select * from DetPedido where idPedido='"+pedido.getId()+"'";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            
            ProductoDB pDB= new ProductoDB();
            
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {
                
               DetPedido detalle = new DetPedido();
               Producto prod= pDB.consultarProducto(rsPA.getInt("idProducto"));
               
               detalle.setCantidad(rsPA.getInt("cantidad"));
               detalle.setIdPedido(rsPA.getInt("idPedido"));
               detalle.setProducto(prod);
               detalle.setMonto(rsPA.getDouble("precio"));
               
                lista.add(detalle);

            }

            rsPA.close(); // cierra conexion
            return lista;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }

    }
        
    
    
    public LinkedList<DetPedido> listaDetallePedidoPorPedidoLinkedList(Pedido pedido) 
            throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<DetPedido> lista = new LinkedList<DetPedido>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = //"select id, idUsuario.nombre as [usuario], fechaEntrega, horarioEntrega, direccionEntrega, monto, estado from Pedido";
                    "select * from DetPedido where idPedido='"+pedido.getId()+"'";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            
            ProductoDB pDB= new ProductoDB();
            
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {
                
               DetPedido detalle = new DetPedido();
               Producto prod= pDB.consultarProducto(rsPA.getInt("idProducto"));
               
               detalle.setCantidad(rsPA.getInt("cantidad"));
               detalle.setIdPedido(rsPA.getInt("idPedido"));
               detalle.setProducto(prod);
               detalle.setMonto(rsPA.getDouble("precio"));
               
                lista.add(detalle);

            }

            rsPA.close(); // cierra conexion
            return lista;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }

    }
    
    


    public LinkedList listaDetalle(Pedido pedido) throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<DetPedido> lista = new LinkedList<DetPedido>();
        
        
        ArrayList<DetPedido> detalles= listaDetallePedidoPorPedido(pedido);
        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = //"select id, idUsuario.nombre as [usuario], fechaEntrega, horarioEntrega, direccionEntrega, monto, estado from Pedido";
                    // "select idPedido, idProducto, cantidad, precio from DetPedido where idPedido='" + pedido.getId() + "'";
                    "select d.idPedido, d.idProducto, p.descripcion, d.cantidad, d.precio from DetPedido d,producto p where idPedido ='" + pedido.getId() + "' and idProducto=id";
//            for (DetPedido detPedido : detalles) {
//                select += "and idProducto='" + detPedido.getProducto().getId() + "'";
//            }
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                DetPedido det = new DetPedido();

                det.setIdPedido(rsPA.getInt("idPedido"));
                det.getProducto().setDescripcion(rsPA.getString("descripcion"));
                det.getProducto().setId(rsPA.getInt("idProducto"));
                det.setCantidad(rsPA.getInt("cantidad"));
                det.setMonto(rsPA.getInt("precio"));

                lista.add(det);

            }

            rsPA.close(); // cierra conexion
            return lista;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }

    }
}
