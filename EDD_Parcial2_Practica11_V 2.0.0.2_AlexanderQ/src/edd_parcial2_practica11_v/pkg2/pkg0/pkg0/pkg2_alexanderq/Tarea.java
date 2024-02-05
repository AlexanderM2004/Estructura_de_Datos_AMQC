package edd_parcial2_practica11_v.pkg2.pkg0.pkg0.pkg2_alexanderq;

/**
 *
 * @author Alexander Quizhpe
 */
public class Tarea {
    int id;
    String descr;
    int año;
    int mes;
    int dias;
    String estado;

    public Tarea(int id, String descr, int año, int mes, int dias, String estado) {
        this.id = id;
        this.descr = descr;
        this.año = año;
        this.mes = mes;
        this.dias = dias;
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

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
