/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import entidad.Compra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class CompraData {
    
    private Connection conex;

    public CompraData() {
        this.conex = Conexion.getConnection();
    }
    
    public void nuevaCompra(Compra compra) {
        try {
            String sql = "INSERT INTO compra "
                    + "(idProveedor, fecha) "
                    + "VALUES (?, ?)";
            
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, compra.getProveedor().getIdProveedor());
            ps.setDate(2, Date.valueOf(compra.getFecha()));
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                compra.setIdCompra(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "¡Nueva compra añadida con exito!");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra. " + ex.getMessage());
        }
    }
    
    public void eliminarCompra(int id) {
        try {
            String sql = "DELETE FROM compra WHERE idCompra = ?";
            
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            
            int resultado = ps.executeUpdate();
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "La compra se eliminó exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar la compra.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra. " + ex.getMessage());
        }
    }
    
    public Compra buscarCompra(int id) {
        Compra compra = null;
        try {
            String busqueda = "SELECT * FROM compra WHERE idCompra = ?";
            
            PreparedStatement ps = conex.prepareStatement(busqueda);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                ProveedorData proveedor = new ProveedorData();
                compra = new Compra();
                compra.setIdCompra(id); // Setea el id que recibe por parametro
                compra.setProveedor(proveedor.buscarProveedor(rs.getInt("idProveedor")));
                compra.setFecha(rs.getDate("fecha").toLocalDate());
            } else {
                JOptionPane.showMessageDialog(null, "No existe la compra.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra. " + ex.getMessage());
        }
        return compra;
    }
    
    public List<Compra> listarProducto() {
        List<Compra> compras = new ArrayList();
        try {
            String listar = "SELECT * FROM compra";
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ProveedorData proveedor = new ProveedorData();
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setProveedor(proveedor.buscarProveedor(rs.getInt("idProveedor")));
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compras.add(compra); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra. " + ex.getMessage());
        }
        return compras;
    }
}
