
package vistas;

import vista.adm.AdmProducto;
import vista.adm.AdmProveedor;
import vista.tabla.TablaProducto;
import vista.tabla.TablaProveedor;

/**
 *
 * @author nicolas
 */
public class MenuView extends javax.swing.JFrame {
    
    /**
     * Creates new form Menu
     */
    public MenuView() {
        initComponents();
        cargarAdm();
        cargarTablas();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabMenu = new javax.swing.JTabbedPane();
        menuProveedores = new javax.swing.JPanel();
        tabProveedor = new javax.swing.JTabbedPane();
        tabAdministrarProveedores = new javax.swing.JPanel();
        tabTablaProveedores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        menuCompras = new javax.swing.JPanel();
        menuProductos = new javax.swing.JPanel();
        tabProducto = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbFechaHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabMenu.setBackground(new java.awt.Color(255, 255, 255));
        tabMenu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabMenu.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        menuProveedores.setBackground(new java.awt.Color(255, 255, 255));
        menuProveedores.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N

        tabProveedor.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tabAdministrarProveedoresLayout = new javax.swing.GroupLayout(tabAdministrarProveedores);
        tabAdministrarProveedores.setLayout(tabAdministrarProveedoresLayout);
        tabAdministrarProveedoresLayout.setHorizontalGroup(
            tabAdministrarProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        tabAdministrarProveedoresLayout.setVerticalGroup(
            tabAdministrarProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        tabProveedor.addTab("Administrar", tabAdministrarProveedores);

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaProveedores);

        javax.swing.GroupLayout tabTablaProveedoresLayout = new javax.swing.GroupLayout(tabTablaProveedores);
        tabTablaProveedores.setLayout(tabTablaProveedoresLayout);
        tabTablaProveedoresLayout.setHorizontalGroup(
            tabTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
        );
        tabTablaProveedoresLayout.setVerticalGroup(
            tabTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        tabProveedor.addTab("Vista proveedores", tabTablaProveedores);

        javax.swing.GroupLayout menuProveedoresLayout = new javax.swing.GroupLayout(menuProveedores);
        menuProveedores.setLayout(menuProveedoresLayout);
        menuProveedoresLayout.setHorizontalGroup(
            menuProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabProveedor)
        );
        menuProveedoresLayout.setVerticalGroup(
            menuProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabProveedor)
        );

        tabMenu.addTab("Proveedores", new javax.swing.ImageIcon(getClass().getResource("/vista/img/usuario.png")), menuProveedores); // NOI18N

        menuCompras.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout menuComprasLayout = new javax.swing.GroupLayout(menuCompras);
        menuCompras.setLayout(menuComprasLayout);
        menuComprasLayout.setHorizontalGroup(
            menuComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        menuComprasLayout.setVerticalGroup(
            menuComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        tabMenu.addTab("Compras", new javax.swing.ImageIcon(getClass().getResource("/vista/img/carrito-de-compras.png")), menuCompras); // NOI18N

        menuProductos.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        tabProducto.addTab("Administrar", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        tabProducto.addTab("Vista productos", jPanel2);

        javax.swing.GroupLayout menuProductosLayout = new javax.swing.GroupLayout(menuProductos);
        menuProductos.setLayout(menuProductosLayout);
        menuProductosLayout.setHorizontalGroup(
            menuProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabProducto)
        );
        menuProductosLayout.setVerticalGroup(
            menuProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabProducto)
        );

        tabMenu.addTab("Productos", new javax.swing.ImageIcon(getClass().getResource("/vista/img/caja-alt.png")), menuProductos); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(51, 153, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(154, 75));

        jLabel1.setFont(new java.awt.Font("Manjari Thin", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ProveMax");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(124, 15));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lbFechaHora.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbFechaHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFechaHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/sobre.png"))); // NOI18N
        lbFechaHora.setText("Notificaciones");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbFechaHora)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMenu)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabMenu))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFechaHora;
    private javax.swing.JPanel menuCompras;
    private javax.swing.JPanel menuProductos;
    private javax.swing.JPanel menuProveedores;
    private javax.swing.JPanel tabAdministrarProveedores;
    private javax.swing.JTabbedPane tabMenu;
    private javax.swing.JTabbedPane tabProducto;
    private javax.swing.JTabbedPane tabProveedor;
    private javax.swing.JPanel tabTablaProveedores;
    private javax.swing.JTable tablaProveedores;
    // End of variables declaration//GEN-END:variables

    private void cargarTablas() {
        TablaProveedor tablaprov = new TablaProveedor();
        tabProveedor.setComponentAt(1, tablaprov);
        
        TablaProducto tablaprod = new TablaProducto();
        tabProducto.setComponentAt(1, tablaprod);
        
        
    }
    
    private void cargarAdm() {
        AdmProducto admprod = new AdmProducto();
        tabProducto.setComponentAt(0, admprod);
        
        AdmProveedor admprov = new AdmProveedor();
        tabProveedor.setComponentAt(0, admprov);
    }
}