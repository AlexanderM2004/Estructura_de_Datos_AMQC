package edd_parcial2_practica3_ordenamiento_alexanderq;

import java.util.Scanner;

/**
 *
 * @author Alexander Quizhpe
 */
public class Metodo_Seleccion {
    Arreglo_Seleccion arr=new Arreglo_Seleccion(10);
    Scanner entrada = new Scanner(System.in);
    long datos;
    public void OrdenarSeleccion(){
        /*
        *  Dado un conjunto de valores enteros, retornar todos las pares de n meros cuya diferencia sea igual a dos. El resultado deber  
        *  estar en orden ascendente de valores. Si se ingresan valores enteros duplicados solo se considerar n una vez para el c lculo de 
        *  las diferencias.
        */

        /*
         * Paso1: Ingreso de datos a analizar
         */
        arr.insertar(11);
        arr.insertar(3);
        arr.insertar(1);
        arr.insertar(9);
        arr.insertar(3);
        arr.insertar(15);
        arr.insertar(1);
        arr.insertar(5);
        arr.insertar(5);
        arr.insertar(13);

        System.out.print("Se ingreso el siguiente conjunto de caracteres: ");
        arr.mostrarElementos();

        /*
         * Paso 2: Buscamos pares de numeros que tengan una diferencia de dos
         */
        System.out.print("Pares de Elementos:");
        arr.mostrarParesOrdenados();
    }
}
