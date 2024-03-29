package edd_parcial2_ejemplo_ordenamiento_arbol_binario_alexanderq;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander Quizhpe
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    private DefaultTableModel model;
    private JTable table;
    private String[] marca;
    private int[] cantidad;
    NodoVehiculo raiz = null;
    
    public View() {
        // Inicializar el modelo de la tabla y la tabla
        model = new DefaultTableModel(
            new Object[][]{
                
            }, 
            new String [] {
                "Marca", "Venta"
            });
        
        table = new JTable(model);

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        table.setBounds(70, 220, 450, 130);
        getContentPane().add(table);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_marc = new javax.swing.JTextField();
        txt_cant = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Btt_Agregar = new javax.swing.JButton();
        Btt_Ordenar = new javax.swing.JButton();
        Btt_Buscar = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(149, 165, 166));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 15, 235));
        setName("Concensionaria"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Marca de Vehiculo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Cantidad de Ventas");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Concensionaria NN");

        Btt_Agregar.setBackground(new java.awt.Color(127, 140, 141));
        Btt_Agregar.setForeground(new java.awt.Color(255, 255, 255));
        Btt_Agregar.setText("Agregar");
        Btt_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btt_AgregarActionPerformed(evt);
            }
        });

        Btt_Ordenar.setBackground(new java.awt.Color(127, 140, 141));
        Btt_Ordenar.setForeground(new java.awt.Color(255, 255, 255));
        Btt_Ordenar.setText("Ordenar");
        Btt_Ordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btt_OrdenarActionPerformed(evt);
            }
        });

        Btt_Buscar.setBackground(new java.awt.Color(127, 140, 141));
        Btt_Buscar.setForeground(new java.awt.Color(255, 255, 255));
        Btt_Buscar.setText("Buscar");
        Btt_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btt_BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_marc, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_cant, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Btt_Buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Btt_Ordenar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btt_Agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_marc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btt_Agregar))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btt_Ordenar))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btt_Buscar)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(183, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btt_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btt_AgregarActionPerformed
        // Obtener datos de los campos de texto
        String marc = txt_marc.getText();
        String cant = txt_cant.getText();
        // Validar que los campos no estén vacíos
        if (!marc.isEmpty() && !cant.isEmpty()) {
            int nota = Integer.parseInt(cant);
            if(nota >= 0){
                if (marca == null) {
                    marca = new String[]{marc};
                    cantidad = new int[]{nota};
                } else {
                    Vehiculo nuevoVehiculo = new Vehiculo(marc, nota);
                    raiz = insertarVehiculo(raiz, nuevoVehiculo);
                }
                agregarFila(txt_marc.getText(), txt_cant.getText());
            }else{
                JOptionPane.showMessageDialog(this, "Solo se admiten numeros mayores o iguales a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // Limpiar campos después de ingresar una nota
        txt_marc.setText("");
        txt_cant.setText(""); 
    }//GEN-LAST:event_Btt_AgregarActionPerformed

    private void Btt_OrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btt_OrdenarActionPerformed
        // Limpiar la tabla actual
        model.setRowCount(0);
        inordenImprimir(raiz);
    }//GEN-LAST:event_Btt_OrdenarActionPerformed

    private void Btt_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btt_BuscarActionPerformed
        // TODO add your handling code here:
        String search = txt_buscar.getText();
        if (buscar(search)) {
            JOptionPane.showMessageDialog(this, "Si existe el elemento seleccionado");
        } else {
            JOptionPane.showMessageDialog(this, "No hay ningun registro que coincida con lo buscado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        txt_buscar.setText(" ");
    }//GEN-LAST:event_Btt_BuscarActionPerformed

    public NodoVehiculo insertarVehiculo(NodoVehiculo raiz, Vehiculo nuevoVehiculo) {
        if (raiz == null) {
            return new NodoVehiculo(nuevoVehiculo);
        } else {
            if (nuevoVehiculo.ventasMes > raiz.vehiculo.ventasMes) {
                raiz.izquierda = insertarVehiculo(raiz.izquierda, nuevoVehiculo);
            } else {
                raiz.derecha = insertarVehiculo(raiz.derecha, nuevoVehiculo);
            }
        }
        return raiz;
    }
         
    public void inordenImprimir(NodoVehiculo raiz) {
        //System.out.println("");
        if (raiz != null) {
            inordenImprimir(raiz.izquierda);
            actualizarFila(raiz.vehiculo.marca, raiz.vehiculo.ventasMes);
            inordenImprimir(raiz.derecha);
        }
    }
    
     // Método para buscar un valor en el árbol
    public boolean buscar(String valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(NodoVehiculo nodo, String valor) {
        if (nodo == null) {
            return false;
        }

        // Comparar cadenas usando el método compareTo
        int comparacion = valor.compareTo(nodo.vehiculo.marca);
        
        if (comparacion == 0) {
            return true;
        }

        if (comparacion < 0) {
            return buscarRec(nodo.izquierda, valor);
        }

        return buscarRec(nodo.derecha, valor);
    }
    
    private void actualizarFila(String marc, int cant) {
        // Agregar una nueva fila a la tabla
        Object[] rowData = {marc, cant};
        model.addRow(rowData);
    }
    
    private void agregarFila(String marc, String cant) {
        // Agregar una nueva fila a la tabla
        Object[] rowData = {marc, cant};
        model.addRow(rowData);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btt_Agregar;
    private javax.swing.JButton Btt_Buscar;
    private javax.swing.JButton Btt_Ordenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cant;
    private javax.swing.JTextField txt_marc;
    // End of variables declaration//GEN-END:variables
}
