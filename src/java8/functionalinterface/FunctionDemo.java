package java8.functionalinterface;

import java.util.Arrays;
import java.util.function.Function;

class FunctionDemo {

	public static void main(String[] args) {
		Function<String,Integer> length = String::length;
		Function<Integer, Boolean> condition = (i) -> i < 10;
		Function<String, Boolean> function = length.andThen(condition);
		
		System.out.println("Ans is: " + function.apply("Java 8"));
		
		Function<String, Integer> convert = Integer::valueOf;
		Function<Integer, Boolean> check = (a) -> a >= 800;
		Function<String, Boolean> isGreaterThan900 = convert.andThen(check);
		System.out.println("is greater than 900: " + isGreaterThan900.apply("9000"));

	}

}
