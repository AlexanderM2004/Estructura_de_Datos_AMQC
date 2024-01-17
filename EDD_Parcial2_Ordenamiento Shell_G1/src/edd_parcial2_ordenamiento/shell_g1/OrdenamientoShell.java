package edd_parcial2_ordenamiento.shell_g1;

/**
 *
 * @author G1
 */
public class OrdenamientoShell {
    // Método de ordenamiento Shell para ordenar los datos por edad
    public void shellSortEdad(String[] nombres, int[] edades) {
        int n = edades.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int auxEdad = edades[i];
                String auxNombre = nombres[i];
                int j;

                for (j = i; j >= gap && edades[j - gap] > auxEdad; j -= gap) {
                    edades[j] = edades[j - gap];
                    nombres[j] = nombres[j - gap];
                }

                edades[j] = auxEdad;
                nombres[j] = auxNombre;
            }
        }
    }
    
     // Método de ordenamiento Shell para ordenar los datos por nombre
    public void shellSortNombre(String[] nombres, int[] edades) {
        int n = nombres.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                String tempNombre = nombres[i];
                int tempEdad = edades[i];
                int j;
                //Se utiliza el método compareTo para comparar las cadenas de texto alfabéticamente
                for (j = i; j >= gap && tempNombre.compareTo(nombres[j - gap]) < 0; j -= gap) {
                    nombres[j] = nombres[j - gap];
                    edades[j] = edades[j - gap];
                }

                nombres[j] = tempNombre;
                edades[j] = tempEdad;
            }
        }
    }
    
    public void mostrarDatos(int cant, String[] nombres, int[] edades){
        // Mostrar personas ordenadas por edad
        for (int i = 0; i < cant; i++) {
            System.out.println("Nombre: " + nombres[i] + ", Edad: " + edades[i]);
        }
    }
}
