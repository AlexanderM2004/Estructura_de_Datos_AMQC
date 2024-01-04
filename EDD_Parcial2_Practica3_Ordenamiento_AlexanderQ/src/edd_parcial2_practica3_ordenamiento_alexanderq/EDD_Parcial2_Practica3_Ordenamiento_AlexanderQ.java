package edd_parcial2_practica3_ordenamiento_alexanderq;

import java.util.Scanner;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial2_Practica3_Ordenamiento_AlexanderQ {
    public static void main(String[] args) {
        // problema: calcular el maximo y el minimo valor de un conjunto de N datos
        Scanner tec = new Scanner(System.in);
        int opc;
        do{
            System.out.println("Metodos de Ordenamientos");
            System.out.println("1: Metodo Burbuja");
            System.out.println("2: Metodo Insercion");
            System.out.println("3: Metodo Seleccion");
            System.out.println("4: Metodo Shell");
            System.out.println("5: Salir");
            System.out.println("-------------------------------------------");           
            opc = tec.nextInt();
            switch(opc){
                case 1:
                    System.out.println("---------------Metodo Burbuja--------------");
                    Metodo_Burbuja burbu= new Metodo_Burbuja();
                    burbu.OrdenarBurbuja();
                    System.out.println("-------------------------------------------");
                    break;
                case 2:
                    System.out.println("--------------Metodo Insercion-------------");
                    Metodo_Insercion insert= new Metodo_Insercion();
                    insert.OrdenarInsercion();
                    System.out.println("-------------------------------------------");
                    break;
                case 3:
                    System.out.println("--------------Metodo Seleccion-------------");
                    Metodo_Seleccion selec= new Metodo_Seleccion();
                    selec.OrdenarSeleccion();
                    System.out.println("-------------------------------------------");
                    break;
                case 4:
                    System.out.println("---------------Metodo Shell----------------");
                    Metodo_Shell shell= new Metodo_Shell();
                    shell.OrdenarShell();
                    System.out.println("-------------------------------------------");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("No existe la opcion seleccionada, vuelva a intentarlo ");
                    break;
            }
        }while(opc != 5);
    }
}
