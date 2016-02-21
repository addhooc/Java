package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Collection_1{
	


	public static void main(String[] args){
		
		Collection<String> box = new HashSet<>();
		
		
		Collection<String> books = Arrays.asList("Odisea", "Eneida", "Ilíada", "Amadís de Gaula");
		
		// Adding a single item in the collection
		Collection<String> owner = Collections.singleton("Martín");
		
		// Adding items in the box
		box.add("Don Qixote");
		box.addAll(books);
				
		int count = box.size();
		System.out.println("I have " +count+ " books");
		
		// Making a copy of the collection
		Collection<String> copy = new ArrayList<String>(box);
		
		// Loop on the collections
		//copy.forEach(System.out::println);
		
		box.forEach(System.out::println);
		
		// Remove all elements from the collection
		box.clear();
		
		// Restore collection from the copy we made
		box.addAll(copy);
		
		// Call toString()
		System.out.println("from box " + box);
		
		// Obtain an array of collection elements.
		// If the iterator guarantees an order, this array has the same order
		Object[] libros = box.toArray();
		for (Object o : libros) {
			System.out.println("from Object[] " + o);
		}
		
		// If we want the elements in a String[],
		// we must pass one in
		String[] nombres = box.toArray(new String[box.size()]);
		for (String s : nombres) {
			System.out.println("from nombres[] " + s);
			
		}
		
		
		
		
//---------------------------------------------------------------------------------------------------
		
		Collection<Integer> sales = Arrays.asList(12000, 23000, 34000, 45000, 56000);
		boolean money = sales.isEmpty();
				
		// Print the sales
		sales.forEach(System.out::println);
		
		// Print the sales > 20000
		sales.stream()
			.filter(x -> x > 20000)
			.forEach(System.out::println);

		
	}

}