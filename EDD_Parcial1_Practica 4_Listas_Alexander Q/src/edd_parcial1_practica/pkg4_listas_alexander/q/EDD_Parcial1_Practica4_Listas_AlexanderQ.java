package edd_parcial1_practica.pkg4_listas_alexander.q;

//Importacion de las librerias
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander Quizhpe
 */
public class EDD_Parcial1_Practica4_Listas_AlexanderQ {

    public static void main(String[] args) {
        List<Atleta> listaAtletas = new ArrayList();
        Competencia compe = new Competencia();
        int opc, num;
        do{
            opc = Integer.parseInt(
            JOptionPane.showInputDialog( null, 
                "1. Registrar Atleta.\n" +
                "2. Datos del campeón.\n" +
                "3. Atletas por país.\n" +
                "4. Tiempo promedio de todos los atletas.\n" +
                "5. Mostrar listados de atletas.\n"+        
                "6. Salir."));
            
            switch(opc){
                case 1:
                    num = Integer.parseInt(
                    JOptionPane.showInputDialog( null, 
                        "---------Registrar Atleta---------\n" +
                        "Atletas a registrar\n"));
                    
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
                    JOptionPane.showMessageDialog(null, "---------Tiempo promedio de los atletas---------\n"+
                            "Tiempo promedio: "+compe.timePromedio());
                    break;
                case 5:
                    compe.mostrarAtletas();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo... :)");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No existe la opcion seleccionada, vuelva a intentarlo");
                    break;
            }     
        }while(opc != 5);
    }
}
