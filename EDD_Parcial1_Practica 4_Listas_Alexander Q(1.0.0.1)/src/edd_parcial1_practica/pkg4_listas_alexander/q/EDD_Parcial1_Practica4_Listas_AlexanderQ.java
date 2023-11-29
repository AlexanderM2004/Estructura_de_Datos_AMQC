package edd_parcial1_practica.pkg4_listas_alexander.q;

//Importacion de las librerias
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 * @author Alexander Quizhpe
 * Clase principal que gestiona un programa para registrar y analizar datos de atletas en una competencia.
 */
public class EDD_Parcial1_Practica4_Listas_AlexanderQ {

    public static void main(String[] args) {
        // Lista para almacenar objetos Atleta
        List<Atleta> listaAtletas = new ArrayList();
        // Scanner para la entrada de datos
        Scanner tec = new Scanner (System.in);
        // Instancia de la clase Competencia para gestionar las operaciones relacionadas con los atletas
        Competencia compe = new Competencia();
        // Variables para el menú
        int opc, num;
        // Menú principal
        do{
            System.out.println("1. Registrar Atleta.");
            System.out.println("2. Datos del campeón.");
            System.out.println("3. Atletas por país.");
            System.out.println("4. Tiempo promedio de todos los atletas.");
            System.out.println("5. Mostrar listados de atletas.");
            System.out.println("6. Eliminar atleta");
            System.out.println("7. Salir.");
            opc = tec.nextInt();
            tec.nextLine();
            switch(opc){
                case 1:
                    System.out.println("---------Registrar Atleta---------");
                    System.out.print("Atletas a registrar: ");
                    num = tec.nextInt();
                    tec.nextLine();
                    for(int i = 0; i < num ; i++){
                        compe.ingresarAtleta(i);
                    }
                    break;
                case 2:
                    compe.atletaGanador();
                    break;
                case 3:
                    compe.atletasPais();
                    break;
                case 4:
                    System.out.println("---------Tiempo promedio de los atletas---------");
                    System.out.println("Tiempo promedio: "+compe.timePromedio());
                    break;
                case 5:
                    compe.mostrarAtletas();
                    break;
                case 6:
                    
                    break;
                case 7:
                    System.out.println("Saliendo... :)");
                    break;
                default:
                    System.out.println("No existe la opcion seleccionada, vuelva a intentarlo");
                    break;
            }     
        }while(opc != 5);
    }
}
