package edd_parcial1_examen1_alexanderq;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Alexander Quizhpe
 */
public class Restaurante {
    //Instanciar los objetos para la manipulacion de las pilas y columnas
    Scanner tec = new Scanner(System.in);
    Stack<Pedido> pedido = new Stack<>();
    Stack<Pedido> pendiente = new Stack<>();
    Queue<Pedido> entregar = new LinkedList<>();
    Queue<Integer> colaAux = new LinkedList<>();
    //Permite llamar la fecha del sistema
    Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR); //Año
    int month = c.get(Calendar.MONTH) + 1;//MEs
    int day = c.get(Calendar.DAY_OF_MONTH);//Dia
    int size = entregar.size();
    int contador = 0;
    String[] menu = new String[10];
    //Declaracion de variables
    String name, produc; 
    double precio;
    int tamano, cant;//Tamaño de la pila
    Pedido tope;//Nodo en la cima de la pila
    boolean validar=true;
    //Constructor de la clase pila
    public Restaurante(){
        this.tamano = 0;
        this.tope = null;
    }
    //Permite ingresar el menu del resturante
    public void ingresarMenu(int i)throws IOException{
        System.out.print((i+1)+":");
        menu[i]=tec.nextLine();
        //Permite sobreescribir el fichero
        try (PrintWriter out = new PrintWriter(new FileWriter("Menu.txt", true))) {
            out.println(i+": "+menu[i]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Permite mostrar el menu del resturante
    public void mostrarMenu(int i){
        System.out.println((i+1)+": "+menu[i]);
    }
    //Metodo para insertar elemento de la pila
    public void push(int i)throws IOException{
        System.out.println("Num. Pedido: "+i);
        do{
            System.out.print("Cliente: ");
            name = tec.nextLine();//Permite el ingreso de nombre del cliente
            validar = name.matches("[a-zA-Z]+");
            if(!validar){
                System.out.println("Solo permite cadena de caracteres");
            }
        }while(!validar);
        
        do{
            System.out.print("Producto: ");
            produc = tec.nextLine();//Permite el ingreso de los productos
            validar = produc.matches("[a-zA-Z]+");
            if(!validar){
                System.out.println("Solo permite cadena de caracteres");
            }
        }while(!validar);
        
        do{
            try{
                System.out.print("Precio: ");
                precio = tec.nextDouble();//Permite el ingreso del precio de los productos
                //validar = name.matches("\\d+(\\.\\d+)?");
                if(!validar){
                    System.out.println("Nota: Solo permite cadena numeros enteros y decimales");
                }
            }catch(NumberFormatException e) {
                validar=false;
                System.out.println("Nota: Por favor, ingrese un número decimales.");
            }
        }while(validar!=true);
        
        do{
            try{
                System.out.print("Cantidad: ");
                cant = tec.nextInt();//Permite el ingreso de la cantidad de producto
                tec.nextLine();
            }catch (NumberFormatException e) {
                validar=false;
                System.out.println("Nota: Por favor, ingrese un número entero.");
            }
        }while(validar!=true);
        System.out.println("");
        pedido.add(i, new Pedido(i, name, produc, precio, cant));//Guarda en la pila los datos ingresados
        //Permite sobreescribir el fichero
        try (PrintWriter out = new PrintWriter(new FileWriter("Pedidos.txt", true))) {
            out.println(day+"/"+month+"/"+year);
            out.println("Orden #: "+i);
            out.println("Cliente: "+name);
            out.println("Producto: "+produc);
            out.println("Precio: "+precio);
            out.println("Cantidad: "+cant);
            out.println("--------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Muestra los elementos de la pila con la ayuda de los metodos get de la clase pedido
    public void mostrarPila(){
        for (Pedido pedi : pedido) {
            System.out.println("Num. Pedido: "+pedi.getNumpedido());
            System.out.println("Cliente: "+pedi.getNomclient());
            System.out.println("Producto: "+pedi.getNomprodu());
            System.out.println("Precio: "+pedi.getPrecio());
            System.out.println("Cantidad: "+pedi.getCant());
            System.out.println("");
        }
    }
    //Muestra los pedidos éndoientes en una nueva pila con la ayuda de los metodos get de la clase pedido
    public void mostrarPendientes(){
        for (Pedido pedi : pedido) {
            System.out.println("Num. Pedido: "+pedi.getNumpedido());
            System.out.println("Cliente: "+pedi.getNomclient());
            System.out.println("Producto: "+pedi.getNomprodu());
            System.out.println("Precio: "+pedi.getPrecio());
            System.out.println("Cantidad: "+pedi.getCant());
            System.out.println("");
        }
    }
    //Muestra los pedidos que estan listos para ser entregados
    public void entregarpedidos(){
        for (Pedido pedi : entregar) {
            System.out.println("Num. Pedido: "+pedi.getNumpedido());
            System.out.println("Cliente: "+pedi.getNomclient());
            System.out.println("Producto: "+pedi.getNomprodu());
            System.out.println("Precio: "+pedi.getPrecio());
            System.out.println("Cantidad: "+pedi.getCant());
            System.out.println("");
            System.out.println("Nota: Pedido entregado, se prodece a eliminar de la cola");
            entregar.poll();
            
        }
        System.out.println("");
    }
    
    public void cancelarPedido(int cancel){
        int i = 0;
        for(Pedido pedi : pedido){
            if (pedi.getNumpedido()!= cancel){
                pendiente.push(pedido.get(i));
                pedido.pop();
                System.out.println("Nota: Pedido cancelado exitosamente");
            }else{
                System.out.println("Nota: No existe ese numero de pedido");
            }
            i++;
        }
    }
    //Clasifica los pedidos a 
    public void clasificarpedidos(int numpedi){
        int i = 0;
        for(Pedido pedi : pedido){
            if (pedi.getNumpedido()!= numpedi){
                pendiente.push(pedido.get(i));
                entregar.add(pedido.pop());
            }else{
                System.out.println("No existe ese numero de pedido");
            }
            i++;
        }
    }
}
