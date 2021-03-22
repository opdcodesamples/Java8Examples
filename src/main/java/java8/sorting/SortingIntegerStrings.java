package java8.sorting;

import java.util.Arrays;

public class SortingIntegerStrings {

	public static void main(String[] args) {
		String nullStr = null;
		String[] arrayOfIntAsStr = new String[] { "45", "32", "31", "1", "4", "6", "321", "123", nullStr };

		Arrays.asList(arrayOfIntAsStr)
							.stream()
							.filter(o -> o != null)
							.mapToInt(Integer::parseInt)
							.sorted()
							.forEach(System.out::println);

	}

}
