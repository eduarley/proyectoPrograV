/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.AccesoDatos;
import DAO.SNMPExceptions;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.imageio.ImageIO;

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
                      "select * from Producto";
              
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
              
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                Producto pro = new Producto();

                //us.setClave(rsPA.getString("clave"));
                pro.setId(rsPA.getInt("id"));
                pro.setDescripcion(rsPA.getString("descripcion"));
                pro.setUrl(rsPA.getString("urlImagen"));
                pro.setPrecio(rsPA.getDouble("precio"));
                pro.setExistencias(rsPA.getInt("existencias"));
                pro.setTipo(rsPA.getString("tipo"));
                pro.setEstado(rsPA.getInt("estado"));
                pro.setIngredientes(rsPA.getString("ingredientes"));
                
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
    
    
    public boolean InsertarProducto(Producto producto)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {
            //Se obtienen los valores del objeto Departamento
            Producto prod= new Producto();
            prod = producto;

            strSQL
                    = "INSERT INTO PRODUCTO(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado) "
                    + "VALUES ('" + prod.getDescripcion() + "','"
                    + "" + prod.getUrl() + "','"
                    + prod.getPrecio() + "','"
                    + "" + prod.getExistencias() + "','"
                    + "" + prod.getTipo() + "','"
                    + ""+ prod.getIngredientes()+ "','"
                    + "1')";
                   

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
                    = "UPDATE Producto SET ESTADO=0 WHERE ID= '" + pro.getId() + "'";

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    ////////////////////////////////////// PARTE DEL MENU////////////////////////////////////
    
    
    
    
    public String listaMenuDesayuno() throws SNMPExceptions, SQLException {

        String estructura = "";

       
        String select = "";
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {

            select
                    = "select descripcion, urlImagen, precio, ingredientes from producto where estado=1 and tipo='desayuno'";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                Producto prod= new Producto();

                
                prod.setDescripcion(rsPA.getString("descripcion"));
                
                prod.setPrecio(rsPA.getDouble("precio"));
                prod.setIngredientes(rsPA.getString("ingredientes"));
                
                prod.setUrl(rsPA.getString("urlImagen"));
                
                
                
                lista.add(prod);
            }
            rsPA.close();//se cierra el ResultSeat.

            for (Producto producto : lista) {
                estructura+="<a href=\"#\">"
                
                            +"<div class=\"menus d-flex ftco-animate\">"
                               +"<img class=\"menu-img img\" src="+producto.getUrl()+" alt=\"imagen\"/>"
                              
                               +" <div class=\"text\">"
                                +"<div class=\"d-flex\">"    
                                       +" <div class=\"one-half\">"
                                        +"<h3>"+producto.getDescripcion()+"</h3>"
                                        +"</div>"
                                        +"<div class=\"one-forth\">"
                                            +"<span class=\"price\">₡"+producto.getPrecio()+"</span>"
                                        +"</div>"
                                    +"</div>"
                                    +"<p><span>"+producto.getIngredientes()+"</span></p>"
                                +"</div>"
                            +"</div>"
                      +"</a>";
            }

            return estructura;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }
    
    
    
    
    
    public String listaMenuAlmuerzo() throws SNMPExceptions, SQLException {

        String estructura = "";

       
        String select = "";
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {

            select
                    = "select descripcion, urlImagen, precio, ingredientes from producto where estado=1 and tipo='almuerzo'";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                Producto prod= new Producto();

                
                prod.setDescripcion(rsPA.getString("descripcion"));
                
                prod.setPrecio(rsPA.getDouble("precio"));
                prod.setIngredientes(rsPA.getString("ingredientes"));
                
                prod.setUrl(rsPA.getString("urlImagen"));
                
                
                
                lista.add(prod);
            }
            rsPA.close();//se cierra el ResultSeat.

            for (Producto producto : lista) {
                estructura+="<a href=\"#\">"
                
                            +"<div class=\"menus d-flex ftco-animate\">"
                               +"<img class=\"menu-img img\" src="+producto.getUrl()+" alt=\"imagen\"/>"
                              
                               +" <div class=\"text\">"
                                +"<div class=\"d-flex\">"    
                                       +" <div class=\"one-half\">"
                                        +"<h3>"+producto.getDescripcion()+"</h3>"
                                        +"</div>"
                                        +"<div class=\"one-forth\">"
                                            +"<span class=\"price\">₡"+producto.getPrecio()+"</span>"
                                        +"</div>"
                                    +"</div>"
                                    +"<p><span>"+producto.getIngredientes()+"</span></p>"
                                +"</div>"
                            +"</div>"
                      +"</a>";
            }

            return estructura;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }
    
    
    
    
    
    
       public String listaMenuCena() throws SNMPExceptions, SQLException {

        String estructura = "";

       
        String select = "";
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {

            select
                    = "select descripcion, urlImagen, precio, ingredientes from producto where estado=1 and tipo='cena'";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                Producto prod= new Producto();

                
                prod.setDescripcion(rsPA.getString("descripcion"));
                
                prod.setPrecio(rsPA.getDouble("precio"));
                prod.setIngredientes(rsPA.getString("ingredientes"));
                
                prod.setUrl(rsPA.getString("urlImagen"));
                
                
                
                lista.add(prod);
            }
            rsPA.close();//se cierra el ResultSeat.

            for (Producto producto : lista) {
                estructura+="<a href=\"#\">"
                
                            +"<div class=\"menus d-flex ftco-animate\">"
                               +"<img class=\"menu-img img\" src="+producto.getUrl()+" alt=\"imagen\"/>"
                              
                               +" <div class=\"text\">"
                                +"<div class=\"d-flex\">"    
                                       +" <div class=\"one-half\">"
                                        +"<h3>"+producto.getDescripcion()+"</h3>"
                                        +"</div>"
                                        +"<div class=\"one-forth\">"
                                            +"<span class=\"price\">₡"+producto.getPrecio()+"</span>"
                                        +"</div>"
                                    +"</div>"
                                    +"<p><span>"+producto.getIngredientes()+"</span></p>"
                                +"</div>"
                            +"</div>"
                      +"</a>";
            }

            return estructura;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }
    
    
    
    
    
    
    
    
}
