package edd_parcial1_practica6_pilas.y.listas_alexander.q;

/**
 *
 * @author Alexander Quizhpe
 */
public class Libro {
    String titulo;
    String autor;
    int año;
    Libro next; 
    
    public Libro(String titulo, String autor, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.next = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
}
