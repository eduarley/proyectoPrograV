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

    public LinkedList<Usuario> listaObjetosClientes() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Usuario> lista = new LinkedList<Usuario>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "select id, nombre,direccion,telefono, estado from Usuario where rol='cliente'";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                Usuario us = new Usuario();

                //us.setClave(rsPA.getString("clave"));
                us.setId(rsPA.getInt("id"));
                us.setNombre(rsPA.getString("nombre"));
                us.setDireccion(rsPA.getString("direccion"));
                us.setEstado(rsPA.getString("estado"));
                //us.setRol(rsPA.getString("rol"));
                us.setTelefono(rsPA.getString("telefono"));

                lista.add(us);

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
    
    
    
    public static Usuario usuarioPorID(Usuario usuario) throws SNMPExceptions, SQLException {
        String select = "";
       

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "select * from Usuario where id='"+usuario.getId()+"'";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            //Se llena el arryaList con los proyectos   
            Usuario us = new Usuario();
            while (rsPA.next()) {

                

                us.setClave(rsPA.getString("clave"));
                us.setId(rsPA.getInt("id"));
                us.setNombre(rsPA.getString("nombre"));
                us.setDireccion(rsPA.getString("direccion"));
                us.setEstado(rsPA.getString("estado"));
                us.setRol(rsPA.getString("rol"));
                us.setTelefono(rsPA.getString("telefono"));

               

            }

            rsPA.close(); // cierra conexion
            return us;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }

    }
    
    public static String seleccionarNombre(int id) throws SNMPExceptions, SQLException {
        String select = "";

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "select nombre from Usuario where id='" + id + "'";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            
            String nombre= rsPA.getString("nombre");

            rsPA.close(); // cierra conexion
            return nombre;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }

    }
    
    
    
/*
    public String listaClientes() throws SNMPExceptions, SQLException {

        String filas = "";

        
        //filas="<td>Hola</td>";

        //return filas;
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
                us.setEstado(rsPA.getString("estado"));
                //us.setRol(rsPA.getString("rol"));
                us.setTelefono(rsPA.getString("telefono"));

                lista.add(us);
            }
            rsPA.close();//se cierra el ResultSeat.

            for (Usuario usuario : lista) {
//                String estado = usuario.getEstado() == 1 ? "Activo" : "Inactivo";
                filas += "<tr>"
                        + "<td>" + usuario.getId() + "</td>"
                        + "<td>" + usuario.getNombre() + "</td>"
                        + "<td>" + usuario.getDireccion() + "</td>"
                        + "<td>" + usuario.getTelefono() + "</td>"
                        + "<td>" + usuario.getEstado() + "</td>";

                if ("activo".equals(usuario.getEstado())) {
                    filas
                            += //boton eliminar
                            "<td  button='true'><button type='button' class='btn btn-danger'><span class='glyphicon glyphicon-minus'></span> Eliminar</button></td>";

                } else {
                    filas
                            += //boton activar
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
*/
    public boolean InsertarUsuario(Usuario usuario)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {
            //Se obtienen los valores del objeto Departamento
            Usuario us = new Usuario();
            us = usuario;

            strSQL
                    = "INSERT INTO USUARIO VALUES ('" + us.getId() + "','"
                    + "" + us.getNombre() + ""
                    + "','1234','" + us.getDireccion() + "','"
                    + "" + us.getTelefono() + "',"
                    + "'Cliente"
                    + "','"
                    + "activo')";

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }

    
    
    public static boolean editarUsuario(Usuario usuarioEditar)
            throws SNMPExceptions, SQLException {
        String strSQL = "";
        AccesoDatos acceso= new AccesoDatos();
        try {
            //Se obtienen los valores del objeto Departamento
           

            strSQL
                    = "UPDATE USUARIO set nombre='"+usuarioEditar.getNombre()+"',"
                    + "clave='"+usuarioEditar.getClave()+"',"
                    + "direccion='"+usuarioEditar.getDireccion()+"',"
                    + "telefono='"+usuarioEditar.getTelefono()+"'"
                    + "where id='"+usuarioEditar.getId()+"';";

            //Se ejecuta la sentencia SQL
            acceso.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
    
    
    
    
    
    
    
    public boolean eliminarUsuario(Usuario usuario)
            throws SNMPExceptions, SQLException {
        String strSQL = "";
        Usuario us = new Usuario();
        us = usuario;
        try {

            strSQL
                    = "UPDATE USUARIO SET ESTADO='inactivo' WHERE ID= '" + us.getId() + "'";

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }

    public boolean activarUsuario(int id)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {

            strSQL
                    = "UPDATE USUARIO SET ESTADO='activo' WHERE ID= '" + id + "'";

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
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
    
    
}
