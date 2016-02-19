package ejemplos;

import java.util.Arrays;
import java.util.List;

public class ForEach {
	

	public static void main(String[] args) {
		List<String> poets = 
				Arrays.asList("Vallejo", "Quevedo", "Darío", "Dante", "Baudelaire");
		// Recorremos la lista
		// Mostramos los elementos por pantalla
		poets.stream().forEach(System.out::println);
		
		System.out.println();
		
		// Buscamos a Vallejo
		// Recorremos la Lista
		// Si etá lo imprimimos por pantalla
		String singlePoet = "Vallejo";
		poets.stream()
			.filter(x -> x.equalsIgnoreCase(singlePoet))
			.forEach(System.out::println);;
		
//-------------------------------------------------------------------------------------
		
			List <Integer> sueldos = 
				Arrays.asList(12345, 54678, 2346, 74658, 66533, 28349, 50000, 23899);
		
		// Se extraen los sueldos que no caen en la franja: 28000 a 60000
		sueldos.stream() // Stream de datos...
			.filter(n -> !( (n < 60000) && (n > 28000) )) // ... filtrados por condicion <o método>
			.forEach(System.out::println); // Salida standar por consola.
		
		

	}

}
