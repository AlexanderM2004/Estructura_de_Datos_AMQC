package Lista;

/*
 * Autor Alexander Quizhpe
 */


public class Nodo {
	public Object dato; //Referencia campo dato
	public Nodo siguiente; //Referencia al siguiente nodo de la lista
	
	public Nodo(Object d) {
		dato = d; //Guarda dato del nodo
		siguiente = null; //Apunta a null
	}
	
	//Imprime el valor del campo dato
	public void mostrarNodo() {
		System.out.println("{"+ dato+"}");
	}
}
