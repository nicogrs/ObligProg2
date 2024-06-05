package interfaz; // Nicolas Rodriguez y Manuel Ackerman

import dominio.Producto;
import dominio.Sistema;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import utilidades.Utilidades;

public class VentanaConsultaProducto extends javax.swing.JFrame implements PropertyChangeListener {
    
    public VentanaConsultaProducto(Sistema modelo) {
        this.modelo = modelo;
        modelo.addPropertyChangeListener(this);
        this.indice = 0;
        initComponents();
        this.modelo.getListaProductos().sort(null);
        ImageIcon icon = new ImageIcon("icono.png");
        this.setIconImage(icon.getImage());
        setLocationRelativeTo(null); //Centra ventana
        this.comboTipo.addItem("Fruta");
        this.comboTipo.addItem("Verdura");
        this.comboVentaPor.addItem("Kilogramo");
        this.comboVentaPor.addItem("Unidad");
        this.comboVentaPor.setSelectedItem(null);
        this.comboTipo.setSelectedItem(null);
        
        cargar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelConsultaProducto = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblVentaPor = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        fieldDescripcion = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox<>();
        btnIzquierda = new javax.swing.JButton();
        btnDerecha = new javax.swing.JButton();
        lblInfoProducto = new javax.swing.JLabel();
        lblTotalVendido1 = new javax.swing.JLabel();
        lblTotalComprado1 = new javax.swing.JLabel();
        lblCantidadVendida1 = new javax.swing.JLabel();
        lblCantidadComprada1 = new javax.swing.JLabel();
        lblPrecioMinimo1 = new javax.swing.JLabel();
        lblPrecioMaximo1 = new javax.swing.JLabel();
        lblVentaMinima = new javax.swing.JLabel();
        lblVentaMaxima = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPrecioMaximo = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPrecioMinimo = new javax.swing.JList();
        comboVentaPor = new javax.swing.JComboBox<>();
        lblImagenProd = new javax.swing.JLabel();
        lblTotalComprado = new javax.swing.JLabel();
        lblTotalVendido = new javax.swing.JLabel();
        lblCantidadVendida = new javax.swing.JLabel();
        lblCantidadComprada = new javax.swing.JLabel();
        lblPrecioMinimo = new javax.swing.JLabel();
        lblPrecioMaximo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta producto - Mercado");
        setResizable(false);

        jPanelConsultaProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setText("Nombre:");
        jPanelConsultaProducto.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 57, 69, -1));

        lblDescripcion.setText("Descripcion:");
        jPanelConsultaProducto.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 97, -1, -1));

        lblTipo.setText("Tipo:");
        jPanelConsultaProducto.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 151, 69, -1));

        lblVentaPor.setText("Venta por:");
        jPanelConsultaProducto.add(lblVentaPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 191, 69, -1));

        fieldNombre.setEnabled(false);
        jPanelConsultaProducto.add(fieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 51, 142, -1));

        fieldDescripcion.setEnabled(false);
        jPanelConsultaProducto.add(fieldDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 91, 142, -1));

        comboTipo.setEnabled(false);
        jPanelConsultaProducto.add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 146, 142, -1));

        btnIzquierda.setText("<");
        btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzquierdaActionPerformed(evt);
            }
        });
        jPanelConsultaProducto.add(btnIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 344, 47, 35));

        btnDerecha.setText(">");
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerechaActionPerformed(evt);
            }
        });
        jPanelConsultaProducto.add(btnDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 344, 47, 35));

        lblInfoProducto.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblInfoProducto.setText("Informacion del producto:");
        jPanelConsultaProducto.add(lblInfoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 27, -1, -1));

        lblTotalVendido1.setText("Total $ vendido entre todos los puestos:");
        jPanelConsultaProducto.add(lblTotalVendido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 69, -1, -1));

        lblTotalComprado1.setText("Total $ comprado por todos los puestos:");
        jPanelConsultaProducto.add(lblTotalComprado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 97, -1, -1));

        lblCantidadVendida1.setText("Cantidad total vendida entre todos los puestos (unidad/kilo):");
        jPanelConsultaProducto.add(lblCantidadVendida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 125, -1, -1));

        lblCantidadComprada1.setText("Cantidad total comprada entre todos los puestos (unidad/kilo):");
        jPanelConsultaProducto.add(lblCantidadComprada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 153, -1, -1));

        lblPrecioMinimo1.setText("Precio mínimo vendido:");
        jPanelConsultaProducto.add(lblPrecioMinimo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 178, -1, -1));

        lblPrecioMaximo1.setText("Precio máximo vendido:");
        jPanelConsultaProducto.add(lblPrecioMaximo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 178, -1, -1));

        lblVentaMinima.setText("Puestos con el precio de venta mínimo:");
        jPanelConsultaProducto.add(lblVentaMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 212, 262, -1));

        lblVentaMaxima.setText("Puestos con el precio de venta máximo:");
        jPanelConsultaProducto.add(lblVentaMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 212, -1, -1));

        listaPrecioMaximo.setPreferredSize(new java.awt.Dimension(270, 140));
        jScrollPane1.setViewportView(listaPrecioMaximo);

        jPanelConsultaProducto.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, -1, 139));

        listaPrecioMinimo.setPreferredSize(new java.awt.Dimension(270, 140));
        jScrollPane2.setViewportView(listaPrecioMinimo);

        jPanelConsultaProducto.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, 139));

        comboVentaPor.setEnabled(false);
        comboVentaPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVentaPorActionPerformed(evt);
            }
        });
        jPanelConsultaProducto.add(comboVentaPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 186, 142, -1));
        jPanelConsultaProducto.add(lblImagenProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 255, 167, 143));

        lblTotalComprado.setText("--- --- --");
        jPanelConsultaProducto.add(lblTotalComprado, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 97, -1, -1));

        lblTotalVendido.setText("--- --- --");
        jPanelConsultaProducto.add(lblTotalVendido, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 69, -1, -1));

        lblCantidadVendida.setText("--- --- --");
        jPanelConsultaProducto.add(lblCantidadVendida, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 125, -1, -1));

        lblCantidadComprada.setText("--- --- --");
        jPanelConsultaProducto.add(lblCantidadComprada, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 153, -1, -1));

        lblPrecioMinimo.setText("--- --- --");
        jPanelConsultaProducto.add(lblPrecioMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 178, -1, -1));

        lblPrecioMaximo.setText("--- --- --");
        jPanelConsultaProducto.add(lblPrecioMaximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 178, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConsultaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConsultaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1028, 463);
    }// </editor-fold>//GEN-END:initComponents

    private void comboVentaPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVentaPorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboVentaPorActionPerformed

    private void btnDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerechaActionPerformed
        if (this.indice + 1 < modelo.getListaProductos().size()) {
            this.indice++;
            cargar();
        } else {
            this.indice = 0;
            cargar();
        }

    }//GEN-LAST:event_btnDerechaActionPerformed

    private void btnIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzquierdaActionPerformed
        if (this.indice - 1 >= 0) {
            this.indice--;
            cargar();
        } else {
            this.indice = modelo.getListaProductos().size() - 1;
            cargar();
        }
    }//GEN-LAST:event_btnIzquierdaActionPerformed
    
    private void cargar() {
        if (modelo.getListaProductos().size() > 0 && indice >= 0 && indice < modelo.getListaProductos().size()) {
            Producto prod = modelo.getListaProductos().get(indice);
            String nombreProducto = prod.getNombre();
            this.fieldNombre.setText(nombreProducto);
            this.fieldDescripcion.setText(prod.getDescripcion());
            String tipoProducto = prod.getTipoProducto();
            this.comboTipo.setSelectedItem(tipoProducto);
            this.comboVentaPor.setSelectedItem(prod.getFormaVenta());
            String rutaImagen = "ImagenesOblig\\" + prod.getRutaImagen();
            this.lblImagenProd.setIcon(new ImageIcon(new ImageIcon(rutaImagen).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
            if (modelo.hayMovimientos()) {
                this.cargarInformacionProducto(prod);
            }
        }
    }
    
    private void cargarInformacionProducto(Producto prod) {
        String nombreProducto = prod.getNombre();
        //Falta validar si de ese producto solo hay o ventas o compras
        this.lblTotalVendido.setText("" + modelo.precioTotalXProducto(nombreProducto, "Venta")); //Esta hardcoded el tipo de movimiento
        this.lblTotalComprado.setText("" + modelo.precioTotalXProducto(nombreProducto, "Compra")); // FEOOO????
        int cantidadVendida = modelo.cantidadTotalXProducto(nombreProducto, "Venta");
        this.lblCantidadVendida.setText("" + cantidadVendida + " - Tipo venta: " + Utilidades.devolverTipoVentaAMostrar(prod.getFormaVenta(), 1)); // Se setea en 1 para utilizar la version -->
        int cantidadComprada = modelo.cantidadTotalXProducto(nombreProducto, "Compra");
        this.lblCantidadComprada.setText("" + cantidadComprada + " - Tipo venta: " + Utilidades.devolverTipoVentaAMostrar(prod.getFormaVenta(), 1)); // --> en singular del tipo venta
        
        int precioVentaMin = modelo.getPrecioVentaMinXProducto(nombreProducto);
        this.lblPrecioMinimo.setText("" + precioVentaMin);
        this.listaPrecioMinimo.setListData(modelo.getPuestosXPrecioYProducto(nombreProducto, precioVentaMin, "Venta").toArray());
        
        int precioVentaMax = modelo.getPrecioVentaMaxXProducto(nombreProducto);
        this.lblPrecioMaximo.setText("" + precioVentaMax);
        this.listaPrecioMaximo.setListData(modelo.getPuestosXPrecioYProducto(nombreProducto, precioVentaMax, "Venta").toArray());
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        cargar();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JComboBox<String> comboVentaPor;
    private javax.swing.JTextField fieldDescripcion;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JPanel jPanelConsultaProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCantidadComprada;
    private javax.swing.JLabel lblCantidadComprada1;
    private javax.swing.JLabel lblCantidadVendida;
    private javax.swing.JLabel lblCantidadVendida1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblImagenProd;
    private javax.swing.JLabel lblInfoProducto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecioMaximo;
    private javax.swing.JLabel lblPrecioMaximo1;
    private javax.swing.JLabel lblPrecioMinimo;
    private javax.swing.JLabel lblPrecioMinimo1;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTotalComprado;
    private javax.swing.JLabel lblTotalComprado1;
    private javax.swing.JLabel lblTotalVendido;
    private javax.swing.JLabel lblTotalVendido1;
    private javax.swing.JLabel lblVentaMaxima;
    private javax.swing.JLabel lblVentaMinima;
    private javax.swing.JLabel lblVentaPor;
    private javax.swing.JList listaPrecioMaximo;
    private javax.swing.JList listaPrecioMinimo;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private int indice;
} // Nicolas Rodriguez y Manuel Ackerman
