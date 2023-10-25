package entidad;

import java.time.LocalDate;

public class Compra {

    private int idCompra;
    private Proveedor proveedor;
    private LocalDate fecha;
    private double total;

    public Compra() {
    }

    public Compra(int idCompra, Proveedor proveedor, LocalDate fecha, double total) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.total = total;
    }

    public Compra(Proveedor proveedor, LocalDate fecha, double total) {
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.total = total;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
}
