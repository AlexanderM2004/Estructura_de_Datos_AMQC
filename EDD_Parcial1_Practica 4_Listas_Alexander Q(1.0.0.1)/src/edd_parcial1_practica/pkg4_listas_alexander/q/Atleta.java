package edd_parcial1_practica.pkg4_listas_alexander.q;

/**
 *
 * @author Alexander Quizhpe
 */
public class Atleta {
    //Declaracion de las variables
    String nombre;
    String naciona;
    float time;

    // El constructor de la clase toma tres argumentos: nombre, naciona y time, y los asigna a los atributos correspondientes.
    public Atleta(String nombre, String naciona, float time) {
        this.nombre = nombre;
        this.naciona = naciona;
        this.time = time;
    }

    /**Los métodos get se utilizan para obtener los valores de los atributos de la clase
    *mientras que los métodos set se utilizan para establecer los valores de los atributos de la clase.
    */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNaciona() {
        return naciona;
    }

    public void setNaciona(String naciona) {
        this.naciona = naciona;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
    
}
