package java8.stream.map;

import java.util.stream.Stream;

class MapWithStrOperations {

	public static void main(String[] args) {

		System.out.println(
				"Notice that as soon as anyMatch get a matching value the processing of rest\n of the values stops..");

		Boolean hasMatch = Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch: " + s);
			return s.startsWith("A");
		});

		System.out.println("hasMatch: " + hasMatch);

		System.out.println("\n\nImportance of sequencing intermediate operations.....");
		System.out.println("\n map() before filter() \n...");

		Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("A");
		}).forEach(s -> System.out.println("forEach: " + s));

		System.out.println(
				"\n\nNotice that order of intermediate operations is very important. In below\n example the number of console outputs have reduced substantially");

		System.out.println("\n\n map() after filter() \n...");

		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("a");
		}).map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("forEach: " + s));

		System.out.println("\n\nSorting operations .....");
		System.out.println("\nSort() followed by filter() and map() leads to higher number of processing steps .....");

		Stream.of("d2", "a2", "b1", "b3", "c").sorted((s1, s2) -> {
			System.out.printf("sort: %s; %s\n", s1, s2);
			return s1.compareTo(s2);
		}).filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("a");
		}).map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("forEach: " + s));

		System.out.println("\nfilter() followed by sort() and map() leads to lower number of processing steps .....");

		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("a");
		}).sorted((s1, s2) -> {
			System.out.printf("sort: %s; %s\n", s1, s2);
			return s1.compareTo(s2);
		}).map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("forEach: " + s));
	}

}
