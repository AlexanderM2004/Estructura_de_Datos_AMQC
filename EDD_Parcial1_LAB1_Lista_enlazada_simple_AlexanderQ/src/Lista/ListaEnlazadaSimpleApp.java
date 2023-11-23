package Lista;

/*
 * Autor Alexander Quizhpe
 */

import java.util.*;

public class ListaEnlazadaSimpleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tec = new Scanner(System.in);
		ListaEnlazadaSimple1 lista = new ListaEnlazadaSimple1();
		int opc;
		int i = 1;
		
		do {
			System.out.println("Nota: Solo admite numeros enteros");
			System.out.println("1: Ingresar datos a la lista");
			System.out.println("2: Ingresar datos en medio de los lista");
			System.out.println("3: Buscar datos de la lista");
			System.out.println("4: Mostrar datos de la lista");
			System.out.println("5: Eliminar datos de la lista");
			System.out.println("6: Salir");
			opc = tec.nextInt();
			
			switch(opc) {
			case 1:
				System.out.println("Ingresar datos a la lista");
				System.out.print("Nodo "+i+": ");
				int cont = tec.nextInt();
				lista.insertarCabezaLista(cont);
				i++;
				break;
			case 2:
				System.out.println("Ingresar datos en medio de los lista");
				//Mostrar los nodos de la lista
				lista.mostrarLista();
				
				System.out.print("Ingrese nodo existente: ");
				int nodviej = tec.nextInt();
				System.out.print("Ingrese nodo a ingresar: ");
				int nodnuev = tec.nextInt();
				//Insertar nodos entre dos nodos
				Nodo nodo = lista.insertar(nodviej, nodnuev);
				if(nodo == null) {
					System.out.println("No se puede insertar nuevo nodo");
				}else {
					System.out.println("Nodo insertado correctamente");
				}
				
				break;
			case 3:
				System.out.println("Buscar datos de la lista");
				//Se busca nodo en la lista
				int busqueda = tec.nextInt();
				nodo = lista.buscarLista(busqueda);
				if(nodo != null) {
					System.out.println("Se encontro nodo con dato buscado");
				}else {
					System.out.println("No se encontro nodo con dato buscado");
				}
				break;
			case 4:
				System.out.println("Mostrar datos de la lista");
				//Mostrar los nodos de la lista
				lista.mostrarLista();
				break;
			case 5:
				i =1;
				//Eliminar nodos
				System.out.println("Eliminar datos de la lista");
				while(!lista.vacia()) {
					nodo=lista.eliminarCabezaLista();
					System.out.println("Nodo eliminado");
					nodo.mostrarNodo();
					System.out.println("");
				}
				break;
			case 6:
				System.out.println("Saliendo....");
				break;
			default:
				System.out.println("No existe la opcion seleccionada");
				break;
			}
		}while(opc !=6);

		
		/**
		 // insertamos 5 elemtos del tipo doble a la cabeza de la lista
		lista.insertarCabezaLista(2.98);
		lista.insertarCabezaLista(3.11);
		lista.insertarCabezaLista(1.2);
		lista.insertarCabezaLista(12.212);
		lista.insertarCabezaLista(8.732);
		
		//Insertar nodos entre dos nodos
		Nodo nodo = lista.insertar(1.2, 45);
		if(nodo == null) {
			System.out.println("No se puede insertar nuevo nodo");
		}else {
			System.out.println("Nodo insertado correctamente");
		}
		
		//Mostrar los nodos de la lista
		lista.mostrarLista();
		//Se busca nodo en la lista
		nodo = lista.buscarLista(3.11);
		if(nodo != null) {
			System.out.println("Se encontro nodo con dato buscado");
		}else {
			System.out.println("No se encontro nodo con dato buscado");
		}
		
		while(!lista.vacia()) {
			nodo=lista.eliminarCabezaLista();
			System.out.println("Nodo eliminado");
			nodo.mostrarNodo();
			System.out.println("");
		}
		
		//Comprobar si la lista esta vacia
		System.out.println("Lista enlazada simple esta vacia: " +lista.vacia());
		lista.mostrarLista();
		
		//Insetamos nuevos nodos a la lista
		lista.insertarCabezaLista("Perro");
		lista.insertarCabezaLista("Gato");
		lista.insertarCabezaLista("Caballo");
		lista.insertarCabezaLista("Conejo");
		
		lista.mostrarLista();
		*/
	}

}
