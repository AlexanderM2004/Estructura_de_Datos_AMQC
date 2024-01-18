package edd_parcial2_evalucion1_alexanderq;
import com.mongodb.client.FindIterable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Alexander Quizhpe
 */
public class GestionNotas extends JFrame{
    //Conectamos a la base de datos
    public MongoDatabase db = new DB_MongoDB().ConnectDB();
    
    //Coleccion de notas
    public MongoCollection<Document> notas = db.getCollection("registros");
    
    public JPanel panel;
    JTextField txt_number = new JTextField();
    JTextField txt_name = new JTextField();
    JTextArea resultArea = new JTextArea();
    JButton AddButton = new JButton("Agregar");
    JButton OrderBurbuja = new JButton("Ordenamiento Burbuja");
    JButton OrderQuickSort = new JButton("Ordenamiento QuickSort");
    JButton SearchSeccuencial = new JButton("Busqueda Secuencial");
    JButton SearchBinario = new JButton("Busqueda Binaria");
    JButton OrderMongo = new JButton("Ordenar Mongo");
    JButton SearchMongo = new JButton("Buscar Mongo");
    private String[] nombresEstudiantes;
    private int[] notasEstudiantes;
    
    //Creamos una ventana grafica con JFrame
    public GestionNotas (){
        notasEstudiantes = new int[0];
        nombresEstudiantes = new String[0];
        
        AddButton.addActionListener((ActionEvent e) -> {
            addRegister();
        });
        
        OrderBurbuja.addActionListener((ActionEvent e) -> {
            simulateBubbleSort();
        });
        
        SearchSeccuencial.addActionListener((ActionEvent e) -> {
            searchSecuencialName();
        });
        
        OrderQuickSort.addActionListener((ActionEvent e) -> {
            simulateQuickSort();
        });
        
        SearchBinario.addActionListener((ActionEvent e) -> {
            searchBinaryName();
        });
        
        OrderMongo.addActionListener((ActionEvent e) -> {
            getDataDBOrder();
        });
        
        SearchMongo.addActionListener((ActionEvent e) -> {
            searchDB();
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
        getRegister();
    }

    private void colocarPanel(){
        panel = new JPanel();
        //Comando para aplicar color al panel
        panel.setBackground(Color.gray);
        //Poner el panel sobre la ventana del registro
        this.getContentPane().add(panel);
    }

    public void colocarEtiquetas(){
        JLabel label = new JLabel("Algoritmos de Busqueda y Ordenacion",SwingConstants.CENTER);
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
        label1.setBounds(35, 45, 70, 15);
        label1.setForeground(Color.white);
        
        JLabel label2 = new JLabel();
        label2.setText("Promedio: ");
        panel.add(label2);
        //Comando para ubicar el label
        label2.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label2.setFont(new Font("Arial", Font.PLAIN, 15));
        label2.setBounds(25, 70, 80, 15);
        label2.setForeground(Color.white);
        
        JLabel label3 = new JLabel();
        label3.setText("Rango de notas de 0 - 20** ");
        panel.add(label3);
        //Comando para ubicar el label
        label3.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label3.setFont(new Font("Arial", Font.PLAIN, 10));
        label3.setBounds(160, 70, 250, 15);
        label3.setForeground(Color.white);
        
        JLabel label4 = new JLabel();
        label4.setText("Nota: Las Busquedas se las hace ");
        panel.add(label4);
        //Comando para ubicar el label
        label4.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label4.setFont(new Font("Arial", Font.PLAIN, 12));
        label4.setBounds(35, 380, 250, 15);
        label4.setForeground(Color.white);
        
        JLabel label5 = new JLabel();
        label5.setText("solo por nombre ");
        panel.add(label5);
        //Comando para ubicar el label
        label5.setHorizontalAlignment(HEIGHT);
        //comando para modificar fuente de letra
        label5.setFont(new Font("Arial", Font.PLAIN, 12));
        label5.setBounds(65, 395, 250, 15);
        label5.setForeground(Color.white);
    }

    //Comando para colocar cajas de texto
    public void ColocarCajatexto(){
        txt_name.setBounds(105, 43, 200, 20);
        panel.add(txt_name);
        txt_number.setBounds(105, 67, 50, 20);
        panel.add(txt_number);
    }

    public void ColocarAreatext(){
        resultArea.setLayout(null);
        resultArea.setBounds(320, 43, 300, 340);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(320, 43, 300, 340);
        panel.add(resultArea);
        panel.add(scrollPane);
    }

    public void ColocarBotones(){
        AddButton.setBounds(80, 100, 175, 30);
        panel.add(AddButton);
        AddButton.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        AddButton.setMnemonic('a');//Sirve para que se active el boton con el teclado Alt + A
        
        OrderBurbuja.setBounds(80, 140, 175, 30);
        panel.add(OrderBurbuja);
        OrderBurbuja.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        OrderBurbuja.setMnemonic('o');//Sirve para que se active el boton con el teclado Alt + O
        
        SearchSeccuencial.setBounds(80, 180, 175, 30);
        panel.add(SearchSeccuencial);
        SearchSeccuencial.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        SearchSeccuencial.setMnemonic('s');//Sirve para que se active el boton con el teclado Alt + S
        
        OrderQuickSort.setBounds(80, 220, 175, 30);
        panel.add(OrderQuickSort);
        OrderQuickSort.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        OrderQuickSort.setMnemonic('q');//Sirve para que se active el boton con el teclado Alt + Q
        
        SearchBinario.setBounds(80, 260, 175, 30);
        panel.add(SearchBinario);
        SearchBinario.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        SearchBinario.setMnemonic('b');//Sirve para que se active el boton con el teclado Alt + B
        
        OrderMongo.setBounds(80, 300, 175, 30);
        panel.add(OrderMongo);
        OrderMongo.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        OrderMongo.setMnemonic('m');//Sirve para que se active el boton con el teclado Alt + M
        
        SearchMongo.setBounds(80, 340, 175, 30);
        panel.add(SearchMongo);
        SearchMongo.setEnabled(true);//Sirve para habilitar o deshabilitar los botones
        SearchMongo.setMnemonic('n');//Sirve para que se active el boton con el teclado Alt + N

    }
    
    private void searchDB(){
        String nombreBuscar = txt_name.getText();
        try {
            //Filtro para la base de datos
            Document sort;
            sort = new Document("Nombre", nombreBuscar);
            
            //Obtener los datos de la base de datos
            FindIterable<Document> docs = notas.find((sort));
            for(Document documento : docs){
                mostrarResultado("Nombre: " + documento.getString("Nombre")+ "    Promedio: " + documento.getString("Promedio"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    private void getDataDBOrder(){
        //Filtro para la base de datos
        try {
            //Filtro para la base de datos
            Document sort;
            sort = new Document("Promedio", 1);
            
            //Obtener los datos de la base de datos
            FindIterable<Document> docs = notas.find().sort(sort);
            
            try (MongoCursor<Document> cursor = docs.iterator()) {
                while(cursor.hasNext()){
                    Document document = cursor.next();
                    mostrarResultado("Nombre: " + document.getString("Nombre")+ "    Promedio: " + document.getString("Promedio"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    private void getRegister(){
        try {
            //Obtener los datos de la base de datos
            FindIterable<Document> docs = notas.find();
            
            try (MongoCursor<Document> cursor = docs.iterator()) {
                while(cursor.hasNext()){
                    Document document = cursor.next();
                    mostrarResultado("Nombre: " + document.getString("Nombre")+ "    Promedio: " + document.getString("Promedio"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    private void addRegister(){
        String nombre = txt_name.getText();
        String notaText = txt_number.getText();
        if (!nombre.isEmpty() && !notaText.isEmpty()) {
            int nota = Integer.parseInt(notaText);
            if((nota >= 0)&&(nota <=20)){
                String [] newArr = new String[nombresEstudiantes.length+1];
                System.arraycopy(nombresEstudiantes,0,newArr,0,nombresEstudiantes.length);
                newArr[nombresEstudiantes.length]=nombre;
                nombresEstudiantes = newArr;

                try{
                    int [] newArray = new int[notasEstudiantes.length+1];
                    System.arraycopy(notasEstudiantes,0,newArray,0,notasEstudiantes.length);
                    newArray[notasEstudiantes.length]=nota;
                    notasEstudiantes = newArray;
                    txt_number.setText("");
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(this, "Solo se numeros","Error", JOptionPane.ERROR_MESSAGE);
                    txt_number.setText(" ");
                }

                mostrarResultado("Nombre: " + nombre + "    Promedio: " + notaText);
                //Creamos una nota - todavia no se guarda en la base de datos
                Document doc = new Document("Nombre", nombre).append("Promedio", notaText);
                try {
                    //Insertamos la nota en la base de datos
                    notas.insertOne(doc);
                } catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hubo un error al registrar el usuario");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Registro no permitido, rango de notas permitidas de 0 a 20","Error de ingreso de Registro", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            mostrarResultado("Por favor, ingrese el nombre y la nota del estudiante.");
        }
        // Limpiar campos después de ingresar una nota
        txt_name.setText("");
        txt_number.setText("");
    }
    
    private void sort() {
        //Se declara un método estático llamado sort que toma un arreglo de enteros como parámetro. Este método implementa el algoritmo de ordenamiento de burbuja.
        mostrarResultado("--------------Ordenano con Algoritmo Burbuja--------------");    
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
        //Verifica si hay datos el la caja de texto correspondiente para poder empezar a ordenar las notas
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
    //Metodo que permite hacer la busqueda Secuencial
    private void searchSecuencialName(){
        //Verifica si hay datos el la caja de texto correspondiente para poder realizar la busqueda
        String nombreBuscar = txt_name.getText();
        mostrarResultado("------------Busqueda con Algoritmo Secuencial-------------"); 
        if (!nombreBuscar.isEmpty() && nombresEstudiantes != null) {
            int i = SecuencialName(nombreBuscar);

            if (i != -1) {
                mostrarResultado("Estudiante encontrado: " + nombresEstudiantes[i] +",  Nota: " + notasEstudiantes[i]);
            } else {
                mostrarResultado("Estudiante no encontrado.");
            }
        } else {
            mostrarResultado("Ingrese el nombre del estudiante para buscar.");
        }
    }
    //Se aplica temas de recursivaidad para que una funcion este llamando a otra omitiendo o ahporrando la codificacion de varias de codigo
    private void OrderQuickSort(){
        mostrarResultado("-------------Ordenano con Algoritmo QuickSort-------------"); 
        quickSort(notasEstudiantes, 0, notasEstudiantes.length-1);//Metodo que llama al metodo quickSort en el cual pasa datos como el arreglo que se va a ordenar, el elemento inial y el ultimo elemto del arreglo
    }
    
    public void quickSort(int[] arr, int izq, int der) {
        if (izq < der) {
            int pivotIndex = partition(notasEstudiantes, izq, der);//Determine el elementp pivote del arreglo en cada pasada
            quickSort(notasEstudiantes, izq, pivotIndex - 1);//Metodo para trabajar con el lado izquierdo de arreglo (Subarreglo izquierdo)
            quickSort(notasEstudiantes, pivotIndex + 1, der);//Metodo para trabajar con el lado derecho del arreglo (Subarreglo derecho)
        }
    }
    //Metodo que permite cambiar de posicion a los datos
    public int partition(int[] arr, int izqu, int dere) {
        int pivot = notasEstudiantes[dere];
        int i = izqu - 1;
        //Permite cambiar de posicion con el subarreglo izquierdo
        for (int j = izqu; j < dere; j++) {
            if (notasEstudiantes[j] < pivot) {
                i++;
                int temp = notasEstudiantes[i];
                notasEstudiantes[i] = notasEstudiantes[j];
                notasEstudiantes[j] = temp;
                
                String tempNomb = nombresEstudiantes[i];
                nombresEstudiantes[i] = nombresEstudiantes[j];
                nombresEstudiantes[j] = tempNomb;
                // Mostrar visualmente el proceso de ordenación paso a paso
                mostrarResultado(Arrays.toString(nombresEstudiantes) + "\n" + Arrays.toString(notasEstudiantes));
            }
        }
        //Permite cambiar de posicion el subarreglo derecho
        int temp = notasEstudiantes[i + 1];
        notasEstudiantes[i + 1] = notasEstudiantes[dere];
        notasEstudiantes[dere] = temp;
        
        String tempNomb = nombresEstudiantes[i + 1];
        nombresEstudiantes[i + 1] = nombresEstudiantes[dere];
        nombresEstudiantes[dere] = tempNomb;
        // Mostrar visualmente el proceso de ordenación paso a paso
        mostrarResultado(Arrays.toString(nombresEstudiantes) + "\n" + Arrays.toString(notasEstudiantes));
        return i + 1;
    }    
    //Permite utilizar los metodos correspondientes para el uso del ordenamientto por QuickSort
    private void simulateQuickSort(){
        //Verifica si hay datos el la caja de texto correspondiente para poder empezar a ordenar las notas
        if (nombresEstudiantes != null && nombresEstudiantes.length > 1) {
            OrderQuickSort();
            mostrarResultado("Notas ordenadas correctamente.");
        } else {
            mostrarResultado("Ingrese al menos dos notas para ordenar.");
        }
    }
    
    //Metodo que permite realizar la busqueda Binaria
    public int BinaryName(String nomBuscar){
        int izqui = 0;
        int derec = nombresEstudiantes.length - 1;
        
        while (izqui <= derec) {
            int mid = izqui + (derec - izqui) / 2;
            int res = nomBuscar.compareTo(nombresEstudiantes[mid]);
            if (res == 0) {
                return mid;
            } else if (res > 0) {
                izqui = mid + 1;
            } else {
                derec = mid - 1;
            }
        }
        return -1;
    }
    //Metodo que permite llamar a la busqueda Binaria, con nombres
    private void searchBinaryName(){
        //Verifica si hay datos el la caja de texto correspondiente para poder realizar la busqueda
        String nomBuscar = txt_name.getText();
        mostrarResultado("------------Busqueda con Algoritmo Binario-------------"); 
        if (!nomBuscar.isEmpty() && nombresEstudiantes != null) {
            int i = BinaryName(nomBuscar);

            if (i != -1) {
                mostrarResultado("Estudiante encontrado: " + nombresEstudiantes[i] +",  Nota: " + notasEstudiantes[i]);
            } else {
                mostrarResultado("Estudiante no encontrado.");
            }
        } else {
            mostrarResultado("Ingrese el nombre del estudiante para buscar.");
        }
    }

     public boolean getDataDB(ArrayList<ArrayList<Object>> data){
        try {
            //Guardamos la nota en el array
            ArrayList<Object> row;
            
            //Obtener los datos de la base de datos
            FindIterable<Document> docs = notas.find();
            
            try (MongoCursor<Document> cursor = docs.iterator()) {
                while(cursor.hasNext()){
                    row = new ArrayList<>();
                    Document document = cursor.next();
                    row.add(document.getString("student"));
                    row.add(document.getDouble("nota"));
                    data.add(row);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
        return true;
    }
     
    //Permite mostrar los resultados por el Area Text
    private void mostrarResultado(String mensaje) {
        resultArea.append(mensaje + "\n\n");
    }
}
