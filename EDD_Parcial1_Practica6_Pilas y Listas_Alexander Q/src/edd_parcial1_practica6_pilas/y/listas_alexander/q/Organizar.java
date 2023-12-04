package edd_parcial1_practica6_pilas.y.listas_alexander.q;


import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Alexander Quizhpe
 */
public class Organizar {
    Scanner tec = new Scanner(System.in);
    Stack<Libro> listBook = new Stack<>();
    Stack<Libro> regalo = new Stack<>();
    String titu, name; 
    int date;
    int tamano;//Tamaño de la pila
    Libro tope;//Nodo en la cima de la pila
    //Constructor de la clase pila
    public Organizar() {
        this.tamano = 0;
        this.tope = null;
    }
    //Metodo para insertar elemento de la pila
    public void push(int i){
        System.out.print("Titulo: ");
        titu = tec.nextLine();
        System.out.print("Autor: ");
        name = tec.nextLine();
        System.out.print("Año: ");
        date = tec.nextInt();
        tec.nextLine();
        System.out.println("");
        //Libro nodo = new Libro(titulo,autor, año);//Crear un nuevo nodo con el dato
        listBook.add(i, new Libro(titu,name, date));
        /**
        nodo.next = tope;//El siguiente del nuevo nodo es la cima actual
        tope = nodo;//El nuevo nodo se convierte en la cima
        tamano++;
        */
    }
    
    public void mostrarPila(){
        for (Libro libro : listBook) {
            System.out.println("Titulo: "+libro.getTitulo());
            System.out.println("Autor: "+libro.getAutor());
            System.out.println("Año: "+libro.getAño());
            System.out.println("");
        }
    }
    
    public void mostrarPilaRegalar(){
        for (Libro libro : regalo) {
            System.out.println("Titulo: "+libro.getTitulo());
            System.out.println("Autor: "+libro.getAutor());
            System.out.println("Año: "+libro.getAño());
            System.out.println("");
        }
    }
    
    public void regalarBook(int date){
        int i = 0;
        for(Libro libro : listBook){
            if (libro.getAño() < date) {
                regalo.push(listBook.get(i));
            }else{
                System.out.println("Libro "+(i+1)+" no cumple con limite de año");
            }
            i++;
        }
        System.out.println("Libros sobrantes: " );
        mostrarPila();
        System.out.println("");
        System.out.println("Libros a regalar: " );
        mostrarPilaRegalar();
    }
   
}
