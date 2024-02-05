package edd_parcial2_practica6_matricula_completa_alexanderq;

import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Alexander Quizhpe
 */

public class Matricula extends JFrame {
    public JPanel panel;
    public JPanel panel1;
    JTable Tabla_Matricula = new JTable();
    JLabel atras = new JLabel();
    JTextField txt_ci = new JTextField();
    JLabel lbl_nombre = new JLabel();
    JLabel lbl_carrera = new JLabel();
    JButton Nuevo = new JButton("Nuevo");
    JButton Buscar = new JButton("Buscar");
    JButton Eliminar = new JButton("Eliminar");
    
    String titulos[] = {"", "Datos"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
    //Conectamos a la base de datos
    public MongoDatabase db = new DB_MongoDB().ConnectDB(); 
    //Coleccion de notas
    public MongoCollection<Document> matri = db.getCollection("Matricula");
    
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
        //limpiarTabla();
        atras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                IniciarActionPerformed(e);
            }
        });
        
        Nuevo.addActionListener((java.awt.event.ActionEvent evt) -> {
            NuevoActionPerformed(evt);
        });
        
        Eliminar.addActionListener((java.awt.event.ActionEvent evt) -> {
            EliminarActionPerformed(evt);
        });
        
        Buscar.addActionListener((java.awt.event.ActionEvent evt) -> {
            buscarPersona();
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
        JLabel label = new JLabel("Verificar Matricula",SwingConstants.CENTER);
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
        
        panel.add(lbl_nombre);
        //Comando para ubicar el label
        lbl_nombre.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        lbl_nombre.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_nombre.setBounds(140, 90, 300, 15);
        
        
        JLabel label2 = new JLabel();
        label2.setText("Carrera: ");
        panel.add(label2);
        //Comando para ubicar el label
        label2.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label2.setFont(new Font("Arial", Font.PLAIN, 15));
        label2.setBounds(40, 130, 100, 15);
        
        panel.add(lbl_carrera);
        //Comando para ubicar el label
        lbl_carrera.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        lbl_carrera.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_carrera.setBounds(140, 130, 300, 15);
        
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
    }
    
    public void ColocarBotones(){
        Nuevo.setBounds(90, 250, 100, 30);
        panel.add(Nuevo);
        Nuevo.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Nuevo.setMnemonic('n');//Sirve para que se active el boton con el teclado Alt + n
        
        Buscar.setBounds(200, 250, 100, 30);
        panel.add(Buscar);
        Buscar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Buscar.setMnemonic('n');//Sirve para que se active el boton con el teclado Alt + n
        
        Eliminar.setBounds(310, 250, 100, 30);
        panel.add(Eliminar);
        Eliminar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Eliminar.setMnemonic('n');//Sirve para que se active el boton con el teclado Alt + n
    }
    
    //Conexion de registro
    public void ModelTableDefault(){
        Tabla_Matricula.setBounds(450, 37, 300, 300);
        Tabla_Matricula.setModel(modelo);
        panel1.add(new JScrollPane(Tabla_Matricula));
        //viewRegister();
    }
    
    private void buscarPersona() {
        // Obtener el CI ingresado
        String ci = txt_ci.getText();

        // Conectar a la base de datos MongoDB
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("Gestion_Matriculas_AMQC");
            MongoCollection<Document> registrosCollection = database.getCollection("Matricula");

            // Realizar la búsqueda por CI
        List<Document> personas = registrosCollection.find(Filters.eq("C1", ci))
                .projection(Projections.fields(Projections.include("Alumno", "Carrera", "Semestre", "Periodo", "Docente", "Materia"), Projections.excludeId()))
                .into(new ArrayList<>());

            if (!personas.isEmpty()) {
                // Mostrar resultados en los labels
                lbl_nombre.setText(personas.get(0).getString("Alumno"));
                lbl_carrera.setText(personas.get(0).getString("Carrera"));

                // Mostrar datos faltantes en la tabla
                mostrarTabla(personas);
            } else {
                // Limpiar labels y tabla
                lbl_nombre.setText("");
                lbl_carrera.setText("");
                limpiarTabla();
                
                // Mostrar mensaje de no encontrado
                JOptionPane.showMessageDialog(this, "Persona con CI " + ci + " no encontrada", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar persona", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void mostrarTabla(List<Document> personas) {
        // Limpiar la tabla antes de agregar nuevos datos
        limpiarTabla();
 
        // Excluir campos específicos que no se deben mostrar
        List<String> camposExcluidos = Arrays.asList("Periodo", "Docente", "Materia");

        // Llenar la tabla con los datos faltantes
        DefaultTableModel modeloTabla = (DefaultTableModel) Tabla_Matricula.getModel();
        for (Document persona : personas) {
            Object[] fila = new Object[2];
            for (String clave : persona.keySet()) {
                if (camposExcluidos.contains(clave)) {
                    Object valor = persona.get(clave);
                    fila[0] = clave;
                    fila[1] = valor;

                    modeloTabla.addRow(fila);
                    System.out.println("Agregado a la tabla: " + clave + ", " + valor);
                }
            }
            modeloTabla.addRow(new Object[modeloTabla.getColumnCount()]);
        }
        // Repintar la tabla después de agregar los datos
        Tabla_Matricula.repaint();
    }
    
    private void limpiarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) Tabla_Matricula.getModel();
        modeloTabla.setRowCount(0);
    }
    
    private void viewRegister(Document persona){
        try {
            // Realizar una operación de lectura (por ejemplo, encontrar todos los documentos)
            FindIterable<Document> documents = matri.find();
            // Excluir campos específicos que no se deben mostrar
            List<String> campos = persona.keySet().stream().filter(key -> !key.equals("C1")&&!key.equals("Alumno") && !key.equals("Carrera")&& !key.equals("Semestre")).toList();

            // Iterar sobre los documentos e imprimirlos
            for (Document document : documents) {
                // Ajusta los nombres de los campos según tus datos
                Object[] fila = {
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
        lbl_nombre.setText("");
        lbl_carrera.setText("");
        limpiarTabla();
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
