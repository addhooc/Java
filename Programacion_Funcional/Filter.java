package ejemplos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

	public static void main(String[] args) {
		String[] input = {"Wittgenstein", "wittgenstein", "WITTGENSTEIN", "WiTtGeNsTeIn"};
		List<String> author = Arrays.asList(input);
		String search = "Wittgenstein";
		
		String philosopher = author.stream()
				.filter(x -> x.equalsIgnoreCase(search))
				.collect(Collectors.joining("\n"));
		
		System.out.println(philosopher);
		

	}

}
