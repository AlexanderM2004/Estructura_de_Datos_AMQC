package edd_parcial2_practica8_arbol_binario_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class ArbolBinarioB {
    Nodo raiz;
    public ArbolBinarioB() {
        this.raiz = null;
    }

    // Método para insertar un valor en el árbol
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.izquierda = insertarRec(raiz.izquierda, valor);
        } else if (valor > raiz.valor) {
            raiz.derecha = insertarRec(raiz.derecha, valor);
        }

        return raiz;
    }

    // Método para realizar un recorrido en orden (in-order traversal)
    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(Nodo raiz) {
        if (raiz != null) {
            inOrdenRec(raiz.izquierda);
            System.out.print(raiz.valor + " ");
            inOrdenRec(raiz.derecha);
        }
    }

    // Método para buscar un valor en el árbol
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            return false;
        }

        if (raiz.valor == valor) {
            return true;
        }

        return valor < raiz.valor
                ? buscarRec(raiz.izquierda, valor)
                : buscarRec(raiz.derecha, valor);
    }
}
