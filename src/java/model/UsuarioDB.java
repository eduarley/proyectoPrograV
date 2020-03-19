/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.AccesoDatos;
import DAO.SNMPExceptions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class UsuarioDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public UsuarioDB() {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

 
    
    
    
    
    public LinkedList listaObjetosClientes()throws SNMPExceptions, SQLException{
        String select = "";
      LinkedList<Usuario> lista = new LinkedList<Usuario>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "select id, nombre,direccion,telefono, estado from Usuario where rol='cliente'";
              
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
              
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                 Usuario us = new Usuario();

                //us.setClave(rsPA.getString("clave"));
                us.setId(rsPA.getInt("id"));
                us.setNombre(rsPA.getString("nombre"));
                us.setDireccion(rsPA.getString("direccion"));
                us.setEstado(rsPA.getInt("estado"));
                //us.setRol(rsPA.getString("rol"));
                us.setTelefono(rsPA.getString("telefono"));
                
                lista.add(us);
                
                
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
    
    
    
    
    
    
    public String listaClientes() throws SNMPExceptions, SQLException {

        String filas = "";

        /*
        filas="<td>Hola</td>";

        return filas;*/
        String select = "";
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try {

            select
                    = "select id, nombre, direccion, telefono, estado from Usuario where rol='cliente'";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                Usuario us = new Usuario();

                //us.setClave(rsPA.getString("clave"));
                us.setId(rsPA.getInt("id"));
                us.setNombre(rsPA.getString("nombre"));
                us.setDireccion(rsPA.getString("direccion"));
                us.setEstado(rsPA.getInt("estado"));
                //us.setRol(rsPA.getString("rol"));
                us.setTelefono(rsPA.getString("telefono"));

                lista.add(us);
            }
            rsPA.close();//se cierra el ResultSeat.

            for (Usuario usuario : lista) {
                String estado = usuario.getEstado() == 1 ? "Activo" : "Inactivo";
                filas += "<tr>"
                        + "<td>" + usuario.getId() + "</td>"
                        + "<td>" + usuario.getNombre() + "</td>"
                        + "<td>" + usuario.getDireccion() + "</td>"
                        + "<td>" + usuario.getTelefono() + "</td>"
                        + "<td>" + estado + "</td>";

                if (usuario.getEstado() == 1) {
                    filas
                            += //boton eliminar
                            "<td  button='true'><button type='button' class='btn btn-danger'><span class='glyphicon glyphicon-minus'></span> Eliminar</button></td>";

                }else{
                    filas+= //boton activar
                            "<td  button='true'><button type='button' class='btn btn-primary'><span class='glyphicon glyphicon-minus'></span> Activar</button></td>";

                }

                filas += "</tr>";
            }

            return filas;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    public String agregarCliente() throws SNMPExceptions, SQLException {

       

        
        String insert = "";
        
        try {

            insert
                    = "insert into usuario values";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(insert);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                Usuario us = new Usuario();

                //us.setClave(rsPA.getString("clave"));
                us.setId(rsPA.getInt("id"));
                us.setNombre(rsPA.getString("nombre"));
                us.setDireccion(rsPA.getString("direccion"));
                us.setEstado(rsPA.getInt("estado"));
                //us.setRol(rsPA.getString("rol"));
                us.setTelefono(rsPA.getString("telefono"));

                lista.add(us);
            }
            rsPA.close();//se cierra el ResultSeat.

           

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }*/

    
    
    
    
    
    
    
    
    
    
    
    
    
}
