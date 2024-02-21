package edd_parcial3_practica2_grafo_profundidad_amplitud_alexanderq;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alexander Quizhpe
 */
public class BusquedaEnAmplitud {
    // Método público que inicia la búsqueda en amplitud en el grafo
    public static boolean busquedaEnAmplitud(Grafo grafo, String objetivo) {
        // Recorremos todos los nodos del grafo
        for (NodoGrafo nodo : grafo.nodos.values()) {
            // Si el nodo actual contiene el objetivo, retorna verdadero
            if (bfsAuxiliarIndividual(nodo, objetivo)) {
                return true;
            }
        }
        // Si no se encuentra el objetivo en el grafo, retorna falso
        return false;
    }
    // Método privado que realiza la búsqueda en amplitud para un nodo específico
    private static boolean bfsAuxiliarIndividual(NodoGrafo nodo, String objetivo) {
        // Creamos una cola para almacenar los nodos a visitar
        Queue<NodoGrafo> cola = new LinkedList<>();
        cola.add(nodo);
        // Mientras la cola no esté vacía, continuamos la búsqueda
        while (!cola.isEmpty()) {
            // Obtenemos el nodo actual de la cola
            NodoGrafo nodoActual = cola.remove();
            
            // Si el valor del nodo actual es igual al objetivo, retorna verdadero
            if (nodoActual.valor.equals(objetivo)) return true;
            // Marcamos el nodo actual como visitado
            nodoActual.estado = EstadoNodoGrafo.Visitado;
            
            // Recorremos los nodos adyacentes del nodo actual
            for (NodoGrafo adyacente : nodoActual.adyacentes.values()) {
                // Si el nodo adyacente no ha sido visitado, lo agregamos a la cola
                if (adyacente.estado == EstadoNodoGrafo.NoVisitado) {
                    cola.add(adyacente);
                }
            }
        }
        // Si no se encuentra el objetivo en los nodos adyacentes, retorna falso
        return false;
    }
}
