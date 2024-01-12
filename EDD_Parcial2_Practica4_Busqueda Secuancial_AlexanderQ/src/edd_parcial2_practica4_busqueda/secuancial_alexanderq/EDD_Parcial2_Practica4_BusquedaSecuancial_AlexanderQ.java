package edd_parcial2_practica4_busqueda.secuancial_alexanderq;

import javax.swing.JOptionPane;

/**
 * @author Alexander Quizhpe
 */

public class EDD_Parcial2_Practica4_BusquedaSecuancial_AlexanderQ {
    public static void main(String[] args) {
        int cant;
        int []arreglo= null;
        int dato, opc;//Variable que va a permitir ingresar datos que se va a buscar
        boolean bandera = false;
        Busqueda_Secuencial busque = new Busqueda_Secuencial();
        do{
            opc  = Integer.parseInt(JOptionPane.showInputDialog("1: Ingresar numeros al arreglo"
                    + "\n 2: Buscar Numero"
                    + "\n 3: Salir"));
            switch(opc){
                case 1:
                    cant  = Integer.parseInt(JOptionPane.showInputDialog("Ingresar dimension del arreglo"));
                    arreglo = new int[cant];//Almacenara los datos
                    for(int i = 0; i<cant;i++){
                        arreglo[i] = Integer.parseInt(JOptionPane.showInputDialog("Dato "+(i+1)+":"));
                    }
                    break;
                case 2:
                    //pedir el numero a buscar
                    dato  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero a buscar"));
                    busque.buscarDato(arreglo, bandera, dato);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Saliendo . . . XD");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"No existe la opcion seleccionada");
                    break;
            }
        }while(opc != 3);
        
        
    }
}
