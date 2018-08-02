package java8.stream.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class FilterDemo2 {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("alpha");
		names.add("beta");
		names.add("gamma");
		
		Stream<String> namesStream = names.parallelStream();
		
		namesStream.filter(name -> {
			System.out.println("name is:: " + name);
			return false;
		}).forEach(name -> {});
		

	}
	
		

}
