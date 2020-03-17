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
import java.util.LinkedList;
/**
 *
 * @author march
 */
public class InicioSesion {
    
    public static boolean validarDatos(int id1, String clave1) throws SNMPExceptions{
        String select= "";
        
        try{
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos= new AccesoDatos();
            
            //Se crea la sentencia de Busqueda
            select=
                    "SELECT id, clave FROM Usuario group by id";
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
        
        
    }
    
}
