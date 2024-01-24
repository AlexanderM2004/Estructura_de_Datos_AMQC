package edd_parcial2_practica9_arbolbinariocompleto_alexanderq;

/**
 *
 * @author Alexander Quihzpe
 */
public class NodoArbol {
    public int numero;
    public NodoArbol izquierda;
    public NodoArbol derecha;
    
    public NodoArbol(int numero) {
        this.numero = numero;
        izquierda = null;
        derecha = null;
    }
}
