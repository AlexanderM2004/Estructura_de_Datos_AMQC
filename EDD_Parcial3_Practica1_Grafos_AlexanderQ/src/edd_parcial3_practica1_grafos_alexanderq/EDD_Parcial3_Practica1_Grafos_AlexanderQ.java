package edd_parcial3_practica1_grafos_alexanderq;

import java.util.*;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial3_Practica1_Grafos_AlexanderQ {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        int opc;
        //Instanciamos la clase de Buscar Grafo
        Grafo_Busqueda grafo = new Grafo_Busqueda(6);
        //Se empieza a agregar aristas
        do{
            System.out.println("1: Ingresar grafo");
            System.out.println("2: Dijkstra");
            System.out.println("3: Mostrar Matriz de adyacencia");
            System.out.println("4: Salir");
            opc = tec.nextInt();
            switch(opc){
                case 1:
                    System.out.println("------------Ingresar grafo-------------");
                    
                    break;
                case 2: 
                    System.out.println("----------Recorrido de Dijkstra---------");
                    
                    break;
                case 3:
                    System.out.println("----------Matriz de adyacencia----------");
                    grafo.mostrarMatrizAdyacencia();
                    break;
                case 4:
                    System.out.println("Saliendo XD ....");
                    break;
                default:
                    System.out.println("No existe la opcion ingresada");
                    break;
            }
        }while(opc != 4);
        
        //Grafo dirigido
        grafo.agregarArista(0, 2, 1);
        grafo.agregarArista(0, 3, 6);
        grafo.agregarArista(0, 1, 7);
        grafo.agregarArista(1, 3, 2);
        grafo.agregarArista(1, 5, 2);
        grafo.agregarArista(2, 3, 2);
        grafo.agregarArista(2, 4, 5);
        grafo.agregarArista(3, 4, 3);
        grafo.agregarArista(3, 5, 4);
        grafo.agregarArista(4, 5, 2);
        
//        grafo.agregarArista(0, 1, 6);
//        grafo.agregarArista(0, 3, 1);
//        grafo.agregarArista(1, 3, 2);
//        grafo.agregarArista(1, 4, 2);
//        grafo.agregarArista(1, 2, 5);
//        grafo.agregarArista(2, 4, 5);
//        grafo.agregarArista(3, 4, 1);
        //Al momento de invertir el origen y el destino, pero manteniendo el peso de cada arista
        //Se crea un grafo no dirigdo
//        grafo.agregarArista(1, 0, 6);
//        grafo.agregarArista(3, 0, 1);
//        grafo.agregarArista(3, 1, 2);
//        grafo.agregarArista(4, 1, 2);
//        grafo.agregarArista(2, 1, 5);
//        grafo.agregarArista(4, 2, 5);
//        grafo.agregarArista(4, 3, 1);
        
        System.out.println("Ruta que recorre: "+grafo.dijkstra(0, 5));
        
        System.out.println("Peso de la ruta: "+grafo.sumaPesosAristas(grafo.dijkstra(0, 5)));
        
        
    }
    
    
}
