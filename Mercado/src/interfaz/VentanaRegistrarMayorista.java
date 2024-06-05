package interfaz; // Nicolas Rodriguez y Manuel Ackerman

import dominio.Producto;
import dominio.Sistema;
import java.awt.List;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utilidades.Utilidades;

public class VentanaRegistrarMayorista extends javax.swing.JFrame implements PropertyChangeListener {

    private Utilidades util;

    public VentanaRegistrarMayorista(Sistema modelo) {
        this.prodAMostrar = (ArrayList<Producto>) modelo.getListaProductos().clone();
        this.prodSeleccionados = new ArrayList<>();
        this.modelo = modelo;
        modelo.addPropertyChangeListener(this);
        this.util = new Utilidades();
        initComponents();
        ImageIcon icon = new ImageIcon("icono.png");
        this.setIconImage(icon.getImage());
        setLocationRelativeTo(null); //Centra ventana
        cargar();
        lblReingresoRut.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRegistrarMayorista = new javax.swing.JPanel();
        lblRut = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblProductos = new javax.swing.JLabel();
        btnCrearMayorista = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JToggleButton();
        fieldRut = new javax.swing.JTextField();
        lblRegistrarMayorista = new javax.swing.JLabel();
        fieldDireccion = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaSeleccionados = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JList();
        btnDerecha = new javax.swing.JButton();
        btnIzquierda = new javax.swing.JButton();
        lblReingresoRut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar mayorista - Mercado");
        setResizable(false);

        lblRut.setText("RUT:");

        lblDireccion.setText("Dirección:");

        lblProductos.setText("Seleccionar productos:");

        btnCrearMayorista.setText("Crear mayorista");
        btnCrearMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMayoristaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        fieldRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldRutActionPerformed(evt);
            }
        });

        lblRegistrarMayorista.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRegistrarMayorista.setText("Registrar mayorista");

        fieldDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDireccionActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre:");

        fieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreActionPerformed(evt);
            }
        });

        listaSeleccionados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaSeleccionados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(listaSeleccionados);

        listaProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(listaProductos);
        listaProductos.getAccessibleContext().setAccessibleDescription("");

        btnDerecha.setText(">");
        btnDerecha.setMargin(new java.awt.Insets(0, 14, 0, 14));
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerechaActionPerformed(evt);
            }
        });

        btnIzquierda.setText("<");
        btnIzquierda.setMargin(new java.awt.Insets(0, 14, 0, 14));
        btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzquierdaActionPerformed(evt);
            }
        });

        lblReingresoRut.setForeground(new java.awt.Color(255, 0, 0));
        lblReingresoRut.setText("* Reingrese el rut");

        javax.swing.GroupLayout jPanelRegistrarMayoristaLayout = new javax.swing.GroupLayout(jPanelRegistrarMayorista);
        jPanelRegistrarMayorista.setLayout(jPanelRegistrarMayoristaLayout);
        jPanelRegistrarMayoristaLayout.setHorizontalGroup(
            jPanelRegistrarMayoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(lblRegistrarMayorista))
            .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(lblRut, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(fieldRut, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(lblReingresoRut))
            .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(fieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblProductos))
            .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistrarMayoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDerecha)
                    .addComponent(btnIzquierda))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(btnCrearMayorista))
        );
        jPanelRegistrarMayoristaLayout.setVerticalGroup(
            jPanelRegistrarMayoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblRegistrarMayorista)
                .addGap(12, 12, 12)
                .addGroup(jPanelRegistrarMayoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblRut))
                    .addComponent(fieldRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(lblReingresoRut)
                .addGap(2, 2, 2)
                .addGroup(jPanelRegistrarMayoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblNombre))
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistrarMayoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblDireccion))
                    .addComponent(fieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(lblProductos)
                .addGap(12, 12, 12)
                .addGroup(jPanelRegistrarMayoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelRegistrarMayoristaLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistrarMayoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnCrearMayorista)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRegistrarMayorista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRegistrarMayorista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 620, 489);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNombreActionPerformed

    private void fieldDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDireccionActionPerformed

    private void fieldRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldRutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRutActionPerformed

    private void btnCrearMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMayoristaActionPerformed
        lblReingresoRut.setVisible(false);
        fieldRut.setBorder(BorderFactory.createLineBorder(util.COLOR_NEGRO));
        listaSeleccionados.setBorder(BorderFactory.createLineBorder(util.COLOR_NEGRO));
        String nombre = fieldNombre.getText();
        String rut = fieldRut.getText();
        String direccion = fieldDireccion.getText();
        //Validacion de Mayoristas
        //Object[] productosSeleccionados =  listaSeleccionados.getSelectedValues();
        if (prodSeleccionados.size() != 0) {
            if (util.validarTxt(rut)) {
                String mensaje = "";
                if (modelo.mayoristaUnico(rut)) { // Si mayorista es único
                    modelo.agregarMayorista(rut, nombre, direccion, this.prodSeleccionados);
                    mensaje = "Mayorista '" + nombre + "' creado correctamente.";
                    this.recargar();
                } else { // Si rut del mayorista ya existe
                    mensaje = "Ya existe un mayorista con el rut '" + rut + "' creado.\nEl rut del mayorista debe ser único.";
                    lblReingresoRut.setVisible(true);
                    fieldRut.setBorder(BorderFactory.createLineBorder(util.COLOR_ROJO));
                }
                JOptionPane.showMessageDialog(this, mensaje, "Informacion del sistema.", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "El rut del mayorista no puede ser vacío. Ingreselo.",
                        "Informacion del sistema.", JOptionPane.ERROR_MESSAGE);
                lblReingresoRut.setVisible(true);
                fieldRut.setBorder(BorderFactory.createLineBorder(util.COLOR_ROJO));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un producto para crear el mayorista.",
                    "Informacion del sistema.", JOptionPane.WARNING_MESSAGE);
            listaSeleccionados.setBorder(BorderFactory.createLineBorder(util.COLOR_ROJO));
        }
        this.btnCrearMayorista.setSelected(false);
    }//GEN-LAST:event_btnCrearMayoristaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerechaActionPerformed
        seleccionar();
    }//GEN-LAST:event_btnDerechaActionPerformed

    private void btnIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzquierdaActionPerformed
        deseleccionar();
    }//GEN-LAST:event_btnIzquierdaActionPerformed

    public void cargar() {
        listaProductos.setListData(this.prodAMostrar.toArray());
    }

    public void recargar() {
        fieldDireccion.setText("");
        fieldNombre.setText("");
        fieldRut.setText("");
        this.prodAMostrar = (ArrayList<Producto>) modelo.getListaProductos().clone();
        this.prodSeleccionados = new ArrayList<>();
        listaProductos.setListData(this.prodAMostrar.toArray());
        listaSeleccionados.setListData(prodSeleccionados.toArray());
    }

    public void seleccionar() {
        Producto prod = (Producto) listaProductos.getSelectedValue();
        prodSeleccionados.add(prod);
        prodAMostrar.remove(prod);
        listaSeleccionados.setListData(prodSeleccionados.toArray());
        listaProductos.setListData(prodAMostrar.toArray());
    }

    public void deseleccionar() {
        Producto prod = (Producto) listaSeleccionados.getSelectedValue();
        prodAMostrar.add(prod);
        prodSeleccionados.remove(prod);
        listaProductos.setListData(prodAMostrar.toArray());
        listaSeleccionados.setListData(prodSeleccionados.toArray());
    }

    public void propertyChange(PropertyChangeEvent evt) {
        listaProductos.setListData(this.prodAMostrar.toArray());
        listaSeleccionados.setListData(prodSeleccionados.toArray());
        revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnCrearMayorista;
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JTextField fieldDireccion;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldRut;
    private javax.swing.JPanel jPanelRegistrarMayorista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblRegistrarMayorista;
    private javax.swing.JLabel lblReingresoRut;
    private javax.swing.JLabel lblRut;
    private javax.swing.JList listaProductos;
    private javax.swing.JList listaSeleccionados;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private ArrayList<Producto> prodSeleccionados;
    private ArrayList<Producto> prodAMostrar;
} // Nicolas Rodriguez y Manuel Ackerman
