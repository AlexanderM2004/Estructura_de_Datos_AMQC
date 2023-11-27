package edd_parcial1_tarea_listas_alexander.q;

/**
 *
 * @author Grupo 1
 */
public class Lista {
    //declaracion de variables
    private Nodo primero;
    //metodo constructor
    public Lista() {
        primero=null;
    }
    //metodo para verficar si la lista enlazada esta vacia
    public boolean vacia(){
        return (primero==null);
    }
    
    /**
    * Este método inserta un nuevo nodo con un valor dado al final de la lista.
    * Si la lista está vacía, el nuevo nodo se convierte en el primer nodo.
    * @param d El valor que se desea almacenar en el nuevo nodo.
    */
    public void insertarlista( int d){
        // Crear un nuevo nodo con el valor proporcionado.
        Nodo nuevoNodo=new Nodo(d);
        // Verificar si la lista está vacía (si el primer nodo es nulo)
        if(primero==null){
            // Si la lista está vacía, el nuevo nodo se convierte en el primer nodo.
            primero=nuevoNodo;
        }else{
            // Si la lista no está vacía, se recorre la lista hasta el último nodo.
            // Se utiliza un puntero para seguir la secuencia de nodos.
            Nodo puntero=primero;
            int contador=0;
            // Avanzar en la lista hasta llegar al último nodo.
            while( puntero.siguiente!=null){
                puntero=puntero.siguiente;
                contador++;
            }
            // Una vez que se alcanza el último nodo, se agrega el nuevo nodo al final.
            puntero.siguiente=nuevoNodo;
        }
    }
    
    /**
    * Este método imprime en la consola los valores almacenados en cada nodo de la lista.
    * La impresión se realiza en orden, desde el primer nodo hasta el último nodo.
    */
    public void mostrarLista(){   
        // Se inicia desde el primer nodo de la lista.
        Nodo nodoActual=primero;
        // Se recorre la lista mientras el nodo actual no sea nulo.
        while(nodoActual!=null){
            // Se utiliza el método mostarNodo() del nodo actual para imprimir su valor.
            nodoActual.mostarNodo();
            // Se avanza al siguiente nodo en la lista.
            nodoActual=nodoActual.siguiente;
        }
        System.out.println("");
    }
    
    /**
    * Este método elimina los nodos de la lista, dejandola vacia.
    */
    public void eliminarlista(){
        primero=null;
    }
    
    /**
    * Calcula y devuelve la suma de los valores almacenados en todos los nodos de la lista.
    * @return La suma de los valores de los nodos.
    */
    public int suma(){
        int suma=0;
        Nodo nodoActual=primero;
        // Recorre la lista sumando los valores de cada nodo.
        while(nodoActual!=null){
            suma+=nodoActual.dato;
            nodoActual=nodoActual.siguiente;
        }
       
        return suma;
    }
    
    /**
    * Encuentra y devuelve el valor máximo almacenado en los nodos de la lista.
    * @return El valor máximo de los nodos.
    */
    public int maximo(){
         // Inicializa el valor máximo con el primer nodo.
        int max=primero.dato;
        Nodo nodoActual=primero.siguiente;
        // Recorre la lista comparando y actualizando el valor máximo.
        while(nodoActual!=null){
            if(nodoActual.dato>max){
              max=nodoActual.dato;
            }
            nodoActual=nodoActual.siguiente;
        }

        return max;
    }
    
    /**
    * Encuentra y devuelve el valor mínimo almacenado en los nodos de la lista.
    * @return El valor mínimo de los nodos.
    */
    public int minimo(){
        // Inicializa el valor mínimo con el primer nodo.
        int min=primero.dato;
        Nodo nodoActual=primero.siguiente;
        // Recorre la lista comparando y actualizando el valor mínimo.
        while(nodoActual!=null){
            if(nodoActual.dato<min){
                min=nodoActual.dato;
            }
            nodoActual=nodoActual.siguiente;
        }

       return min;
    }
    
    /**
    * Ordena la lista en orden ascendente
    * Este método modifica la lista actual.
    */
    public void ascendente(){
        // Verifica si la lista está vacía; si es así, no hay nada que ordenar.
        if(primero!=null){
            return;
        }
        boolean cambio;
        do{
            cambio=false;
            Nodo nodoActual=primero;
            Nodo siguiente=primero.siguiente;
            // Recorre la lista comparando y realizando intercambios si es necesario.
            while(siguiente!=null){
                if(nodoActual.dato>siguiente.dato){
                    // Intercambia los valores de los nodos.
                    int aux=nodoActual.dato;
                    nodoActual.dato=siguiente.dato;
                    siguiente.dato=aux;
                    cambio=true;

                }
                nodoActual=siguiente;
                siguiente=siguiente.siguiente;
            }

        }while(cambio);
    }
    
    /**
    * Imprime en la consola los cuadrados de los valores almacenados en cada nodo de la lista.
    */
    public void cuadrados(){
        Nodo nodoActual=primero;
         // Recorre la lista imprimiendo los cuadrados de los valores de cada nodo.
        while(nodoActual!=null){
            nodoActual.mostarNodocuadrado();
            nodoActual=nodoActual.siguiente;
        }
        System.out.println("");
    }
}
