package edd_parcial3_practica2_grafo_profundidad_amplitud_alexanderq;

import java.util.*;

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
    
    public void imprimirGrafo() {
        System.out.println("Representación del Grafo:");
        for (NodoGrafo nodo : nodos.values()) {
            System.out.print("Nodo " + nodo.valor + " -> ");
            for (NodoGrafo vecino : nodo.adyacentes.values()) {
                System.out.print(vecino.valor + " ");
            }
            System.out.println();
        }
    }
}
