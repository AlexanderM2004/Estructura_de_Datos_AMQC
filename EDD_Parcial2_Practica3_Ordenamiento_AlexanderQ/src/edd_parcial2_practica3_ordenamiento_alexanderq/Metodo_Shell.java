package edd_parcial2_practica3_ordenamiento_alexanderq;

import java.util.Scanner;

/**
 *
 * @author Alexander Quizhpe
 */
public class Metodo_Shell {
    Scanner scanner=new Scanner(System.in);
    public void OrdenarShell(){
        /*
        Dado un numero entero no negativo, retornarlo con sus digitos en orden descendente
        */

        Arreglo_Shell arr;
        
        // Ingresamos numero a analizar
        System.out.print("Ingrese numero entero: ");
        int numero=scanner.nextInt();

        // contamos el numero de digitos
        int n=numero;
        int numDigitos=0;
        while (n>0) {
            n=n/10;
            numDigitos++;
        }

        // obtenemos cada digito del numero y lo ingresamos al arreglo
        long cociente;
        long digito;
        long temp=numero;
        arr=new Arreglo_Shell(numDigitos);
        while(temp!=0) {
            cociente=temp/10;
            digito=temp-cociente*10;
            arr.insertar(digito);
            temp=cociente;
        }

        // ordenamos el arreglo usando la ordenacion Shell
        arr.ordenacionShell();

        // imprimimos valores de arreglo desde ultimo elemento hasta el primero
        arr.mostrarElementosOrdenInverso();
    }
}
