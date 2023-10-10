
package vista.adm;

import accesoadatos.ProductoData;
import accesoadatos.ProveedorData;
import entidad.Producto;
import entidad.Proveedor;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicolas
 */
public class AdmCompra extends javax.swing.JPanel {
    
    private double total;
    
    DecimalFormat df = new DecimalFormat("###,###,###.##");
    
    DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int fila, int columna){
            return false;
        }
    };
            
    public AdmCompra() {
        initComponents();
        armarCabecera();
        cargarComboProveedor();
        cargarComboProducto();
        ((JTextField) this.jDateChooserCompra.getDateEditor()).setEditable(false);
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
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jDateChooserCompra = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jComboProveedor = new javax.swing.JComboBox<>();
        jComboProducto = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCompra = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnEliminarProdu = new javax.swing.JButton();
        txtPrecioTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jbCargar = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar compra", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel1.setText("Código");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 110, -1));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Proveedor");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel3.setText("Producto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel4.setText("Fecha de compra");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 100, -1));

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
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        jDateChooserCompra.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jPanel1.add(jDateChooserCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 240, -1));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel5.setText("Cantidad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        jPanel1.add(jComboProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 230, -1));

        jPanel1.add(jComboProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 230, -1));

        jtCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtCompra);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 770, 140));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Detalle de Compra");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        btnEliminarProdu.setBackground(new java.awt.Color(193, 4, 4));
        btnEliminarProdu.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnEliminarProdu.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProdu.setText("Eliminar Producto");
        btnEliminarProdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProduActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarProdu, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, -1, 40));

        txtPrecioTotal.setEditable(false);
        txtPrecioTotal.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jPanel1.add(txtPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 400, 130, -1));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel6.setText("Total");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, -1, -1));

        jbCargar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbCargar.setText("Cargar");
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 142, 100, 40));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 58;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char caracter = evt.getKeyChar();
        if ((caracter < '0') || (caracter > '9')){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (total == 0 && jDateChooserCompra == null) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Error al registrar", HEIGHT);
        } else {
            //Falta el código
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed

        Producto produ = (Producto)jComboProducto.getSelectedItem();
        
        if (txtCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Indique la cantidad.", "Error al registrar", HEIGHT);
        } else {
            double subtotal = Double.parseDouble(txtCantidad.getText()) * (produ.getPrecioActual());

            modelo.addRow(new Object[]{
                produ.getIdProducto(),
                produ.getNombreProducto(),
                txtCantidad.getText(),
                df.format(produ.getPrecioActual()),
                subtotal
            });
            
            total += subtotal;
            txtPrecioTotal.setText(df.format(total) + "");
            txtCantidad.setText("");
        }
    }//GEN-LAST:event_jbCargarActionPerformed

    private void btnEliminarProduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProduActionPerformed
        try {
            //row: Para guardar la fila seleccionada.
            int row = jtCompra.getSelectedRow();

            //Redondea el total a 2 decimales
            total = Math.round(total * 100.0) / 100.0;

            //Resta al total el subtotal de la fila seleccionada
            total -= (double) modelo.getValueAt(row, 4);

            //El TextField recibe el nuevo total y se formatea con decimales
            txtPrecioTotal.setText(df.format(total) + "");
            modelo.removeRow(row);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningún producto para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarProduActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarProdu;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<Producto> jComboProducto;
    private javax.swing.JComboBox<Proveedor> jComboProveedor;
    private com.toedter.calendar.JDateChooser jDateChooserCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCargar;
    private javax.swing.JTable jtCompra;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtPrecioTotal;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera(){
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO");
        modelo.addColumn("SUB-TOTAL");
        jtCompra.setModel(modelo);
    }
    
    private void cargarComboProveedor(){
    
        ProveedorData proveData = new ProveedorData();
     
        for(Proveedor proveedor : proveData.listarProveedor()){
            jComboProveedor.addItem(proveedor);
        }
    }
    
    private void cargarComboProducto(){
    
        ProductoData produData = new ProductoData();
     
        for(Producto producto : produData.listarProducto()){
            jComboProducto.addItem(producto);
        }
    }
    
     private void limpiarFilas() {
         
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
     
     private void refrescarTabla(){
    
        limpiarFilas();
        ProductoData produData = new ProductoData();
        Producto producto = (Producto) jComboProducto.getSelectedItem();
        List<Producto> lista = new ArrayList<>();
        lista = produData.listarProducto();
        
        for (Producto insc : lista) {
            modelo.addRow(new Object[]{
                insc.getIdProducto(),
                insc.getNombreProducto(),
                txtCantidad.getText(),
            });
        }
    }
}  
