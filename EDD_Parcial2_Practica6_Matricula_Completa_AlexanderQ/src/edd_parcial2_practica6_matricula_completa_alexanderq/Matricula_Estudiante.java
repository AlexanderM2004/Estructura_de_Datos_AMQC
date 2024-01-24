package edd_parcial2_practica6_matricula_completa_alexanderq;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author Alexander Quizhpe
 */

public class Matricula_Estudiante extends JFrame {
    public JPanel panel;
    public JPanel panel1;
    JTable Tabla_Matricula = new JTable();
    JLabel atras = new JLabel();
    JTextField txt_ci = new JTextField();
    JTextField txt_materia = new JTextField();
    JTextField txt_nombre = new JTextField();
    JComboBox <String> Cmb_Docente;
    JComboBox Cmb_Carrera = new JComboBox();
    JComboBox Cmb_Semestre = new JComboBox();
    JComboBox Cmb_Periodo = new JComboBox();
    JButton Nuevo = new JButton("Nuevo");
    JButton Guardar = new JButton("Guardar");
    JButton Eliminar = new JButton("Eliminar");
    
    String titulos[] = {"ID","Alumno", "Carrera", "Semestre", "Periodo", "Docente", "Materia"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
    //Conectamos a la base de datos
    public MongoDatabase db = new DB_MongoDB().ConnectDB(); 
    //Coleccion de notas
    public MongoCollection<Document> matri = db.getCollection("Matricula");
    
    //Creamos una ventana grafica con JFrame
    public Matricula_Estudiante (){
        this.setSize(1100,400); 
        setTitle("Registro Matricula"); //Comando que permitecolocar nombre a la ventana
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
        JLabel label = new JLabel("Registro Matricula",SwingConstants.CENTER);
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
        label1.setText("Alumno: ");
        panel.add(label1);
        //Comando para ubicar el label
        label1.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label1.setFont(new Font("Arial", Font.PLAIN, 15));
        label1.setBounds(40, 90, 100, 15);
        
        JLabel label2 = new JLabel();
        label2.setText("Carrera: ");
        panel.add(label2);
        //Comando para ubicar el label
        label2.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label2.setFont(new Font("Arial", Font.PLAIN, 15));
        label2.setBounds(40, 130, 100, 15);
        
        JLabel label3 = new JLabel();
        label3.setText("Semestre: ");
        panel.add(label3);
        //Comando para ubicar el label
        label3.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label3.setFont(new Font("Arial", Font.PLAIN, 15));
        label3.setBounds(40, 170, 100, 15);
        
        JLabel label4 = new JLabel();
        label4.setText("Periodo: ");
        panel.add(label4);
        //Comando para ubicar el label
        label4.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label4.setFont(new Font("Arial", Font.PLAIN, 15));
        label4.setBounds(40, 210, 100, 15);
        
        JLabel label5 = new JLabel();
        label5.setText("Docente: ");
        panel.add(label5);
        //Comando para ubicar el label
        label5.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label5.setFont(new Font("Arial", Font.PLAIN, 15));
        label5.setBounds(40, 250, 100, 15);
        
        JLabel label6 = new JLabel();
        label6.setText("Materia: ");
        panel.add(label6);
        //Comando para ubicar el label
        label6.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label6.setFont(new Font("Arial", Font.PLAIN, 15));
        label6.setBounds(40, 290, 100, 15);
        
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
        
        txt_materia.setBounds(140, 287, 300, 20);
        panel.add(txt_materia);
    }
    
    public void ColocarComboBox(){
        Cmb_Carrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tecnologias de la Información", "Biotecnologia", "Agropecuaria"}));
        Cmb_Carrera.setBounds(140, 127, 300, 20);
        panel.add(Cmb_Carrera);
        
        Cmb_Semestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Septimo", "Octavo", "Noveno"}));
        Cmb_Semestre.setBounds(140,167,300,20);
        panel.add(Cmb_Semestre);
        
        Cmb_Periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "202351", "202350","202251", "202250"}));
        Cmb_Periodo.setBounds(140,207,300,20);
        panel.add(Cmb_Periodo);
        
        // Conectar a la base de datos MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("Gestion_Matriculas_AMQC");
        MongoCollection<Document> collection = database.getCollection("Docente");

        // Crear una consulta para recuperar los datos del campo específico
        ArrayList<String> results = new ArrayList<>();
        for (Document doc : collection.find(Filters.exists("Nombre"))) {
            results.add(doc.getString("Nombre"));
        }

        // Crear un modelo de cuadro combinado y agregar los resultados de la consulta
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (String result : results) {
            model.addElement(result);
        }

        Cmb_Docente = new JComboBox<>(model);
        Cmb_Docente.setBounds(140, 247, 300, 20);
        panel.add(Cmb_Docente);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==Cmb_Carrera) {
            String seleccionado=(String)Cmb_Carrera.getSelectedItem();
            setTitle(seleccionado);
        }
        if (e.getSource()==Cmb_Semestre) {
            String seleccionado=(String)Cmb_Semestre.getSelectedItem();
            setTitle(seleccionado);
        }
    }
    
    public void ColocarBotones(){
        Nuevo.setBounds(90, 340, 100, 30);
        panel.add(Nuevo);
        Nuevo.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Nuevo.setMnemonic('n');//Sirve para que se active el boton con el teclado Alt + n
        
        Guardar.setBounds(200, 340, 100, 30);
        panel.add(Guardar);
        Guardar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Guardar.setMnemonic('g');//Sirve para que se active el boton con el teclado Alt + g
        
        Eliminar.setBounds(310, 340, 100, 30);
        panel.add(Eliminar);
        Eliminar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Eliminar.setMnemonic('e');//Sirve para que se active el boton con el teclado Alt + e
    }
    
    //Conexion de registro
    public void ModelTableDefault(){
        Tabla_Matricula.setBounds(450, 37, 300, 300);
        Tabla_Matricula.setModel(modelo);
        panel1.add(new JScrollPane(Tabla_Matricula));
        viewRegister();
    }

    private void addRegister(ActionEvent evt) {
        String ci = txt_ci.getText();
        String alum = txt_nombre.getText();
        String carr = (String) Cmb_Carrera.getSelectedItem();
        String semes = (String) Cmb_Semestre.getSelectedItem();
        String peri = (String) Cmb_Periodo.getSelectedItem();
        String docen = (String) Cmb_Docente.getSelectedItem();
        String materia = txt_materia.getText();
        if (!ci.isEmpty() && !alum.isEmpty() && !carr.isEmpty() && !semes.isEmpty() && !peri.isEmpty() && !docen.isEmpty() && !materia.isEmpty()) {
            //Creamos una nota - todavia no se guarda en la base de datos
            Document doc = new Document("C1", ci).append("Alumno", alum).append("Carrera", carr).append("Semestre", semes).append("Periodo", peri).append("Docente", docen).append("Materia", materia);
            try {
                //Insertamos la nota en la base de datos
                matri.insertOne(doc);
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
            FindIterable<Document> documents = matri.find();

            // Iterar sobre los documentos e imprimirlos
            for (Document document : documents) {
                // Ajusta los nombres de los campos según tus datos
                Object[] fila = {
                    document.getString("C1"),
                    document.getString("Alumno"),
                    document.getString("Carrera"),
                    document.getString("Semestre"),
                    document.getString("Periodo"),
                    document.getString("Docente"),
                    document.getString("Materia")
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
        Cmb_Carrera.setSelectedItem(null);
        Cmb_Semestre.setSelectedItem(null);
        Cmb_Periodo.setSelectedItem(null);
        Cmb_Docente.setSelectedItem(null);
        txt_materia.setText("");
    }

    private void EliminarActionPerformed(ActionEvent evt) {
        int fila = Tabla_Matricula.getSelectedRow();
        if (fila != -1) {
            // Obtener los datos de la fila seleccionada
            String ci = (String) Tabla_Matricula.getValueAt(fila, 0);
            String alum = (String) Tabla_Matricula.getValueAt(fila, 1);
            String carr = (String) Tabla_Matricula.getValueAt(fila, 2);
            String semes = (String) Tabla_Matricula.getValueAt(fila,3);
            String peri = (String) Tabla_Matricula.getValueAt(fila, 4);
            String docen = (String) Tabla_Matricula.getValueAt(fila,5);
            String materia = (String) Tabla_Matricula.getValueAt(fila, 6);
            // Obtén más valores según tus necesidades

            // Configurar los criterios de eliminación
            Document criterios = new Document("C1", ci).append("Alumno", alum).append("Carrera", carr).append("Semestre", semes).append("Periodo", peri).append("Docente", docen).append("Materia", materia);
            // Agrega más criterios según tus necesidades

            // Eliminar el documento en MongoDB
            try{
                matri.deleteOne(criterios);
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
