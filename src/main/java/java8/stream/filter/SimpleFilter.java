package java8.stream.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class SimpleFilter {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("alpha");
		names.add("beta");
		names.add("gamma");
		
		Stream<String> namesStream = names.parallelStream();
		
		System.out.println("Filter Returning false");
		namesStream.filter(name -> false).forEach(System.out::println);
		
		namesStream = names.parallelStream();
		System.out.println("Filter Returning true");
		namesStream.filter(name -> true).forEach(System.out::println);
		

	}
	
		

}
