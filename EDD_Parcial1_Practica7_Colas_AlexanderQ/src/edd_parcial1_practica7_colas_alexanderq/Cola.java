package edd_parcial1_practica7_colas_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class Cola {
    private Object[] colaArr;// arregloque contiene los elementos de la cola
    private int tamanoMax;// guarda el tamaño máximo del arreglo
    private int frente;// apunta al primer elemento de la cola
    private int fin;// apunta al ultimo elemento de la cola
    private int numElems;// lleva elcontrol del numero de elementos en la cola
    // constructor - inicializa valores de la cola
    public Cola(int tamano) {
        tamanoMax = tamano;
        colaArr = new Object[tamanoMax];// instancia arreglo que guarda los elementos de la cola
        fin = -1;// la variable fin la inicializamos a -1
        frente = 0;// la variable frente la inicializamos a 0
        numElems = 0;// numElems se inicializa a 0 (la cola esta vacía, sin elementos)
    }
    
    public void insertar(Object elemento){
        if(fin == tamanoMax -1){
            fin = -1;// hace que la cola sea circular
        }
        fin++;// mueve apuntador fin al siguiente índice en colaArr
        colaArr[fin]=elemento;// inserta el elemento en la posición fin del arreglo
        numElems++;// aumenta en uno el numero de elementos
    }
    // retira el elemento que se encuentra al frente de la cola
    public Object quitar(){
        Object temp = colaArr[frente];// obtiene el elemento del frente de la cola y lo asigna a una variable temporal
        frente+=1;// se mueve frente una posición para que apunte al siguiente índice de la cola
        if(frente == tamanoMax){
            frente = 0;// hace que la cola sea circular
        }
        numElems--;// se reduce en uno el numero de elementos de la cola
        return temp;// retornamos el elemento borrado de la cabeza de la cola

    }
    // devuelve el elemento que se encuentra al frente o primero en la cola
    public Object frenteCola(){
        return colaArr[frente];// retorna elemento que está en la cabeza de la cola

    }
    // devuelve true si la cola esta vacía (no tiene elementos)
    public boolean colaVacia(){
        return (numElems == 0);// retorna valor booleano dependiendo si la cola está o no vacía

    }
    // devuelve true si la cola está llena
    public boolean colaLLena(){
        return (numElems==tamanoMax); // compara los valores del numero de elementos del arreglo con el tamaño del arreglo
    }
    
    // devuelve el numero de elementos que tiene la cola
    public int tamanoCola() {
        return numElems; // retorna valor de la variable numElems
    }

}
