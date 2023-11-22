package Lista;

import java.util.List;
import java.util.ArrayList;

public class Lista {

	public static void main(String[] args) {
		List<String> colors = new ArrayList<>();
		//.add permite ingresar datos a la lista
		colors.add("Amarillo");
		colors.add("Azul");

		System.out.println("Colores: "+colors);//Muestra todos los elementos de la lista
	}

}
