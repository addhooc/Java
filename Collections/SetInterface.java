package collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetInterface {

	public static void main(String[] args) {
		SortedSet<String> set = new TreeSet<>(Arrays.asList(args));
		
		set.add("C");
		set.add("A");
		
		Collection<String> chords = Arrays.asList("D", "E", "F", "G", "B");
		Collection<String> sharpChords = Arrays.asList("C#", "D#", "E", "F#", "G#", "A#", "B");
		
		
		set.addAll(chords);
		set.addAll(sharpChords);
		
		set.forEach(System.out::println);
		
		//for (String data : set) {
			//System.out.println(data);
			
		//}

	}

}
