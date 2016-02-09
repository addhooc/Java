package ejemplos;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class Lambdas {
	
	static boolean esPar(Integer n){
		return n % 2 == 0;
	}

	public static void main(String[] args) {
		
		List <Integer> lista1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		
		List <Integer> caja1 = new ArrayList<Integer>();
				
		caja1 = lista1.stream()  // Iteracion de elementos
				.filter(Lambdas::esPar) // Filtrados por el método booleano esPar
				.collect(Collectors.toList()); // Coleccionados en una lista
		
		System.out.println("Filter --> "+ caja1.toString());
		
		//-----------------------------------------------------------------------
		
		// Lambda
		
		List <Integer> lista2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		
		List <Integer> caja2 = new ArrayList<Integer>();

		caja2 = lista2.stream()  // Iteracion de elementos
				.filter(n -> n%2 == 0) // Filtrados por una funcion cuyo resultado debe ser booleano
				.collect(Collectors.toList()); // Coleccionados en una lista
		
		System.out.println("Lambda --> " + caja2.toString());
		
		

	}

}
