package edd_parcial1_practica.pkg4_listas_alexander.q;

//Importacion de las librerias
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander Quizhpe
 */
public class Competencia {
    
    List<Atleta> listaAtletas = new ArrayList();
    //Metodo para ingresar datos dela atleta
    public void ingresarAtleta( int i){
        String nomb = JOptionPane.showInputDialog(null, "---------Registrar Atleta---------\n" + "Nombre:");
        String pais = JOptionPane.showInputDialog(null, "---------Registrar Atleta---------\n" + "Pais:");
        float tiemp = Integer.parseInt(JOptionPane.showInputDialog( null, "---------Registrar Atleta---------\n" + "Tiempo (seg):"));
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
        JOptionPane.showMessageDialog(null, 
            "---------Atleta mas Rapido---------\n"+
            "Mombre: "+atlerap.getNombre()+"\n"+
            "Nacionalidad: "+atlerap.getNaciona()+"\n"+
            "Tiempo: "+atlerap.getTime()+" seg");
    }
    
    public void atletasPais(){
        String pais = JOptionPane.showInputDialog(null, "---------Atletas por país---------\n" + "Ingresa el nombre del país:");

        // Mostrar los nombres de los atletas del país ingresado
        for (Atleta atle : listaAtletas) {
            //equalsIgnoreCase permite compara dos cadenas de texto ignorando las mayusculas y minusculas
            if (atle.getNaciona().equalsIgnoreCase(pais)) {
                JOptionPane.showMessageDialog(null, "Nombre: "+atle.getNombre());
            }else{
                JOptionPane.showMessageDialog(null, "No existe el pais ingresado: ");
            }
        }
    }
    
    
    public float timePromedio(){
        float timepro = 0;
        int cont = 0;
        for (Atleta atle : listaAtletas) {
            timepro = atle.getTime()+ timepro; 
            cont ++;
        }
        float tipro = timepro/cont;
        return tipro;
    }
    public void mostrarAtletas(){
        for (Atleta atle : listaAtletas) {
            JOptionPane.showMessageDialog(null,
                "---------Mostrar atletas---------\n"+    
                "Mombre: "+atle.getNombre()+"\n"+
                "Nacionalidad: "+atle.getNaciona()+"\n"+
                "Tiempo: "+atle.getTime()+" seg");
        }
    }
}
