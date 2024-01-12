package edd_parcial2_practica4_busqueda.secuancial_alexanderq;

import javax.swing.JOptionPane;

/**
 *
 * @author Alexander Quizhpe
 */
public class Busqueda_Secuencial {
    
    public void buscarDato(int arreglo[], boolean bandera, int dato){
        //Codigo de busqueda secuencial
        //Iterador
        int i = 0;
        while(i<arreglo.length && bandera == false){
            if(arreglo[i] == dato){
                bandera = true;//Se vuelve verdadero si se encuentra el numero
            }
            i++;//Incrementa valor del interador
        }
        
        if(bandera == false){
            JOptionPane.showMessageDialog(null,"No existe el elemento en el arreglo");
        }else{
            JOptionPane.showMessageDialog(null, "Elemento "+dato+" encontrado en la posicion " + i +" del arreglo");
        }
    }
}
