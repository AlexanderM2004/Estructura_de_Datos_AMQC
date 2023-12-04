package edd_parcial1_practica6_pilas.y.listas_alexander.q;
import java.util.*;
/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial1_Practica6_PilasYListas_AlexanderQ {
    public static void main(String[] args) {
        Organizar libro = new Organizar();
        Scanner tec = new Scanner(System.in);
        int opc;
        String titu, name; 
        int date;
        do{
            System.out.println("1: Ingresar Libros");
            System.out.println("2: Regalar libros");
            System.out.println("3: Ordenar libros");
            System.out.println("4: Salir");
            opc = tec.nextInt();
            tec.nextLine();
            switch(opc){
                case 1:
                    System.out.println("--------------Ingresar Libros--------------");
                    System.out.print("Cantidad de libros a ingresar: ");
                    int cant = tec.nextInt();
                    for(int i = 0; i<cant;i++){
                        libro.push(i);
                    }
                    System.out.println("Libros ingresados");
                    libro.mostrarPila();
                    break;
                case 2:
                    System.out.println("--------------Regalar libros--------------");
                    System.out.print("Fecha de edicion maxima: ");
                    date = tec.nextInt();
                    libro.regalarBook(date);
                    break;
                case 3:
                    System.out.println("--------------Ordenar libros--------------");
                    break;
                case 4:
                    System.out.println("Saliendo ...");
                    break;
                default:
                    System.out.println("No existe la opcion seleccionada");
                    break;
            }
        }while(opc !=4);
        
        
    }
    
}
