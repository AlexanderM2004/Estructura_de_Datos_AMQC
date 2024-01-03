package edd_parcial2_practica1_metodo.burbuja_alexanderq;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



/**
 *
 * @author Alexander Quizhpe
 */
public class Burbuja extends JFrame{
    public JPanel panel;
    JTextField txt_number = new JTextField();
    JTextArea resultArea = new JTextArea(10, 30);
    JButton AddButton = new JButton("Agregar");
    JButton SimularButton = new JButton("Simular");
    private int[] numbers;
    
    //Creamos una ventana grafica con JFrame
    public Burbuja (){
        numbers = new int[0];
        AddButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                addNumber();
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
        JLabel label = new JLabel("Ordenamiento Burbuja",SwingConstants.CENTER);
        panel.add(label);
        panel.setLayout(null);
        label.setBounds(70, 10, 350, 20);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.white);

        JLabel label1 = new JLabel();
        label1.setText("Numero: ");
        panel.add(label1);
        //Comando para ubicar el label
        label1.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label1.setFont(new Font("Arial", Font.PLAIN, 15));
        label1.setBounds(30, 45, 70, 15);
    }

    //Comando para colocar cajas de texto
    public void ColocarCajatexto(){
        txt_number.setBounds(105, 43, 100, 20);
        panel.add(txt_number);
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
    
    private void addNumber(){
        try{
            int number = Integer.parseInt(txt_number.getText());
            int [] newArray = new int[numbers.length+1];
            System.arraycopy(numbers,0,newArray,0,numbers.length);
            newArray[numbers.length]=number;
            numbers = newArray;
            txt_number.setText("");
            updateResultArea();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Ingrese un numero valido","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean sort(int [] numbers){
        try {
            for(int i = 0; i < numbers.length - 1; i++){
                for(int j = 0; j < numbers.length - 1 - i; j++){
                    if(numbers[j] > numbers[1 + j]){
                        int aux = numbers[j];
                        numbers[j] = numbers[1 + j];
                        numbers[1 + j]= aux;
                    }
                }
            }
            return true;
        } catch (Exception e){
            System.out.println("Error: " + e);
            return false;
        }
    }
     
    private void simulateBubbleSort(){
        this.sort(numbers);
        updateResultArea();
    }
    
    private void updateResultArea(){
        StringBuilder sb = new StringBuilder();
        for (int num:numbers){
            sb.append(num).append(" ");
        }
        resultArea.setText("Numero Ingresados " + sb.toString());
    }
}
