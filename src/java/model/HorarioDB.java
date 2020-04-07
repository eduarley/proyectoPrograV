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
 * @author Usuario
 */
public class HorarioDB {

    public LinkedList<Horario> listaHorarios(int idUsuario) throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Horario> lista = new LinkedList<Horario>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "select * from HorarioEntrega where idUsuario='" + idUsuario + "'";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                Horario horario = new Horario();

                //us.setClave(rsPA.getString("clave"));
                horario.setId(rsPA.getInt("id"));
                horario.setIdUsuario(rsPA.getInt("idUsuario"));
                horario.setHoraInicio(rsPA.getString("horaInicio"));
                horario.setHoraFin(rsPA.getString("horaFin"));
                lista.add(horario);
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
    
    
    
     public boolean InsertarHorario(Horario horario)
            throws SNMPExceptions, SQLException {
        String strSQL = "";
        AccesoDatos acceso= new AccesoDatos();
        try {
            //Se obtienen los valores del objeto Departamento
            
            

            strSQL
                    = "INSERT INTO HORARIOENTREGA(idUsuario,horainicio,horafin) "
                    + "VALUES ('" + horario.getIdUsuario() + "','"
                    + "" + horario.getHoraInicio() + "','"
                    + ""+horario.getHoraFin()+"')";
                    

            //Se ejecuta la sentencia SQL
            acceso.ejecutaSQL(strSQL);
            return true;

        } catch (Exception e) {
            //  throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
            return false;

        } finally {

        }
    }
    
}
