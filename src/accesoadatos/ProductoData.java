package accesoadatos;

import entidad.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductoData {
    
    private Connection conex;

    public ProductoData() {
        this.conex = Conexion.getConnection();
    }
    
    private void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void nuevoProducto(Producto producto) {
        try {
            String sql = "INSERT INTO producto "
                    + "(nombreProducto, descripcion, precioActual, stock, estado) "
                    + "VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "¡Nuevo producto añadido con exito!");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
    }
    
    public void darAltaProducto(int id) {
        try {
            String sql = "UPDATE producto SET estado = 1 WHERE idProducto = ?";
            
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            
            int resultado = ps.executeUpdate();
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "El producto se dió de alta exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al dar de alta el producto.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
    }
    
    public void cambiarEstadoProducto(int id) {
        try {
            String sql = "UPDATE producto SET estado = 0 WHERE idProducto = ?";
            
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            
            int resultado = ps.executeUpdate();
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "El producto se dió de baja exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al dar de baja el producto.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
    }
    
    public Producto buscarProducto(int id) {
        Producto producto = null;
        try {
            String busqueda = "SELECT * FROM producto WHERE idProducto = ?";
            
            PreparedStatement ps = conex.prepareStatement(busqueda);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(id); // Setea el id que recibe por parametro
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el producto.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
        return producto;
    }
    
    public List<Producto> listarProducto(int estado) {
        List<Producto> productos = new ArrayList();
        try {
            String listar = "";
            switch (estado) {
                case 0:
                    listar = "SELECT * FROM producto WHERE estado = 0";
                    break;
                case 1:
                    listar = "SELECT * FROM producto WHERE estado = 1";
                    break;
                default:
                    listar = "SELECT * FROM producto";
            }
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                productos.add(producto); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
        return productos;
    }
    
    public List<Producto> listarProductoEstado(int estado) {
        List<Producto> productos = new ArrayList();
        try {
            String listar = "SELECT * FROM producto WHERE estado = "+ estado;
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                productos.add(producto); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
        return productos;
    }
    
    public List<String> cantidadProducto() {
        List productos = new ArrayList();
        try {
            String cant = "SELECT nombreProducto, stock FROM producto WHERE stock < 10";

            PreparedStatement ps = conex.prepareStatement(cant);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setStock(rs.getInt("stock"));
                productos.add("* El stock del producto " + producto.getNombreProducto() + " esta por debajo del minimo. Stock : " + producto.getStock());
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
        return productos;
    }
    
    public List<Producto> listarStockMinimo(int stock) {
        List<Producto> productos = new ArrayList();
        try {
            String listar = "SELECT * FROM producto WHERE stock < ?";
            
            PreparedStatement ps = conex.prepareStatement(listar);
            ps.setInt(1, stock);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                productos.add(producto); // Se agregar la producto creada arriba al arraylist.
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
        return productos;
    }
    
    public void modificarProducto(Producto producto) {
        try {
            String sql = "UPDATE producto SET nombreProducto=?, descripcion=?, precioActual=?, stock=?, estado=? WHERE idProducto=?";

            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.setInt(6, producto.getIdProducto());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                mensaje("Producto modificado");

            } else {
                mensaje("El producto NO existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
    }
    
    public void actualizarStock(int idProducto, int cantidad) {
        try {
            String sql = "UPDATE producto SET stock = stock + "+ cantidad +" WHERE idProducto = "+ idProducto;

            PreparedStatement ps = conex.prepareStatement(sql);
            int exito = ps.executeUpdate();
            
            /*
            if (exito == 1) {
                mensaje("El stock del producto fue actualizado.");
            } else {
                mensaje("Error al actualizar el stock del producto.");
            }
            */
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }
    }
}
