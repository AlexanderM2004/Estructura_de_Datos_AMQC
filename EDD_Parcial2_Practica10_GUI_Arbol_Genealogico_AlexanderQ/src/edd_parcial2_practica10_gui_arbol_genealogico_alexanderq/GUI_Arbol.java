package edd_parcial2_practica10_gui_arbol_genealogico_alexanderq;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Alexander Quizhpe
 */
public class GUI_Arbol extends JFrame{
    
    CraerArbolGenealogico arbol = new CraerArbolGenealogico();
    
    public JPanel panel;
    JTextField txt_number = new JTextField();
    JTextField txt_name = new JTextField();
    JTextArea resultArea = new JTextArea(20, 2);
    JComboBox Cmb_Persona = new JComboBox();
    JComboBox Cmb_Genero = new JComboBox();
    JButton AddButton = new JButton("Agregar");
    JButton ViewButton = new JButton("Mostrar");
    private String[] nombresEstudiantes;
    private int[] notasEstudiantes;
    
    //Creamos una ventana grafica con JFrame
    public GUI_Arbol (){
        AddButton.addActionListener((ActionEvent e) -> {
            //addRegister();
        });
        
        ViewButton.addActionListener((ActionEvent e) -> {
            //simulateBubbleSort();
        });
        
       this.setSize(680,450); 
       setTitle("Arbol Binario"); //Comando que permitecolocar nombre a la ventana
       //Comando que permite finalizar todo el programa en el momento que se cierra la ventana
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       //Comando para centrar la ventana del monitor
       setLocationRelativeTo(null);
       iniciarComponentes();
    }

    private void iniciarComponentes(){
        colocarPanel();
        colocarEtiquetas();
        ColocarBotones();
        ColocarCajatexto();
        ColocarAreatext();
        ColocarComboBox();
    }

    private void colocarPanel(){
        panel = new JPanel();
        //Comando para aplicar color al panel
        panel.setBackground(Color.gray);
        //Poner el panel sobre la ventana del registro
        this.getContentPane().add(panel);
    }

    public void colocarEtiquetas(){
        JLabel label = new JLabel("Arbol Binario",SwingConstants.CENTER);
        panel.add(label);
        panel.setLayout(null);
        label.setBounds(175, 10, 350, 20);
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setForeground(Color.white);
        
        JLabel label1 = new JLabel();
        label1.setText("Nombre: ");
        panel.add(label1);
        //Comando para ubicar el label
        label1.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label1.setFont(new Font("Arial", Font.PLAIN, 15));
        label1.setBounds(20, 45, 120, 15);
        label1.setForeground(Color.white);
        
        JLabel label2 = new JLabel();
        label2.setText("Carga Familiar: ");
        panel.add(label2);
        //Comando para ubicar el label
        label2.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label2.setFont(new Font("Arial", Font.PLAIN, 15));
        label2.setBounds(20, 70, 120, 15);
        label2.setForeground(Color.white);
        
        JLabel label3 = new JLabel();
        label3.setText("Nacimiento: ");
        panel.add(label3);
        //Comando para ubicar el label
        label3.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label3.setFont(new Font("Arial", Font.PLAIN, 15));
        label3.setBounds(20, 95, 120, 15);
        label3.setForeground(Color.white);
        
        JLabel label4 = new JLabel();
        label4.setText("Genero: ");
        panel.add(label4);
        //Comando para ubicar el label
        label4.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label4.setFont(new Font("Arial", Font.PLAIN, 15));
        label4.setBounds(20, 120, 120, 15);
        label4.setForeground(Color.white);
    }

    //Comando para colocar cajas de texto
    public void ColocarCajatexto(){
        txt_name.setBounds(125, 43, 150, 20);
        panel.add(txt_name);
        txt_number.setBounds(125, 95, 150, 20);
        panel.add(txt_number);
    }

    public void ColocarAreatext(){
        resultArea.setBounds(290, 43, 340, 340);
        resultArea.setEditable(false);
        panel.add(resultArea);
    }

    public void ColocarBotones(){
        AddButton.setBounds(75, 180, 150, 30);
        panel.add(AddButton);
        AddButton.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        AddButton.setMnemonic('a');//Sirve para que se active el boton con el teclado Alt + n
       
        ViewButton.setBounds(75, 220, 150, 30);
        panel.add(ViewButton);
        ViewButton.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        ViewButton.setMnemonic('m');//Sirve para que se active el boton con el teclado Alt + b
    }
    
    public void ColocarComboBox(){
        Cmb_Persona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abuelo", "Abuela", "Padre", "Madre", "Hijo"}));
        Cmb_Persona.setBounds(125, 70, 150, 20);
        panel.add(Cmb_Persona);
        
        Cmb_Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino"}));
        Cmb_Genero.setBounds(125,120,150,20);
        panel.add(Cmb_Genero);
    }
    
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==Cmb_Persona) {
            String seleccionado=(String)Cmb_Persona.getSelectedItem();
            setTitle(seleccionado);
        }
        if (e.getSource()==Cmb_Genero) {
            String seleccionado=(String)Cmb_Genero.getSelectedItem();
            setTitle(seleccionado);
        }
    }
    
    private void mostrarResultado(String mensaje) {
        resultArea.append(mensaje + "\n\n");
    }
}
