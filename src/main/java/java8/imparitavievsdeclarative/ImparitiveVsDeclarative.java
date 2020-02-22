package java8.imparitavievsdeclarative;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class ImparitiveVsDeclarative {
	
	static int count = 0;
	
	public static void main(String[] args) {
		
		// find the double of first even number greater than 5 an print it
		
		List<Integer> numbers = Arrays.asList(3,1,7,2,5,8,9,10,21,22,54,4);
		
		// imperative style
		int result = 0;
		
		for(Integer i : numbers) {
			count++;
			if(i %2 == 0 ) {
				count++;
				if( i > 5) {
					count++;
					result = i += i;					
					break;
				}
			}
		}
		
		System.out.println(String.format("result: %s, count: %s", result, count));
		
		
		count = 0;
		
		Optional<Integer> resultOptional = numbers.stream()
		.filter(n -> isEven(n, num -> num % 2 == 0))
		.filter(n -> isGT5(n, num -> num > 5))		
		.map(n -> returnDouble(n, num -> num * 2))
		.findFirst();
		
		
		
		if(resultOptional.isPresent()) {
			System.out.println(String.format("result: %s, count: %s", resultOptional.get(), count));
		}
		
 
	}
	
	public static Boolean isGT5( Integer num, Predicate<Integer> p) {
		count++;
		return p.test(num);
	}
	
	public static Boolean isEven( Integer num, Predicate<Integer> p) {
		count++;
		return p.test(num);
	}
	
	public static Integer returnDouble( Integer num, Function<Integer,Integer> f) {
		count++;
		return f.apply(num);
	}

}
