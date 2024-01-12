package edd_parcial2_practica5_algoritmobusqueda_alexanderq;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author PERSONAL
 */
public class Busqueda extends JFrame{
    public JPanel panel;
    JTextField txt_number = new JTextField();
    JTextArea resultArea = new JTextArea(10, 30);
    JButton AddButton = new JButton("Agregar");
    JButton OrderButton = new JButton("Ordenar");
    JButton SearchSButton = new JButton("Secuencial");
    JButton SearchBButton = new JButton("Binario");
    private int[] number;
    int num;
    //Creamos una ventana grafica con JFrame
    public Busqueda (){
        number = new int[0];
        AddButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                addNumber();
            }
        });
        
        OrderButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                simulateBubbleSort();
            }
        });
        
        SearchSButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                searchSeleccion();
            }
        });
        
        SearchBButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                searchBinary();
            }
        });
       this.setSize(680,450); 
       setTitle("Algoritmos de Busqueda"); //Comando que permitecolocar nombre a la ventana
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
        JLabel label = new JLabel("Busqueda Seleccion - Binaria",SwingConstants.CENTER);
        panel.add(label);
        panel.setLayout(null);
        label.setBounds(175, 10, 350, 20);
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setForeground(Color.white);

        JLabel label1 = new JLabel();
        label1.setText("Numero: ");
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
        txt_number.setBounds(105, 43, 100, 20);
        panel.add(txt_number);
    }

    public void ColocarAreatext(){
        resultArea.setBounds(230, 43, 400, 340);
        resultArea.setEditable(false);
        panel.add(resultArea);
    }

    public void ColocarBotones(){
        
        AddButton.setBounds(40, 80, 150, 30);
        panel.add(AddButton);
        AddButton.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        AddButton.setMnemonic('a');//Sirve para que se active el boton con el teclado Alt + n
        
        
        OrderButton.setBounds(40, 120, 150, 30);
        panel.add(OrderButton);
        OrderButton.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        OrderButton.setMnemonic('o');//Sirve para que se active el boton con el teclado Alt + o
        
        SearchSButton.setBounds(40, 160, 150, 30);
        panel.add(SearchSButton);
        SearchSButton.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        SearchSButton.setMnemonic('s');//Sirve para que se active el boton con el teclado Alt + s
        
        SearchBButton.setBounds(40, 200, 150, 30);
        panel.add(SearchBButton);
        SearchBButton.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        SearchBButton.setMnemonic('b');//Sirve para que se active el boton con el teclado Alt + b
    }
    
    private void addNumber(){
        try{
            num = Integer.parseInt(txt_number.getText());
            int [] newArray = new int[number.length+1];
            System.arraycopy(number,0,newArray,0,number.length);
            newArray[number.length]=num;
            number = newArray;
            txt_number.setText("");
            updateResultArea();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Solo se numeros","Error", JOptionPane.ERROR_MESSAGE);
            txt_number.setText(" ");
        }
    }
    
    public static void sort(int [] arr) {
    //Se declara un método estático llamado sort que toma un arreglo de enteros como parámetro. Este método implementa el algoritmo de ordenamiento de burbuja.
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    // swap arr[i-1] and arr[i]
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
     
    private void simulateBubbleSort(){
        this.sort(number);
        updateResultArea();
    }
    
    public void buscarDatoSeleccion(int [] arr){
        //Codigo de busqueda secuencial
        //Iterador
        boolean bandera = false;
        int i = 0;
        while(i<arr.length && bandera == false){
            if(arr[i] == num){
                bandera = true;//Se vuelve verdadero si se encuentra el numero
            }
            i++;//Incrementa valor del interador
        }
        
        if(bandera == false){
            JOptionPane.showMessageDialog(null,"No existe el elemento en el arreglo");
        }else{
            JOptionPane.showMessageDialog(null, "Elemento "+num+" encontrado en la posicion " + i +" del arreglo");
        }
    }
    
    private void searchSeleccion(){
        this.buscarDatoSeleccion(number);
        updateResultArea();
    }
    
    public void BuscarDatoBinario(int [] arr){
        int dato,infe,sup,mitad,i;
        boolean bandera =false;
        //CODIGO DE BEUSQUEDA binaria
        infe=0;
        sup=5;
        i=0;
        mitad=(infe+sup)/2;
        while (infe<sup && i<5){
            if(arr[mitad]==num){
                bandera=true;
                break;
            }
            if(arr[mitad]>num){
               sup=mitad;
               mitad=(infe+sup)/2;
            }
            if(arr[mitad]<num){
               infe=mitad;
               mitad=(infe+sup)/2;
            }
            i++;
        }
        if (bandera ==true){
            JOptionPane.showMessageDialog(null, "EL NUMERO  SE ENCUENTRA EN la POSICION "+mitad);

        }else{
            JOptionPane.showMessageDialog(null, "EL NUMERO  NO SE ENCUENTRA EN EL ARREGLO");
        }
    }
    
    private void searchBinary(){
        this.BuscarDatoBinario(number);
        updateResultArea();
    }
    
    private void updateResultArea(){
        StringBuilder sb = new StringBuilder();
        for (int num:number){
            sb.append(num).append(" ");
        }
        resultArea.setText("Numeros Ingresados: \n"+sb.toString());
    }
}
