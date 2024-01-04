package edd_parcial2_practica2_metodo.de.ordenamiento_alexanderq;

import static edd_parcial2_practica2_metodo.de.ordenamiento_alexanderq.StringOnlyException.validateString;
import java.awt.*;
import java.awt.event.*;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author Alexander Quizhpe
 */
public class Burbuja extends JFrame{
     public JPanel panel;
    JTextField txt_name = new JTextField();
    JTextArea resultArea = new JTextArea(10, 30);
    JButton AddButton = new JButton("Agregar");
    JButton SimularButton = new JButton("Simular");
    private String[] names;
    
    //Creamos una ventana grafica con JFrame
    public Burbuja (){
        names = new String[0];
        AddButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                addName();
            }
        });
        
        SimularButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                simulateBubbleSort();
            }
        });
        
       this.setSize(500,500); 
       setTitle("Metodo de Ordenamiento Burbuja"); //Comando que permitecolocar nombre a la ventana
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
    }

    private void colocarPanel(){
        panel = new JPanel();
        //Comando para aplicar color al panel
        panel.setBackground(Color.gray);
        //Poner el panel sobre la ventana del registro
        this.getContentPane().add(panel);
    }

    public void colocarEtiquetas(){
        JLabel label = new JLabel("Ordenamiento Burbuja - Nombres",SwingConstants.CENTER);
        panel.add(label);
        panel.setLayout(null);
        label.setBounds(70, 10, 350, 20);
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setForeground(Color.white);

        JLabel label1 = new JLabel();
        label1.setText("Nombre: ");
        panel.add(label1);
        //Comando para ubicar el label
        label1.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label1.setFont(new Font("Arial", Font.PLAIN, 15));
        label1.setBounds(30, 45, 70, 15);
        label1.setForeground(Color.white);
    }

    //Comando para colocar cajas de texto
    public void ColocarCajatexto(){
        txt_name.setBounds(105, 43, 100, 20);
        panel.add(txt_name);
    }

    public void ColocarAreatext(){
        resultArea.setBounds(40, 80, 400, 340);
        resultArea.setEditable(false);
        panel.add(resultArea);
    }

    public void ColocarBotones(){
        
        AddButton.setBounds(230, 40, 100, 30);
        panel.add(AddButton);
        AddButton.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        AddButton.setMnemonic('a');//Sirve para que se active el boton con el teclado Alt + n
        
        
        SimularButton.setBounds(350, 40, 100, 30);
        panel.add(SimularButton);
        SimularButton.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        SimularButton.setMnemonic('s');//Sirve para que se active el boton con el teclado Alt + n
    }
    
    private void addName(){
        try{
            String name = txt_name.getText();
            validateString(name);
            String [] newArray = new String[names.length+1];
            System.arraycopy(names,0,newArray,0,names.length);
            newArray[names.length]=name;
            names = newArray;
            txt_name.setText("");
            updateResultArea();
        }catch(StringOnlyException e){
            JOptionPane.showMessageDialog(this, "Solo se permiten cadenas de texto (Letras)","Error", JOptionPane.ERROR_MESSAGE);
            txt_name.setText(" ");
        }
    }
    
    public static void sort(String [] arr) {
    //Se declara un método estático llamado sort que toma un arreglo de enteros como parámetro. Este método implementa el algoritmo de ordenamiento de burbuja.
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            String temp = "";
            for(int i = 0; i < n; i++) {
                for(int j = 1; j < (n - i); j++) {
                    if(arr[j - 1].compareTo(arr[j]) > 0) {
                        temp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        } while (swapped);
    }
     
    private void simulateBubbleSort(){
        this.sort(names);
        updateResultArea();
    }
    
    private void updateResultArea(){
        StringBuilder sb = new StringBuilder();
        for (String num:names){
            sb.append(num).append(" ");
        }
        resultArea.setText("Nombres Ingresados: "+sb.toString());
    }
}
