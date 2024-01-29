package edd_parcial2_practica10_gui_arbol_genealogico_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class Persona {
    private String nombre;
    private String fechaNacimiento;
    private String genero;
    // private int edad;
    public Persona(String nombre, String fechaNacimiento, String genero) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }
    // Getters y setters según sea necesario
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
