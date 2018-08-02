package java8.stream.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class ReduceDemo2 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sunil","Ramesh","Ganesh","Mahesh","Durgesh","Bhavesh","Gyanesh","Jignesh","Balu");
		System.out.println("\n list: " + names);
		
		Optional<String> reduced = names.stream().map(String::toUpperCase).sorted().reduce((s1,s2) -> s1 + "#" + s2);		
		System.out.println("\n reduced sorted list in upper case "); 
		reduced.ifPresent(System.out::println);
		
	}
}


