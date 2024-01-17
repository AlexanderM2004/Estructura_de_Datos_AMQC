package edd_parcial2_ejemplo_ordenamiento_arbol_binario_alexanderq;

import java.util.Scanner;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial2_Ejemplo_Ordenamiento_Arbol_Binario_AlexanderQ {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        NodoVehiculo raiz = null;
        Concesionario consen = new Concesionario();
        int opc;
        boolean marc = false;
        System.out.println("Ingreso de datos de ventas mensuales en el concesionario");
        System.out.println("Ingrese 'fin' en la marca para finalizar.");
        do{
            System.out.println("Concesionaria NN");
            System.out.println("1: Ingresar datos de ventas mensuales");
            System.out.println("2: Ordenar datos segun las ventas mayores");
            System.out.println("3: Salir");
            opc = tec.nextInt();
            tec.nextLine();
            switch(opc){
                case 1:
                    marc = true;
                    System.out.println("Ingresar datos de ventas mensuales");
                    while (true) {
                        System.out.print("Marca del vehiculo ('fin' para terminar): ");
                        String marca = tec.nextLine();

                        if (marca.equalsIgnoreCase("fin")) {
                            break;
                        }

                        System.out.print("Ventas al mes del vehiculo: ");
                        int ventasMes = tec.nextInt();
                        tec.nextLine(); // Consumir la nueva línea después de nextInt()

                        Vehiculo nuevoVehiculo = new Vehiculo(marca, ventasMes);
                        raiz = consen.insertarVehiculo(raiz, nuevoVehiculo);
                    }
                    break;
                case 2:
                    if(marc){
                        System.out.println("Ordenar datos segun las ventas mayores");
                        System.out.println("Lista de vehiculos ordenada por ventas de mayor a menor:");
                        consen.inordenImprimir(raiz);
                    }else{
                        System.out.println("Primero ingrese datos al sistema");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("No existe la opcion seleccionada");
                    break;
            }
        }while(opc != 3);
    }
}
