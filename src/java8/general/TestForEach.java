package java8.general;

import java.util.ArrayList;
import java.util.List;

class TestForEach {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("alpha");
		names.add("beta");
		names.add("gamma");
		
		names.forEach(System.out::println);
		

	}

}
