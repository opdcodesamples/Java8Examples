package java8.functionalinterface.predicate;

import java.util.function.Predicate;

class SimplePredicate {

	public static void main(String[] args) {
		Predicate<String> predicate = (someValue) -> someValue.length() > 0;
		String someVal = "Osmand Prashant Das";
		Boolean isTrue = predicate.test(someVal);
		System.out.println("Predicate is True: " + isTrue);
	}

}
