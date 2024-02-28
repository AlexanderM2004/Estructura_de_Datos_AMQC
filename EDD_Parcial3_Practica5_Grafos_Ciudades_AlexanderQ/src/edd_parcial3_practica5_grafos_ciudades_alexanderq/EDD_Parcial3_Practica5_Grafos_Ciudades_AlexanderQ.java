package edd_parcial3_practica5_grafos_ciudades_alexanderq;

import java.util.Scanner;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial3_Practica5_Grafos_Ciudades_AlexanderQ {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        int opc, cant;
        boolean marc = false;
        //Instanciamos la clase de Buscar Grafo
        Grafo_Ciudades grafo = null;
        //Se empieza a agregar aristas
        do{
            System.out.println("---------------------MENU-------------------");
            System.out.println("1: Ingresar Ciudades");
            System.out.println("2: Buscar Rutas entre ciudades");
            System.out.println("3: Mostrar Matriz de adyacencia");
            System.out.println("4: Salir");
            System.out.println("----------------------------------------------");
            opc = tec.nextInt();
            tec.nextLine();
            switch(opc){
                case 1:
                    marc = true;
                    System.out.println("------------Ingresar Ciudades-------------");
                    System.out.print("Cantidad de Ciudades: ");
                    cant = tec.nextInt();
                    grafo = new Grafo_Ciudades(cant);
                    System.out.print("Cantidad de calles: ");
                    int aris = tec.nextInt();
                    tec.nextLine();
                    System.out.println("------------------------------------------");
                    for(int i = 0; i<aris;i++){
                        System.out.print("Ciudad Origen: ");
                        String origen = tec.nextLine();
                        System.out.print("Ciudad Destino: ");
                        String destino = tec.nextLine();
                        System.out.print("Distancia en Km: ");
                        int peso = tec.nextInt();
                        tec.nextLine();
                        grafo.agregarArista(origen, destino, peso);
                        grafo.agregarArista(destino, origen, peso);
                        System.out.println(" ");
                    }
                    break;
                case 2: 
                    if(marc){
                        System.out.println("----------Buscar Rutas entre ciudades---------");
                        System.out.print("Ciudad de Origen: ");
                        String nodorigen = tec.nextLine();
                        System.out.print("Ciudad de Destino: ");
                        String nododestino = tec.nextLine();
                        System.out.println("Ruta entre Ciudades: "+grafo.dijkstra(nodorigen, nododestino));
                        System.out.println("Distancia Total: "+grafo.sumaPesosAristas(grafo.dijkstra(nodorigen, nododestino))+" Km");
                    }else{
                        System.out.println("Primero ingrese dos ciudades como minimo");
                    }
                    break;
                case 3:
                    if(marc){
                        System.out.println("----------Matriz de adyacencia----------");
                        grafo.mostrarMatrizAdyacencia();
                    }else{
                        System.out.println("Primero ingrese dos ciudades como minimo");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo XD ....");
                    break;
                default:
                    System.out.println("No existe la opcion ingresada");
                    break;
            }
        }while(opc != 4);      
    }
}
