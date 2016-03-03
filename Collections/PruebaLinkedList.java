package colecciones;

import java.util.*;

public class PruebaLinkedList {

	public static void main(String[] args) {
		
		LinkedList<String> personas = new LinkedList<>();
		
		personas.add("Primero");
		personas.add("Segundo");
		personas.add("Tercero");
		personas.add("Cuarto");
		
		int cantidadEnLaLista1 = personas.size();
		System.out.println("Personas en la LinkedList: " + cantidadEnLaLista1 + "\n");
		
		// Recorremos los elementos
		personas.forEach(System.out::println);
		
		// agregar elemento en índice determinado
		personas.add(0, "Cero");
		
		int cantidadEnLaLista2 = personas.size();
		System.out.println("\n" + "Personas en la LinkedList: " + cantidadEnLaLista2 + "\n");
		
		System.out.println("Luego de agregar en el índice cero" + "\n");
		
		personas.forEach(System.out::println);
		System.out.println();
		
		// Instanciación de un ListIterator		
		ListIterator<String> iterador = personas.listIterator();
		
		/*
		 * Por defecto el iterador se encuentra en la primera posición -> "Cero"
		 * Utilizando iterador.next(), nos desplazamos al espacio comprendido entre
		 * el primer y el segundo elemento.
		 * Estando allí, agregamos otro elemento -> "Cero punto cinco"
		 */
		
		iterador.next();
		iterador.add("Cero punto cinco");
		
		System.out.println("Luego de agregar entre el índice cero y el uno" + "\n");
		
		int cantidadEnLaLista3 = personas.size();
		System.out.println("\n" + "Personas en la LinkedList: " + cantidadEnLaLista3 + "\n");
		
	
		for (String persona : personas) {
			System.out.println(persona);
			
		}
	

		
		

	}

}
