package edd_parcial2_ejemplo_busqueda_secuencial_g1;

/**
 *
 * @author G1
 */
public class Busqueda_Secuencial {
     // Método de búsqueda secuencial
    public String[] busquedaSecuencial(String[][] guia, String nombre) {
        for (String[] contacto : guia) {
            // Comparar el nombre del contacto actual con el nombre buscado (ignorando mayúsculas/minúsculas)
            if (contacto[0].equalsIgnoreCase(nombre)) {
                // Si se encuentra, devolver la información del contacto
                return contacto;
            }
        }
        // Si no se encuentra, devolver null
        return null;
    }
}
