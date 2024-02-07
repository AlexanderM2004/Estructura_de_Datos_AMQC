package edd_parcial2_examen_u2_alexanderq;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Quizhpe
 */
public class Directorio {
    //Delaracion de todos los elemtos que van a conformar el dirctorio
    private String direc;
    private List<Directorio> subdirec;
    private List<String> arch;

    //Constructor de la clase
    public Directorio(String direc) {
        this.direc = direc;
        this.subdirec = new ArrayList<>();
        this.arch = new ArrayList<>();
    }
    
    //Metodo que permite aagregar subdirectorios
    public void agregarSubdirec(Directorio subdir) {
        subdirec.add(subdir);
    }

    //Metodod que permite agregar archivos a los subdirectorios
    public void agregarArch(String archivo) {
        arch.add(archivo);
    }

    //Metodo que permite eliminar los subdirectorios creados
    public void eliminarSubdirec(Directorio subdir) {
        subdirec.remove(subdir);
    }

    //Metodo que permite eliminar archvos de los subdirectorios
    public void eliminarArch(String archivo) {
        arch.remove(archivo);
    }

    //Metodo que permite mostrar el arbol binario mediante consola
    public void mostrarArbol(int nivel) {
        StringBuilder espacios = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            espacios.append("  ");
        }
        System.out.println(espacios + direc + "/:");
        for (String archivo : arch) {
            System.out.println(espacios + "  - " + archivo);
        }
        for (Directorio subdirectorio : subdirec) {
            subdirectorio.mostrarArbol(nivel + 1);
        }
    }

//    metodo que permite la busqueda de archivos de los subdirectorios
    public boolean buscarArch(String nombreArch) {
        if (arch.contains(nombreArch)) {
            return true;
        }
        for (Directorio subdirectorio : subdirec) {
            if (subdirectorio.buscarArch(nombreArch)) {
                return true;
            }
        }
        return false;
    }
}
