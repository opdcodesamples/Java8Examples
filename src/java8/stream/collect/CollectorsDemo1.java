package java8.stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class CollectorsDemo1 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		 String commaSeparatedNumbers = numbers.stream()
		     .map(Object::toString)
		     .collect(Collectors.joining(", "));
		
		System.out.println(commaSeparatedNumbers);
		

	}
	
		

}
