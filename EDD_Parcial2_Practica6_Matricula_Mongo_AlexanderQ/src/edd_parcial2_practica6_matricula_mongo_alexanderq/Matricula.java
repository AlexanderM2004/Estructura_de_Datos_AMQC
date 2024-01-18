package edd_parcial2_practica6_matricula_mongo_alexanderq;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.awt.*;
import java.awt.event.*;
import static java.awt.image.ImageObserver.HEIGHT;
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
    Color color; // = new Color(127, 140, 141);
    Color color1;// = new Color(149, 165, 166);
    JTable Tabla_Laboratorio = new JTable();
    JTextField txt_Nota = new JTextField();
    JTextField txt_nombre = new JTextField();
    JTextField txt_Docente = new JTextField();
    JComboBox Cmb_Carrera = new JComboBox();
    JComboBox Cmb_Semestre = new JComboBox();
    JComboBox Cmb_Periodo = new JComboBox();
    JButton Nuevo = new JButton("Nuevo");
    JButton Guardar = new JButton("Guardar");
    JButton Eliminar = new JButton("Eliminar");
    JButton Editar = new JButton("Editar");
    
    //Creamos una ventana grafica con JFrame
    public Matricula (){
       this.setSize(1000,400); 
       setTitle("Registro Matricula"); //Comando que permitecolocar nombre a la ventana
       //Comando que permite finalizar todo el programa en el momento que se cierra la ventana
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       iniciarComponentes();
       //mostrarDatos();
       ModelTableDefault();
    }
    
    private void iniciarComponentes(){
        colocarPanel();
        colocarEtiquetas();
        ColocarBotones();
        ColocarCajatexto();
        ColocarComboBox();
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //NuevoActionPerformed(evt);
            }
        });
        
        Guardar.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                //GuardarActionPerformed(evt);
            }
        });
        
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //EliminarActionPerformed(evt);
            }
        });
        
        Editar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //EditarActionPerformed(evt);
            }
        });
    }
   
    private void colocarPanel(){
        panel = new JPanel();
        panel1 = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        panel1.setPreferredSize(new Dimension(700, 500));
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
        Nuevo.setBounds(40, 300, 100, 30);
        panel.add(Nuevo);
        Nuevo.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Nuevo.setMnemonic('n');//Sirve para que se active el boton con el teclado Alt + n
        
        Guardar.setBounds(140, 300, 100, 30);
        panel.add(Guardar);
        Guardar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Guardar.setMnemonic('g');//Sirve para que se active el boton con el teclado Alt + g
        
        Eliminar.setBounds(240, 300, 100, 30);
        panel.add(Eliminar);
        Eliminar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Eliminar.setMnemonic('d');//Sirve para que se active el boton con el teclado Alt + d
        
        Editar.setBounds(340, 300, 100, 30);
        panel.add(Editar);
        Editar.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        Editar.setMnemonic('e');//Sirve para que se active el boton con el teclado Alt + e
    }
    
    //Conexion de registro
    public void ModelTableDefault (){
        Tabla_Laboratorio.setBounds(450, 37, 500, 500);
        String titulos[] = {"Alumno", "Carrera", "Semestre", "Periodo", "Docente", "Nota"};
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        Tabla_Laboratorio.setModel(modelo);
        //Tabla_Laboratorio.setPreferredScrollableViewportSize(Tabla_Laboratorio.getPreferredSize());
        panel1.add(new JScrollPane(Tabla_Laboratorio));
        //mostrarDatos();
    }
}
