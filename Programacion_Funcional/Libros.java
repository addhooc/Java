package ejemplos;

import java.util.Arrays;
import java.util.List;

public class Libros {

	public static void main(String[] args) {
		
		// Una lista de Strings		
		List <String> biblioteca = Arrays.asList("Gravity's Rainbow", 
												"V.",
												"Europa",
												"Moby Dick",
												"Rayuela");
						
		boolean disponible = biblioteca.contains("Gravity's Rainbow");
		
		if (disponible) {
			System.out.println("El libro " +biblioteca.get(4)+ " está disponible");
		}
		else{
			System.out.println("Libro no disponible.");
		}
	
	}

}
