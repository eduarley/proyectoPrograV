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
import java.util.LinkedList;

/**
 *
 * @author march
 */
public class PedidoDB {
    
    
    
    
       public int ultimoIdInsertado()throws SNMPExceptions, SQLException{
        String select = "";
        int id=0;
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "select max(id) as id from pedido ";
              
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
              
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                Producto pro = new Producto();
                
                 id=rsPA.getInt("id");
                
                
                
                
              }
              
              rsPA.close(); // cierra conexion
              return id;
              
          } catch (SQLException e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage(), e.getErrorCode());
          }catch (Exception e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage());
          } finally {
              
          }
          
    }
    
    
    public boolean insertarPedido(Pedido pedido)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {
            
            
            AccesoDatos acceso= new AccesoDatos();

            strSQL
                    = "INSERT INTO PEDIDO(idUsuario,fechaEntrega,horarioEntrega,direccionEntrega,monto,estado)"
                    + "VALUES ("
                    + "'"+pedido.getUsuario().getId()+"','"
                    + ""+pedido.getFechaEntrega()+"','"
                    + ""+pedido.getHorarioEntrega()+"','"
                    + ""+pedido.getDireccionEntrega()+"','"
                    + ""+pedido.getMonto()+"','"
                  
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
    
    /*
    
    public boolean InsertarDetallePedido(Pedido pedido, ArrayList<Producto> listaProductos, int cantidad)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {
            
            
            AccesoDatos acceso= new AccesoDatos();

            for (Producto prod  : listaProductos) {
                
                strSQL
                    
                    
                    = "INSERT INTO DetPedido"
                    + " VALUES ("
                    + "'"+pedido.getId()+"','"
                    + ""+prod.getId()+"','"
                    + ""+cantidad+"','"
                    + ""+pedido.getMonto()+"'); ";
                
                acceso.ejecutaSQL(strSQL);
            }
            
            
            
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
    
    */
   public boolean InsertarDetallePedido(DetPedido detalle)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {
            
            
            AccesoDatos acceso= new AccesoDatos();

            for (Producto prod  : detalle.getListaProductos()) {
                
                strSQL
                    
                    
                    = "INSERT INTO DetPedido"
                    + " VALUES ("
                    + "'"+detalle.getPedido().getId()+"','"
                    + ""+prod.getId()+"','"
                    + ""+detalle.getCantidad()+"','"
                    + ""+detalle.getPedido().getMonto()+"'); ";
                
                acceso.ejecutaSQL(strSQL);
            }
            
            
            
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
   
   
   
   public LinkedList listaPedido()throws SNMPExceptions, SQLException{
        String select = "";
      LinkedList<Pedido> lista = new LinkedList<Pedido>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      //"select id, idUsuario.nombre as [usuario], fechaEntrega, horarioEntrega, direccionEntrega, monto, estado from Pedido";
                      "select id, fechaEntrega, horarioEntrega, direccionEntrega, monto, estado from Pedido";
              
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
              
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                Pedido ped = new Pedido();

                ped.setId(rsPA.getInt("id"));
               // ped.getUsuario().setNombre(rsPA.getString("usuario"));
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
          }catch (Exception e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage());
          } finally {
              
          }
          
    }
   
   
   
   
   public LinkedList listaDetalle(Pedido pedido)throws SNMPExceptions, SQLException{
        String select = "";
      LinkedList<DetPedido> lista = new LinkedList<DetPedido>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      //"select id, idUsuario.nombre as [usuario], fechaEntrega, horarioEntrega, direccionEntrega, monto, estado from Pedido";
                      "select idPedido, idProducto, cantidad, precio from DetPedido";
              
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
              
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                DetPedido det = new DetPedido();

                det.getPedido().setId(rsPA.getInt("idPedido"));
                det.setIdProducto(rsPA.getInt("idProducto"));
                det.setCantidad(rsPA.getInt("cantidad"));
                det.setMonto(rsPA.getInt("precio"));
                
                lista.add(det);
                
              }
              
              rsPA.close(); // cierra conexion
              return lista;
              
          } catch (SQLException e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage(), e.getErrorCode());
          }catch (Exception e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage());
          } finally {
              
          }
          
    }
}
