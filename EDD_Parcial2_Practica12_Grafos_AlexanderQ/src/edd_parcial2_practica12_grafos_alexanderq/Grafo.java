package edd_parcial2_practica12_grafos_alexanderq;

import java.util.HashMap;

/**
 *
 * @author Alexander Quizhpe
 */
public class Grafo {
    public HashMap<String, NodoGrafo> nodos; // Nodos del grafo
    // Constructor que inicializa un grafo vacío
    public Grafo() {
        nodos = new HashMap<String, NodoGrafo>();
    }
    // Método que obtiene o crea un nodo en el grafo dado su nombre
    public NodoGrafo obtenerOcrearNodo(String nombre) {
        NodoGrafo nodo = nodos.get(nombre);
        if (nodo == null) {
        nodo = new NodoGrafo(nombre);
        nodos.put(nombre, nodo);
    }
        return nodo;
    }
    // Método que añade una arista al grafo entre los nodos de inicio y fin
    public void agregarArista(String inicio, String fin) {
        NodoGrafo nodoInicio = obtenerOcrearNodo(inicio);
        NodoGrafo nodoFin = obtenerOcrearNodo(fin);
        nodoInicio.agregarVecino(nodoFin);
    }
}
