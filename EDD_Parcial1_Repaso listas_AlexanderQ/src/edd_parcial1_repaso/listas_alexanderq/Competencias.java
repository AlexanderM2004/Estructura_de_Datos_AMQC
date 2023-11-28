package edd_parcial1_repaso.listas_alexanderq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alexander Quizhpe
 */
public class Competencias {
    Atleta atletas[];
    BufferedReader bfr;
    
    int cantidadAtletas;
    
    public Competencias(int N){
        atletas = new Atleta[N];
        bfr = new BufferedReader(new InputStreamReader(System.in));
        cantidadAtletas = 0;
        
    }
    
    public void IniciarCompetencia() throws IOException{
        int op = 5;
        do{
            System.out.println("Competencia");
            System.out.println("1. Registrar Atleta");
            System.out.println("2. Datos del campeón");
            System.out.println("3. Atletas por país");
            System.out.println("4. Tiempo promedio de todos los atleta");
            System.out.println("6. Salir");
            System.out.print("Ingrese la opcion: ");
            op = Integer.parseInt(bfr.readLine());
            EvaluarOpcion(op);
        }while(op != 5);
    }
    
    private void EvaluarOpcion(int op) throws IOException{
        switch(op){
            case 1:
                if(cantidadAtletas <= atletas.length - 1){
                    System.out.print("Ingresar Atleta, nombre:");
                    String nombre = bfr.readLine();
                    System.out.print("Nacionalidad:");
                    String nacio = bfr.readLine();
                    System.out.print("Tiempo:");
                    int tiempo = Integer.parseInt(bfr.readLine());
                    atletas[cantidadAtletas] = new Atleta(nombre, nacio, tiempo);
                    cantidadAtletas++;
                }else{
                    System.out.println("No se puede ingresar más atletas.");
                }
                System.out.println(atletas.length);
                break;
            case 2:
                // indice donde s eubica  el atleta en el areglo y luego el timpo
                int idxAtleta = 0;
                int menorTiempo = 100;
                // for para recorrer el arreglo
                for(int i=0;i<atletas.length;i++){
                    // usamos get tiempo de la clase atleta
                        if(menorTiempo > atletas[i].getTime()){
                        menorTiempo = (int) atletas[i].getTime();
                        //guardo el indice para saber donde esta el atleta
                        idxAtleta = i;
                    }
                }
                System.out.println("El Atleta campeón es: " + atletas[idxAtleta].getNombre());
                System.out.println("Con el tiempo: " + menorTiempo);
                break;
            case 3:
                System.out.print("Ingrese el país:");
                String pais = bfr.readLine();
                for(int j=0;j<atletas.length;j++){
                    //para comparar cadenas uso de la clase equals
                    if(atletas[j].getNaciona().equals(pais)){
                        System.out.println(atletas[j].getNombre());
                    }
                }
                break;
            case 4:
                int sumaTiempos = 0;
                for(int k=0;k<atletas.length;k++){
                    sumaTiempos = (int) (sumaTiempos + atletas[k].getTime());
                }
                double promedio = sumaTiempos / atletas.length;
                System.out.println("El tiempo promedio es:" + promedio);
                break;
            default:
                break;
        }
        
    }
}
