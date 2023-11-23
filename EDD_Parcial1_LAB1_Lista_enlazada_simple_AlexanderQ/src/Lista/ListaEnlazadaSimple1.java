package Lista;

/*
 * Autor Alexander Quizhpe
 */


public class ListaEnlazadaSimple1 {
	
	//Variables de instancia
	private Nodo primero;
	
	//Constructor
	public ListaEnlazadaSimple1() {
		primero = null;
	}
	
	//verifica si la lista enlazada simple esta vacia
	public boolean vacia() {
		return (primero == null);
	}
	
	//Inserta nodo en la cabeza de la lista
	public void insertarCabezaLista(Object d) {
		Nodo nuevoNodo = new Nodo(d);
		nuevoNodo.siguiente = primero;
		primero = nuevoNodo;
	}
	
	//Elimina nodo de la cabeza de la lista (asume que la lista no esta vacia)
	public Nodo eliminarCabezaLista() {
		Nodo temp = primero;
		primero = primero.siguiente;
		
		return temp;
	}
	
	//Imprime el contenido de los nodos de la lista simple enlazada
	public void mostrarLista() {
		System.out.println("Lista (primero -> ultimo): ");
		Nodo nodoActual = primero;
		
		while(nodoActual != null) {
			nodoActual.mostrarNodo();
			nodoActual = nodoActual.siguiente;
		}
		
		System.out.println("");
	}
	
	//Busca nodo con el dato de parametro pásado al metodo (asume que la lista no esta vacia)
	public Nodo buscarLista(Object dato) {
		Nodo nodoActual = primero;
		while(!nodoActual.dato.equals(dato)) {
			if(nodoActual.siguiente == null) {
				return null;
			}else {
				nodoActual = nodoActual.siguiente;
			}
		}
		return nodoActual;
	}
	
	//Borra nodo que contiene el objeto data ingresado como parametro
	public Nodo eliminar(Object dato) {
		Nodo nodoActual = primero;
		Nodo nodoAnterior = primero;
		
		while(nodoActual.dato.equals(dato)) {
			if(nodoActual.siguiente == null) {
				return null;
			}else {
				nodoAnterior = nodoActual;
				nodoActual = nodoActual.siguiente;
			}
		}
		
		//Si encuentra nodo lo borra
		if(nodoActual == primero) {
			primero = primero.siguiente;
		}else {
			nodoAnterior.siguiente = nodoActual.siguiente;
		}
		
		return nodoActual;
	}
	
	//Inserta nodo con parametro valorNuevo despiues del nodo  que contiene el vlro del párametro valorExistente
	public Nodo insertar(Object valorExistente, Object valorNuevo) {
		Nodo nuevoNodo = new Nodo(valorNuevo);
		Nodo nodoActual = primero;
		
		while(!nodoActual.dato.equals(valorExistente)) {
			if(nodoActual.siguiente == null) {
				return null;
			}else {
				nodoActual = nodoActual.siguiente;
			}
		}
		
		nuevoNodo.siguiente = nodoActual.siguiente;
		nodoActual.siguiente = nuevoNodo;
		
		return nuevoNodo;
	}
}
