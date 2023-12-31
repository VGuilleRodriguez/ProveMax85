package vista;

import accesoadatos.ProductoData;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MenuVista extends javax.swing.JFrame {
    
    public MenuVista() {
        initComponents();
        listNotificacion.setVisible(false);
        notificacion();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        proveedorVista1 = new vista.ProveedorVista();
        productoVista1 = new vista.ProductoVista();
        compraVista1 = new vista.CompraVista();
        detalleCompraVista1 = new vista.DetalleCompraVista();
        panelSuperior = new javax.swing.JPanel();
        lbNotificaciones = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listNotificacion = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ProveMax");
        setIconImage(new ImageIcon(getClass().getResource("/vista/img/icono.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(237, 230, 219));
        jPanel1.setLayout(new java.awt.BorderLayout());

        tabMenu.setBackground(new java.awt.Color(237, 230, 219));
        tabMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(162, 179, 139)));
        tabMenu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabMenu.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tabMenu.addTab("Proveedores", new javax.swing.ImageIcon(getClass().getResource("/vista/img/usuario.png")), proveedorVista1); // NOI18N
        tabMenu.addTab("Productos", new javax.swing.ImageIcon(getClass().getResource("/vista/img/caja-alt.png")), productoVista1); // NOI18N
        tabMenu.addTab("Compras", new javax.swing.ImageIcon(getClass().getResource("/vista/img/carrito-de-compras.png")), compraVista1); // NOI18N
        tabMenu.addTab("Detalles", new javax.swing.ImageIcon(getClass().getResource("/vista/img/informacion.png")), detalleCompraVista1); // NOI18N

        jPanel1.add(tabMenu, java.awt.BorderLayout.CENTER);

        lbNotificaciones.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        lbNotificaciones.setForeground(new java.awt.Color(255, 255, 255));
        lbNotificaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNotificaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/sobre.png"))); // NOI18N
        lbNotificaciones.setToolTipText("Notificaciones");
        lbNotificaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNotificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNotificacionesMouseClicked(evt);
            }
        });

        jScrollPane2.setBorder(null);

        listNotificacion.setBackground(new java.awt.Color(238, 238, 238));
        listNotificacion.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        listNotificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        listNotificacion.setSelectionBackground(new java.awt.Color(238, 238, 238));
        jScrollPane2.setViewportView(listNotificacion);

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap(633, Short.MAX_VALUE)
                .addComponent(lbNotificaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNotificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel1.add(panelSuperior, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbNotificacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNotificacionesMouseClicked
        notificacion();
        if (listNotificacion.isVisible()) {
            listNotificacion.setVisible(false);
        } else {
            listNotificacion.setVisible(true);
        }
    }//GEN-LAST:event_lbNotificacionesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.CompraVista compraVista1;
    private vista.DetalleCompraVista detalleCompraVista1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JLabel lbNotificaciones;
    private static javax.swing.JList<String> listNotificacion;
    private javax.swing.JPanel panelSuperior;
    private vista.ProductoVista productoVista1;
    private vista.ProveedorVista proveedorVista1;
    private javax.swing.JTabbedPane tabMenu;
    // End of variables declaration//GEN-END:variables

    protected static void notificacion() {
        ProductoData prodData = new ProductoData();
        
        //Cambia el icono si hay notificaciones
        if (prodData.cantidadProducto().size() >= 1) {
            lbNotificaciones.setIcon(new javax.swing.ImageIcon("src/vista/img/punto-de-sobre.png"));
        } else {
            lbNotificaciones.setIcon(new javax.swing.ImageIcon("src/vista/img/sobre.png"));
        }
        
        //Crea un Vector y le asigna la dimension segun el size del ArrayList
        String[] listData = new String[prodData.cantidadProducto().size()];
        
        //Convierte el ArrayList a Vector
        listData = prodData.cantidadProducto().toArray(listData);
        
        listNotificacion.setListData(listData);
    }
}
