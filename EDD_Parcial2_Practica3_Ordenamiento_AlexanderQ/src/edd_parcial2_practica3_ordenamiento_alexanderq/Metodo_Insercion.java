package edd_parcial2_practica3_ordenamiento_alexanderq;

import java.util.Scanner;

/**
 *
 * @author Alexander Quizhpe
 */
public class Metodo_Insercion {
    //long datos;
    Arreglo_Insercion arr=new Arreglo_Insercion(10);
    //Scanner entrada=new Scanner(System.in);
    public void OrdenarInsercion(){
        // insertamos 6 valores al arreglo
        arr.insertar(16);
        arr.insertar(11);
        arr.insertar(56);
        arr.insertar(4);
        arr.insertar(87);
        arr.insertar(78);

        // solicitamos valor para el cual queremos averiguar los numeros en el arreglo menores a el
        Scanner entrada=new Scanner(System.in);
        System.out.print("Ingrese valor: ");
        int valor=entrada.nextInt();

        // mostramos elementos insertados
        System.out.print("Elementos insertados: ");
        arr.mostrarElementos();

        // imprimimos valores menores al valor de la variable valor
        System.out.print("Elementos menores a " + valor + ": ");
        arr.mostrarElementosMenoresA(valor);
    }
}
