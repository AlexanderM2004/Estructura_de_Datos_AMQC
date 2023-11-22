package Arrays;
//Importar libreria Scanner para ingresar valores por pantalla
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		//Declarar el objeto que permita el ingreso de datos
		Scanner tec = new Scanner(System.in);
		//Creacion del arreglo de tipo entero el cual va a almacenar los numeros ingresados por el usuario
		int[] num = new int[5];
		//Creacion de variables para la manipulacion del arreglo
		int opc, j = 1, a=1 ;
		
		do {
			
			//Menu de opciones en la que se muestra las acciones del sistema
			int numpos = 0, numneg = 0, cero = 0;
			float subpos = 0, subneg = 0 ;
			System.out.println("1: Ingresar Numeros a Arreglo");
			System.out.println("2: Mostrar Numeros del Arreglo");
			System.out.println("3: Mostrar Numeros del Arreglo Invertidos");
			System.out.println("4: Mostrar Media de Numeros");
			System.out.println("5: Salir");
			opc = tec.nextInt();//Permite escoger la opcion del menu
			//Redirecciona a la opcion del menu escogida
			switch(opc) {
			case 1:
				//Ejercicio 1
				/**
				 * Ingresar 5 numeros en un arreglo
				 */
				System.out.println("Ingresar Numeros");
				//Mediante un bucle for, se va hacer el ingreso de los datos, ya que la variable i va ha establecer la posicion del arreglo
				//en la que se quiera guardar el dato
				for(int i=0; i<5; i++) {
					System.out.print("Numero "+j+": ");
					num[i] = tec.nextInt();//Permite ingresar los datos al arreglo
					j++;
				}
				break;
			case 2:
				//Ejercicio 1
				/**
				 * Mostrar los 5 numeros ingresados
				 */
				System.out.println("Numeros Ingresados");
				//Mediante un bucle for, se va hacer la lectura de los datos, ya que la variable i va ha establecer la posicion del arreglo
				//en la que se quiera leer el dato
				for(int i=0; i<5; i++) {
					System.out.println("Numero "+a+": "+num[i]);//Muestra los numeros por pantalla
					a++;
				}
				break;
			case 3:
				//Ejercicio 2
				/**
				 * Invertir los datos ingresados en el arreglo
				 */
				//Mediante un bucle for, se va hacer la lectura de los datos, del  posicion ultima a la mas primera, ya que la variable i va 
				//ha establecer la posicion del arreglo en la que se quiera leer el dato
				System.out.println("Numeros Ingresados Inverso");
				for(int i=4; i>=0; i--) {
					System.out.println("Numero "+i+": "+num[i]);//Muestra los numeros por pantalla
					a++;
				}
				break;
			case 4:
				//Ejercicio 3
				/**
				 * Calcular la media de los numeros positivos, negativos y contar la cantidad de 0
				 * ingresados en el arreglo
				 */
				System.out.println("Media de los numeros");
				//Calcula la media de los numeros positivos y negativos, ademas de contar la cantidad de 0
				for(int i=0; i<5; i++) {
					if(num[i] >= 1) {
						subpos=subpos+num[i];
						numpos++;
					}else if(num[i] <=-1) {
						subneg=subneg+num[i];
						numneg++;
					}else {
						cero++;
					}
				}
				
				//Muestra la media de los numeros positivos, negativo
				//ademas de que muestra la cantidad de 0
				System.out.println("Media numero positivos: "+subpos/numpos);
				System.out.println("Media numero negativos: "+subneg/numneg);
				System.out.println("Cantidad de 0: "+cero);
				break;
			case 5:
				System.out.println("Saliendo");
				break;
			default: 
				System.out.println("No existe la opcion selecionada");
				break;
			}
			System.out.println("-------------------------------------------");
		}while(opc != 5);		
	}
}
