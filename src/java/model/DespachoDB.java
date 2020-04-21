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
import java.util.LinkedList;

/**
 *
 * @author march
 */
public class DespachoDB {

    public DespachoDB() {
    }
    
    public static boolean insertarDetalleDespacho(DetPedido detalle, int id) throws SNMPExceptions, SQLException{
        String strSQL = "";
        try {

            AccesoDatos acceso = new AccesoDatos();
                strSQL
                        = "INSERT INTO DetDespacho"
                        + " VALUES ("
                        + "'" + id + "','"
                        + "" + detalle.getProducto().getId() + "','"
                        + "" + detalle.getCantidad() + "','"
                        + "" + detalle.getMonto() + "'); ";

                acceso.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
    
    public static boolean insertarDespacho(Despacho desp)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {

            //InsertarDetallePedido(pedido);
            AccesoDatos acceso = new AccesoDatos();

            strSQL
                    = "INSERT INTO Despacho(idEncFactura,fechaEnvio,medio,estado)"
                    + "VALUES ("
                    + "'" + desp.getIdFactura() + "','"
                    + "" + desp.getFechaEnvio() + "','"
                    + "" + desp.getMedio() + "','"
                    + "" + 1 + "')";

            //Se ejecuta la sentencia SQL
            
            String prueba = strSQL;
            acceso.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
    
    public static boolean actualizarEstadoDespacho(int id)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {

            AccesoDatos acceso = new AccesoDatos();

            strSQL
                    = "update EncFactura set estadoDespacho='" + "despachado" + "' where id='" + id + "'";

            
             String prueba = strSQL;
            acceso.ejecutaSQL(strSQL);

            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
    
    
    public static LinkedList listaSinDespachar() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Factura> lista = new LinkedList<Factura>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "select p.id, u.nombre, p.idPedido, p.direccion, p.tipoPago, p.subTotal, p.iva, p.descuento, p.total, p.estadoDespacho from EncFactura p, Usuario u where p.idUsuario=u.id and p.estadoDespacho='" + "sin despachar" + "'";
                    //"select p.id, p.idUsuario, u.nombre, p.fechaEntrega, p.horarioEntrega, p.direccionEntrega, p.monto, p.estado from Pedido p, Usuario u where idUsuario=u.id";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                Factura fac = new Factura();

                fac.setId(rsPA.getInt("id"));
                fac.getUsuario().setNombre(rsPA.getString("nombre"));
       //         ped.getUsuario().setNombre(UsuarioDB.seleccionarNombre(ped.getUsuario().getId()));
                
                fac.getPedido().setId(rsPA.getInt("idPedido"));
                fac.getDireccion().setDireccion(rsPA.getString("direccion"));
                fac.setTipoPago(rsPA.getString("tipoPago"));
                fac.setSubTotal(rsPA.getDouble("subTotal"));
                fac.setIva(rsPA.getDouble("iva"));
                fac.setDescuento(rsPA.getDouble("descuento"));
                fac.setTotal(rsPA.getDouble("total"));
                fac.setEstadoDespacho(rsPA.getString("estadoDespacho"));

                lista.add(fac);

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
    
    
    public static LinkedList listaDespachados() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Factura> lista = new LinkedList<Factura>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "select p.id, u.nombre, p.idPedido, p.direccion, p.tipoPago, p.subTotal, p.iva, p.descuento, p.total, p.estadoDespacho from EncFactura p, Usuario u where p.idUsuario=u.id and p.estadoDespacho='" + "despachado" + "'";
                    //"select p.id, p.idUsuario, u.nombre, p.fechaEntrega, p.horarioEntrega, p.direccionEntrega, p.monto, p.estado from Pedido p, Usuario u where idUsuario=u.id";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                Factura fac = new Factura();

                fac.setId(rsPA.getInt("id"));
                fac.getUsuario().setNombre(rsPA.getString("nombre"));
       //         ped.getUsuario().setNombre(UsuarioDB.seleccionarNombre(ped.getUsuario().getId()));
                
                fac.getPedido().setId(rsPA.getInt("idPedido"));
                fac.getDireccion().setDireccion(rsPA.getString("direccion"));
                fac.setTipoPago(rsPA.getString("tipoPago"));
                fac.setSubTotal(rsPA.getDouble("subTotal"));
                fac.setIva(rsPA.getDouble("iva"));
                fac.setDescuento(rsPA.getDouble("descuento"));
                fac.setTotal(rsPA.getDouble("total"));
                fac.setEstadoDespacho(rsPA.getString("estadoDespacho"));

                lista.add(fac);

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
    
    
    public static int ultimoIdInsertado() throws SNMPExceptions, SQLException {
        String select = "";
        int id = 0;

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "select max(id) as id from Despacho ";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
 
            
             while (rsPA.next()) {

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
    
}
