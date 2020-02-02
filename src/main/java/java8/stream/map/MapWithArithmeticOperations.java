package java8.stream.map;

import java.util.Arrays;
import java.util.List;

public class MapWithArithmeticOperations {
	
	public static void main(String[] a) {
		
		// find the sum of double of even numbers in a given list
		
		List<Integer> numbers = Arrays.asList(2,4,5,7,12,99,13,43,88,1,9,41,87);
		
		Integer sum = numbers.stream()
		.filter(n -> n % 2 ==0)
		.map(n -> n * 2)
		.mapToInt(Integer::valueOf)
		.sum();
		
		System.out.println("Sum: " + sum);
			
		
	}

}
