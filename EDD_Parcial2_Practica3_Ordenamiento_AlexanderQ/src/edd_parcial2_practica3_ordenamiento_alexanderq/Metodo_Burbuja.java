package edd_parcial2_practica3_ordenamiento_alexanderq;

import java.util.Scanner;

/**
 *
 * @author Alexander Quizhpe
 */
public class Metodo_Burbuja {
    // variable que guarda los valores ingresados por el teclado
    long datos;
    // declaramos instancia de la clase Scanner para ingresar datos por la consola
    Scanner entrada = new Scanner(System.in);
    
    public void OrdenarBurbuja(){
        // ingresamos cantidad de datos a procesar
        System.out.print("Ingrese la cantidad de datos a analizar: ");
        int tamano=entrada.nextInt();
        // creamos una instancia de la clase ArregloBurbuja (pasamos la variable tamaño al constructor)
        Arreglo_Burbuja arr = new Arreglo_Burbuja(tamano);
        // ingresamos conjunto de datos
        System.out.println("Ingrese los " + tamano + " datos ");
        // leemos los datos numericos ingresados por teclado
        for(int i=0;i<tamano;i++) {
            System.out.print("Dato " + (i + 1) + ": ");
            datos=entrada.nextLong();
            arr.insertar(datos);
        }
        // imprimimos datos ingresados
        System.out.println("Datos antes de estar ordenados:");
        arr.mostrarElementos();
        // ordenamos los datos usando la ordenacion por burbuja
        arr.ordenacionBurbuja();
        // imprimimos datos ordenados
        System.out.println("Datos ordenados:");
        arr.mostrarElementos();
        // imprimimos elemento menor y mayor
        System.out.println("El menor valor es: " + arr.valorElemento(0));
        System.out.println("El mayor valor es: " + arr.valorElemento(tamano-1));
    }
}
