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
 * @author march
 */
public class ProductoDB {
    
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public ProductoDB() {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }
    
    public LinkedList listaObjetosProductos()throws SNMPExceptions, SQLException{
        String select = "";
      LinkedList<Producto> lista = new LinkedList<Producto>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "select id, descripcion, imagen, precio, existencias, tipo, estado from Producto";
              
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
              
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                Producto pro = new Producto();

                //us.setClave(rsPA.getString("clave"));
                pro.setId(rsPA.getInt("id"));
                pro.setDescripcion(rsPA.getString("descripcion"));
                pro.setImagen(rsPA.getBytes("imagen"));
                pro.setPrecio(rsPA.getDouble("precio"));
                pro.setExistencias(rsPA.getInt("existencias"));
                pro.setTipo(rsPA.getString("tipo"));
                pro.setEstado(rsPA.getInt("estado"));
                
                lista.add(pro);
                
                
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
    
    
    public String listaProductos() throws SNMPExceptions, SQLException {

        String filas = "";

        /*
        filas="<td>Hola</td>";

        return filas;*/
        String select = "";
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {

            select
                    = "select id, descripcion, imagen, precio, existencias, tipo, estado from Producto";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                Producto pro = new Producto();

                pro.setId(rsPA.getInt("id"));
                pro.setDescripcion(rsPA.getString("descripcion"));
                pro.setImagen(rsPA.getBytes("imagen"));
                pro.setPrecio(rsPA.getDouble("precio"));
                pro.setExistencias(rsPA.getInt("existencias"));
                pro.setTipo(rsPA.getString("tipo"));
                pro.setEstado(rsPA.getInt("estado"));   //Esta línea puede permanecer, NO AFECTA
                
                lista.add(pro);
            }
            rsPA.close();//se cierra el ResultSeat.

            for (Producto producto : lista) {
//                String estado = producto.getEstado() == 1 ? "Activo" : "Inactivo";
                filas += "<tr>"
                        + "<td>" + producto.getId() + "</td>"
                        + "<td>" + producto.getDescripcion()+ "</td>"
                        + "<td>" + producto.getImagen()+ "</td>"
                        + "<td>" + producto.getPrecio()+ "</td>"
                        + "<td>" + producto.getExistencias()+ "</td>"
                        + "<td>" + producto.getTipo()+ "</td>";
//                        + "<td>" + estado + "</td>";

                if (producto.getEstado() == 1) {
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
    
    
    public boolean InsertarProducto(Producto producto)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {
            //Se obtienen los valores del objeto Departamento
            Producto pro = new Producto();
            pro = producto;
            int estado= 1;
            strSQL
                    = "INSERT INTO USUARIO VALUES ('" + pro.getDescripcion() + "','" +
                    "" + pro.getImagen()+ "" + "','" + 
                    "" + pro.getPrecio() + "" + "','" + 
                    "" + pro.getExistencias()+ "" + "','" + 
                    "" + pro.getTipo()+ "','" + "" + estado + "')";

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }

    //NOTA
    public boolean eliminarProducto(Producto producto)
            throws SNMPExceptions, SQLException {
        String strSQL = "";
        Producto pro = new Producto();
        pro = producto;
        try {

            strSQL
                    = "UPDATE USUARIO SET ESTADO=0 WHERE ID= '" + pro.getId() + "'";

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
    
}
