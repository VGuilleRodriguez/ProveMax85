package accesoadatos;

import entidad.Compra;
import entidad.Proveedor;
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
                    + "(idProveedor, fecha, total) "
                    + "VALUES (?, ?, ?)";
            
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, compra.getProveedor().getIdProveedor());
            ps.setDate(2, Date.valueOf(compra.getFecha()));
            ps.setDouble(3, compra.getTotal());
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
                compra.setTotal(rs.getDouble("total"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la compra.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra. " + ex.getMessage());
        }
        return compra;
    }
    
    public Compra buscarCompraPorProveedor(int id) {
        Compra compra = null;
        try {
            String busqueda = "SELECT * FROM compra WHERE idProveedor = ?";
            
            PreparedStatement ps = conex.prepareStatement(busqueda);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                ProveedorData proveedor = new ProveedorData();
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setProveedor(proveedor.buscarProveedor(rs.getInt("idProveedor")));
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setTotal(rs.getDouble("total"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la compra.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra. " + ex.getMessage());
        }
        return compra;
    }
    
    public List<Compra> listarCompras() {
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
                compra.setTotal(rs.getDouble("total"));
                compras.add(compra); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra. " + ex.getMessage());
        }
        return compras;
    }
    
    public List<Compra> listarEntreFechas(String fechaDesde, String fechaHasta) {
        List<Compra> compras = new ArrayList();
        try {
            String listar = "SELECT idCompra, compra.idProveedor, fecha, total "
                    + "FROM compra JOIN proveedor ON (compra.idProveedor = proveedor.idProveedor) "
                    + "WHERE fecha BETWEEN '"+ fechaDesde +"' AND '"+ fechaHasta +"'";
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Compra compra = new Compra();
                ProveedorData proveedorData = new ProveedorData();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setProveedor(proveedorData.buscarProveedor(rs.getInt("idProveedor")));
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setTotal(rs.getDouble("total"));
                compras.add(compra); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle-compra. " + ex.getMessage());
        }
        return compras;
    }
    
    public List<Compra> listarPorProveedor(Proveedor proveedor) {
        List<Compra> compras = new ArrayList();
        try {
            String listar = "SELECT * FROM compra WHERE idProveedor = "+ proveedor.getIdProveedor();

            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setProveedor(proveedor);
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setTotal(rs.getDouble("total"));
                compras.add(compra); // Se agregar la producto creada arriba al arraylist.
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor o detalle-compra. " + ex.getMessage());
        }
        return compras;
    }
    
    public int obtenerUltimaCompra() {
        int idCompra = 0;
        
        try {
            String busqueda = "SELECT idCompra FROM compra ORDER BY idCompra DESC LIMIT 1";
            
            PreparedStatement ps = conex.prepareStatement(busqueda);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                idCompra = rs.getInt("idCompra");
            } else {
                JOptionPane.showMessageDialog(null, "No existe la compra.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra. " + ex.getMessage());
        }
        return idCompra;
    }
}
