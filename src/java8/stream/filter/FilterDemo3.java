package java8.stream.filter;

import java.util.ArrayList;
import java.util.List;

class FilterDemo3 {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("alpha");
		names.add("beta");
		names.add("gamma");
		
		names.stream().forEach((name) -> {
			//showConsumer(() -> name); // compilation error
		});

	}
	
	public static void showConsumer(String name) {
		System.out.println(name);

	}	

}
