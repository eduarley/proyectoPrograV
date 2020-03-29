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
                      "select id, descripcion, imagen, precio, existencias, tipo, estado from Producto";
              
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
              
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                Producto pro = new Producto();

                //us.setClave(rsPA.getString("clave"));
                pro.setId(rsPA.getInt("id"));
                pro.setDescripcion(rsPA.getString("descripcion"));
                pro.setFile(rsPA.getBytes("imagen"));
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
    
    
    public String listaProductos() throws SNMPExceptions, SQLException {

        String filas = "";

        /*
        filas="<td>Hola</td>";

        return filas;*/
        String select = "";
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {

            select
                    = "select id, descripcion, imagen, precio, existencias, tipo, ingredientes, estado from Producto";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                Producto pro = new Producto();

                pro.setId(rsPA.getInt("id"));
                pro.setDescripcion(rsPA.getString("descripcion"));
                //pro.setImagen(rsPA.getBytes("imagen"));
                pro.setPrecio(rsPA.getDouble("precio"));
                pro.setExistencias(rsPA.getInt("existencias"));
                pro.setTipo(rsPA.getString("tipo"));
                pro.setIngredientes(rsPA.getString("ingredientes"));
                pro.setEstado(rsPA.getInt("estado"));   //Esta línea puede permanecer, NO AFECTA
                
                lista.add(pro);
            }
            rsPA.close();//se cierra el ResultSeat.

            for (Producto producto : lista) {
//                String estado = producto.getEstado() == 1 ? "Activo" : "Inactivo";
                filas += "<tr>"
                        + "<td>" + producto.getId() + "</td>"
                        + "<td>" + producto.getDescripcion()+ "</td>"
                        //+ "<td>" + producto.getImagen()+ "</td>"
                        + "<td>" + producto.getPrecio()+ "</td>"
                        + "<td>" + producto.getExistencias()+ "</td>"
                        + "<td>" + producto.getTipo()+ "</td>"
                        + "<td>" + producto.getIngredientes()+ "</td>";
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
    
    
//    public boolean InsertarProducto(Producto producto)
//            throws SNMPExceptions, SQLException {
//        String strSQL = "";
//
//        try {
//         
//            
//            
//            Producto pro = new Producto();
//            pro = producto;
//            
////            strSQL
////                    = "INSERT INTO producto(descripcion,imagen,precio,existencias,tipo,estado) "
////                    + "VALUES ('" + pro.getDescripcion() + "','"+pro.getFile()+"','"+pro.getPrecio()+"','"+pro.getExistencias()+"','"+pro.getTipo()+"','Activo')";
////                    
//            
//
//            PreparedStatement st= conn.prepareStatement("INSERT INTO producto(descripcion,imagen,precio,existencias,tipo,estado)"
//                    + "VALUES ('" + pro.getDescripcion() + "','?','"+pro.getPrecio()+"','"+pro.getExistencias()+"','"+pro.getTipo()+"','Activo')");
//            st.setBinaryStream(1, pro.getFile());
//            
//            st.executeUpdate();
//            
//            conn.close();
//            //Se ejecuta la sentencia SQL
//            //accesoDatos.ejecutaSQL(strSQL);
//            return true;
//
//        } catch (Exception e) {
//            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
//            return false;
//
//        } finally {
//
//        }
//    }
    
    
    
    public boolean InsertarProducto(Producto producto)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {
            
            
            byte[] imageBytes=null;
            
              AccesoDatos accesoDatos = new AccesoDatos();  
              Producto pro = new Producto();
            pro = producto;
              
              
              
               strSQL
                    = "INSERT INTO producto(descripcion,imagen,precio,existencias,tipo,estado) "
                    + "VALUES ('" + pro.getDescripcion() + "','"+pro.getUploadedFile().getSubmittedFileName()+"','"
                       +pro.getPrecio()+"','"+pro.getExistencias()+"','"+pro.getTipo()+"','"+pro.getIngredientes()+"','1')";
                    
              PreparedStatement statement = conn.prepareStatement(strSQL);
              
              ResultSet rsPA = statement.executeQuery();
              
              
              while (rsPA.next()) {

                imageBytes=rsPA.getBytes("file");
                
                
              }
              
              rsPA.close(); // cierra conexion
            
            
            
            
            
            
            
            return true;

        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            /*return false;*/

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
    
    
    
    
    
    public boolean modificarProducto(Producto producto)
            throws SNMPExceptions, SQLException {
        String strSQL = "";
        Producto pro = new Producto();
        pro = producto;
        try {

            strSQL
                    = "UPDATE Producto SET descripcion=0 WHERE ID= '" + pro.getId() + "'";

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
                    = "select descripcion, imagen, precio, ingredientes from producto where estado=1 and tipo='desayuno'";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                Producto prod= new Producto();

                
                prod.setDescripcion(rsPA.getString("descripcion"));
                
                prod.setPrecio(rsPA.getDouble("precio"));
                prod.setIngredientes(rsPA.getString("ingredientes"));
                
                
                Blob blob=  (rsPA.getBlob("imagen"));
                InputStream in = blob.getBinaryStream();  
                BufferedImage image = ImageIO.read(in);
                prod.setImg(image);
                
                
                lista.add(prod);
            }
            rsPA.close();//se cierra el ResultSeat.

            for (Producto producto : lista) {
                estructura+="<a href=\"producto.xhtml\">"
                
                            +"<div class=\"menus d-flex ftco-animate\">"
                               +"<div class=\"menu-img img\" style=\"background-image: url();\"></div>"
                              
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
                    = "select descripcion, imagen, precio, ingredientes from producto where estado=1 and tipo='almuerzo'";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                Producto prod= new Producto();

                
                prod.setDescripcion(rsPA.getString("descripcion"));
                //prod.setFile(rsPA.getBytes("imagen"));
                prod.setPrecio(rsPA.getDouble("precio"));
                prod.setIngredientes(rsPA.getString("ingredientes"));

                lista.add(prod);
            }
            rsPA.close();//se cierra el ResultSeat.

            for (Producto producto : lista) {
                estructura+="<a href=\"producto.xhtml\">"
                
                            +"<div class=\"menus d-flex ftco-animate\">"
                               +"<div class=\"menu-img img\" style=\"background-image: url();\"></div>"
                              
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
                    = "select descripcion, imagen, precio, ingredientes from producto where estado=1 and tipo='cena'";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                Producto prod= new Producto();

                
                prod.setDescripcion(rsPA.getString("descripcion"));
                //prod.setFile(rsPA.getBytes("imagen"));
                prod.setPrecio(rsPA.getDouble("precio"));
                prod.setIngredientes(rsPA.getString("ingredientes"));

                lista.add(prod);
            }
            rsPA.close();//se cierra el ResultSeat.

            for (Producto producto : lista) {
                estructura+="<a href=\"producto.xhtml\">"
                
                            +"<div class=\"menus d-flex ftco-animate\">"
                               +"<div class=\"menu-img img\" style=\"background-image: url();\"></div>"
                              
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
