package accesoadatos;

import entidad.DetalleCompra;
import java.sql.Connection;
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
public class DetalleCompraData {
    
    private Connection conex;

    public DetalleCompraData() {
        this.conex = Conexion.getConnection();
    }
    
    public void nuevoDetalleCompra(DetalleCompra detallecompra) {
        try {
            String sql = "INSERT INTO detallecompra "
                    + "(cantidad, precioCosto, idCompra, idProducto) "
                    + "VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detallecompra.getCantidad());
            ps.setDouble(2, detallecompra.getPrecioCosto());
            ps.setInt(3, detallecompra.getCompra().getIdCompra());
            ps.setInt(4, detallecompra.getProducto().getIdProducto());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                detallecompra.setIdDetalleCompra(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "¡Nuevo detalle-compra añadido con exito!");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle-compra. " + ex.getMessage());
        }
    }
    
    public void eliminarDetalleCompra(int id) {
        try {
            String sql = "DELETE FROM detallecompra WHERE idDetalleCompra = ?";
            
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            
            int resultado = ps.executeUpdate();
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "El detalle-compra se eliminó exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el detalle-compra.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle-compra. " + ex.getMessage());
        }
    }
    
    public void cambiarEstadoDetalleCompra(int id) {
        try {
            String sql = "UPDATE detallecompra SET estado = 0 WHERE idDetalleCompra = ?";
            
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            
            int resultado = ps.executeUpdate();
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "El detalle-compra se dió de baja exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al dar de baja el detalle-compra.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle-compra. " + ex.getMessage());
        }
    }
    
    public DetalleCompra buscarProducto(int id) {
        DetalleCompra detallecompra = null;
        try {
            String busqueda = "SELECT * FROM detallecompra WHERE idDetalleCompra = ?";
            
            PreparedStatement ps = conex.prepareStatement(busqueda);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                CompraData compra = new CompraData();
                ProductoData producto = new ProductoData();
                detallecompra = new DetalleCompra();
                detallecompra.setIdDetalleCompra(id); // Setea el id que recibe por parametro
                detallecompra.setCantidad(rs.getInt("cantidad"));
                detallecompra.setPrecioCosto(rs.getDouble("precioCosto"));
                detallecompra.setCompra(compra.buscarCompra(rs.getInt("idCompra")));
                detallecompra.setProducto(producto.buscarProducto(rs.getInt("idProducto")));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el detalle-compra.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle-compra. " + ex.getMessage());
        }
        return detallecompra;
    }
    
    public List<DetalleCompra> listarProducto() {
        List<DetalleCompra> detallecompras = new ArrayList();
        try {
            String listar = "SELECT * FROM detallecompra";
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                CompraData compra = new CompraData();
                ProductoData producto = new ProductoData();
                DetalleCompra detallecompra = new DetalleCompra();
                detallecompra.setIdDetalleCompra(rs.getInt("idDetalleCompra"));
                detallecompra.setCantidad(rs.getInt("cantidad"));
                detallecompra.setPrecioCosto(rs.getDouble("precioCosto"));
                detallecompra.setCompra(compra.buscarCompra(rs.getInt("idCompra")));
                detallecompra.setProducto(producto.buscarProducto(rs.getInt("idProducto")));
                detallecompras.add(detallecompra); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
        return detallecompras;
    }
}
