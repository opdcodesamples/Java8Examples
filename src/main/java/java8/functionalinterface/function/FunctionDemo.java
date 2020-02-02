package java8.functionalinterface.function;

import java.util.function.Function;

class FunctionDemo {

	public static void main(String[] args) {
		
		/* Function is an inbuilt Functional Interface which takes one parameter and return a value */
		
		Function<String,Integer> verifyLength = String::length;
		Function<Integer, Boolean> verifyCondition = (i) -> i < 10;
		Function<String, Boolean> function = verifyLength.andThen(verifyCondition);
		
		System.out.println("Ans is: " + function.apply("Java 8"));
		
		Function<String, Integer> convert = Integer::valueOf;
		Function<Integer, Boolean> check = (a) -> a >= 800;
		Function<String, Boolean> isGreaterThan900 = convert.andThen(check);
		System.out.println("is greater than 900: " + isGreaterThan900.apply("9000"));

	}

}
