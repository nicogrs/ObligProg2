package interfaz;
//Manuel Ackerman y Nicolas Rodriguez
import dominio.Puesto;
import dominio.Sistema;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VentanaReporte extends javax.swing.JFrame implements PropertyChangeListener {

    public VentanaReporte(Sistema modelo) {
        this.modelo = modelo;
        initComponents();
        modelo.addPropertyChangeListener(this);
        ImageIcon icon = new ImageIcon("icono.png");
        this.setIconImage(icon.getImage());
        setLocationRelativeTo(null); //Centra ventana
        cargar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupobtnTipoMovimiento = new javax.swing.ButtonGroup();
        panelReporte1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        radioCompras = new javax.swing.JRadioButton();
        radioVentas = new javax.swing.JRadioButton();
        radioTodos = new javax.swing.JRadioButton();
        botonGenerar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPuestos = new javax.swing.JList();
        checkboxSeleccTodos = new javax.swing.JCheckBox();
        lblSeleccPuestos = new javax.swing.JLabel();
        lblSeleccPuestos1 = new javax.swing.JLabel();
        lblSeleccPuestos2 = new javax.swing.JLabel();
        spinnerDesde = new javax.swing.JSpinner();
        lblDesde = new javax.swing.JLabel();
        lblHasta = new javax.swing.JLabel();
        spinnerHasta = new javax.swing.JSpinner();
        lblCantMaxima = new javax.swing.JLabel();
        lblValorCantMaxima = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte - Mercado");
        getContentPane().setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setText("Generar reporte");

        grupobtnTipoMovimiento.add(radioCompras);
        radioCompras.setSelected(true);
        radioCompras.setText("Compras");
        radioCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioComprasActionPerformed(evt);
            }
        });

        grupobtnTipoMovimiento.add(radioVentas);
        radioVentas.setText("Ventas");

        grupobtnTipoMovimiento.add(radioTodos);
        radioTodos.setText("Todos");

        botonGenerar.setText("Generar reporte");
        botonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaPuestos);

        checkboxSeleccTodos.setText("Seleccionar todos");
        checkboxSeleccTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkboxSeleccTodosItemStateChanged(evt);
            }
        });

        lblSeleccPuestos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSeleccPuestos.setText("Seleccionar puestos:");

        lblSeleccPuestos1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSeleccPuestos1.setText("Seleccionar tipo de movimiento:");

        lblSeleccPuestos2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSeleccPuestos2.setText("Seleccionar rango de movimiento:");

        spinnerDesde.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblDesde.setText("Desde:");

        lblHasta.setText("Hasta:");

        spinnerHasta.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblCantMaxima.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCantMaxima.setText("Cantidad total de movimientos:");

        lblValorCantMaxima.setText("---");

        javax.swing.GroupLayout panelReporte1Layout = new javax.swing.GroupLayout(panelReporte1);
        panelReporte1.setLayout(panelReporte1Layout);
        panelReporte1Layout.setHorizontalGroup(
            panelReporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReporte1Layout.createSequentialGroup()
                .addGap(0, 231, Short.MAX_VALUE)
                .addGroup(panelReporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesde)
                    .addComponent(lblHasta))
                .addGap(18, 18, 18)
                .addGroup(panelReporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(264, 264, 264))
            .addGroup(panelReporte1Layout.createSequentialGroup()
                .addGroup(panelReporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReporte1Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addGroup(panelReporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSeleccPuestos2)
                            .addComponent(lblSeleccPuestos)))
                    .addGroup(panelReporte1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(lblTitulo))
                    .addGroup(panelReporte1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addGroup(panelReporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelReporte1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(checkboxSeleccTodos))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelReporte1Layout.createSequentialGroup()
                                .addComponent(radioCompras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioVentas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioTodos))
                            .addComponent(lblSeleccPuestos1)))
                    .addGroup(panelReporte1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblCantMaxima)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorCantMaxima))
                    .addGroup(panelReporte1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(botonGenerar)
                        .addGap(90, 90, 90)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelReporte1Layout.setVerticalGroup(
            panelReporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReporte1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(panelReporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantMaxima)
                    .addComponent(lblValorCantMaxima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSeleccPuestos1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelReporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioCompras)
                    .addComponent(radioVentas)
                    .addComponent(radioTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSeleccPuestos2)
                .addGap(18, 18, 18)
                .addGroup(panelReporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDesde))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelReporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHasta)
                    .addComponent(spinnerHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblSeleccPuestos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkboxSeleccTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelReporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGenerar)
                    .addComponent(botonCancelar))
                .addGap(33, 33, 33))
        );

        getContentPane().add(panelReporte1);
        panelReporte1.setBounds(0, 0, 630, 510);

        setBounds(0, 0, 648, 533);
    }// </editor-fold>//GEN-END:initComponents

    private void radioComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioComprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioComprasActionPerformed

    private void botonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarActionPerformed
        int desde = (int) spinnerDesde.getValue() - 1;
        int hasta = (int) spinnerHasta.getValue() - 1;
        String mensaje = "";
        try {
            if (desde <= hasta && hasta < modelo.getListaMovimientos().size()) {
                ArrayList<Puesto> puestos;
                if (!listaPuestos.isSelectionEmpty()) {
                    puestos = (ArrayList<Puesto>) listaPuestos.getSelectedValuesList();
                } else {
                    puestos = null;
                }
                if (radioCompras.isSelected()) {
                    modelo.generarReporte("Compra", puestos, desde, hasta);
                    mensaje = "Reporte por compras generado correctamente.";
                } else if (radioVentas.isSelected()) {
                    modelo.generarReporte("Venta", puestos, desde, hasta);
                    mensaje = "Reporte por ventas generado correctamente.";
                } else if (radioTodos.isSelected()) {
                    modelo.generarReporte("Todos", puestos, desde, hasta);
                    mensaje = "Reporte por todos los movimientos generado correctamente.";
                }
                JOptionPane.showMessageDialog(this, mensaje, "Información del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "El rango ingresado es invalido.", "Información del Sistema.", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "El reporte no pudo ser generado.", "Información del Sistema.", JOptionPane.ERROR_MESSAGE);
        }
        this.botonGenerar.setSelected(false);
    }//GEN-LAST:event_botonGenerarActionPerformed

    private void checkboxSeleccTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkboxSeleccTodosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            listaPuestos.setSelectionInterval(0, modelo.getListaPuestos().size() - 1);
        } else {
            listaPuestos.clearSelection();
        }
    }//GEN-LAST:event_checkboxSeleccTodosItemStateChanged

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void cargar() {
        radioCompras.setSelected(true);
        lblValorCantMaxima.setText("" + modelo.getListaMovimientos().size());
        listaPuestos.setListData(modelo.getListaPuestos().toArray());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        cargar();
        listaPuestos.clearSelection();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGenerar;
    private javax.swing.JCheckBox checkboxSeleccTodos;
    private javax.swing.ButtonGroup grupobtnTipoMovimiento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantMaxima;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblSeleccPuestos;
    private javax.swing.JLabel lblSeleccPuestos1;
    private javax.swing.JLabel lblSeleccPuestos2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorCantMaxima;
    private javax.swing.JList listaPuestos;
    private javax.swing.JPanel panelReporte1;
    private javax.swing.JRadioButton radioCompras;
    private javax.swing.JRadioButton radioTodos;
    private javax.swing.JRadioButton radioVentas;
    private javax.swing.JSpinner spinnerDesde;
    private javax.swing.JSpinner spinnerHasta;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
//Manuel Ackerman y Nicolas Rodriguez