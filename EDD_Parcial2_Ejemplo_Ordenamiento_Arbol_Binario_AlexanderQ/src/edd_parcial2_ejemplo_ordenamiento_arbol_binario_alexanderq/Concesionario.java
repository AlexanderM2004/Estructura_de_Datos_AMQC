package edd_parcial2_ejemplo_ordenamiento_arbol_binario_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class Concesionario {
    
    public NodoVehiculo insertarVehiculo(NodoVehiculo raiz, Vehiculo nuevoVehiculo) {
        if (raiz == null) {
            return new NodoVehiculo(nuevoVehiculo);
        } else {
            if (nuevoVehiculo.ventasMes > raiz.vehiculo.ventasMes) {
                raiz.izquierda = insertarVehiculo(raiz.izquierda, nuevoVehiculo);
            } else {
                raiz.derecha = insertarVehiculo(raiz.derecha, nuevoVehiculo);
            }
        }
        return raiz;
    }

    public void inordenImprimir(NodoVehiculo raiz) {
        if (raiz != null) {
            inordenImprimir(raiz.izquierda);
            System.out.println("Marca: " + raiz.vehiculo.marca + ", Ventas al mes: " + raiz.vehiculo.ventasMes);
            inordenImprimir(raiz.derecha);
        }
    }
}
