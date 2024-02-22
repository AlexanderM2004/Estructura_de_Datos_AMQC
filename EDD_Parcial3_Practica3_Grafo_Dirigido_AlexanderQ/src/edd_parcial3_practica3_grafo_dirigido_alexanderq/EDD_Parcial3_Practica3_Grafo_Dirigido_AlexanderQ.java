package edd_parcial3_practica3_grafo_dirigido_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial3_Practica3_Grafo_Dirigido_AlexanderQ {

    public static void main(String[] args) {
        // TODO code application logic here
        //Instanciamos la ckase del ggrafo
        Grafo_Djisktra grafo = new Grafo_Djisktra(9);
        //Ingresamos los valores del grafo con sus nodos y aristas
        grafo.agregarArista('A', 'B', 10);
        grafo.agregarArista('A', 'C', 15);
        grafo.agregarArista('B', 'D', 12);
        grafo.agregarArista('B', 'F', 15);
        grafo.agregarArista('C', 'E', 10);
        grafo.agregarArista('C', 'G', 8);
        grafo.agregarArista('D', 'E', 5);
        grafo.agregarArista('D', 'H', 7);
        grafo.agregarArista('E', 'F', 7);
        grafo.agregarArista('E', 'I', 8);
        grafo.agregarArista('F', 'I', 6);
        grafo.agregarArista('G', 'H', 12);
        grafo.agregarArista('H', 'I', 10);
        
        
        //Mostramos los valores del grafo
        System.out.println(grafo.dijkstra('A', 'H'));
        System.out.println(grafo.sumaPesosAristas(grafo.dijkstra('A', 'H')));
        System.out.println("");
        System.out.println("----------Matriz de Adyacencia----------");
        grafo.mostrarMatrizAdyacencia();
        System.out.println("");
        System.out.println("-----------Lista de Adyacencia----------");
        grafo.mostrarListaAdyacencia();
    }
    
}
