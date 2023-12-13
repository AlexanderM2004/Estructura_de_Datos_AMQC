
package edd_parcial1_examen1_alexanderq;

/**
 *
 * @author ESPE
 */
public class Pedido extends Producto{
    //Declarcion de variables
    int numpedido;
    String nomclient;
    //Constructor de la clase
    public Pedido(int numpedido, String nomclient, String nomprodu, double precio, int cant) {
        super(nomprodu, precio, cant);
        this.numpedido = numpedido;
        this.nomclient = nomclient;
    }
    //Metodos get y set de las varialbes de la clase producto y pedido
    public int getNumpedido() {
        return numpedido;
    }

    public void setNumpedido(int numpedido) {
        this.numpedido = numpedido;
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public String getNomprodu() {
        return nomprodu;
    }

    public void setNomprodu(String nomprodu) {
        this.nomprodu = nomprodu;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
}
