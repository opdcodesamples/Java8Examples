package java8.functionalinterface;

import java.util.function.Function;

class FunctionDemo {

	public static void main(String[] args) {
		Function<String,Integer> length = String::length;
		Function<Integer, Boolean> condition = (i) -> i < 10;
		Function<String, Boolean> function = length.andThen(condition);
		
		System.out.println("Ans is: " + function.apply("Java 8"));

	}

}
