package edd_parcial1_tarea_listas_alexander.q;

//Se importa la libreria scanner la cual permite el ingreso de datos mediante el teclado
import java.util.Scanner;

/**
 *
 * @author Grupo 1
 */
public class EDD_Parcial1_Tarea_Listas_AlexanderQ {

    public static void main(String[] args) {
        
        Lista lista= new Lista(); // Crear una instancia de la clase Lista.
        Scanner entrada= new Scanner(System.in);
        int op,num;
        int dat;
        // Menú principal para interactuar con la lista enlazada.
        do{
            System.out.println("----------MENU LISTA ENLAZADA----------");
            System.out.println("1. INSERTAR DATOS DE LISTA");
            System.out.println("2. SUMA DE LOS ELEMENTOS DE LA LISTA");
            System.out.println("3. EL VALOR MAXIMO DE LA LISTA");
            System.out.println("4. EL VALOR MINIMO DE LA LISTA");
            System.out.println("5. ORDEN ASCENDENTE DE LA LISTA");
            System.out.println("6. CUADRADOS DE LOS ELEMENTOS DE LA LISTA");
            System.out.println("7. MOSTRAR ELEMENTOS");
            System.out.println("8. SALIR");
            op= entrada.nextInt();
            // Switch para manejar las opciones del menú.
            switch(op){
                case 1:
                    // Limpiar la lista antes de ingresar nuevos datos.
                    lista.eliminarlista();
                    System.out.println("INGRESE CUANTOS DATOS VA A INGRESAR:");
                    num= entrada.nextInt();
                    //Ingreso de los datos a los nodos mediante un buvle for
                    for(int i=0;i<num;i++){
                        System.out.print("INGRESE EL DATO  "+(i+1)+" : ");
                        dat=entrada.nextInt();
                        lista.insertarlista(dat);
                    }              
                    break;
                case 2:
                    System.out.println("LA SUMA DE LOS ELEMENTOS DE LA LISTA ES "+lista.suma());
                    break;
                 case 3:
                    System.out.println("EL VALOR MAXIMO DE LA LISTA ES "+lista.maximo());
                    break;
                case 4:
                    System.out.println("EL VALOR MINIMO DE LA LISTA ES "+lista.minimo());
                    break;    
                case 5:
                    System.out.println("LA LISTA EN ORDEN ASCENDENTE ES ");
                    lista.ascendente(); //Muestra la los datos de la lista en orden ascendente
                    lista.mostrarLista(); //Muestra la los datos de la lista
                    break;
                case 6:
                    System.out.println("LOS CUADRADOS DE LOS ELEMENTO DE LA LISTA SON: ");
                    lista.cuadrados();//Muestra los cuadrados de los elementos de la lista
                    break; 
                case 7:
                    System.out.println("LA LISTA DE LOS ELEMENTOS INGRESADOS SON ");
                    lista.mostrarLista();//Muestra la los datos de la lista
                    break;
                case 8:
                    System.out.println("SALIENDOOOOOO......");
                    
                    break;   
                default:
                    System.out.println("LA OPCION ES INCORRECTA");
                    break;  
            }
        }while(op!=8);//Se va a repetir el bucle, siempre y cuando la opcion escojida sea distinta a 8
    }
}
