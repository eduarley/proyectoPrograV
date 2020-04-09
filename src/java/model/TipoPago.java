/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author march
 */
public enum TipoPago {
    Efectivo{
        public String toString(){
            return "Efectivo";
        }
    },
    Cuenta_Por_Cobrar{
        public String toString(){
            return "Cuenta por cobrar";
        };
    }
}
