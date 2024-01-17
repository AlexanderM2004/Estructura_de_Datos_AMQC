package edd_parcial2_ejemplo_ordenamiento_arbol_binario_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class NodoVehiculo {
    Vehiculo vehiculo;
    NodoVehiculo izquierda;
    NodoVehiculo derecha;

    public NodoVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.izquierda = null;
        this.derecha = null;
    }
}
