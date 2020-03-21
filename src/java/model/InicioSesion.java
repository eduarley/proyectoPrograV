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

/**
 *
 * @author march
 */
public class InicioSesion {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public InicioSesion() {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    /*
    public boolean validarDatos(int id1, String clave1) 
            throws SNMPExceptions, SQLException{
        String select= "";
        
        try{
 
            select=
                    "SELECT id, clave FROM Usuario";
            //se ejecuta la sentencia sql
            ResultSet rsPA= accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while(rsPA.next()){
                
                int id= rsPA.getInt("id");
                
                String clave = rsPA.getString("clave");
                
                //se construye el objeto.
                Usuario us= new Usuario(id, clave);
                
                if(us.getId()==id1 && us.getClave().equals(clave1)){
                    return true;
                }
            }
            rsPA.close();//se cierra el ResultSeat.
            return false;
            
        }catch(SQLException e){
            throw new SNMPExceptions (SNMPExceptions.SQL_EXCEPTION,
                                     e.getMessage(),e.getErrorCode());
        }catch(Exception e){
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,e.getMessage());
        }finally{
            
        }
        
        
    }*/

    public Usuario validarDatos(int id1, String clave1)
            throws SNMPExceptions, SQLException {
        String select = "";

        try {

            select
                    = "SELECT * FROM Usuario";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                Usuario us = new Usuario();

                us.setClave(rsPA.getString("clave"));
                us.setId(rsPA.getInt("id"));
                us.setNombre(rsPA.getString("nombre"));
                us.setDireccion(rsPA.getString("direccion"));
                us.setEstado(rsPA.getString("estado"));
                us.setRol(rsPA.getString("rol"));
                us.setTelefono(rsPA.getString("telefono"));

                if (us.getId() == id1 && us.getClave().equals(clave1) && us.getEstado().equals("activo")) {
                    return us;
                }
            }
            rsPA.close();//se cierra el ResultSeat.
            return null;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }

    }

}
