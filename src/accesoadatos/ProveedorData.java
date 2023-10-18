/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import entidad.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class ProveedorData {
    
    private Connection conex;

    public ProveedorData() {
        this.conex = Conexion.getConnection();
    }
    
    private void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    
    
    
    public void nuevoProveedor(Proveedor proveedor) {
        try {
            String sql = "INSERT INTO proveedor "
                    + "(razonSocial, domicilio, telefono, estado) "
                    + "VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setInt(3, proveedor.getTelefono());
            ps.setBoolean(4, proveedor.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                proveedor.setIdProveedor(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "¡Nuevo proveedor añadido con exito!");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor. " + ex.getMessage());
        }
    }
    
    public void eliminarProveedor(int id) {
        try {
            String sql = "DELETE FROM proveedor WHERE idProveedor = ?";
            
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            
            int resultado = ps.executeUpdate();
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "El proveedor se eliminó exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor. " + ex.getMessage());
        }
    }
    
    public void cambiarEstadoProveedor(int id) {
        try {
            String sql = "UPDATE proveedor SET estado = 0 WHERE idProveedor = ?";
            
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            
            int resultado = ps.executeUpdate();
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "El proveedor se dió de baja exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al dar de baja el proveedor.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
    }
    
    public Proveedor buscarProveedor(int id) {
        Proveedor proveedor = null;
        try {
            String busqueda = "SELECT * FROM proveedor WHERE idProveedor = ? AND estado = 1";
            
            PreparedStatement ps = conex.prepareStatement(busqueda);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(id); // Setea el id que recibe por parametro
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getInt("telefono"));
                proveedor.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el proveedor.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor. " + ex.getMessage());
        }
        return proveedor;
    }
    
    public List<Proveedor> listarProveedor() {
        List<Proveedor> proveedores = new ArrayList();
        try {
            String listar = "SELECT * FROM proveedor";
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getInt("telefono"));
                proveedor.setEstado(rs.getBoolean("estado"));
                proveedores.add(proveedor); // Se agregar la proveedor creado arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
        return proveedores;
    }
    
   
    
    public void modificarProveedor(Proveedor Proveedor){
         try {
        String sql = "UPDATE Proveedor SET razonSocial=?, domicilio=?, telefono=?, estado=? WHERE idProveedor=?";
        
        PreparedStatement ps = conex.prepareStatement(sql);
            ps.setString(1, Proveedor.getRazonSocial());
            ps.setString(2, Proveedor.getDomicilio());
            ps.setInt(3, Proveedor.getTelefono());      
            ps.setBoolean(4,Proveedor.isEstado());
            ps.setInt(5, Proveedor.getIdProveedor());
            int exito = ps.executeUpdate();
            if (exito == 1) {               
                mensaje("Proveedor modificado");
                
            } else {
                mensaje("El proveedor NO existe");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    
}
