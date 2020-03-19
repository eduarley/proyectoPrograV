/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author march
 */
@Named(value = "beanProducto")
@SessionScoped
public class beanProducto implements Serializable {

    /**
     * Creates a new instance of beanProducto
     */
    public beanProducto() {
    }
    
}
