package colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

import org.omg.CORBA.TCKind;

public class PruebaLinkedList2 {

	public static void main(String[] args) {
		
		LinkedList<String> paises =  new LinkedList<String>();
		
		paises.add("España");
		paises.add("México");
		paises.add("Uruguay");
		paises.add("Perú");
		
		LinkedList<String> capitales =  new LinkedList<String>();
		
		capitales.add("Madrid");
		capitales.add("D.F.");
		capitales.add("Montevideo");
		capitales.add("Lima");
		
//		System.out.println(paises);
//		paises.forEach(System.out::println);
//		System.out.println();
//		System.out.println(capitales);
//		capitales.forEach(System.out::println);
		
		ListIterator<String> itPaises = paises.listIterator();
		ListIterator<String> itCapitales = capitales.listIterator();
		
		// Pildoras Informáticas
		while(itCapitales.hasNext()){
			if(itPaises.hasNext()){
				itPaises.next();
			}
			itPaises.add(itCapitales.next());			
		}
		
		System.out.println(paises);
		
		// Yo XD
		while(itPaises.hasNext()){
			itPaises.next();
			while(itCapitales.hasNext()){
				itPaises.add(itCapitales.next());
			}
		}
		
		System.out.println("Paises + Capitales -> " + paises);
		
		//paises.removeAll(capitales);
		
		//System.out.println("Paises - Capitales -> " + paises);
		
		/*
		 * Los iteradores han quedado en su posición final
		 * Para regrearlos al inicio, es preciso inicializarlos de nuevo
		 * como vemos a continuación:
		 */
		
		//itCapitales = capitales.listIterator();
		
		while(itCapitales.hasNext()){
			itCapitales.next();
			if(itCapitales.hasNext()){
				itCapitales.next();
				itCapitales.remove();
			}
		
		}
		
		System.out.println("Luego de eleiminar las Capitales pares, " + capitales + "\n");
		
		// Ahora de la lista Paises extraeremos la lista Capitales
		paises.removeAll(capitales);
		paises.forEach(System.out::println);
		
	}

}
