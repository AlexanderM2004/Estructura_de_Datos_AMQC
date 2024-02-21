package edd_parcial3_practica2_grafo_profundidad_amplitud_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class BusquedaEnProfundidad {
    // Método público que inicia la búsqueda en profundidad en el grafo
    public static boolean busquedaEnProfundidad(Grafo grafo, String objetivo) {
        // Recorremos todos los nodos del grafo
        for (NodoGrafo nodo : grafo.nodos.values()) {
            // Si el nodo actual contiene el objetivo, retorna verdadero
            if (dfsRecursivoAuxiliar(nodo, objetivo)) {
                return true;
            }
        }
        // Si no se encuentra el objetivo en el grafo, retorna falso
        return false;
    }
    // Método privado recursivo para realizar la búsqueda en profundidad
    private static boolean dfsRecursivoAuxiliar(NodoGrafo nodoActual, String objetivo) {
        // Si el valor del nodo actual es igual al objetivo, retorna verdadero
        if (nodoActual.valor.equals(objetivo)) {
            return true;
        }
        // Marcamos el nodo actual como visitado
        nodoActual.estado = EstadoNodoGrafo.Visitado;
        // Recorremos los nodos vecinos del nodo actual
        for (NodoGrafo nodoVecino : nodoActual.adyacentes.values()) {
            // Si el nodo vecino no ha sido visitado, realizamos la búsqueda en profundidad recursivamente
            if (nodoVecino.estado != EstadoNodoGrafo.Visitado) {
                if (dfsRecursivoAuxiliar(nodoVecino, objetivo)) {
                    return true;
                }
            }
        }
        // Si no se encuentra el objetivo en los nodos vecinos, retorna falso
        return false;
    }
}
