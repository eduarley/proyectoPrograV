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
@Named(value = "beanFactura")
@SessionScoped
public class beanFactura implements Serializable {

    /**
     * Creates a new instance of beanFactura
     */
    public beanFactura() {
    }
    
}
