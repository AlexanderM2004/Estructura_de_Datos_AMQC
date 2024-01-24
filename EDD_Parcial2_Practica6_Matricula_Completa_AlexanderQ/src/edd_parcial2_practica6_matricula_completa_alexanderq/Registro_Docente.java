package edd_parcial2_practica6_matricula_completa_alexanderq;

import com.mongodb.client.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author Alexander Quizhpe
 */

public class Registro_Docente extends JFrame{
    public JPanel panel;
    public JPanel panel1;
    JTable Tabla_Docente = new JTable();
    JLabel atras = new JLabel();
    JTextField txt_ci = new JTextField();
    JTextField txt_nombre = new JTextField();
    JComboBox Cmb_Periodo = new JComboBox();
    JComboBox Cmb_Estado = new JComboBox();
    JButton Nuevo = new JButton("Nuevo");
    JButton Guardar = new JButton("Guardar");
    JButton Eliminar = new JButton("Eliminar");
    
    String titulos[] = {"CI","Nombre", "Periodo", "Estado"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
    //Conectamos a la base de datos
    public MongoDatabase db = new DB_MongoDB().ConnectDB(); 
    //Coleccion de notas
    public MongoCollection<Document> docen = db.getCollection("Docente");
    
    //Creamos una ventana grafica con JFrame
    public Registro_Docente (){
        this.setSize(1100,400); 
        setTitle("Registro Docente"); //Comando que permitecolocar nombre a la ventana
        //Comando que permite finalizar todo el programa en el momento que se cierra la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
        ModelTableDefault();
    }
    
    private void iniciarComponentes(){
        colocarPanel();
        colocarEtiquetas();
        ColocarBotones();
        ColocarCajatexto();
        ColocarComboBox();
        
        atras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                IniciarActionPerformed(e);
            }
        });
        
        Nuevo.addActionListener((java.awt.event.ActionEvent evt) -> {
            NuevoActionPerformed(evt);
        });
        
        Guardar.addActionListener((java.awt.event.ActionEvent evt) -> {
            addRegister(evt);
        });
        
        Eliminar.addActionListener((java.awt.event.ActionEvent evt) -> {
            EliminarActionPerformed(evt);
        });
    }
   
    private void colocarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel1 = new JPanel();
        panel.setPreferredSize(new Dimension(500, 400));
        panel1.setPreferredSize(new Dimension(600, 400));
        //Comando para aplicar color al panel
        panel.setBackground(new Color(127, 140, 141));
        panel1.setBackground(new Color(149, 165, 166));
        //Poner el panel sobre la ventana del registro
        this.getContentPane().add(panel, BorderLayout.WEST);
        this.getContentPane().add(panel1, BorderLayout.EAST);
        this.pack();
    }
    
    public void colocarEtiquetas(){
        JLabel label = new JLabel("Registro Docente",SwingConstants.CENTER);
        panel.add(label);
        panel.setLayout(null);
        label.setBounds(75, 15, 350, 15);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.white);
        
        JLabel label0 = new JLabel();
        label0.setText("ID: ");
        panel.add(label0);
        //Comando para ubicar el label
        label0.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label0.setFont(new Font("Arial", Font.PLAIN, 15));
        label0.setBounds(40, 50, 100, 15);
        
        JLabel label1 = new JLabel();
        label1.setText("Nombre: ");
        panel.add(label1);
        //Comando para ubicar el label
        label1.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label1.setFont(new Font("Arial", Font.PLAIN, 15));
        label1.setBounds(40, 90, 100, 15);
        
        JLabel label2 = new JLabel();
        label2.setText("Periodo: ");
        panel.add(label2);
        //Comando para ubicar el label
        label2.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label2.setFont(new Font("Arial", Font.PLAIN, 15));
        label2.setBounds(40, 130, 100, 15);
        
        JLabel label3 = new JLabel();
        label3.setText("Estado: ");
        panel.add(label3);
        //Comando para ubicar el label
        label3.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label3.setFont(new Font("Arial", Font.PLAIN, 15));
        label3.setBounds(40, 170, 100, 15);
        
        JLabel vers = new JLabel();
        vers.setText("V 2.0.0.2 ");
        panel.add(vers);
        //Comando para ubicar el label
        vers.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        vers.setFont(new Font("Arial", Font.PLAIN,10));
        vers.setForeground(Color.white);
        vers.setBounds(10, 380, 100, 15);
                
        //Comando para colocar imagen
        ImageIcon imagen = new ImageIcon("Imagenes\\atra.png");//La imagen se encuetra en la misma carpeta del proyecto
        atras.setBounds(10, 15, 20, 20);
        panel.add(atras);
        //Modificar imagen
        atras.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(atras.getWidth(), atras.getHeight(), Image.SCALE_SMOOTH)));
        
    }
    
    //Comando para colocar cajas de texto
    public void ColocarCajatexto(){
        txt_ci.setBounds(140, 47, 300, 20);
        panel.add(txt_ci);
        
        txt_nombre.setBounds(140, 87, 300, 20);
        panel.add(txt_nombre);
    }
    
    public void ColocarComboBox(){
        Cmb_Periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "202351", "202350","202251", "202250"}));
        Cmb_Periodo.setBounds(140, 127, 300, 20);
        panel.add(Cmb_Periodo);
        
        Cmb_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombramiento", "Contrato"}));
        Cmb_Estado.setBounds(140,167,300,20);
        panel.add(Cmb_Estado);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==Cmb_Periodo) {
            String seleccionado=(String)Cmb_Periodo.getSelectedItem();
            setTitle(seleccionado);
        }
        if (e.getSource()==Cmb_Estado) {
            String seleccionado=(String)Cmb_Estado.getSelectedItem();
            setTitle(seleccionado);
        }
    }
    
    public void ColocarBotones(){
        Nuevo.setBounds(90, 240, 100, 30);
        panel.add(Nuevo);
        Nuevo.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Nuevo.setMnemonic('n');//Sirve para que se active el boton con el teclado Alt + n
        
        Guardar.setBounds(200, 240, 100, 30);
        panel.add(Guardar);
        Guardar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Guardar.setMnemonic('g');//Sirve para que se active el boton con el teclado Alt + g
        
        Eliminar.setBounds(310, 240, 100, 30);
        panel.add(Eliminar);
        Eliminar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Eliminar.setMnemonic('e');//Sirve para que se active el boton con el teclado Alt + e
    }
    
    //Conexion de registro
    public void ModelTableDefault(){
        Tabla_Docente.setBounds(450, 37, 300, 300);
        Tabla_Docente.setModel(modelo);
        panel1.add(new JScrollPane(Tabla_Docente));
        viewRegister();
    }

    private void addRegister(ActionEvent evt) {
        String ci = txt_ci.getText();
        String nomb = txt_nombre.getText();
        String peri = (String) Cmb_Periodo.getSelectedItem();
        String esta = (String) Cmb_Estado.getSelectedItem();
        if (!ci.isEmpty() && !nomb.isEmpty() && !peri.isEmpty() && !esta.isEmpty()) {
            //Creamos una nota - todavia no se guarda en la base de datos
            Document doc = new Document("C1", ci).append("Nombre", nomb).append("Periodo", peri).append("Estado", esta);
            try {
                //Insertamos la nota en la base de datos
                docen.insertOne(doc);
            } catch (Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un error al registrar el usuario");
            }
            modelo.setRowCount(0);
            viewRegister();
        }else{
            JOptionPane.showMessageDialog(this, "LLene todos los campos requeridos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void viewRegister(){
        try {
            // Realizar una operación de lectura (por ejemplo, encontrar todos los documentos)
            FindIterable<Document> documents = docen.find();

            // Iterar sobre los documentos e imprimirlos
            for (Document document : documents) {
                // Ajusta los nombres de los campos según tus datos
                Object[] fila = {
                    document.getString("C1"),
                    document.getString("Nombre"),
                    document.getString("Periodo"),
                    document.getString("Estado")
                };
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void NuevoActionPerformed(ActionEvent evt) {
        txt_ci.setText("");
        txt_nombre.setText("");
        Cmb_Periodo.setSelectedItem(null);
        Cmb_Estado.setSelectedItem(null);
    }

    private void EliminarActionPerformed(ActionEvent evt) {
        int fila = Tabla_Docente.getSelectedRow();
        if (fila != -1) {
            // Obtener los datos de la fila seleccionada
            String ci = (String) Tabla_Docente.getValueAt(fila, 0);
            String nomb = (String) Tabla_Docente.getValueAt(fila, 1);
            String peri = (String) Tabla_Docente.getValueAt(fila, 2);
            String esta = (String) Tabla_Docente.getValueAt(fila,3);

            // Configurar los criterios de eliminación
            Document criterios = new Document("C1", ci).append("Nombre", nomb).append("Periodo", peri).append("Estado", esta);
            // Agrega más criterios según tus necesidades

            // Eliminar el documento en MongoDB
            try{
                docen.deleteOne(criterios);
                // Eliminar la fila del modelo de la tabla
                modelo.removeRow(fila);
                JOptionPane.showMessageDialog(this, "Fila eliminada con éxito");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar la fila", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila antes de intentar eliminar", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void IniciarActionPerformed(MouseEvent e) {                                         
        this.dispose();
        Inicio ini = new Inicio();
        ini.setVisible(true);
    } 
}
