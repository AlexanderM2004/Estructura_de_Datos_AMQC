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

public final class Registro_Estudiante extends JFrame{
    public JPanel panel;
    
    JLabel atras = new JLabel();
    JTextField txt_ci = new JTextField();
    JTextField txt_nombre = new JTextField();
    JTextField txt_naci = new JTextField();
    JTextField txt_bachi = new JTextField();
    JComboBox Cmb_Genero = new JComboBox();
    JButton Nuevo = new JButton("Nuevo");
    JButton Guardar = new JButton("Guardar");
    JButton Eliminar = new JButton("Eliminar");
    // Crear un modelo de tabla
    DefaultTableModel modeloTabla = new DefaultTableModel();
    JTable Tabla_Estudiante = new JTable(modeloTabla);
    /*
    String titulos[] = {"CI","Nombre", "Periodo", "Estado", "Carrera", "Materia"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);
      */  
    //Conectamos a la base de datos
    public MongoDatabase db = new DB_MongoDB().ConnectDB(); 
    //Coleccion de notas
    public MongoCollection<Document> docen = db.getCollection("Estudiante");
    
    //Creamos una ventana grafica con JFrame
    public Registro_Estudiante (){
        this.setSize(500,500); 
        setTitle("Registro Estudiante"); //Comando que permitecolocar nombre a la ventana
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
        panel.setPreferredSize(new Dimension(500, 500));
        //Comando para aplicar color al panel
        panel.setBackground(new Color(127, 140, 141));
        //Poner el panel sobre la ventana del registro
        this.getContentPane().add(panel, BorderLayout.WEST);
        this.pack();
    }
    
    public void colocarEtiquetas(){
        JLabel label = new JLabel("Registro Estudiantes",SwingConstants.CENTER);
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
        label1.setText("Nombres: ");
        panel.add(label1);
        //Comando para ubicar el label
        label1.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label1.setFont(new Font("Arial", Font.PLAIN, 15));
        label1.setBounds(40, 90, 100, 15);
        
        JLabel label2 = new JLabel();
        label2.setText("Genero: ");
        panel.add(label2);
        //Comando para ubicar el label
        label2.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label2.setFont(new Font("Arial", Font.PLAIN, 15));
        label2.setBounds(40, 130, 100, 15);
        
        JLabel label3 = new JLabel();
        label3.setText("Nacimiento: ");
        panel.add(label3);
        //Comando para ubicar el label
        label3.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label3.setFont(new Font("Arial", Font.PLAIN, 15));
        label3.setBounds(40, 170, 100, 15);
        
        JLabel label4 = new JLabel();
        label4.setText("Titulo Bachiller: ");
        panel.add(label4);
        //Comando para ubicar el label
        label4.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label4.setFont(new Font("Arial", Font.PLAIN, 15));
        label4.setBounds(40, 210, 100, 15);
        
        JLabel vers = new JLabel();
        vers.setText("V 2.0.0.2 ");
        panel.add(vers);
        //Comando para ubicar el label
        vers.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        vers.setFont(new Font("Arial", Font.PLAIN,10));
        vers.setForeground(Color.white);
        vers.setBounds(10, 480, 100, 15);
                
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
        
        txt_naci.setBounds(140, 167, 300, 20);
        panel.add(txt_naci);
        
        txt_bachi.setBounds(140, 207, 300, 20);
        panel.add(txt_bachi);
    }
    
    public void ColocarComboBox(){
        Cmb_Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino"}));
        Cmb_Genero.setBounds(140, 127, 300, 20);
        panel.add(Cmb_Genero);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==Cmb_Genero) {
            String seleccionado=(String)Cmb_Genero.getSelectedItem();
            setTitle(seleccionado);
        }
    }
    
    public void ColocarBotones(){
        Nuevo.setBounds(90, 250, 100, 30);
        panel.add(Nuevo);
        Nuevo.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Nuevo.setMnemonic('n');//Sirve para que se active el boton con el teclado Alt + n
        
        Guardar.setBounds(200, 250, 100, 30);
        panel.add(Guardar);
        Guardar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Guardar.setMnemonic('g');//Sirve para que se active el boton con el teclado Alt + g
        
        Eliminar.setBounds(310, 250, 100, 30);
        panel.add(Eliminar);
        Eliminar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Eliminar.setMnemonic('e');//Sirve para que se active el boton con el teclado Alt + e
    }
    
    //Conexion de registro
    public void ModelTableDefault(){
        Tabla_Estudiante.setBounds(50, 300, 400, 175);
        // Agregar columnas al modelo de tabla
        modeloTabla.addColumn("CI");
        modeloTabla.addColumn("Nombres");
        modeloTabla.addColumn("Genero");
        modeloTabla.addColumn("Nacimiento");
        modeloTabla.addColumn("Bachillerato");
        // Crear un JScrollPane para permitir desplazamiento si hay muchos datos
        JScrollPane scrollPane = new JScrollPane(Tabla_Estudiante);
        panel.add(Tabla_Estudiante);
        viewRegister();
    }

    private void addRegister(ActionEvent evt) {
        String ci = txt_ci.getText();
        String nomb = txt_nombre.getText();
        String gene = (String) Cmb_Genero.getSelectedItem();
        String nacio = txt_naci.getText();
        String bachi = txt_bachi.getText();
        if (!ci.isEmpty() && !nomb.isEmpty() && !gene.isEmpty() && !nacio.isEmpty()&& !bachi.isEmpty()) {
            //Creamos una nota - todavia no se guarda en la base de datos
            Document doc = new Document("C1", ci).append("Nombre", nomb).append("Genero", gene).append("Nacio", nacio).append("Bachiller", bachi);
            try {
                //Insertamos la nota en la base de datos
                docen.insertOne(doc);
            } catch (Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hubo un error al registrar el usuario");
            }
            modeloTabla.setRowCount(0);
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
                    document.getString("Genero"),
                    document.getString("Nacio"),
                    document.getString("Bachiller")
                };
                modeloTabla.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void NuevoActionPerformed(ActionEvent evt) {
        txt_ci.setText("");
        txt_nombre.setText("");
        Cmb_Genero.setSelectedItem(null);
        txt_naci.setText("");
        txt_bachi.setText("");
    }

    private void EliminarActionPerformed(ActionEvent evt) {
        int fila = Tabla_Estudiante.getSelectedRow();
        if (fila != -1) {
            // Obtener los datos de la fila seleccionada
            String ci = (String) Tabla_Estudiante.getValueAt(fila, 0);
            String nomb = (String) Tabla_Estudiante.getValueAt(fila, 1);
            String gene = (String) Tabla_Estudiante.getValueAt(fila, 2);
            String nacio = (String) Tabla_Estudiante.getValueAt(fila,3);
            String bachi = (String) Tabla_Estudiante.getValueAt(fila,4);

            // Configurar los criterios de eliminación
            Document criterios = new Document("C1", ci).append("Nombre", nomb).append("Genero", gene).append("Nacio", nacio).append("Bachiller", bachi);
            // Agrega más criterios según tus necesidades

            // Eliminar el documento en MongoDB
            try{
                docen.deleteOne(criterios);
                // Eliminar la fila del modelo de la tabla
                modeloTabla.removeRow(fila);
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
