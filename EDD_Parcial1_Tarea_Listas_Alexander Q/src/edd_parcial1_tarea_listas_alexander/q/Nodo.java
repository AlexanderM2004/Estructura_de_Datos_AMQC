package edd_parcial1_tarea_listas_alexander.q;

/**
 *
 * @author Grupo 1
 */
public class Nodo {
    public int dato; //Representa un dato numérico asociado al nodo.
    public Nodo siguiente;
    
    //Este es el constructor de la clase. Toma un parámetro d que se utiliza para inicializar el atributo 
    //dato del objeto Nodo recién creado.
    public Nodo(int d) {
        dato = d;
    }
    
    //metodo que me imprima el valor del campo de dato
    public void mostarNodo(){
        System.out.println("{"+dato+ "}");
    }
    
    //Este método imprime en la consola el cuadrado del valor del campo dato
    public void mostarNodocuadrado(){
        System.out.println("{"+(dato*dato)+ "}");
    }
}
