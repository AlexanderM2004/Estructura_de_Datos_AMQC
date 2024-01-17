
package edd_parcial2_ordenamiento.shell_g1;

import java.util.Scanner;

/**
 *
 * @author G1
 */
public class EDD_Parcial2_OrdenamientoShell_G1 {
    public static void main(String[] args) {
        //Se importa la clase Scanner para facilitar la entrada de datos desde la consola
        Scanner tec = new Scanner(System.in);
        //Se instancia el objeto de la clase Ordenamiento Shell, para poder utilizar todos sus metodos
        OrdenamientoShell shell = new OrdenamientoShell();
        //Declarar Variables a utilizar
        //Declarar arreglos a utilizar
        String[] nombres = null ;//Almacenara Nombres
        int[] edades = null;//Almacenara por edades
        int opc, cant = 0;
        boolean marc = false;
        do{
            System.out.println("Metodo de Ordenamiento Shell");
            System.out.println("1: Ingresar Datos");
            System.out.println("2: Ordenar Datos por la edad");
            System.out.println("3: Ordenar Datos por nombre");
            System.out.println("4: Salir");
            System.out.println("--------------------------------------------------------");
            opc = tec.nextInt();
            switch(opc){
                case 1:
                    marc = true;
                    System.out.println("---------------------Ingresar Datos---------------------");
                    System.out.print("Ingrese la cantidad de personas: "); //Se solicita al usuario que ingrese la cantidad de personas.
                    cant = tec.nextInt();
                    //Declarar arreglos a utilizar
                    nombres = new String[cant];//Almacenara Nombres
                    edades = new int[cant];//Almacenara por edades
                    tec.nextLine();
                    // Ingreso de datos utilizando un bucle for para ingresar los nombres y las edades de las personas.
                    for (int i = 0; i < cant; i++) {
                        System.out.print("Ingrese el nombre de la persona " + (i + 1) + ": ");
                        nombres[i] = tec.next(); //Ingresa los nombres de la persona

                        System.out.print("Ingrese la edad de la persona " + (i + 1) + ": ");
                        edades[i] = tec.nextInt(); //Ingresa Edad de la persona
                        tec.nextLine();
                    }
                    System.out.println("--------------------------------------------------------");
                    break;
                case 2:
                    if(marc){
                        System.out.println("---------------Ordenar Datos por la edad----------------");
                        // Ordenamiento por edad utilizando Shell Sort
                        shell.shellSortEdad(nombres, edades);
                        // Mostrar personas ordenadas por edad
                        shell.mostrarDatos(cant, nombres, edades);
                    }else{
                        System.out.println("Primero ingrese datos al sistema");
                    }
                    System.out.println("--------------------------------------------------------");
                    break;
                case 3:
                    if(marc){
                        System.out.println("----------------Ordenar Datos por nombre----------------");
                        // Ordenamiento por nombre utilizando Shell Sort
                        shell.shellSortNombre(nombres, edades);
                        // Mostrar personas ordenadas por nombre
                        shell.mostrarDatos(cant, nombres, edades);
                    }else{
                        System.out.println("Primero ingrese datos al sistema");
                    }
                    System.out.println("--------------------------------------------------------");
                    break;
                case 4:
                    System.out.println("Saliendo ...");
                    break;
                default:
                    System.out.println("No existe la opcion seleccionada ");
                    System.out.println("--------------------------------------------------------");
                    break;
            }
        }while(opc != 4);
    }
}
