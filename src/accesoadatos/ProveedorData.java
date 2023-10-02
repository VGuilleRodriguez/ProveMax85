/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import java.sql.Connection;

/**
 *
 * @author nicolas
 */
public class ProveedorData {
    
    private Connection conex;

    public ProveedorData(Connection conex) {
        this.conex = Conexion.getConnection();
    }
    
    
}
