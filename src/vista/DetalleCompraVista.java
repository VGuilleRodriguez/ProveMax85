package vista;

import accesoadatos.CompraData;
import accesoadatos.DetalleCompraData;
import accesoadatos.ProductoData;
import accesoadatos.ProveedorData;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import entidad.Compra;
import entidad.DetalleCompra;
import entidad.Producto;
import entidad.Proveedor;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class DetalleCompraVista extends javax.swing.JPanel {
    
    private static DefaultTableModel tableModelCompra = new DefaultTableModel() {
        public boolean isCellEditable(int r, int c) {
            return false;
        }
    };
    
    private static DefaultTableModel tableModelDetalle = new DefaultTableModel() {
        public boolean isCellEditable(int r, int c) {
            return false;
        }
    };
    
    private CompraData compraData;
    private DetalleCompraData detalleData;
    private DateChooser dateChooserCompra, dateChooserDetalle;
    private String fechaDesde, fechaHasta;
    
    public DetalleCompraVista() {
        initComponents();
        compraData = new CompraData();
        detalleData = new DetalleCompraData();
        dateChooserCompra = new DateChooser();
        dateChooserDetalle = new DateChooser();
        
        // Se toma un TextField y se lo asigna como un DateChooser.
        dateChooserCompra.setTextField(txtDateCompra);
        dateChooserDetalle.setTextField(txtDateDetalle);
        
        // Este método dice que el tipo de selección es entre dos fechas.
        dateChooserCompra.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        dateChooserDetalle.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        
        // Este método quita un texto que muestra el día actual.
        dateChooserCompra.setLabelCurrentDayVisible(false);
        dateChooserDetalle.setLabelCurrentDayVisible(false);
        
        // El siguiente método lee el evento del calendario al seleccionar las fechas.
        // Y luego carga la tabla con las fechas seleccionadas.
        dateChooserCompra.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween fecha, DateChooserAction action) {
                
                // Se cambia el formato de las fechas para que la base de datos las entienda.
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                fechaDesde = df.format(fecha.getFromDate());
                fechaHasta = df.format(fecha.getToDate());
                
                tableModelCompra.setRowCount(0); // Se limpia la tabla cada vez que una fecha fue seleccionada.
                
                buttonGroupCompra.clearSelection(); // Se deseleccionan los bótones de compra.
                
                // Se carga la tabla con las fechas nuevas seleccionadas.
                for (Compra compra : compraData.listarEntreFechas(fechaDesde, fechaHasta)) {
                    tableModelCompra.addRow(new Object[]{
                        compra.getIdCompra(),
                        compra.getProveedor(),
                        compra.getFecha(),
                        compra.getTotal()
                    });
                }//end for
            }//end dateBetweenChaged metod
        });//end addActionDateChooserListener
        
        dateChooserDetalle.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween fecha, DateChooserAction action) {
                
                // Se cambia el formato de las fechas para que la base de datos las entienda.
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                fechaDesde = df.format(fecha.getFromDate());
                fechaHasta = df.format(fecha.getToDate());
                
                tableModelDetalle.setRowCount(0); // Se limpia la tabla cada vez que una fecha fue seleccionada.
                
                buttonGroupDetalle.clearSelection(); // Se deseleccionan los bótones de detalle.
                
                // Se carga la tabla con las fechas nuevas seleccionadas.
                for (DetalleCompra detalle : detalleData.listarEntreFechas(fechaDesde, fechaHasta)) {
                    tableModelDetalle.addRow(new Object[]{
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
        refrescarTablaCompra();
        refrescarTablaDetalle();
        agruparRadioButton();
        cargarComboProveedor();
        cargarComboProducto();
    }//end constructor

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCompra = new javax.swing.ButtonGroup();
        buttonGroupDetalle = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCompra = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtDateCompra = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnBuscarProveedor = new javax.swing.JLabel();
        comboProveedor = new javax.swing.JComboBox<>();
        btnListarCompras = new javax.swing.JRadioButton();
        btnUltimaCompra = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        txtDateDetalle = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        comboProducto = new javax.swing.JComboBox<>();
        btnBuscarProducto = new javax.swing.JLabel();
        btnListarDetalles = new javax.swing.JRadioButton();
        btnUltimoDetalleCompra = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(237, 230, 219));

        tableCompra.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        tableCompra.getTableHeader().setReorderingAllowed(false);
        tableCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableCompraMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableCompra);

        tableDetalle.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        tableDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDetalle.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableDetalle);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Compras realizadas");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("Detalle de las compras");

        jSeparator4.setBackground(new java.awt.Color(237, 230, 219));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(162, 179, 139));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel5.setBackground(new java.awt.Color(162, 179, 139));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar compra por fecha", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        txtDateCompra.setBackground(new java.awt.Color(162, 179, 139));
        txtDateCompra.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtDateCompra.setForeground(new java.awt.Color(255, 255, 255));
        txtDateCompra.setBorder(null);
        txtDateCompra.setPreferredSize(new java.awt.Dimension(326, 28));

        jSeparator3.setBackground(new java.awt.Color(162, 179, 139));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setPreferredSize(new java.awt.Dimension(326, 6));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDateCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(txtDateCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(162, 179, 139));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar compra por proveedor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/busqueda_mini.png"))); // NOI18N
        btnBuscarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarProveedorMouseClicked(evt);
            }
        });

        comboProveedor.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N

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

        btnListarCompras.setBackground(new java.awt.Color(162, 179, 139));
        btnListarCompras.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnListarCompras.setForeground(new java.awt.Color(255, 255, 255));
        btnListarCompras.setSelected(true);
        btnListarCompras.setText("Mostrar todas las compras");
        btnListarCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarComprasActionPerformed(evt);
            }
        });

        btnUltimaCompra.setBackground(new java.awt.Color(162, 179, 139));
        btnUltimaCompra.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnUltimaCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnUltimaCompra.setText("Mostrar mi última compra");
        btnUltimaCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUltimaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimaCompraActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(162, 179, 139));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar detalle por fecha", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        txtDateDetalle.setBackground(new java.awt.Color(162, 179, 139));
        txtDateDetalle.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtDateDetalle.setForeground(new java.awt.Color(255, 255, 255));
        txtDateDetalle.setBorder(null);
        txtDateDetalle.setPreferredSize(new java.awt.Dimension(326, 28));

        jSeparator2.setBackground(new java.awt.Color(162, 179, 139));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setPreferredSize(new java.awt.Dimension(326, 6));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDateDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(txtDateDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(162, 179, 139));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar detalle por producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        comboProducto.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N

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

        btnListarDetalles.setBackground(new java.awt.Color(162, 179, 139));
        btnListarDetalles.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnListarDetalles.setForeground(new java.awt.Color(255, 255, 255));
        btnListarDetalles.setSelected(true);
        btnListarDetalles.setText("Mostrar detalle de todas las compras");
        btnListarDetalles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListarDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarDetallesActionPerformed(evt);
            }
        });

        btnUltimoDetalleCompra.setBackground(new java.awt.Color(162, 179, 139));
        btnUltimoDetalleCompra.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnUltimoDetalleCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnUltimoDetalleCompra.setText("Mostrar detalle de mi última compra");
        btnUltimoDetalleCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUltimoDetalleCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoDetalleCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListarCompras)
                    .addComponent(btnUltimaCompra)
                    .addComponent(btnListarDetalles)
                    .addComponent(btnUltimoDetalleCompra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListarCompras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUltimaCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListarDetalles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUltimoDetalleCompra)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(297, 297, 297))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(276, 276, 276))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarProveedorMouseClicked
        tableModelCompra.setRowCount(0); // Limpia la tabla.
        buttonGroupCompra.clearSelection(); // Deselecciona los radio button de compra.
        
        for (Compra compra : compraData.listarPorProveedor((Proveedor) comboProveedor.getSelectedItem())) {
            tableModelCompra.addRow(new Object[]{
                compra.getIdCompra(),
                compra.getProveedor().getRazonSocial(),
                compra.getFecha(),
                compra.getTotal()
            });
        }//end for
    }//GEN-LAST:event_btnBuscarProveedorMouseClicked

    private void btnBuscarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarProductoMouseClicked
        tableModelDetalle.setRowCount(0); // Limpia la tabla.
        buttonGroupDetalle.clearSelection(); // Deselecciona los radio button de detalle.
        
        for (DetalleCompra detalle : detalleData.listarPorProducto((Producto) comboProducto.getSelectedItem())) {
            tableModelDetalle.addRow(new Object[]{
                detalle.getIdDetalleCompra(),
                detalle.getCompra().getProveedor(),
                detalle.getCompra().getFecha(),
                detalle.getProducto().getNombreProducto(),
                detalle.getCantidad(),
                detalle.getPrecioCosto()
            });
        }//end for
    }//GEN-LAST:event_btnBuscarProductoMouseClicked

    private void btnUltimoDetalleCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoDetalleCompraActionPerformed
        tableModelDetalle.setRowCount(0); // Limpia la tabla.
        
        if (btnUltimoDetalleCompra.isSelected()) {
            for (DetalleCompra detalle : detalleData.obtenerUltimaCompra()) {
                tableModelDetalle.addRow(new Object[]{
                    detalle.getIdDetalleCompra(),
                    detalle.getCompra().getProveedor(),
                    detalle.getCompra().getFecha(),
                    detalle.getProducto().getNombreProducto(),
                    detalle.getCantidad(),
                    detalle.getPrecioCosto()
                });
            }//end for
        }
    }//GEN-LAST:event_btnUltimoDetalleCompraActionPerformed

    private void btnListarDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarDetallesActionPerformed
        tableModelDetalle.setRowCount(0); // Limpia la tabla.
        
        if (btnListarDetalles.isSelected()) {
            refrescarTablaDetalle();
        }
    }//GEN-LAST:event_btnListarDetallesActionPerformed

    private void tableCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCompraMousePressed
        int seleccionar = tableCompra.getSelectedRow();
        int idCompra = (int) tableCompra.getValueAt(seleccionar, 0);
        
        if (seleccionar != -1) {
            tableModelDetalle.setRowCount(0);
            for (DetalleCompra detalle : detalleData.listarDetallesPorIdCompra(idCompra)) {
                tableModelDetalle.addRow(new Object[]{
                    detalle.getIdDetalleCompra(),
                    detalle.getCompra().getProveedor(),
                    detalle.getCompra().getFecha(),
                    detalle.getProducto().getNombreProducto(),
                    detalle.getCantidad(),
                    detalle.getPrecioCosto()
                });
            }//end for
        }//end if
    }//GEN-LAST:event_tableCompraMousePressed

    private void btnListarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarComprasActionPerformed
        tableModelCompra.setRowCount(0); // Limpia la tabla.
        
        if (btnListarCompras.isSelected()) {
            refrescarTablaCompra();
        }
    }//GEN-LAST:event_btnListarComprasActionPerformed

    private void btnUltimaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimaCompraActionPerformed
        tableModelCompra.setRowCount(0); // Limpia la tabla.
        
        if (btnUltimaCompra.isSelected()) {
            Compra compra = compraData.buscarCompra(compraData.obtenerUltimaCompra());
            tableModelCompra.addRow(new Object[]{
                compra.getIdCompra(),
                compra.getProveedor().getRazonSocial(),
                compra.getFecha(),
                compra.getTotal()
            });
        }
    }//GEN-LAST:event_btnUltimaCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscarProducto;
    private javax.swing.JLabel btnBuscarProveedor;
    private javax.swing.JRadioButton btnListarCompras;
    private javax.swing.JRadioButton btnListarDetalles;
    private javax.swing.JRadioButton btnUltimaCompra;
    private javax.swing.JRadioButton btnUltimoDetalleCompra;
    private javax.swing.ButtonGroup buttonGroupCompra;
    private javax.swing.ButtonGroup buttonGroupDetalle;
    private static javax.swing.JComboBox<Producto> comboProducto;
    private static javax.swing.JComboBox<Proveedor> comboProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tableCompra;
    private javax.swing.JTable tableDetalle;
    private javax.swing.JTextField txtDateCompra;
    private javax.swing.JTextField txtDateDetalle;
    // End of variables declaration//GEN-END:variables

    private void cargarModeloTabla() {
        tableModelDetalle.addColumn("CÓDIGO");
        tableModelDetalle.addColumn("PROVEEDOR");
        tableModelDetalle.addColumn("FECHA");
        tableModelDetalle.addColumn("PRODUCTO");
        tableModelDetalle.addColumn("CANTIDAD");
        tableModelDetalle.addColumn("PRECIO COSTO");
        tableDetalle.setModel(tableModelDetalle);
        
        tableModelCompra.addColumn("CÓDIGO");
        tableModelCompra.addColumn("PROVEEDOR");
        tableModelCompra.addColumn("FECHA");
        tableModelCompra.addColumn("TOTAL");
        tableCompra.setModel(tableModelCompra);
    }

    protected static void refrescarTablaCompra() {
        tableModelCompra.setRowCount(0); // Limpia la tabla.
        CompraData compraData = new CompraData();
        
        for (Compra compra : compraData.listarCompras()) {
            tableModelCompra.addRow(new Object[]{
                compra.getIdCompra(),
                compra.getProveedor().getRazonSocial(),
                compra.getFecha(),
                compra.getTotal()
            });
        }//end for
    }
    
    protected static void refrescarTablaDetalle() {
        tableModelDetalle.setRowCount(0); // Limpia la tabla.
        DetalleCompraData detalleData = new DetalleCompraData();
        
        for (DetalleCompra detalle : detalleData.listarDetalles()) {
            tableModelDetalle.addRow(new Object[]{
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
        buttonGroupCompra.add(btnUltimaCompra);
        buttonGroupCompra.add(btnListarCompras);
        
        buttonGroupDetalle.add(btnUltimoDetalleCompra);
        buttonGroupDetalle.add(btnListarDetalles);
    }
    
    protected static void cargarComboProveedor() {
        comboProveedor.removeAllItems(); // Limpia el combo.
        ProveedorData proveData = new ProveedorData();
        
        for(Proveedor proveedor : proveData.listarProveedor(2)){
            comboProveedor.addItem(proveedor);
        }
    }
    
    protected static void cargarComboProducto() {
        comboProducto.removeAllItems(); // Limpia el combo.
        ProductoData produData = new ProductoData();
        
        for(Producto producto : produData.listarProducto(2)) {
            comboProducto.addItem(producto);
        }
    }
}//end class
