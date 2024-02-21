package edd_parcial3_practica2_grafo_profundidad_amplitud_alexanderq;

import java.util.*;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial3_Practica2_Grafo_Profundidad_Amplitud_AlexanderQ {
    public static void main(String[] args) {
        // TODO code application logic here
        // Crear un grafo
        Grafo grafo = new Grafo(); // Create an instance of the Grafo class
//        Scanner scanner = new Scanner(System.in);
//        int opcion;
//        do {
//            System.out.println("-----------------Menu-----------------");
//            System.out.println("1. Agregar arista");
//            System.out.println("2. Busqueda en Profundidad");
//            System.out.println("3. Busqueda en Amplitud");
//            System.out.println("4. Salir");
//            System.out.print("Ingrese la opción: ");
//            opcion = scanner.nextInt();
//
//            switch (opcion) {
//                case 1:
//                    System.out.print("Ingrese el nodo de inicio: ");
//                    String inicio = scanner.next();
//                    System.out.print("Ingrese el nodo de fin: ");
//                    String fin = scanner.next();
//                    grafo.agregarArista(inicio, fin);
//                    System.out.println("Arista agregada exitosamente.");
//                    break;
//                case 2:
//                    System.out.print("Ingrese el nodo objetivo para la búsqueda en profundidad: ");
//                    String objetivoProfundidad = scanner.next();
//                    boolean encontradoProfundidad = BusquedaEnProfundidad.busquedaEnProfundidad(grafo, objetivoProfundidad);
//                    if (encontradoProfundidad) {
//                        System.out.println("Se encontró el nodo en la búsqueda en profundidad.");
//                    } else {
//                        System.out.println("No se encontró el nodo en la búsqueda en profundidad.");
//                    }
//                    break;
//                case 3:
//                    System.out.print("Ingrese el nodo objetivo para la búsqueda en amplitud: ");
//                    String objetivoAmplitud = scanner.next();
//                    boolean encontradoAmplitud = BusquedaEnAmplitud.busquedaEnAmplitud(grafo, objetivoAmplitud);
//                    if (encontradoAmplitud) {
//                        System.out.println("Se encontró el nodo en la búsqueda en amplitud.");
//                    } else {
//                        System.out.println("No se encontró el nodo en la búsqueda en amplitud.");
//                    }
//                    break;
//                case 4:
//                    System.out.println("Saliendo...");
//                    break;
//                default:
//                    System.out.println("Opción no válida. XD ");
//            }
//        } while (opcion != 4);
        // Agregar nodos y aristas al grafo
        grafo.agregarArista("A", "B");
        grafo.agregarArista("B", "C");
        grafo.agregarArista("B", "D");
        grafo.agregarArista("C", "E");
        grafo.agregarArista("D", "F");

        // Imprimir la representación del grafo en la consola
        grafo.imprimirGrafo();
    }
    
}
