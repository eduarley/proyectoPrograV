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
public class FacturaDB {

    public FacturaDB() {
        
    }
    
    
    
   
    public static boolean insertarDetalle(DetPedido detalle, int id) throws SNMPExceptions, SQLException{
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
    
    
    
    
    public static boolean insertarFactura(Factura fac) throws SNMPExceptions, SQLException{
        String strSQL = "";
        try {

            AccesoDatos acceso = new AccesoDatos();
                strSQL
                        = "INSERT INTO EncFactura(idUsuario,idPedido,direccion,tipoPago,subTotal,iva,descuento,total, estadoDespacho)"
                        + " VALUES ("
                        + "'" + fac.getUsuario().getId() + "','"
                        + "" + fac.getPedido().getId() + "','"
                        + "" + fac.getDireccion().getDireccion() + "','"
                        + "" + fac.getTipoPago() + "','"
                        + "" + fac.getSubTotal() + "','"
                        + "" + fac.getIva() + "','"
                        + "" + fac.getDescuento() + "','"
                        + "" + fac.getTotal() + "','"
                        + "" + "sin despachar" + "'); ";

                acceso.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
    
    
    public static boolean facturado(int id)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {

            AccesoDatos acceso = new AccesoDatos();

            strSQL
                    = "update Pedido set estado='" + "cancelado" + "' where id='" + id + "'";

            acceso.ejecutaSQL(strSQL);

            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

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
                    = "select max(id) as id from EncFactura ";

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
    
    
    
    
    public static boolean insertarCXC(Factura fac) throws SNMPExceptions, SQLException{
        String strSQL = "";
        try {

            AccesoDatos acceso = new AccesoDatos();
                strSQL
                        = "INSERT INTO CXC"
                        + " VALUES ("
                        + "'" + fac.getId() + "','"
                        + "" + fac.getUsuario().getId() + "'); ";

                acceso.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
    
    
    
    
    public static boolean actualizarACXC(Pedido p) throws SNMPExceptions, SQLException{
        String strSQL = "";
        try {

            AccesoDatos acceso = new AccesoDatos();
                strSQL
                        = "Update pedido set estado='CXC' where id='"+ p.getId()+"'";

                acceso.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
    
    
    
    public static LinkedList listaCreditoReporte() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Factura> lista = new LinkedList<Factura>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "select p.id, u.nombre, p.idPedido, p.direccion, p.tipoPago, p.subTotal, p.iva, p.descuento, p.total from EncFactura p, Usuario u where p.idUsuario=u.id and p.tipoPago='" + "credito" + "'";
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
    
    
    public static LinkedList listaContadoReporte() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Factura> lista = new LinkedList<Factura>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "select p.id, u.nombre, p.idPedido, p.direccion, p.tipoPago, p.subTotal, p.iva, p.descuento, p.total from EncFactura p, Usuario u where p.idUsuario=u.id and p.tipoPago='" + "contado" + "'";
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
    
  
}
