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
        cargarTablaConDetalles();
        cargarComboProveedor();
        cargarComboProducto();
        agruparRadioButton();
    }//end constructor

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtBuscarCodigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnBuscarCodigo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtDate = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnBuscarProveedor = new javax.swing.JLabel();
        comboProveedor = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        comboProducto = new javax.swing.JComboBox<>();
        btnBuscarProducto = new javax.swing.JLabel();
        btnUltimaCompra = new javax.swing.JRadioButton();
        btnListarDetalles = new javax.swing.JRadioButton();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar detalle por código de compra", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 14))); // NOI18N

        txtBuscarCodigo.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        txtBuscarCodigo.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtBuscarCodigo.setBorder(null);
        txtBuscarCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarCodigoKeyTyped(evt);
            }
        });

        jSeparator1.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnBuscarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/busqueda_mini.png"))); // NOI18N
        btnBuscarCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarCodigoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(txtBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCodigo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnBuscarCodigo))
                    .addComponent(txtBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar detalle por fecha", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 14))); // NOI18N

        txtDate.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        txtDate.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtDate.setBorder(null);
        txtDate.setPreferredSize(new java.awt.Dimension(326, 28));

        jSeparator2.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setPreferredSize(new java.awt.Dimension(326, 6));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar detalle por proveedor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 14))); // NOI18N

        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/busqueda_mini.png"))); // NOI18N
        btnBuscarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarProveedorMouseClicked(evt);
            }
        });

        comboProveedor.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        comboProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboProveedorMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarProveedor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBuscarProveedor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar detalle por producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 14))); // NOI18N

        comboProducto.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        comboProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboProductoMousePressed(evt);
            }
        });

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/busqueda_mini.png"))); // NOI18N
        btnBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarProductoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarProducto)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(comboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBuscarProducto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUltimaCompra.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnUltimaCompra.setText("Mostrar detalle de mi última compra");
        btnUltimaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimaCompraActionPerformed(evt);
            }
        });

        btnListarDetalles.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnListarDetalles.setSelected(true);
        btnListarDetalles.setText("Mostrar detalle de todas las compras");
        btnListarDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarDetallesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUltimaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListarDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnListarDetalles)
                        .addGap(18, 18, 18)
                        .addComponent(btnUltimaCompra))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboProductoMousePressed
        cargarComboProducto();
    }//GEN-LAST:event_comboProductoMousePressed

    private void comboProveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboProveedorMousePressed
        cargarComboProveedor();
    }//GEN-LAST:event_comboProveedorMousePressed

    private void btnBuscarCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarCodigoMouseClicked
        tableModel.setRowCount(0);
        
        for (DetalleCompra detalle : detalleData.listarProductosPorCompra(Integer.parseInt(txtBuscarCodigo.getText()))) {
            tableModel.addRow(new Object[]{
                detalle.getIdDetalleCompra(),
                detalle.getCompra().getProveedor(),
                detalle.getCompra().getFecha(),
                detalle.getProducto().getNombreProducto(),
                detalle.getCantidad(),
                detalle.getPrecioCosto()
            });
        }//end for
    }//GEN-LAST:event_btnBuscarCodigoMouseClicked

    private void btnBuscarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarProveedorMouseClicked
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
    }//GEN-LAST:event_btnBuscarProveedorMouseClicked

    private void btnBuscarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarProductoMouseClicked
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
    }//GEN-LAST:event_btnBuscarProductoMouseClicked

    private void txtBuscarCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCodigoKeyTyped
        char caracter = evt.getKeyChar();
        if ((caracter < '0') || (caracter > '9')){
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarCodigoKeyTyped

    private void btnUltimaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimaCompraActionPerformed
        tableModel.setRowCount(0);
        
        if (btnUltimaCompra.isSelected()) {
            for (DetalleCompra detalle : detalleData.obtenerUltimaCompra()) {
                tableModel.addRow(new Object[]{
                    detalle.getIdDetalleCompra(),
                    detalle.getCompra().getProveedor(),
                    detalle.getCompra().getFecha(),
                    detalle.getProducto().getNombreProducto(),
                    detalle.getCantidad(),
                    detalle.getPrecioCosto()
                });
            }//end for
        } else {
            tableModel.setRowCount(0);
        }
    }//GEN-LAST:event_btnUltimaCompraActionPerformed

    private void btnListarDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarDetallesActionPerformed
        tableModel.setRowCount(0);
        
        if (btnListarDetalles.isSelected()) {
            cargarTablaConDetalles();
        } else {
            tableModel.setRowCount(0);
        }
    }//GEN-LAST:event_btnListarDetallesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscarCodigo;
    private javax.swing.JLabel btnBuscarProducto;
    private javax.swing.JLabel btnBuscarProveedor;
    private javax.swing.JRadioButton btnListarDetalles;
    private javax.swing.JRadioButton btnUltimaCompra;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Producto> comboProducto;
    private javax.swing.JComboBox<Proveedor> comboProveedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBuscarCodigo;
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
        comboProveedor.removeAllItems();

        ProveedorData provData = new ProveedorData();

        for(Proveedor proveedor : provData.listarProveedor()){
            comboProveedor.addItem(proveedor);
        }
    }
    
    private void cargarComboProducto() {
        comboProducto.removeAllItems();
        
        ProductoData prodData = new ProductoData();

        for(Producto producto : prodData.listarProducto()){
            comboProducto.addItem(producto);
        }
    }
    
    private void cargarTablaConDetalles() {
        for (DetalleCompra detalle : detalleData.listarDetalles()) {
            tableModel.addRow(new Object[]{
                detalle.getIdDetalleCompra(),
                detalle.getCompra().getProveedor(),
                detalle.getCompra().getFecha(),
                detalle.getProducto().getNombreProducto(),
                detalle.getCantidad(),
                detalle.getPrecioCosto()
            });
        }//end for
    }
    
    private void agruparRadioButton() {
        buttonGroup1.add(btnUltimaCompra);
        buttonGroup1.add(btnListarDetalles);
    }
}
