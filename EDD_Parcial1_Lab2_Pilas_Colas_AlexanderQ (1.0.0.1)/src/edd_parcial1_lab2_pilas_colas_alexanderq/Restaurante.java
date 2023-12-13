package edd_parcial1_lab2_pilas_colas_alexanderq;
//Importar librerias
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Alexander Quizhpe
 */
public class Restaurante{
    //Instanciar los objetos para la manipulacion de las pilas y columnas
    Scanner tec = new Scanner(System.in);
    Stack<Pedido> pedido = new Stack<>();
    Stack<Pedido> pendiente = new Stack<>();
    Queue<Pedido> entregar = new LinkedList<>();
    //Declaracion de variables
    String name, produc; 
    float precio;
    int tamano, cant;//Tamaño de la pila
    Pedido tope;//Nodo en la cima de la pila
    boolean validar;
    //Constructor de la clase pila
    public Restaurante(){
        this.tamano = 0;
        this.tope = null;
    }
    //Metodo para insertar elemento de la pila
    public void push(int i){
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
            System.out.print("Precio: ");
            precio = tec.nextFloat();//Permite el ingreso del precio de los productos
            validar = name.matches("\\d+(\\.\\d+)?");
            if(!validar){
                System.out.println("Solo permite cadena numeros enteros y decimales");
            }
        }while(!validar);
        
        do{
            System.out.print("Cantidad: ");
            cant = tec.nextInt();//Permite el ingreso de la cantidad de productos
            validar = name.matches("\\d+");
            
        tec.nextLine();
            if(!validar){
                System.out.println("Solo permite cadena numeros enteros y decimales");
            }
        }while(!validar);
        System.out.println("");
        pedido.add(i, new Pedido(i, name, produc, precio, cant));//Guarda en la pila los datos ingresados
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
        }
        System.out.println("");
    }
    //Clasifica los pedidos a 
    public void clasificarpedidos(int numpedi){
        int i = 0;
        for(Pedido pedi : pedido){
            if (pedi.getNumpedido()!= numpedi) {
                pendiente.push(pedido.get(i));
                entregar.add(pedido.pop());
            }else{
                System.out.println("No existe ese numero de pedido");
            }
            i++;
        }
    }
}
