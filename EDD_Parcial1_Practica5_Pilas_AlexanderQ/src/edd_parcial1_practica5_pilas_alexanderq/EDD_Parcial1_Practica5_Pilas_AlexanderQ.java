package edd_parcial1_practica5_pilas_alexanderq;
import java.util.Scanner;
/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial1_Practica5_Pilas_AlexanderQ {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        Pilas mipila = new Pilas();
        int opc , cant = 0;
        do{
            System.out.println("1. Ingresar datos a la Pila");
            System.out.println("2. Mostrar datos de la Pila");
            System.out.println("3. Eliminar datos de la Pila");
            System.out.println("4. Cabeza de la Pila");
            System.out.println("5. Fondo de la Pila");
            System.out.println("6. Salir");
            opc = tec.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Ingresar datos a la Pila");
                    System.out.print("Cantidad de datos a ingresar: ");
                    cant = tec.nextInt();
                    for(int i = 0; i<cant;i++){
                        System.out.println("Valor: ");
                        int valo = tec.nextInt();
                        mipila.push(valo);
                    }
                    break;
                case 2:
                    System.out.println("Mostrar datos de la Pila");
                    mipila.mostrarPila();
                    break;
                case 3:
                    System.out.println("Eliminar datos de la Pila");
                    for(int i = 0; i<cant;i++){
                        System.out.println("Valor "+mipila.pop()+" eliminado");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo ... :)");
                    break;
                case 5:
                    System.out.println("Cabeza de la Pila");
                    mipila.cabezaPila();
                    break;
                case 6: 
                    System.out.println("Fondo de la Pila");
                    
                    break;
                default:
                    System.out.println("No existe la opcion seleccionada");
                    break;
            }
        }while(opc != 6);
    }
}
