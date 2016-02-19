package ejemplos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Map {

	public static void main(String[] args) {
		
		String [] input = {"Pascal", "Python", "Java", "C++", "C", "Haskell", "Lisp"};
		List<String> languages = Arrays.asList(input);
		List<Integer> langLength = languages.stream()
				.map(String::length)
				.collect(Collectors.toList());
		
				
		for (Integer i : langLength) {
			System.out.println(i);
		}
		

	}

}
