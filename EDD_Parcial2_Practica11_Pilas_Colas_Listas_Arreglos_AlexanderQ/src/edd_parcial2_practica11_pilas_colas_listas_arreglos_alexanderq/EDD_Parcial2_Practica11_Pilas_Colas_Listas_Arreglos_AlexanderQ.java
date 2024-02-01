package edd_parcial2_practica11_pilas_colas_listas_arreglos_alexanderq;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial2_Practica11_Pilas_Colas_Listas_Arreglos_AlexanderQ {
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        AgendaTareas tareas = new AgendaTareas(0, "", "", "");
        int opc;
        String fecact = "01/02/2024";
        do{
            System.out.println("Fecha actual: "+fecact);
            System.out.println("1: Agregar tarea");
            System.out.println("2: Marcar tarea como completada");
            System.out.println("3: Visualizar tareas pendientes");
            System.out.println("4: Visualizar tareas completadas");
            System.out.println("5: Visualizar tareas vencidas");
            System.out.println("6: Salir");
            System.out.println("-----------------------------------------------------");
            opc = tec.nextInt();
            switch(opc){
                case 1:
                    System.out.println("--------------------Agregar Tarea--------------------");
                    //Agregar tarea
                    System.out.print("Cantidad de tareas a ingresar: ");
                    int cant = tec.nextInt();
                    for(int i = 0; i<cant;i++){
                        tareas.push(i);//Llamar al metodo para ingresar datos a la pila
                    }
                    
                    break;
                case 2:
                    System.out.println("------------Marcar tarea como completada-------------");
                    System.out.println("Tareas Pendientes");
                    tareas.mostrarPilaPendiente();
                    System.out.print("Numero de pedido a preparar: ");
                    int numpedi = tec.nextInt();
                    tareas.clasificarTareas(numpedi+1);//Llamar al metodo para que permita clasificar los datos
                    break;
                case 3:
                    System.out.println("-------------Visualizar tareas pendientes------------");
                    tareas.mostrarPilaPendiente();
                    break;
                case 4:
                    System.out.println("------------Visualizar tareas completadas------------");
                    tareas.mostrarPilaCompletado();
                    break;
                case 5:
                    System.out.println("-------------Visualizar tareas vencidas--------------");
                    tareas.mostrarPilaVencido();
                    break;
                case 6:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("No existe la opcion selecionada");
                    break;
            }
        }while(opc != 6);
    }    
}
