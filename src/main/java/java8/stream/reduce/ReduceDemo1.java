package java8.stream.reduce;

import java.util.Arrays;
import java.util.List;

class ReduceDemo1 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("1","2","3","4");
		
		String result = names.stream().reduce("#", String::concat);
		
		System.out.println(result);
		

	}
	
		

}
