package accesoadatos;

import entidad.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
    
    public void darAltaProveedor(int id) {
        try {
            String sql = "UPDATE proveedor SET estado = 1 WHERE idProveedor = ?";
            
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            
            int resultado = ps.executeUpdate();
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "El proveedor se dió de alta exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al dar de alta el proveedor.");
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor. " + ex.getMessage());
        }
    }
    
    public Proveedor buscarProveedor(int id) {
        Proveedor proveedor = null;
        try {
            String busqueda = "SELECT * FROM proveedor WHERE idProveedor = ?";
            
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
    
    public List<Proveedor> listarProveedor(int estado) {
        List<Proveedor> proveedores = new ArrayList();
        try {
            String listar = "";
            switch (estado) {
                case 0:
                    listar = "SELECT * FROM proveedor WHERE estado = 0";
                    break;
                case 1:
                    listar = "SELECT * FROM proveedor WHERE estado = 1";
                    break;
                default:
                    listar = "SELECT * FROM proveedor";
            }
            
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor. " + ex.getMessage());
        }
        return proveedores;
    }
    
    public List<Proveedor> listarProveedorEstado(int estado) {
        List<Proveedor> proveedores = new ArrayList();
        try {
            String listar = "SELECT * FROM proveedor WHERE estado = "+ estado;
            
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor. " + ex.getMessage());
        }
        return proveedores;
    }

    public void modificarProveedor(Proveedor proveedor) {
        try {
            String sql = "UPDATE proveedor SET razonSocial = ?, domicilio = ?, telefono = ?, estado = ? "
                    + "WHERE idProveedor = ?";

            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setInt(3, proveedor.getTelefono());
            ps.setBoolean(4, proveedor.isEstado());
            ps.setInt(5, proveedor.getIdProveedor());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                mensaje("Proveedor modificado");
            } else {
                mensaje("Error al modificar el proveedor");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor. " + ex.getMessage());
        }
    }

}
