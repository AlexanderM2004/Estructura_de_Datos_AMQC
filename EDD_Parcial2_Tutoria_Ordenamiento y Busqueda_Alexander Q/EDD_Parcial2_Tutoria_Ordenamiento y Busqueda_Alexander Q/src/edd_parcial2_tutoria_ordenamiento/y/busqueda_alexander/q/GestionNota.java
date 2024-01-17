package edd_parcial2_tutoria_ordenamiento.y.busqueda_alexander.q;

import java.awt.*;
import java.awt.event.*;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.Arrays;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Alexander Q
 */
public class GestionNota extends JFrame{
    public JPanel panel;
    JTextField txt_number = new JTextField();
    JTextField txt_name = new JTextField();
    JTextArea resultArea = new JTextArea(20, 2);
    JButton AddButton = new JButton("Agregar");
    JButton OrderButton = new JButton("Ordenar");
    JButton SearchSButton = new JButton("Buscar por nombre");
    private String[] nombresEstudiantes;
    private int[] notasEstudiantes;
    
    //Creamos una ventana grafica con JFrame
    public GestionNota (){
        AddButton.addActionListener((ActionEvent e) -> {
            addRegister();
        });
        
        OrderButton.addActionListener((ActionEvent e) -> {
            simulateBubbleSort();
        });
        
        SearchSButton.addActionListener((ActionEvent e) -> {
            searchSecuencialName();
        });
       this.setSize(680,450); 
       setTitle("Algoritmos de Ordenamiento y Busqueda"); //Comando que permitecolocar nombre a la ventana
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
        JLabel label = new JLabel("Busqueda Secuencial - Ordenacion Binaria",SwingConstants.CENTER);
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
        label1.setBounds(30, 45, 70, 15);
        label1.setForeground(Color.white);
        
        JLabel label2 = new JLabel();
        label2.setText("Nota: ");
        panel.add(label2);
        //Comando para ubicar el label
        label2.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label2.setFont(new Font("Arial", Font.PLAIN, 15));
        label2.setBounds(30, 70, 70, 15);
        label2.setForeground(Color.white);
    }

    //Comando para colocar cajas de texto
    public void ColocarCajatexto(){
        txt_name.setBounds(105, 43, 100, 20);
        panel.add(txt_name);
        txt_number.setBounds(105, 67, 100, 20);
        panel.add(txt_number);
    }

    public void ColocarAreatext(){
        resultArea.setBounds(230, 43, 400, 340);
        resultArea.setEditable(false);
        /** Área de texto para mostrar resultados
        add(new JScrollPane(resultArea));
        setSize(400, 300);
        setLocationRelativeTo(null);
        * */
        panel.add(resultArea);
    }

    public void ColocarBotones(){
        AddButton.setBounds(40, 100, 150, 30);
        panel.add(AddButton);
        AddButton.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        AddButton.setMnemonic('a');//Sirve para que se active el boton con el teclado Alt + n
        
        
        OrderButton.setBounds(40, 140, 150, 30);
        panel.add(OrderButton);
        OrderButton.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        OrderButton.setMnemonic('o');//Sirve para que se active el boton con el teclado Alt + o
        
        SearchSButton.setBounds(40, 180, 150, 30);
        panel.add(SearchSButton);
        SearchSButton.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        SearchSButton.setMnemonic('b');//Sirve para que se active el boton con el teclado Alt + b
    }
    
    private void addRegister(){
        String nombre = txt_name.getText();
        String notaText = txt_number.getText();

        if (!nombre.isEmpty() && !notaText.isEmpty()) {
            int nota = Integer.parseInt(notaText);

            if (nombresEstudiantes == null) {
                nombresEstudiantes = new String[]{nombre};
                notasEstudiantes = new int[]{nota};
            } else {
                // Añadir nuevos elementos a los arreglos
                nombresEstudiantes = Arrays.copyOf(nombresEstudiantes, nombresEstudiantes.length + 1);
                notasEstudiantes = Arrays.copyOf(notasEstudiantes, notasEstudiantes.length + 1);

                nombresEstudiantes[nombresEstudiantes.length - 1] = nombre;
                notasEstudiantes[notasEstudiantes.length - 1] = nota;
            }

            mostrarResultado("Nombre: " + nombre + "    Promedio: " + notaText);
        } else {
            mostrarResultado("Por favor, ingrese el nombre y la nota del estudiante.");
        }

        // Limpiar campos después de ingresar una nota
        txt_name.setText("");
        txt_number.setText("");
    }
    
    private void sort() {
    //Se declara un método estático llamado sort que toma un arreglo de enteros como parámetro. Este método implementa el algoritmo de ordenamiento de burbuja.
        int n = notasEstudiantes.length;
        boolean intercambio;

        do {
            intercambio = false;

            for (int i = 1; i < n; i++) {
                if (notasEstudiantes[i - 1] > notasEstudiantes[i]) {
                    // Intercambiar notas
                    int tempNota = notasEstudiantes[i - 1];
                    notasEstudiantes[i - 1] = notasEstudiantes[i];
                    notasEstudiantes[i] = tempNota;

                    // Intercambiar nombres
                    String tempNombre = nombresEstudiantes[i - 1];
                    nombresEstudiantes[i - 1] = nombresEstudiantes[i];
                    nombresEstudiantes[i] = tempNombre;

                    intercambio = true;

                    // Mostrar visualmente el proceso de ordenación paso a paso
                    mostrarResultado(Arrays.toString(nombresEstudiantes) + "\n" + Arrays.toString(notasEstudiantes));
                }
            }
        } while (intercambio);
    }
     
    private void simulateBubbleSort(){
        if (nombresEstudiantes != null && nombresEstudiantes.length > 1) {
            sort();
            mostrarResultado("Notas ordenadas correctamente.");
        } else {
            mostrarResultado("Ingrese al menos dos notas para ordenar.");
        }
    }
    
    public int SecuencialName(String nombreBuscar){
        //Codigo de busqueda secuencial
        //Iterador
        // Iterar sobre el arreglo
        for (int i = 0; i < nombresEstudiantes.length; i++) {
            if (nombresEstudiantes[i].equalsIgnoreCase(nombreBuscar)) {
                return i;
            }
        }
        return -1;
    }
    
    private void searchSecuencialName(){
        String nombreBuscar = txt_name.getText();

        if (!nombreBuscar.isEmpty() && nombresEstudiantes != null) {
            int indice = SecuencialName(nombreBuscar);

            if (indice != -1) {
                mostrarResultado("Estudiante encontrado: " + nombresEstudiantes[indice] +
                        ", Nota: " + notasEstudiantes[indice]);
            } else {
                mostrarResultado("Estudiante no encontrado.");
            }
        } else {
            mostrarResultado("Ingrese el nombre del estudiante para buscar.");
        }
    }
    
    private void mostrarResultado(String mensaje) {
        resultArea.append(mensaje + "\n\n");
    }
}
