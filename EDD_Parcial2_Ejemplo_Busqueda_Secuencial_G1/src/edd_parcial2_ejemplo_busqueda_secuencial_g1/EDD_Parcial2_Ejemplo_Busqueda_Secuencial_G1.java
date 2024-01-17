package edd_parcial2_ejemplo_busqueda_secuencial_g1;

import java.util.Scanner;

/**
 *
 * @author G1
 */
public class EDD_Parcial2_Ejemplo_Busqueda_Secuencial_G1 {
    public static void main(String[] args) {
        Busqueda_Secuencial busque = new Busqueda_Secuencial();
        // Solicitar al usuario la cantidad de contactos en la guía telefónica
        Scanner tec = new Scanner(System.in);
        String[][] guiaTelefonica = {};
        int opc, cant;
        boolean marc = false;
        do{
            System.out.println("Guia Telefonica");
            System.out.println("1: Ingresar Contactos");
            System.out.println("2: Buscar contacto");
            System.out.println("3: Salir");
            opc = tec.nextInt();
            tec.nextLine();
            switch(opc){
                case 1:
                    marc = true;
                    System.out.println("----------------Ingresar Contacto----------------");
                    System.out.print("Cantidad de contactos en la guia telefonica: ");
                    cant = tec.nextInt();
                    tec.nextLine(); // Consumir el salto de línea después del número

                    // Crear la guía telefónica (nombre, número)
                    guiaTelefonica = new String[cant][2];

                    // Solicitar al usuario ingresar los datos de cada contacto
                    for (int i = 0; i < cant; i++) {
                        System.out.print("Nombre del contacto " + (i + 1) + ": ");
                        guiaTelefonica[i][0] = tec.nextLine();
                        System.out.print("Número de telefono " + (i + 1) + ": ");
                        guiaTelefonica[i][1] = tec.nextLine();
                    };
                    break;
                case 2:
                    if(marc){
                        System.out.println("-----------------Buscar Contacto-----------------");
                        System.out.print("Nombre del contacto a buscar: ");
                        String name = tec.nextLine();

                        String[] secu= busque.busquedaSecuencial(guiaTelefonica, name);

                        // Mostrar el resultado
                        if (secu != null) {
                            System.out.println("Nombre: " + secu[0]);
                            System.out.println("Número de telefono: " + secu[1]);
                        } else {
                            System.out.println("El contacto " + name + " no fue encontrado en la guía telefonica.");
                        }
                    }else{
                        System.out.println("Primero ingrese contactos");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo ...");
                    break;
                default:
                    System.out.println("No existe la opcion seleccionada, intentelo nuevamente");
                    break;
            }
        }while(opc != 3);
    }
}
