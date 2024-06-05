package interfaz; // Nicolas Rodriguez y Manuel Ackerman
import dominio.Movimiento;
import dominio.Sistema;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VentanaInicial extends javax.swing.JFrame implements Serializable, PropertyChangeListener {

    private int valorSeleccionado; // 1 = Sistema Existente, 2 = Sistema Vacio, 3 = Sistema nuevo con Productos

    public VentanaInicial(Sistema modelo) {
        this.modelo = modelo;
        initComponents();
        ImageIcon icon = new ImageIcon("icono.png");
        this.setIconImage(icon.getImage());
        setLocationRelativeTo(null); //Centra ventana
        jLabelIconImagenVentanaInicial.setIcon(new ImageIcon("ImagenesOblig/ImagenMenuPrincipal.jpg"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelVentanaInicial = new javax.swing.JPanel();
        jLabelMensajeInicial = new javax.swing.JLabel();
        jButtonSistemaExistente = new javax.swing.JButton();
        jButtonSistemaNuevo = new javax.swing.JButton();
        jLabelIconImagenVentanaInicial = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mercado");
        setResizable(false);

        jPanelVentanaInicial.setEnabled(false);

        jLabelMensajeInicial.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabelMensajeInicial.setText("Bienvenido al Mercado de Frutas y Verduras!");

        jButtonSistemaExistente.setText("Cargar Sistema Existente");
        jButtonSistemaExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSistemaExistenteActionPerformed(evt);
            }
        });

        jButtonSistemaNuevo.setText("Cargar Sistema Nuevo");
        jButtonSistemaNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSistemaNuevoActionPerformed(evt);
            }
        });

        jLabelIconImagenVentanaInicial.setIconTextGap(8);
        jLabelIconImagenVentanaInicial.setPreferredSize(new java.awt.Dimension(1121, 481));

        javax.swing.GroupLayout jPanelVentanaInicialLayout = new javax.swing.GroupLayout(jPanelVentanaInicial);
        jPanelVentanaInicial.setLayout(jPanelVentanaInicialLayout);
        jPanelVentanaInicialLayout.setHorizontalGroup(
            jPanelVentanaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentanaInicialLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelVentanaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelVentanaInicialLayout.createSequentialGroup()
                        .addGroup(jPanelVentanaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSistemaNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSistemaExistente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelIconImagenVentanaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabelMensajeInicial))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanelVentanaInicialLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonSistemaExistente, jButtonSistemaNuevo});

        jPanelVentanaInicialLayout.setVerticalGroup(
            jPanelVentanaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentanaInicialLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelMensajeInicial)
                .addGap(18, 18, 18)
                .addGroup(jPanelVentanaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVentanaInicialLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButtonSistemaExistente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButtonSistemaNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelIconImagenVentanaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanelVentanaInicialLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonSistemaExistente, jButtonSistemaNuevo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVentanaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVentanaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int getValorSeleccionado() {
        return this.valorSeleccionado;
    }

    public void setValorSeleccionado(int valor) {
        this.valorSeleccionado = valor;
    }

    private void jButtonSistemaExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSistemaExistenteActionPerformed
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("sistema.ser"));
            this.modelo = (Sistema) in.readObject();
            modelo.setManejador();
            in.close();
            VentanaMenuPrincipal m1 = new VentanaMenuPrincipal(this.modelo);
            Movimiento.setContMov(modelo.getListaMovimientos().size() + 1);
            m1.setVisible(true);
            dispose();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encontró un sistema guardado anteriormente. Debe cargar un sistema nuevo.",
                    "Información del Sistema.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSistemaExistenteActionPerformed

    private void jButtonSistemaNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSistemaNuevoActionPerformed
        // Mostrar optionPane con 2 opciones, sistema vacío (2) o con productos precargados (3)
        String[] opciones = {"Sistema vacío", "Sistema con productos precargados"};
        int respuesta = JOptionPane.showOptionDialog(null, "¿Cómo desea crear el sistema?", "Creación de nuevo sistema",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        File productos = new File("productos.txt");
        VentanaMenuPrincipal m1 = new VentanaMenuPrincipal(this.modelo);
        switch (respuesta) {
            case 0:
                this.modelo = new Sistema();
                this.dispose();
                m1.setVisible(true);
                break;
            case 1:
                if (respuesta == 1 && !productos.exists()) {
                    JOptionPane.showMessageDialog(null, "El archivo 'productos.txt' no se encuentra en el directorio. Verifique su existencia e intente de nuevo.",
                            "Información del Sistema.", JOptionPane.WARNING_MESSAGE);
                } else {
                    boolean hayErrores = this.modelo.precargarProductos();
                    if (hayErrores) {
                        JOptionPane.showMessageDialog(null, "El archivo 'productos.txt' contiene errores, no todos los productos se pudieron cargar correctamente.\nVea el archivo 'errores.txt' para mas detalles.",
                            "Información del Sistema.", JOptionPane.WARNING_MESSAGE);
                    }
                    m1.setVisible(true);
                    this.dispose();
                }
                break;
        }
    }//GEN-LAST:event_jButtonSistemaNuevoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSistemaExistente;
    private javax.swing.JButton jButtonSistemaNuevo;
    private javax.swing.JLabel jLabelIconImagenVentanaInicial;
    private javax.swing.JLabel jLabelMensajeInicial;
    private javax.swing.JPanel jPanelVentanaInicial;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        modelo.addPropertyChangeListener(this);
    }
} // Nicolas Rodriguez y Manuel Ackerman
