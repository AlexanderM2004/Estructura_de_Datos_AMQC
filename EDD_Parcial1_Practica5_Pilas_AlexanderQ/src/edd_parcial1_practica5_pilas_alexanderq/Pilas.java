package edd_parcial1_practica5_pilas_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class Pilas {
    int tamano;//Tamaño de la pila
    Nodo tope;//Nodo en la cima de la pila
    //Constructor de la clase pila
    public Pilas() {
        this.tamano = 0;
        this.tope = null;
    }
    //Metodo para insertar elemento de la pila
    public void push(int valor){
        Nodo nodo = new Nodo(valor);//Crear un nuevo nodo con el dato
        nodo.siguiente = tope;//El siguiente del nuevo nodo es la cima actual
        tope = nodo;//El nuevo nodo se convierte en la cima
        tamano++;
    }
    //Metodo para eliminar y devolver el elmento en la cima de la pila
    public int pop(){
        if(tamano > 0){
            int returnValue = tope.valor;//Obtiene valor de la cima
            tope = tope.siguiente;//Mover la cima al siguiente nodo
            tamano--;
            return returnValue;
        }else{
            return -1;//Valor predeterminado para indicar un error
        }
    }
    
    public void mostrarPila(){
        Nodo actual = tope;
        int i = 0;
        while(actual != null){
            i++;
            System.out.println("Dato: "+actual.valor);
            actual = actual.siguiente;
        }
        System.out.println("");
    }
    
    public void cabezaPila(){
        Nodo cabeza = tope;
        System.out.println("Dato: "+cabeza.valor);
    }
}
