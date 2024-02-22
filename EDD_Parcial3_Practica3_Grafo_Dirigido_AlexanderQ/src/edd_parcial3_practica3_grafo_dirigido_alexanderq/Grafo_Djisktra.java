package edd_parcial3_practica3_grafo_dirigido_alexanderq;

import java.util.*;

/**
 *
 * @author Alexander Quizhpe
 */
public class Grafo_Djisktra {
        private final int cantidadVertices;
    private final Map<Character, Integer> mapaVertices; // Mapeo de letras a índices
    private final List<List<Arista>> listaAdyacencia;

    public Grafo_Djisktra(int cantidadVertices) {
        this.cantidadVertices = cantidadVertices;
        this.listaAdyacencia = new ArrayList<>(cantidadVertices);
        this.mapaVertices = new HashMap<>();

        // Inicializar el mapeo de letras a índices
        for (int i = 0; i < cantidadVertices; i++) {
            char letra = (char) ('A' + i);
            this.mapaVertices.put(letra, i);
            this.listaAdyacencia.add(new ArrayList<>());
        }
    }

    // Método para agregar una arista
    public void agregarArista(char origen, char destino, int peso) {
        int indexOrigen = mapaVertices.get(origen);
        int indexDestino = mapaVertices.get(destino);
        this.listaAdyacencia.get(indexOrigen).add(new Arista(indexDestino, peso));
    }

    // Método para ejecutar el algoritmo Dijkstra
    public List<Character> dijkstra(char origen, char destino) {
        int indexOrigen = mapaVertices.get(origen);
        int indexDestino = mapaVertices.get(destino);
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(cantidadVertices, Comparator.comparingInt(a -> a.peso));
        int[] distancias = new int[cantidadVertices];
        int[] previos = new int[cantidadVertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(previos, -1);

        colaPrioridad.add(new Nodo(indexOrigen, 0));
        distancias[indexOrigen] = 0;

        while (!colaPrioridad.isEmpty()) {
            Nodo nodoActual = colaPrioridad.poll();
            int u = nodoActual.vertice;

            for (Arista arista : listaAdyacencia.get(u)) {
                int v = arista.destino;
                int peso = arista.peso;
                if (distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                    previos[v] = u;
                    colaPrioridad.add(new Nodo(v, distancias[v]));
                }
            }
        }

        List<Character> ruta = new ArrayList<>();
        for (int i = indexDestino; i != -1; i = previos[i]) {
            ruta.add((char) ('A' + i));
        }
        Collections.reverse(ruta);

        return ruta;
    }

    private static class Nodo {
        private final int vertice;
        private final int peso;

        public Nodo(int vertice, int peso) {
            this.vertice = vertice;
            this.peso = peso;
        }
    }

    private static class Arista {
        private final int destino;
        private final int peso;

        public Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }
    
    // Método auxiliar para obtener el peso de una arista
    private int obtenerPesoArista(char origen, char destino) {
        int indexOrigen = mapaVertices.get(origen);
        int indexDestino = mapaVertices.get(destino);
        for (Arista arista : listaAdyacencia.get(indexOrigen)) {
            if (arista.destino == indexDestino) {
                return arista.peso;
            }
        }
        return Integer.MAX_VALUE;
    }
    
    // Método para calcular la suma de pesos de las aristas en una ruta
    public int sumaPesosAristas(List<Character> ruta) {
        int suma = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            char origen = ruta.get(i);
            char destino = ruta.get(i + 1);
            int peso = obtenerPesoArista(origen, destino);
            suma += peso;
        }
        return suma;
    }
    
    // Método para mostrar la matriz de adyacencia
    public void mostrarMatrizAdyacencia() {
        for (int i = 0; i < cantidadVertices; i++) {
            char letraOrigen = (char) ('A' + i);
            for (int j = 0; j < cantidadVertices; j++) {
                char letraDestino = (char) ('A' + j);
                int peso = obtenerPesoArista(letraOrigen, letraDestino);
                System.out.print((peso == Integer.MAX_VALUE ? "0" : peso) + " ");
            }
            System.out.println();
        }
    }
    
    // Método para mostrar la lista de adyacencia con letras
    public void mostrarListaAdyacencia() {
        for (int i = 0; i < cantidadVertices; i++) {
            char letraOrigen = (char) ('A' + i);
            System.out.print(letraOrigen + " >> ");
            List<Arista> adyacentes = listaAdyacencia.get(i);
            for (Arista arista : adyacentes) {
                char letraDestino = (char) ('A' + arista.destino);
                System.out.print(letraDestino + "(" + arista.peso + ") ");
            }
            System.out.println();
        }
    }
}
