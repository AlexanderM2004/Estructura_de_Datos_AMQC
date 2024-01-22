package edd_parcial2_practica6_matricula_mongo_alexanderq;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.awt.*;
import java.awt.event.*;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.*;
import org.bson.Document;
import org.bson.types.ObjectId;
/**
 *
 * @author Alexander Quizhpe
 */
public class Matricula extends JFrame{
    public JPanel panel;
    public JPanel panel1;
    Graphics g;
    Color color;
    Color color1;
    JTable Tabla_Laboratorio = new JTable();
    JTextField txt_Nota = new JTextField();
    JTextField txt_nombre = new JTextField();
    JTextField txt_Docente = new JTextField();
    JTextField txt_Search = new JTextField();
    JComboBox Cmb_Carrera = new JComboBox();
    JComboBox Cmb_Semestre = new JComboBox();
    JComboBox Cmb_Periodo = new JComboBox();
    JButton Nuevo = new JButton("Nuevo");
    JButton Guardar = new JButton("Guardar");
    JButton Eliminar = new JButton("Eliminar");
    JButton Editar = new JButton("Editar");
    JButton OrdenarMam = new JButton("Ordenar Mayor a Menor");
    JButton OrdenarmaM = new JButton("Ordenar Menor a Mayor");
    JButton Buscar = new JButton("Buscar");
    
    String titulos[] = {"Alumno", "Carrera", "Semestre", "Periodo", "Docente", "Nota"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
    //Conectamos a la base de datos
    public MongoDatabase db = new DB_MongoDB().ConnectDB(); 
    //Coleccion de notas
    public MongoCollection<Document> regis = db.getCollection("Registros");
    
    //Creamos una ventana grafica con JFrame
    public Matricula (){
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
        Nuevo.addActionListener((java.awt.event.ActionEvent evt) -> {
            NuevoActionPerformed(evt);
        });
        
        Guardar.addActionListener((java.awt.event.ActionEvent evt) -> {
            addRegister(evt);
        });
        
        Eliminar.addActionListener((java.awt.event.ActionEvent evt) -> {
            EliminarActionPerformed(evt);
        });
        
        Editar.addActionListener((java.awt.event.ActionEvent evt) -> {
            EditarActionPerformed(evt);
        });
        
        OrdenarMam.addActionListener((java.awt.event.ActionEvent evt) -> {
            ordenarTabla("Nota", -1);
        });
        
        OrdenarmaM.addActionListener((java.awt.event.ActionEvent evt) -> {
            ordenarTabla("Nota", 1);
        });
        
        Buscar.addActionListener((java.awt.event.ActionEvent evt) -> {
            searchDB();
        });
    }
   
    private void colocarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel1 = new JPanel();
        panel.setPreferredSize(new Dimension(500, 400));
        panel1.setPreferredSize(new Dimension(600, 400));
        //Comando para aplicar color al panel
        panel.setBackground(color = new Color(127, 140, 141));
        panel1.setBackground(color1 = new Color(149, 165, 166));
        //Poner el panel sobre la ventana del registro
        this.getContentPane().add(panel, BorderLayout.WEST);
        this.getContentPane().add(panel1, BorderLayout.EAST);
        this.pack();
    }
    
    public void colocarEtiquetas(){
        JLabel label = new JLabel("Registro Matricula",SwingConstants.CENTER);
        panel.add(label);
        panel.setLayout(null);
        label.setBounds(75, 10, 350, 15);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.white);
        
        JLabel label1 = new JLabel();
        label1.setText("Alumno: ");
        panel.add(label1);
        //Comando para ubicar el label
        label1.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label1.setFont(new Font("Arial", Font.PLAIN, 15));
        label1.setBounds(40, 40, 100, 15);
        
        JLabel label2 = new JLabel();
        label2.setText("Carrera: ");
        panel.add(label2);
        //Comando para ubicar el label
        label2.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label2.setFont(new Font("Arial", Font.PLAIN, 15));
        label2.setBounds(40, 80, 100, 15);
        
        JLabel label3 = new JLabel();
        label3.setText("Semestre: ");
        panel.add(label3);
        //Comando para ubicar el label
        label3.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label3.setFont(new Font("Arial", Font.PLAIN, 15));
        label3.setBounds(40, 120, 100, 15);
        
        JLabel label4 = new JLabel();
        label4.setText("Periodo: ");
        panel.add(label4);
        //Comando para ubicar el label
        label4.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label4.setFont(new Font("Arial", Font.PLAIN, 15));
        label4.setBounds(40, 160, 100, 15);
        
        JLabel label5 = new JLabel();
        label5.setText("Docente: ");
        panel.add(label5);
        //Comando para ubicar el label
        label5.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label5.setFont(new Font("Arial", Font.PLAIN, 15));
        label5.setBounds(40, 200, 100, 15);
        
        JLabel label6 = new JLabel();
        label6.setText("Nota: ");
        panel.add(label6);
        //Comando para ubicar el label
        label6.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label6.setFont(new Font("Arial", Font.PLAIN, 15));
        label6.setBounds(40, 240, 100, 15);
    }
    
    //Comando para colocar cajas de texto
    public void ColocarCajatexto(){
        txt_nombre.setBounds(140, 37, 300, 20);
        panel.add(txt_nombre);
        
        txt_Docente.setBounds(140, 197, 300, 20);
        panel.add(txt_Docente);
        
        txt_Nota.setBounds(140, 237, 50, 20);
        panel.add(txt_Nota);
        
        txt_Search.setBounds(150, 355, 290, 20);
        panel.add(txt_Search);
    }
    
    public void ColocarComboBox(){
        Cmb_Carrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tecnologias de la Información", "Biotecnologia", "Agropecuaria"}));
        Cmb_Carrera.setBounds(140, 77, 300, 20);
        panel.add(Cmb_Carrera);
        
        Cmb_Semestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Septimo", "Octavo", "Noveno"}));
        Cmb_Semestre.setBounds(140,117,300,20);
        panel.add(Cmb_Semestre);
        
        Cmb_Periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "202351", "202350","202251", "202250"}));
        Cmb_Periodo.setBounds(140,157,300,20);
        panel.add(Cmb_Periodo);
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
        Nuevo.setBounds(40, 275, 100, 30);
        panel.add(Nuevo);
        Nuevo.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Nuevo.setMnemonic('n');//Sirve para que se active el boton con el teclado Alt + n
        
        Guardar.setBounds(140, 275, 100, 30);
        panel.add(Guardar);
        Guardar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Guardar.setMnemonic('g');//Sirve para que se active el boton con el teclado Alt + g
        
        Eliminar.setBounds(240, 275, 100, 30);
        panel.add(Eliminar);
        Eliminar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Eliminar.setMnemonic('l');//Sirve para que se active el boton con el teclado Alt + l
        
        Editar.setBounds(340, 275, 100, 30);
        panel.add(Editar);
        Editar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Editar.setMnemonic('e');//Sirve para que se active el boton con el teclado Alt + e
        
        OrdenarMam.setBounds(40, 315, 200, 30);
        panel.add(OrdenarMam);
        OrdenarMam.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        OrdenarMam.setMnemonic('o');//Sirve para que se active el boton con el teclado Alt + o
        
        OrdenarmaM.setBounds(240, 315, 200, 30);
        panel.add(OrdenarmaM);
        OrdenarmaM.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        OrdenarmaM.setMnemonic('r');//Sirve para que se active el boton con el teclado Alt + r
        
        Buscar.setBounds(40, 355, 100, 20);
        panel.add(Buscar);
        Buscar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Buscar.setMnemonic('b');//Sirve para que se active el boton con el teclado Alt + b
    }
    
    //Conexion de registro
    public void ModelTableDefault(){
        Tabla_Laboratorio.setBounds(450, 37, 300, 300);
        Tabla_Laboratorio.setModel(modelo);
        panel1.add(new JScrollPane(Tabla_Laboratorio));
        //mostrarDatos();
        viewRegister();
    }

    private void addRegister(ActionEvent evt) {
        String alum = txt_nombre.getText();
        String carr = (String) Cmb_Carrera.getSelectedItem();
        String semes = (String) Cmb_Semestre.getSelectedItem();
        String peri = (String) Cmb_Periodo.getSelectedItem();
        String docen = txt_Docente.getText();
        String nota = txt_Nota.getText();
        //Creamos una nota - todavia no se guarda en la base de datos
        Document doc = new Document("Alumno", alum).append("Carrera", carr).append("Semestre", semes).append("Periodo", peri).append("Docente", docen).append("Nota", nota);
        try {
            //Insertamos la nota en la base de datos
            regis.insertOne(doc);
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hubo un error al registrar el usuario");
        }
        modelo.setRowCount(0);
        viewRegister();
    }
    
    private void viewRegister(){
        try {
            // Realizar una operación de lectura (por ejemplo, encontrar todos los documentos)
            FindIterable<Document> documents = regis.find();

            // Iterar sobre los documentos e imprimirlos
            for (Document document : documents) {
                // Ajusta los nombres de los campos según tus datos
                Object[] fila = {
                    document.getString("Alumno"),
                    document.getString("Carrera"),
                    document.getString("Semestre"),
                    document.getString("Periodo"),
                    document.getString("Docente"),
                    document.getString("Nota")
                };
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void NuevoActionPerformed(ActionEvent evt) {
        txt_nombre.setText("");
        Cmb_Carrera.setSelectedItem(null);
        Cmb_Semestre.setSelectedItem(null);
        Cmb_Periodo.setSelectedItem(null);
        txt_Docente.setText("");
        txt_Nota.setText("");
    }

    private void EliminarActionPerformed(ActionEvent evt) {
        int fila = Tabla_Laboratorio.getSelectedRow();
        if (fila != -1) {
            // Obtener los datos de la fila seleccionada
            String alum = (String) Tabla_Laboratorio.getValueAt(fila, 0);
            String carr = (String) Tabla_Laboratorio.getValueAt(fila, 1);
            String semes = (String) Tabla_Laboratorio.getValueAt(fila, 2);
            String peri = (String) Tabla_Laboratorio.getValueAt(fila, 3);
            String docen = (String) Tabla_Laboratorio.getValueAt(fila, 4);
            String nota = (String) Tabla_Laboratorio.getValueAt(fila, 5);
            // Obtén más valores según tus necesidades

            // Configurar los criterios de eliminación
            Document criterios = new Document("Alumno", alum).append("Carrera", carr).append("Semestre", semes).append("Periodo", peri).append("Docente", docen).append("Nota", nota);
            // Agrega más criterios según tus necesidades

            // Eliminar el documento en MongoDB
            try{
                regis.deleteOne(criterios);
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
    
    private void ordenarTabla(String campo, int orden) {
        // Ordenar el modelo de la tabla según el campo y el orden especificados
        modelo.setRowCount(0); // Limpiar filas existentes
        try {
            // Realizar una consulta y ordenar según el campo y el orden
            FindIterable<Document> documents = regis.find().sort(new Document(campo, orden));

            // Iterar sobre los documentos e imprimirlos
            for (Document document : documents) {
                // Ajusta los nombres de los campos según tus datos
                Object[] fila = {
                    document.getString("Alumno"),
                    document.getString("Carrera"),
                    document.getString("Semestre"),
                    document.getString("Periodo"),
                    document.getString("Docente"),
                    document.getString("Nota")
                };
                modelo.addRow(fila);
            }
            
            // Actualizar la representación visual de la tabla
            Tabla_Laboratorio.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al ordenar la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void searchDB(){
        String nombreBuscar = txt_Search.getText();
        try {
            //Filtro para la base de datos
            Document sort;
            sort = new Document("Alumno", nombreBuscar);
            
            //Obtener los datos de la base de datos
            FindIterable<Document> docs = regis.find((sort));
            for(Document documento : docs){
                
                String mensaje = "Alumno: " + documento.getString("Alumno")+"\n"+"Carrera: " + documento.getString("Carrera")+"\n"+"Semestre: " + documento.getString("Semestre")+"\n"+"Periodo: " + documento.getString("Periodo")+"\n"+"Docente: " + documento.getString("Docente")+"\n"+"Nota: " + documento.getString("Nota");         
                JOptionPane.showMessageDialog(null, mensaje, "Buscar Estudiante", JOptionPane.INFORMATION_MESSAGE);        
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void EditarActionPerformed(ActionEvent evt) {
        int fila = Tabla_Laboratorio.getSelectedRow();

        if (fila != -1) {
            // Obtener los datos de la fila seleccionada
            String alum = (String) Tabla_Laboratorio.getValueAt(fila, 0);
            String carr = (String) Tabla_Laboratorio.getValueAt(fila, 1);
            String semes = (String) Tabla_Laboratorio.getValueAt(fila, 2);
            String peri = (String) Tabla_Laboratorio.getValueAt(fila, 3);
            String docen = (String) Tabla_Laboratorio.getValueAt(fila, 4);
            String nota = (String) Tabla_Laboratorio.getValueAt(fila, 5);
            // Obtén más valores según tus necesidades

            // Permitir al usuario editar los datos
            String nalum = JOptionPane.showInputDialog(this, "Alumno:", alum);
            String ncarr = JOptionPane.showInputDialog(this, "Carrera:", carr);
            String nsemes = JOptionPane.showInputDialog(this, "Semestre:", semes);
            String nperi = JOptionPane.showInputDialog(this, "Periodo:", peri);
            String ndocen = JOptionPane.showInputDialog(this, "Docente1:", docen);
            String nnota = JOptionPane.showInputDialog(this, "Nota:", nota);
            // Obtén más nuevos valores según tus necesidades

            // Actualizar el modelo de la tabla con los nuevos valores
            Tabla_Laboratorio.setValueAt(nalum, fila, 0);
            Tabla_Laboratorio.setValueAt(ncarr, fila, 1);
            Tabla_Laboratorio.setValueAt(nsemes, fila, 3);
            Tabla_Laboratorio.setValueAt(nperi, fila, 4);
            Tabla_Laboratorio.setValueAt(ndocen, fila, 5);
            Tabla_Laboratorio.setValueAt(nnota, fila, 6);
            // Actualiza más columnas según tus necesidades

            // Actualizar los datos en MongoDB
            try {

                // Construir el filtro para identificar el documento a actualizar
                Document filtro = new Document("Alumno", alum).append("Carrera", carr).append("Semestre", semes).append("Periodo", peri).append("Docente", docen).append("Nota", nota);
                // Agrega más campos según tus necesidades

                // Construir el documento con los nuevos valores
                Document nuevosValores = new Document("Alumno", nalum).append("Carrera", ncarr).append("Semestre", nsemes).append("Periodo", nperi).append("Docente", ndocen).append("Nota", nnota);
                // Agrega más campos según tus necesidades

                // Realizar la actualización en MongoDB
                regis.updateOne(filtro, new Document("$set", nuevosValores));
                JOptionPane.showMessageDialog(this, "Fila editada con éxito");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al editar la fila", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila antes de intentar editar", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
