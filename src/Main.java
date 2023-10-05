
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import vistas.LoginF;

import accesoadatos.CompraData;
import accesoadatos.Conexion;
import accesoadatos.ProductoData;
import accesoadatos.ProveedorData;
import entidad.Compra;
import entidad.Producto;
import entidad.Proveedor;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author violetalapobre
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* FlatLaf setup */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        
        LoginF loginView = new LoginF();
        loginView.setVisible(true);
        loginView.setLocationRelativeTo(null);
        
        /****************************/
        Conexion.getConnection();
        
        ProductoData prodat = new ProductoData();
        
        //Producto producto = new Producto("Galletas pepas", "galletas con membrillo", 380.90, 36, true); //nombreProducto, descripcion, precioActual, stock, estado
        
        //Producto producto = new Producto("Gaseosa ret", "gaseosa de uva", 760.99, 6, true);
        
        //prodat.cambiarEstadoProducto(1); // Recibe el id del producto a dar de baja
        
        //prodat.nuevoProducto(producto);
        
        //System.out.println(prodat.buscarProducto(1).toString()); // Lanza la excepcion NullPointerException si el producto esta de baja
        //System.out.println(prodat.buscarProducto(2).toString());
        
        //prodat.eliminarProducto(1);
        
        ProveedorData provdat = new ProveedorData();
        
        //Proveedor proveedor1 = new Proveedor("Fulano SA", "Tu vecino", 91283, true);
        
        //proveedor1.setIdProveedor(1);
        
        //Proveedor proveedor2 = new Proveedor("Corrupcion SRL", "La esquina", 23489, true);
        
        //provdat.nuevoProveedor(proveedor1);
        
        //provdat.nuevoProveedor(proveedor2);
        
        //provdat.cambiarEstadoProveedor(2);
        
        //System.out.println(provdat.buscarProveedor(1));
        
        //provdat.eliminarProveedor(2);
        
        CompraData comdat = new CompraData();
        
        //Compra compra = new Compra(proveedor1, LocalDate.of(2000, 12, 24));
        
        //comdat.nuevaCompra(compra);
        
        //System.out.println(comdat.buscarCompra(2));
        
    }
    
}
