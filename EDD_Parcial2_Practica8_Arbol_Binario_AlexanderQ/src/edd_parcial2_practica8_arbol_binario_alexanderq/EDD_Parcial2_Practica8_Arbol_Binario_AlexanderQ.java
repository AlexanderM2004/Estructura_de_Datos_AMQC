package edd_parcial2_practica8_arbol_binario_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial2_Practica8_Arbol_Binario_AlexanderQ {
    public static void main(String[] args) {
        ArbolBinarioB arbol = new ArbolBinarioB();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido In-Orden:");
        arbol.inOrden();

        int valorABuscar = 40;
        System.out.println("\n¿El valor " + valorABuscar + " está en el árbol? " + arbol.buscar(valorABuscar));
        
    }
    
}
