package edd_parcial3_practica5_grafos_ciudades_alexanderq;


import java.util.*;
/**
 *
 * @author Alexander Quizhpe
 */
public class Grafo_Ciudades {
    // Cantidad total de vértices en el grafo
        private final int cantidadVertices;
    private final Map<String, List<Arista>> listaAdyacencia;

    public Grafo_Ciudades(int cantidadVertices) {
        this.cantidadVertices = cantidadVertices;
        this.listaAdyacencia = new HashMap<>();
    }

    public void agregarArista(String origen, String destino, int peso) {
        listaAdyacencia.computeIfAbsent(origen, k -> new ArrayList<>()).add(new Arista(destino, peso));
    }

    public List<String> dijkstra(String origen, String destino) {
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(cantidadVertices, Comparator.comparingInt(a -> a.peso));
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> previos = new HashMap<>();
        for (String vertice : listaAdyacencia.keySet()) {
            distancias.put(vertice, Integer.MAX_VALUE);
            previos.put(vertice, null);
        }

        colaPrioridad.add(new Nodo(origen, 0));
        distancias.put(origen, 0);

        while (!colaPrioridad.isEmpty()) {
            Nodo nodoActual = colaPrioridad.poll();
            String u = nodoActual.vertice;

            if (u.equals(destino)) break;

            for (Arista arista : listaAdyacencia.getOrDefault(u, Collections.emptyList())) {
                String v = arista.destino;
                int peso = arista.peso;
                if (distancias.get(u) + peso < distancias.get(v)) {
                    distancias.put(v, distancias.get(u) + peso);
                    previos.put(v, u);
                    colaPrioridad.add(new Nodo(v, distancias.get(v)));
                }
            }
        }

        List<String> ruta = new ArrayList<>();
        for (String v = destino; v != null; v = previos.get(v)) {
            ruta.add(v);
        }
        Collections.reverse(ruta);

        return ruta;
    }

    private int obtenerPesoArista(String origen, String destino) {
        for (Arista arista : listaAdyacencia.getOrDefault(origen, Collections.emptyList())) {
            if (arista.destino.equals(destino)) {
                return arista.peso;
            }
        }
        return Integer.MAX_VALUE;
    }

    public int sumaPesosAristas(List<String> ruta) {
        int suma = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            String origen = ruta.get(i);
            String destino = ruta.get(i + 1);
            int peso = obtenerPesoArista(origen, destino);
            suma += peso;
        }
        return suma;
    }

    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        for (String origen : listaAdyacencia.keySet()) {
            for (String destino : listaAdyacencia.keySet()) {
                int peso = obtenerPesoArista(origen, destino);
                System.out.print((peso == Integer.MAX_VALUE ? "0" : peso) + " ");
            }
            System.out.println();
        }
    }

    private static class Nodo {
        private final String vertice;
        private final int peso;

        public Nodo(String vertice, int peso) {
            this.vertice = vertice;
            this.peso = peso;
        }
    }

    private static class Arista {
        private final String destino;
        private final int peso;

        public Arista(String destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }
}
