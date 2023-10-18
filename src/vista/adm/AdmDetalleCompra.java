package vista.adm;

import accesoadatos.DetalleCompraData;
import accesoadatos.ProductoData;
import accesoadatos.ProveedorData;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import entidad.DetalleCompra;
import entidad.Producto;
import entidad.Proveedor;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class AdmDetalleCompra extends javax.swing.JPanel {
    
    DetalleCompraData detalleData;
    private DateChooser dateChooser;
    private String fechaDesde, fechaHasta;
    
    private DefaultTableModel tableModel = new DefaultTableModel() {
        public boolean isCellEditable(int r, int c) {
            return false;
        }
    };
    
    public AdmDetalleCompra() {
        initComponents();
        detalleData = new DetalleCompraData();
        dateChooser = new DateChooser();
        
        // Se toma un TextField y se lo asigna como un DateChooser.
        dateChooser.setTextField(txtDate);
        
        // Este método dice que el tipo de selección es entre dos fechas.
        dateChooser.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        
        // Este método quita un texto que muestra el día actual.
        dateChooser.setLabelCurrentDayVisible(false);
        
        // El siguiente método lee el evento del calendario al seleccionar las fechas.
        // Y luego carga la tabla con las fechas seleccionadas.
        dateChooser.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween fecha, DateChooserAction action) {
                
                // Se cambia el formato de las fechas para que la base de datos las entienda.
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                fechaDesde = df.format(fecha.getFromDate());
                fechaHasta = df.format(fecha.getToDate());
                
                //eliminarFilas();
                
                // Se limpia la tabla cada vez que una fecha fue seleccionada.
                tableModel.setRowCount(0);
                
                // Se carga la tabla con las fechas nuevas seleccionadas.
                for (DetalleCompra detalle : detalleData.listarEntreFechas(fechaDesde, fechaHasta)) {
                    tableModel.addRow(new Object[]{
                        detalle.getIdDetalleCompra(),
                        detalle.getCompra().getProveedor(),
                        detalle.getCompra().getFecha(),
                        detalle.getProducto().getNombreProducto(),
                        detalle.getCantidad(),
                        detalle.getPrecioCosto()
                    });
                }//end for
            }//end dateBetweenChaged metod
        });//end addActionDateChooserListener
        
        cargarModeloTabla();
    }//end constructor

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboProveedor = new javax.swing.JComboBox<>();
        comboProducto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        btnBuscarCodigo = new javax.swing.JButton();
        btnBuscarProveedor = new javax.swing.JButton();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        jLabel1.setText("Codigo:");

        jLabel2.setText("Fecha");

        jLabel3.setText("Proveedor:");

        comboProveedor.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        comboProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboProveedorMousePressed(evt);
            }
        });

        comboProducto.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        comboProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboProductoMousePressed(evt);
            }
        });

        jLabel4.setText("Producto:");

        btnBuscarProducto.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/busqueda.png"))); // NOI18N
        btnBuscarProducto.setBorder(null);
        btnBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnBuscarCodigo.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        btnBuscarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/busqueda.png"))); // NOI18N
        btnBuscarCodigo.setBorder(null);
        btnBuscarCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnBuscarProveedor.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/busqueda.png"))); // NOI18N
        btnBuscarProveedor.setBorder(null);
        btnBuscarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboProveedor, 0, 221, Short.MAX_VALUE)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(comboProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscarCodigo)
                    .addComponent(btnBuscarProducto)
                    .addComponent(btnBuscarProveedor))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarProveedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarProducto))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        tableModel.setRowCount(0);
        
        for (DetalleCompra detalle : detalleData.listarPorProducto((Producto) comboProducto.getSelectedItem())) {
            tableModel.addRow(new Object[]{
                detalle.getIdDetalleCompra(),
                detalle.getCompra().getProveedor(),
                detalle.getCompra().getFecha(),
                detalle.getProducto().getNombreProducto(),
                detalle.getCantidad(),
                detalle.getPrecioCosto()
            });
        }//end for
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void comboProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboProductoMousePressed
        cargarComboProducto();
    }//GEN-LAST:event_comboProductoMousePressed

    private void comboProveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboProveedorMousePressed
        cargarComboProveedor();
    }//GEN-LAST:event_comboProveedorMousePressed

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        tableModel.setRowCount(0);
        
        for (DetalleCompra detalle : detalleData.listarPorProveedor((Proveedor) comboProveedor.getSelectedItem())) {
            tableModel.addRow(new Object[]{
                detalle.getIdDetalleCompra(),
                detalle.getCompra().getProveedor(),
                detalle.getCompra().getFecha(),
                detalle.getProducto().getNombreProducto(),
                detalle.getCantidad(),
                detalle.getPrecioCosto()
            });
        }//end for
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCodigo;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JComboBox<Producto> comboProducto;
    private javax.swing.JComboBox<Proveedor> comboProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtDate;
    // End of variables declaration//GEN-END:variables

    private void cargarModeloTabla() {
        tableModel.addColumn("CÓDIGO");
        tableModel.addColumn("PROVEEDOR");
        tableModel.addColumn("FECHA");
        tableModel.addColumn("PRODUCTO");
        tableModel.addColumn("CANTIDAD");
        tableModel.addColumn("PRECIO COSTO");
        table.setModel(tableModel);
    }
    
    private void cargarComboProveedor() {
        System.out.println("Se ha cargado el combo de proveedor");
        comboProveedor.removeAllItems();

        ProveedorData provData = new ProveedorData();

        for(Proveedor proveedor : provData.listarProveedor()){
            comboProveedor.addItem(proveedor);
        }
    }
    
    private void cargarComboProducto() {
        System.out.println("Se ha cargado el combo de producto");
        comboProducto.removeAllItems();
        
        ProductoData prodData = new ProductoData();

        for(Producto producto : prodData.listarProducto()){
            comboProducto.addItem(producto);
        }
    }
    
    private void refrescarTabla() {
        tableModel.setRowCount(0);
        DetalleCompraData detalleData = new DetalleCompraData();
        
        for (DetalleCompra detalle : detalleData.listarEntreFechas(fechaDesde, fechaHasta)) {
            tableModel.addRow(new Object[]{
                detalle.getIdDetalleCompra(),
                detalle.getCompra().getProveedor(),
                detalle.getCompra().getFecha(),
                detalle.getProducto().getNombreProducto(),
                detalle.getCantidad(),
                detalle.getPrecioCosto()
            });
        }
    }
}
