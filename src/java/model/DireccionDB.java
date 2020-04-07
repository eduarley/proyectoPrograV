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
public class DireccionDB {

    public DireccionDB() {
    }
    
    public LinkedList<Direccion> listaDirecciones(int idUsuario)throws SNMPExceptions, SQLException{
        String select = "";
      LinkedList<Direccion> lista = new LinkedList<Direccion>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "select * from DireccionEntrega where idUsuario='" + idUsuario + "'";
              
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
              
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                Direccion dir = new Direccion();

                //us.setClave(rsPA.getString("clave"));
                dir.setId(rsPA.getInt("id"));
                dir.setIdUsuario(rsPA.getInt("idUsuario"));
                dir.setDireccion(rsPA.getString("direccion"));
                lista.add(dir);
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
    
    
    
    
    
    
    public boolean InsertarDireccion(Direccion direccion)
            throws SNMPExceptions, SQLException {
        String strSQL = "";
        AccesoDatos acceso= new AccesoDatos();
        try {
            //Se obtienen los valores del objeto Departamento
            Producto prod= new Producto();
            

            strSQL
                    = "INSERT INTO DIRECCIONENTREGA(idUsuario,direccion) "
                    + "VALUES ('" + direccion.getIdUsuario() + "','"
                    + "" + direccion.getDireccion() + "')";
                    

            //Se ejecuta la sentencia SQL
            acceso.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
    
    
    
    public void eliminarProducto(Direccion direccion)
            throws SNMPExceptions, SQLException {
        String strSQL = "";
        
        AccesoDatos acceso= new AccesoDatos();
        try {

            strSQL
                    = "delete from DireccionEntrega where id= '" + direccion.getId() + "'";

            //Se ejecuta la sentencia SQL
            acceso.ejecutaSQL(strSQL);
          

        } catch (Exception e) {
            

        } finally {

        }
    }
    
}
