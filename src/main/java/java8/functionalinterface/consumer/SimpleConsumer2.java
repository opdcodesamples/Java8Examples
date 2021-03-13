package java8.functionalinterface.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class SimpleConsumer2 {

	public static void main(String[] args) {
		
		Consumer<String> consumer = (name) -> System.out.println(String.format("name is : %s", name));;		
		
		List<String> names = new ArrayList<>();
		
		names.add("alpha");
		names.add("beta");
		names.add("gamma");
		
		names.stream().forEach((n) -> consumer.accept(n)); 		

	}

}
