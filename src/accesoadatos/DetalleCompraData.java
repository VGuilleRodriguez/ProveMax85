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
public class DetalleCompraData {
    
    private Connection conex;

    public DetalleCompraData(Connection conex) {
        this.conex = Conexion.getConnection();
    }
    
    
}
