package accesoadatos;

import entidad.DetalleCompra;
import entidad.Producto;
import entidad.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleCompraData {
    
    private Connection conex;
    CompraData compraData = new CompraData();
    ProductoData productoData = new ProductoData();
    DetalleCompra detalle;

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
                //JOptionPane.showMessageDialog(null, "¡Nuevo detalle-compra añadido con exito!");
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al crear un nuevo detalle-compra!");
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
                detallecompra.setIdDetalleCompra(id); // Setea el id que recibe por parametro
                detallecompra.setCantidad(rs.getInt("cantidad"));
                detallecompra.setPrecioCosto(rs.getDouble("precioCosto"));
                detallecompra.setCompra(compraData.buscarCompra(rs.getInt("idCompra")));
                detallecompra.setProducto(productoData.buscarProducto(rs.getInt("idProducto")));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el detalle-compra.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle-compra. " + ex.getMessage());
        }
        return detallecompra;
    }
    
    public List<DetalleCompra> listarDetalles() {
        List<DetalleCompra> detallecompras = new ArrayList();
        try {
            String listar = "SELECT * FROM detallecompra";
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                detalle = new DetalleCompra();
                detalle.setIdDetalleCompra(rs.getInt("idDetalleCompra"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioCosto(rs.getDouble("precioCosto"));
                detalle.setCompra(compraData.buscarCompra(rs.getInt("idCompra")));
                detalle.setProducto(productoData.buscarProducto(rs.getInt("idProducto")));
                detallecompras.add(detalle); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
        return detallecompras;
    }
    
    public List<DetalleCompra> listarDetallesSet() {
        List<DetalleCompra> detallecompras = new ArrayList();
        try {
            String listar = "SELECT DISTINCT compra.idProveedor, detallecompra.idProducto FROM detallecompra " +
                            "JOIN compra ON (detallecompra.idCompra = compra.idCompra)";
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                detalle = new DetalleCompra();
                detalle.setCompra(compraData.buscarCompraPorProveedor(rs.getInt("compra.idProveedor")));
                detalle.setProducto(productoData.buscarProducto(rs.getInt("idProducto")));
                detallecompras.add(detalle); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle-compra. " + ex.getMessage());
        }
        return detallecompras;
    }
    
    public List<DetalleCompra> listarDetallesPorIdCompra(int id) {
        List<DetalleCompra> detallecompras = new ArrayList();
        try {
            String listar = "SELECT * FROM detallecompra WHERE idCompra = "+ id;
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                detalle = new DetalleCompra();
                detalle.setIdDetalleCompra(rs.getInt("idDetalleCompra"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioCosto(rs.getDouble("precioCosto"));
                detalle.setCompra(compraData.buscarCompra(rs.getInt("idCompra")));
                detalle.setProducto(productoData.buscarProducto(rs.getInt("idProducto")));
                detallecompras.add(detalle); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
        return detallecompras;
    }
    
    public List<DetalleCompra> listarProductosPorCompra(int idCompra) {
        List<DetalleCompra> detallecompras = new ArrayList();
        try {
            String listar = "SELECT idDetalleCompra, compra.idCompra, idProducto, cantidad, precioCosto "
                    + "FROM compra JOIN detallecompra ON (detallecompra.idCompra = compra.idCompra) "
                    + "WHERE compra.idCompra = ?";
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ps.setInt(1, idCompra);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                detalle = new DetalleCompra();
                detalle.setIdDetalleCompra(rs.getInt("idDetalleCompra"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioCosto(rs.getDouble("precioCosto"));
                detalle.setCompra(compraData.buscarCompra(rs.getInt("idCompra")));
                detalle.setProducto(productoData.buscarProducto(rs.getInt("idProducto")));
                detallecompras.add(detalle); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
        return detallecompras;
    }
    
    public List<DetalleCompra> listarEntreFechas(String fechaDesde, String fechaHasta) {
        List<DetalleCompra> detallecompras = new ArrayList();
        try {
            String listar = "SELECT idDetalleCompra, compra.idCompra, idProducto, cantidad, precioCosto "
                    + "FROM compra JOIN detallecompra ON (detallecompra.idCompra = compra.idCompra) "
                    + "WHERE fecha BETWEEN '"+ fechaDesde +"' AND '"+ fechaHasta +"'";
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                detalle = new DetalleCompra();
                detalle.setIdDetalleCompra(rs.getInt("idDetalleCompra"));
                detalle.setCompra(compraData.buscarCompra(rs.getInt("idCompra")));
                detalle.setProducto(productoData.buscarProducto(rs.getInt("idProducto")));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioCosto(rs.getDouble("precioCosto"));
                detallecompras.add(detalle); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle-compra. " + ex.getMessage());
        }
        return detallecompras;
    }

    public List<DetalleCompra> listarPorProducto(Producto producto) {
        List<DetalleCompra> detallecompras = new ArrayList();
        try {
            String listar = "SELECT idDetalleCompra, idCompra, detallecompra.idProducto, cantidad, precioCosto "
                    + "FROM producto JOIN detallecompra ON (detallecompra.idProducto = producto.idProducto) "
                    + "WHERE producto.idProducto = "+ producto.getIdProducto();

            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                detalle = new DetalleCompra();
                detalle.setIdDetalleCompra(rs.getInt("idDetalleCompra"));
                detalle.setCompra(compraData.buscarCompra(rs.getInt("idCompra")));
                detalle.setProducto(productoData.buscarProducto(rs.getInt("idProducto")));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioCosto(rs.getDouble("precioCosto"));
                detallecompras.add(detalle); // Se agregar la producto creada arriba al arraylist.
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto o detalle-compra. " + ex.getMessage());
        }
        return detallecompras;
    }
    
    public List<DetalleCompra> obtenerUltimaCompra() {
        List<DetalleCompra> detallecompras = new ArrayList();
        try {
            String listar = "SELECT idDetalleCompra, compra.idCompra, idProducto, cantidad, precioCosto "
                        + "FROM compra JOIN detallecompra ON (detallecompra.idCompra = compra.idCompra) "
                        + "WHERE detallecompra.idCompra = (SELECT MAX(detallecompra.idCompra) FROM detallecompra)";
            
            PreparedStatement ps = conex.prepareStatement(listar);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                detalle = new DetalleCompra();
                detalle.setIdDetalleCompra(rs.getInt("idDetalleCompra"));
                detalle.setCompra(compraData.buscarCompra(rs.getInt("idCompra")));
                detalle.setProducto(productoData.buscarProducto(rs.getInt("idProducto")));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioCosto(rs.getDouble("precioCosto"));
                detallecompras.add(detalle); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra. " + ex.getMessage());
        }
        return detallecompras;
    }
    
    public List<DetalleCompra> listarProductoMasCompradoPorFecha(String fechaDesde, String fechaHasta) {
        List<DetalleCompra> detallecompras = new ArrayList();
        try {
            String listar = "SELECT idDetalleCompra, compra.idCompra, idProducto, cantidad, precioCosto "
                    + "FROM compra JOIN detallecompra ON (detallecompra.idCompra = compra.idCompra) "
                    + "WHERE fecha BETWEEN '"+ fechaDesde +"' AND '"+ fechaHasta +"' ORDER BY cantidad DESC ";
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                detalle = new DetalleCompra();
                detalle.setIdDetalleCompra(rs.getInt("idDetalleCompra"));
                detalle.setCompra(compraData.buscarCompra(rs.getInt("idCompra")));
                detalle.setProducto(productoData.buscarProducto(rs.getInt("idProducto")));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioCosto(rs.getDouble("precioCosto"));
                detallecompras.add(detalle); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle-compra. " + ex.getMessage());
        }
        return detallecompras;
    }
}
