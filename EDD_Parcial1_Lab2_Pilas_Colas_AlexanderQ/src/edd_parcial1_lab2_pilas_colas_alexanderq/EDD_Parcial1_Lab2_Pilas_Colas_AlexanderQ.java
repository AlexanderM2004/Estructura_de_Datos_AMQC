package edd_parcial1_lab2_pilas_colas_alexanderq;

import java.util.Scanner;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial1_Lab2_Pilas_Colas_AlexanderQ {
    public static void main(String[] args) {
        //Declaracion de metods para el ingreso de datos
        Scanner tec = new Scanner(System.in);
        //Intanciar Objeto
        Restaurante rest = new Restaurante();
        //Delcaracion de variables
        int opc, numpedi;
        do{
            //Menu de acciones del restaurante
            System.out.println("---------------------MENU---------------------");
            System.out.println("1: Agregar Pedido");
            System.out.println("2: Preparar Pedido");
            System.out.println("3: Entregar Pedido");
            System.out.println("4: Mostrar Pedidos Pendientes");
            System.out.println("5: Salir");
            opc = tec.nextInt();//Permite seleccionar la opcion del menu
            tec.nextLine();
            switch(opc){
                case 1:
                    //Agregar pedido
                    System.out.println("Agregar Pedido");
                    System.out.print("Cantidad de pedidos a ingresar: ");
                    int cant = tec.nextInt();
                    for(int i = 0; i<cant;i++){
                        rest.push(i);//Llamar al metodo para ingresar datos a la pila
                    }
                    break;
                case 2:
                    System.out.println("Preparar Pedido");
                    rest.mostrarPila();
                    System.out.print("Numero de pedido a preparar: ");
                    numpedi = tec.nextInt();
                    rest.clasificarpedidos(numpedi);//Llamar al metodo para que permita clasificar los datos
                    break;
                case 3:
                    System.out.println("Entregar Pedido");
                    rest.entregarpedidos();//Muestra mediante las colas los pedidos qu ya estan
                    break;
                case 4:
                    System.out.println("Mostrar Pedidos Pendientes");
                    rest.mostrarPendientes();//Muestra los pedidos pendientes en un pila
                    break;
                case 5:
                    System.out.println("Saliendo ...");
                    break;
                default:
                    System.out.println("No existe la opcion seleccionada");
                    break;
            }
        }while(opc != 5);
    }
    
}
