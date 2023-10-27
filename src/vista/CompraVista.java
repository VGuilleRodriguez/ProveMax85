package vista;

import accesoadatos.CompraData;
import accesoadatos.DetalleCompraData;
import accesoadatos.ProductoData;
import accesoadatos.ProveedorData;
import entidad.*;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CompraVista extends javax.swing.JPanel {
    
    DefaultTableModel tableModel = new DefaultTableModel(){
        public boolean isCellEditable(int fila, int columna){
            return false;
        }
    };
    
    private double total;
    private ProductoData produData;
    private CompraData compraData;
    private DetalleCompraData detalleData;
    
    DecimalFormat df = new DecimalFormat("###,###,###.##");

    public CompraVista() {
        initComponents();
        produData = new ProductoData();
        compraData = new CompraData();
        detalleData = new DetalleCompraData();
        
        ((JTextField) this.jDateChooserCompra.getDateEditor()).setEditable(false);
        this.jDateChooserCompra.setDate(Date.valueOf(LocalDate.now(ZoneId.systemDefault())));
        
        armarCabecera();
        cargarComboProveedor();
        cargarComboProducto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnEliminarProdu = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnLimpiarTabla = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboProveedor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jDateChooserCompra = new com.toedter.calendar.JDateChooser();
        txtCantidad = new javax.swing.JTextField();
        btnCargar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboProducto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(237, 230, 219));

        btnRegistrar.setBackground(new java.awt.Color(27, 117, 73));
        btnRegistrar.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setMaximumSize(new java.awt.Dimension(150, 32));
        btnRegistrar.setMinimumSize(new java.awt.Dimension(150, 32));
        btnRegistrar.setPreferredSize(new java.awt.Dimension(150, 38));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        table.setBackground(new java.awt.Color(237, 230, 219));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        table.setSelectionBackground(new java.awt.Color(162, 179, 139));
        table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Detalle de Compra");

        btnEliminarProdu.setBackground(new java.awt.Color(193, 4, 4));
        btnEliminarProdu.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnEliminarProdu.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProdu.setText("Eliminar producto");
        btnEliminarProdu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProduActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtTotal.setPreferredSize(new java.awt.Dimension(200, 26));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel6.setText("Total");

        btnLimpiarTabla.setBackground(new java.awt.Color(0, 102, 204));
        btnLimpiarTabla.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnLimpiarTabla.setForeground(java.awt.Color.white);
        btnLimpiarTabla.setText("Limpiar tabla");
        btnLimpiarTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiarTabla.setPreferredSize(new java.awt.Dimension(145, 32));
        btnLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTablaActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(237, 230, 219));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(237, 230, 219));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Proveedor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        comboProveedor.setBackground(new java.awt.Color(237, 230, 219));
        comboProveedor.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        comboProveedor.setPreferredSize(new java.awt.Dimension(32, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 198;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 12, 0, 0);
        jPanel2.add(comboProveedor, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fecha de compra");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        jPanel2.add(jLabel4, gridBagConstraints);

        jDateChooserCompra.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jDateChooserCompra.setMaxSelectableDate(Date.valueOf(LocalDate.now(ZoneId.systemDefault()))
        );
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 213;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        jPanel2.add(jDateChooserCompra, gridBagConstraints);

        txtCantidad.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 151;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 0);
        jPanel2.add(txtCantidad, gridBagConstraints);

        btnCargar.setBackground(new java.awt.Color(255, 204, 102));
        btnCargar.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        btnCargar.setText("Cargar");
        btnCargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargar.setMaximumSize(new java.awt.Dimension(78, 29));
        btnCargar.setMinimumSize(new java.awt.Dimension(78, 29));
        btnCargar.setPreferredSize(new java.awt.Dimension(78, 29));
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 12);
        jPanel2.add(btnCargar, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cantidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 105;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 18, 0, 0);
        jPanel2.add(jLabel5, gridBagConstraints);

        comboProducto.setBackground(new java.awt.Color(237, 230, 219));
        comboProducto.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        comboProducto.setPreferredSize(new java.awt.Dimension(32, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 198;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 12, 0, 0);
        jPanel2.add(comboProducto, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarProdu)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpiarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char caracter = evt.getKeyChar();
        if ((caracter < '0') || (caracter > '9')){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (total == 0 || jDateChooserCompra.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Error al registrar", HEIGHT);
        } else {
            // Se toma los datos para compra
            Proveedor proveedor = (Proveedor)comboProveedor.getSelectedItem();
            LocalDate fecha = jDateChooserCompra.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            // Se instancia una compra con los datos tomados de arriba
            Compra compra = new Compra(proveedor, fecha, total);
            
            // Se manda la compra de arriba a la base de datos
            compraData.nuevaCompra(compra);
            
            /*
             * A la compra creada mas arriba como no tiene id porque solo se le
             * paso dos datos, se busca ese id que se genero automaticamente 
             * en la base de datos con el metodo obtenerUltimaCompra() y se le
             * asigna con el set a la compra anterior, entonces la compra quedaria
             * con todos los datos y se la pasariamos al contructor de detalle
             * Si no se le setea el id a la compra al momento de crear un nuevo
             * detalle en la base de datos tiraria un NullPointerException.
             */
            compra.setIdCompra(compraData.obtenerUltimaCompra());
            
            // Se toma los datos para detalle-compra.
            for (int i = 0; i < table.getRowCount(); i++) {
                int idProducto = (int) table.getValueAt(i, 0);
                Producto producto = produData.buscarProducto(idProducto);
                int cantidad = Integer.parseInt((String) table.getValueAt(i, 2));
                
                // Actualiza el stock de los productos.
                produData.actualizarStock(idProducto, cantidad);
                
                double subtotal = (double) table.getValueAt(i, 4);

                // Se instancia un detalle-compra con los datos anteriores.
                DetalleCompra detalle = new DetalleCompra(cantidad, subtotal, compra, producto);

                // Se manda el detalle-compra a la base de datos.
                detalleData.nuevoDetalleCompra(detalle);
            }
            
            tableModel.setRowCount(0); // Limpia la tabla.
            txtCantidad.setText("");
            txtTotal.setText("");
            MenuVista.notificacion(); // Actualiza las notificaciones.
            DetalleCompraVista.refrescarTablaCompra(); // Actualiza la tabla Compra en la vista DetalleCompra
            DetalleCompraVista.refrescarTablaDetalle(); // Actualiza la tabla Detalle en la vista DetalleCompra
            ProductoVista.refrescarTabla(); // Actualiza la tabla en la vista Producto.
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        Producto produ = (Producto)comboProducto.getSelectedItem();
        try {
            if (txtCantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Indique la cantidad.", "Error al cargar", HEIGHT);
            } else {
                double subtotal = Double.parseDouble(txtCantidad.getText()) * (produ.getPrecioActual());

                tableModel.addRow(new Object[]{
                    produ.getIdProducto(),
                    produ.getNombreProducto(),
                    txtCantidad.getText(),
                    df.format(produ.getPrecioActual()),
                    subtotal
                });

                total += subtotal;
                txtTotal.setText(df.format(total) + "");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "No puede usar caracteres alfabeticos y/o símbolos especiales.", "Error al cargar", HEIGHT);
        } finally {
            txtCantidad.setText("");
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnEliminarProduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProduActionPerformed
        try {
            int row = table.getSelectedRow(); // Guarda la fila seleccionada.

            //Redondea el total a 2 decimales
            total = Math.round(total * 100.0) / 100.0;

            //Resta al total el subtotal de la fila seleccionada
            total -= (double) tableModel.getValueAt(row, 4);

            //El TextField recibe el nuevo total y se formatea con decimales
            txtTotal.setText(df.format(total) + "");
            tableModel.removeRow(row);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningún producto para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarProduActionPerformed

    private void btnLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTablaActionPerformed
        tableModel.setRowCount(0); // Limpia la tabla.
        txtCantidad.setText("");
        txtTotal.setText("");
    }//GEN-LAST:event_btnLimpiarTablaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEliminarProdu;
    private javax.swing.JButton btnLimpiarTabla;
    private javax.swing.JButton btnRegistrar;
    private static javax.swing.JComboBox<Producto> comboProducto;
    private static javax.swing.JComboBox<Proveedor> comboProveedor;
    private com.toedter.calendar.JDateChooser jDateChooserCompra;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera(){
        tableModel.addColumn("CÓDIGO");
        tableModel.addColumn("PRODUCTO");
        tableModel.addColumn("CANTIDAD");
        tableModel.addColumn("PRECIO");
        tableModel.addColumn("SUB-TOTAL");
        table.setModel(tableModel);
    }
    
    protected static void cargarComboProveedor() {
        comboProveedor.removeAllItems(); // Limpia el combo.
        ProveedorData proveData = new ProveedorData();
        for(Proveedor proveedor : proveData.listarProveedor(1)) {
            comboProveedor.addItem(proveedor);
        }
    }
    
    protected static void cargarComboProducto() {
        comboProducto.removeAllItems(); // Limpia el combo.
        ProductoData produData = new ProductoData();
        for(Producto producto : produData.listarProducto(1)) {
            comboProducto.addItem(producto);
        }
    }
}  
