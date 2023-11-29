package edd_parcial1_practica.pkg4_listas_alexander.q;

//Importacion de las librerias
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * Clase Competencia que gestiona un conjunto de atletas.
 * Permite ingresar, mostrar y analizar datos sobre los atletas.
 * Autor: Alexander Quizhpe
 */
public class Competencia {
    // Scanner para la entrada de datos
    Scanner tec = new Scanner(System.in);
    // Lista para almacenar los objetos Atleta
    List<Atleta> listaAtletas = new ArrayList();
    //Metodo para ingresar datos dela atleta
    public void ingresarAtleta( int i){
        System.out.println("---------Registrar Atleta---------");
        System.out.print("Nombre: ");
        String nomb = tec.nextLine();
        System.out.print("Pais: ");
        String pais = tec.nextLine();
        System.out.print("Tiempo (seg): ");
        float tiemp = tec.nextFloat();
        listaAtletas.add(i, new Atleta(nomb, pais, tiemp));
    }
    //Metodos para motrar al atleta ganador
    public void atletaGanador(){
        // Encontrar el atleta con el tiempo más bajo
        Atleta atlerap = listaAtletas.get(0);
        for (Atleta atle : listaAtletas) {
            if (atle.getTime()< atlerap.getTime()) {
                atlerap = atle;
            }
        }
        
        // Imprimir los datos del atleta más rápido
        System.out.println("---------Atleta mas Rapido---------");
        System.out.println("Nombre: "+atlerap.getNombre());
        System.out.println("Nacionalidad: "+atlerap.getNaciona());
        System.out.println("Tiempo: "+atlerap.getTime()+" seg");
    }
    // Método para mostrar atletas de un país específico
    public void atletasPais(){
        System.out.println("---------Atletas por país---------");
        System.out.print("Ingresa el nombre del país: ");
        String pais = tec.nextLine();

        // Mostrar los nombres de los atletas del país ingresado
        for (Atleta atle : listaAtletas) {
            //equalsIgnoreCase permite compara dos cadenas de texto ignorando las mayusculas y minusculas
            if (atle.getNaciona().equalsIgnoreCase(pais)) {
                System.out.println("Nombre: "+atle.getNombre());
            }else{
                System.out.println("No existe el pais ingresado");
            }
        }
    }
    // Método para calcular el tiempo promedio de todos los atletas
    public float timePromedio(){
        float timepro = 0;
        int cont = 0;
        for (Atleta atle : listaAtletas) {
            timepro = atle.getTime()+ timepro; 
            cont ++;
        }
        
        if (cont != 0) {
            float tipro = timepro/cont;
            return tipro;
        } else {
            return 0; // Evitar la división por cero si no hay atletas
        }
    }
    // Método para mostrar todos los atletas registrados
    public void mostrarAtletas(){
        for (Atleta atle : listaAtletas) {
            System.out.println("---------Mostrar atletas---------");
            System.out.println("Mombre: "+atle.getNombre());
            System.out.println("Nacionalidad: "+atle.getNaciona());
            System.out.println("Tiempo: "+atle.getTime()+" seg");
            System.out.println("");
        }
    }
    // Método para eliminar un atleta por nombre
    public void eliminarAtleta(){
        System.out.println("---------Borrar atletas---------");
        System.out.print("Ingrese nombre de atleta a eliminar: ");
        String nomb = tec.nextLine();
        
        boolean atletaEncontrado = false;

        // Usar un iterador para evitar problemas al modificar la lista durante la iteración
        java.util.Iterator<Atleta> iter = listaAtletas.iterator();
        while (iter.hasNext()) {
            Atleta atle = iter.next();
            if (atle.getNombre().equalsIgnoreCase(nomb)) {
                iter.remove(); // Eliminar el atleta actual de la lista
                System.out.println("Atleta eliminado con éxito");
                atletaEncontrado = true;
            }
        }

        if (!atletaEncontrado) {
            System.out.println("No existe el atleta ingresado.");
        }

        System.out.println("");
        mostrarAtletas();
    }
            
}
