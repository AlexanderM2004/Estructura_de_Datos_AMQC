package edd_parcial1_practica7_colas_alexanderq;

import java.util.Scanner;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial1_Practica7_Colas_AlexanderQ {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int opc, cant=0;
        Cola cola = new Cola(cant);
        // insertamos 4 elementos a la cola
        do{
            System.out.println("COLAS");
            System.out.println("1: Ingresar datos a la cola");
            System.out.println("2: Mostrar elemento en la cabeza de la cola");
            System.out.println("3: Verificar que la cola esta vacia");
            System.out.println("4: Verificar que la cola esta llena");
            System.out.println("5: Mostrar tamaño y datos de la cola");
            System.out.println("6: Eliminar datos de la cola");
            System.out.println("7: Salir");
            opc = tec.nextInt();
            tec.nextLine();
            switch(opc){
                case 1:
                    System.out.println("Ingresar datos a la cola");
                    System.out.println("Cantidad de elmentos a ingresar");
                    cant = tec.nextInt();
                    tec.nextLine();
                    for(int i = 0; i<cant; i++){
                        System.out.print(i+": ");
                        int dato = tec.nextInt();
                        cola.insertar(dato);
                    }
                    break;
                case 2:
                    System.out.println("Mostrar elemento en la cabeza de la cola");
                    System.out.print("ELEMENTO EN LA CABEZA DE LA COLA: ");
                    System.out.print((boolean) cola.frenteCola());
                    break;
                case 3:
                    System.out.println("Verificar que la cola esta vacia");
                    System.out.print("COLA VACIA: ");
                    System.out.println(cola.colaVacia());
                    break;
                case 4:
                    System.out.println("Verificar que la cola esta llena");
                    System.out.print("COLA LLENA: ");
                    System.out.println(cola.colaLLena());
                    break;
                case 5:
                    System.out.println("Mostrar tamaño y datos de la cola");
                    System.out.print("TAMAÑO DE LA COLA: ");
                    System.out.println(cola.tamanoCola());
                    System.out.println("ELEMTOS DE LA COLA");
                    while(!cola.colaVacia()) {
                        Object n = null;
                        System.out.print(n);
                        System.out.print(" ");
                    }
                    break;
                case 6:
                    System.out.println("Eliminar datos de la cola");
                    while(!cola.colaVacia()) {
                        Object n = cola.quitar();
                    }
                    System.out.println("Cola eliminada");
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("No existe la opcion seleccionada");
                    break;
            }
        }while(opc != 7);
    }
}
