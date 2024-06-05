package interfaz; // Nicolas Rodriguez y Manuel Ackerman

import dominio.Dueño;
import dominio.Puesto;
import dominio.Sistema;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class VentanaConsultaPuesto extends javax.swing.JFrame implements PropertyChangeListener {

    public VentanaConsultaPuesto(Sistema modelo) {
        this.modelo = modelo;
        modelo.addPropertyChangeListener(this);
        initComponents();
        ImageIcon icon = new ImageIcon("icono.png");
        this.setIconImage(icon.getImage());
        setLocationRelativeTo(null); //Centra ventana
        tablaPuestos.setDefaultEditor(Object.class, null);
        tablaPuestos.getTableHeader().setReorderingAllowed(false);
        cargar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelConsultaPuesto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPuestos = new javax.swing.JTable();
        lblDueños = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta puesto - Mercado");
        setResizable(false);

        jScrollPane1.setViewportView(tablaPuestos);

        lblDueños.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDueños.setText("Lista de puestos existentes");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsultaPuestoLayout = new javax.swing.GroupLayout(jPanelConsultaPuesto);
        jPanelConsultaPuesto.setLayout(jPanelConsultaPuestoLayout);
        jPanelConsultaPuestoLayout.setHorizontalGroup(
            jPanelConsultaPuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsultaPuestoLayout.createSequentialGroup()
                .addContainerGap(543, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(39, 39, 39))
            .addGroup(jPanelConsultaPuestoLayout.createSequentialGroup()
                .addGroup(jPanelConsultaPuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConsultaPuestoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelConsultaPuestoLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(lblDueños)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelConsultaPuestoLayout.setVerticalGroup(
            jPanelConsultaPuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsultaPuestoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblDueños)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConsultaPuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConsultaPuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 651, 411);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    public void cargar() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Identficacion");
        model.addColumn("Dueño");
        model.addColumn("Ubicacion");
        model.addColumn("Cantidad empleados");
        for (Puesto puesto : modelo.getListaPuestos()) {
            Object[] fila = {puesto.getIdentificacion(), puesto.getDueño(), puesto.getUbicacion(), puesto.getCantEmpleados()};
            model.addRow(fila);
        }
        tablaPuestos.setModel(model);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        cargar();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanelConsultaPuesto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDueños;
    private javax.swing.JTable tablaPuestos;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
} // Nicolas Rodriguez y Manuel Ackerman