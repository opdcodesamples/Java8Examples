package java8.functionalinterface.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class SimpleConsumer2 {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("alpha");
		names.add("beta");
		names.add("gamma");
		
		names.stream().forEach((name) -> showConsumer( name, (n) -> { System.out.println(n); })); 
		names.stream().forEach((name) -> showConsumer( name, (n) -> { System.out.println( "this is " + n); })); 
		names.stream().forEach((name) -> showConsumer( name, (n) -> { System.out.println( n.toUpperCase()); })); 
		

	}
	
	public static void showConsumer(String name, Consumer<String> c) {
		c.accept(name);

	}	

}
