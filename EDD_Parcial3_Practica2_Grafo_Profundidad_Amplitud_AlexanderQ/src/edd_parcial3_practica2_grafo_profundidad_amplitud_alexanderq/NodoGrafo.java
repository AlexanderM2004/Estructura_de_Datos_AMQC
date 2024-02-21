package edd_parcial3_practica2_grafo_profundidad_amplitud_alexanderq;

import java.util.*;

/**
 *
 * @author Alexander Quizhpe
 */
public class NodoGrafo {
    public String valor; // El valor que almacena el nodo del grafo
    public EstadoNodoGrafo estado;
    public HashMap<String, NodoGrafo> adyacentes; // Nodos adyacentes a este nodo en el grafo

    // Constructor que inicializa un nodo con un valor dado
    public NodoGrafo(String valor) {
      this.valor = valor;
      this.adyacentes = new HashMap<String, NodoGrafo>();
      this.estado = EstadoNodoGrafo.NoVisitado;
    }


    // Constructor que inicializa un nodo con un valor y nodos adyacentes dados
    public NodoGrafo(String valor, HashMap<String, NodoGrafo> adyacentes) {
      this.valor = valor;
      this.adyacentes = adyacentes;
    }

    // Método para agregar un nodo vecino al nodo actual en el grafo
    public void agregarVecino(NodoGrafo nodo) {
      if (!adyacentes.containsKey(nodo.valor)) {
        adyacentes.put(nodo.valor, nodo);
      }
    }

    // Método hashCode para generar el código hash del nodo
    @Override
    public int hashCode() {
      final int primo = 31;
      int resultado = 1;
      resultado = primo * resultado + ((valor == null) ? 0 : valor.hashCode());
      return resultado;
    }

    // Método equals para comparar si dos nodos son iguales
    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      NodoGrafo otro = (NodoGrafo) obj;
      if (valor == null) {
        if (otro.valor != null) return false;
      } else if (!valor.equals(otro.valor)) return false;
      return true;
    }
}
