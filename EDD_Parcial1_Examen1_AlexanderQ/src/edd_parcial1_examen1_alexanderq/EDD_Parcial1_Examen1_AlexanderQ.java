
package edd_parcial1_examen1_alexanderq;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial1_Examen1_AlexanderQ {

    public static void main(String[] args) throws IOException {
        //Declaracion de metods para el ingreso de datos
        Scanner tec = new Scanner(System.in);
        //Intanciar Objeto
        int[] num = new int[1];
        Restaurante rest = new Restaurante();
        //Delcaracion de variables
        int opc, numpedi;
        boolean marc = false;
        do{
            //Menu de acciones del restaurante
            System.out.println("---------------------MENU---------------------");
            System.out.println("1: Ingresar menu");
            System.out.println("2: Agregar Pedido");
            System.out.println("3: Preparar Pedido");
            System.out.println("4: Entregar Pedido");
            System.out.println("5: Cancelar Pedido");
            System.out.println("6: Mostrar Pedidos Pendientes");
            System.out.println("7: Salir");
            opc = tec.nextInt();//Permite seleccionar la opcion del menu
            tec.nextLine();
            switch(opc){
                case 1:
                    marc = true;
                    System.out.println("Ingresar Menu");
                    System.out.println("Cantidad de platos a ingresar: ");
                    num[0] = tec.nextInt();
                    for(int i = 0; i<num[0];i++){
                        rest.ingresarMenu(i);
                    }
                    break;
                case 2:
                    if(marc){
                        //Agregar pedido
                        System.out.println("Agregar Pedido");
                        for(int i = 0; i<num[0];i++){
                            rest.mostrarMenu(i);
                        }
                        
                        System.out.println(" ");
                        System.out.print("Cantidad de pedidos a ingresar: ");
                        int canti = tec.nextInt();
                        for(int i = 0; i<canti;i++){
                            rest.push(i);//Llamar al metodo para ingresar datos a la pila
                        }
                    }else{
                        System.out.println("Primero ingrese un menu antes de hacer los pedidos");
                    }
                    break;
                case 3:
                    System.out.println("Preparar Pedido");
                    rest.mostrarPila();
                    System.out.print("Numero de pedido a preparar: ");
                    numpedi = tec.nextInt();
                    rest.clasificarpedidos(numpedi);//Llamar al metodo para que permita clasificar los datos
                    break;
                case 4:
                    System.out.println("Entregar Pedido");
                    System.out.println("Pedido a entregar: ");
                    rest.entregarpedidos();//Muestra mediante las colas los pedidos qu ya estan
                    break;
                case 5:
                    System.out.println("Cancelar Pedido");
                    rest.mostrarPila();
                    System.out.print("Num. Pedido a cancelar: ");
                    int cancel= tec.nextInt();
                    rest.cancelarPedido(cancel);
                    break;
                case 6:
                    System.out.println("Mostrar Pedidos Pendientes");
                    rest.mostrarPendientes();//Muestra los pedidos pendientes en un pila
                    break;
                case 7:
                    System.out.println("Saliendo ...");
                    break;
                default:
                    System.out.println("No existe la opcion seleccionada");
                    break;
            }
        }while(opc != 7);
    }
}
