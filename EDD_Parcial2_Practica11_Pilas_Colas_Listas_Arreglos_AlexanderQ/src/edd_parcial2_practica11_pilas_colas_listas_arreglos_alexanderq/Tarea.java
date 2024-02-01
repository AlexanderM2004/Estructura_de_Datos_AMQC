package edd_parcial2_practica11_pilas_colas_listas_arreglos_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class Tarea {
    int id;
    String descr;
    String fecha;
    String estado;

    public Tarea(int id, String descr, String fecha, String estado) {
        this.id = id;
        this.descr = descr;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
