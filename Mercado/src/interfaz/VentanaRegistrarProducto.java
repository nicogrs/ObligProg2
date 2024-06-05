package interfaz; // Nicolas Rodriguez y Manuel Ackerman
import dominio.Sistema;
import java.awt.Image;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import utilidades.Utilidades;

public class VentanaRegistrarProducto extends javax.swing.JFrame {
    
    private Utilidades util;
    
    public VentanaRegistrarProducto(Sistema sis) {
        this.modelo = sis;
        this.util = new Utilidades();
        this.cambiarIdiomaAEspañol(); //Cambia idioma del fileChooser a español
        initComponents();
        ImageIcon icon = new ImageIcon("icono.png");
        this.setIconImage(icon.getImage());
        setLocationRelativeTo(null); //Centra ventana
        lblImagen.setIcon(new ImageIcon("ImagenesOblig\\iconoSeleccionarImagen.jpg"));
        buscadorArchivos.setAcceptAllFileFilterUsed(false); // Quita filtro "All Files"
        lblReingresoNombre.setVisible(false);
    }

    public void reset() {
        fieldDescripcion.setText("");
        fieldNombre.setText("");
        lblImagen.setIcon(new ImageIcon("ImagenesOblig\\iconoSeleccionarImagen.jpg"));
        buscadorArchivos.setSelectedFile(new File("ImagenesOblig\\iconoSeleccionarImagen.jpg")); // Resetea el archivo seleccionado
        comboTipo.setSelectedIndex(0);
        comboVenta.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRegistrarProducto = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        buscadorArchivos = new javax.swing.JFileChooser();
        lblSeleccionarImagen = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblVentaPor = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        fieldDescripcion = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox<>();
        comboVenta = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        btnAltaProducto = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblImagen = new javax.swing.JLabel();
        lblReingresoNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar producto - Mercado");
        setResizable(false);
        getContentPane().setLayout(null);

        lblNombre.setText("Nombre:");

        buscadorArchivos.setCurrentDirectory(new File("ImagenesOblig"));
        buscadorArchivos.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png"));
        buscadorArchivos.setName(""); // NOI18N
        buscadorArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorArchivosActionPerformed(evt);
            }
        });

        lblSeleccionarImagen.setText("Seleccionar imagen");

        lblDescripcion.setText("Descripcion:");

        lblTipo.setText("Tipo:");

        lblVentaPor.setText("Venta por:");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fruta", "Verdura" }));

        comboVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilogramo", "Unidad" }));
        comboVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVentaActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnAltaProducto.setText("Alta producto");
        btnAltaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaProductoActionPerformed(evt);
            }
        });

        lblReingresoNombre.setForeground(new java.awt.Color(255, 0, 0));
        lblReingresoNombre.setText("* Reingrese el nombre");

        javax.swing.GroupLayout jPanelRegistrarProductoLayout = new javax.swing.GroupLayout(jPanelRegistrarProducto);
        jPanelRegistrarProducto.setLayout(jPanelRegistrarProductoLayout);
        jPanelRegistrarProductoLayout.setHorizontalGroup(
            jPanelRegistrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarProductoLayout.createSequentialGroup()
                .addGroup(jPanelRegistrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrarProductoLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrarProductoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelRegistrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAltaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(jPanelRegistrarProductoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanelRegistrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblVentaPor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRegistrarProductoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblReingresoNombre)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(fieldNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboVenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldDescripcion, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addComponent(buscadorArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelRegistrarProductoLayout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(lblSeleccionarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRegistrarProductoLayout.setVerticalGroup(
            jPanelRegistrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarProductoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblSeleccionarImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegistrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscadorArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanelRegistrarProductoLayout.createSequentialGroup()
                        .addGroup(jPanelRegistrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(lblReingresoNombre)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelRegistrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescripcion)
                            .addComponent(fieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanelRegistrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipo)
                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanelRegistrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVentaPor)
                            .addComponent(comboVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelRegistrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRegistrarProductoLayout.createSequentialGroup()
                                .addComponent(btnReset)
                                .addGap(18, 18, 18)
                                .addComponent(btnAltaProducto))
                            .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );

        getContentPane().add(jPanelRegistrarProducto);
        jPanelRegistrarProducto.setBounds(0, 0, 802, 381);

        setBounds(0, 0, 825, 460);
    }// </editor-fold>//GEN-END:initComponents
    
    private void cambiarIdiomaAEspañol(){ //Cambia manualmente el idioma de los componentes del JFileChooser
        UIManager.put("FileChooser.openDialogTitleText", "Abrir archivo"); 
        UIManager.put("FileChooser.saveDialogTitleText", "Guardar archivo"); 
        UIManager.put("FileChooser.lookInLabelText", "Buscar en:"); 
        UIManager.put("FileChooser.saveInLabelText", "Guardar en:"); 
        UIManager.put("FileChooser.fileNameLabelText", "Nombre de archivo:"); 
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo de archivo:"); 
        UIManager.put("FileChooser.openButtonText", "Abrir"); 
        UIManager.put("FileChooser.saveButtonText", "Guardar"); 
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        // VER DE CAMBIAR EL HOVER DE LOS BOTONES
    }
    
    private void buscadorArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorArchivosActionPerformed
        File archivo = buscadorArchivos.getSelectedFile();
        if (archivo != null) {
            if (evt.getActionCommand().equals(javax.swing.JFileChooser.APPROVE_SELECTION)) {
                ImageIcon imagenIcono = new ImageIcon(archivo.toString());
                Icon icono = new ImageIcon(imagenIcono.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
                lblImagen.setIcon(icono);
            }
            if (evt.getActionCommand().equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
                String rutaImagen = "ImagenesOblig\\iconoSeleccionarImagen.jpg";
                ImageIcon imagenIcono = new ImageIcon(rutaImagen);
                Icon icono = new ImageIcon(imagenIcono.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
                lblImagen.setIcon(icono);
                buscadorArchivos.setSelectedFile(new File("ImagenesOblig\\iconoSeleccionarImagen.jpg")); // Resetea el archivo seleccionado
            }
        } else {
            String rutaImagen = "ImagenesOblig\\iconoSeleccionarImagen.jpg";
            ImageIcon imagenIcono = new ImageIcon(rutaImagen);
            Icon icono = new ImageIcon(imagenIcono.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(icono);
            buscadorArchivos.setSelectedFile(new File("ImagenesOblig\\iconoSeleccionarImagen.jpg")); // Resetea el archivo seleccionado
        }
    }//GEN-LAST:event_buscadorArchivosActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        this.reset();
        this.btnReset.setSelected(false);
    }//GEN-LAST:event_btnResetActionPerformed

    private void comboVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboVentaActionPerformed

    private void btnAltaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaProductoActionPerformed
        fieldNombre.setBorder(BorderFactory.createLineBorder(util.COLOR_NEGRO)); //Setea color de borde a negro
        lblReingresoNombre.setVisible(false); //Oculta label de reeingreso
        String nombre = fieldNombre.getText();
        String descripcion = fieldDescripcion.getText();
        String tipoProducto = (String) comboTipo.getSelectedItem();
        String formaVenta = (String) comboVenta.getSelectedItem();
        String rutaImagen = "";
        try {
            rutaImagen = modelo.procesarRutaImagen(buscadorArchivos.getSelectedFile().getAbsolutePath()); // NO SE DEBE VALIDAR ACA SI EL ARCHIVO ES NULL?
        } catch(NullPointerException e){
            rutaImagen = "ImagenesOblig\\iconoSeleccionarImagen.jpg";
        }
        // Validaciones de producto
        if (util.validarTxt(nombre)) { //validar que nombre no sea vacío
            if (modelo.productoUnico(nombre)) { // Si producto es único
                modelo.agregarProducto(nombre, descripcion, tipoProducto, formaVenta, rutaImagen);
                JOptionPane.showMessageDialog(this, "Producto '" + nombre + "' creado correctamente.",
                        "Informacion del sistema.", JOptionPane.INFORMATION_MESSAGE); // VER DE COLOCAR IMAGEN DE PRODUCTO EN EL OPTION PANE
                this.reset();
            } else { // Si nombre del puesto ya existe
                JOptionPane.showMessageDialog(this, "Ya existe un producto con el nombre '" + nombre + "' creado.\nEl nombre del producto debe ser único.",
                        "Informacion del sistema.", JOptionPane.INFORMATION_MESSAGE);
                fieldNombre.setBorder(BorderFactory.createLineBorder(util.COLOR_ROJO));
                lblReingresoNombre.setVisible(true); //Muestra label de reeingreso
            }
        } else {
            JOptionPane.showMessageDialog(this, "El nombre del producto no puede ser vacío. Ingreselo.",
                        "Informacion del sistema.", JOptionPane.ERROR_MESSAGE);
            fieldNombre.setBorder(BorderFactory.createLineBorder(util.COLOR_ROJO));
            lblReingresoNombre.setVisible(true); //Muestra label de reeingreso
        }
        this.btnAltaProducto.setSelected(false);
    }//GEN-LAST:event_btnAltaProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaProducto;
    private javax.swing.JButton btnReset;
    private javax.swing.JFileChooser buscadorArchivos;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JComboBox<String> comboVenta;
    private javax.swing.JTextField fieldDescripcion;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JPanel jPanelRegistrarProducto;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblReingresoNombre;
    private javax.swing.JLabel lblSeleccionarImagen;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblVentaPor;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
} // Nicolas Rodriguez y Manuel Ackerman
