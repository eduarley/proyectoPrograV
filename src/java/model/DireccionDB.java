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
    
    public LinkedList listaDirecciones(int idUsuario)throws SNMPExceptions, SQLException{
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
