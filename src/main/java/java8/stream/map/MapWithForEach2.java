package java8.stream.map;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class MapWithForEach2 {

	public static void main(String[] args) {

		// notice mapToInt
		Stream.of("a1", "a2", "a3")
				.map(s -> s.substring(1))
				.mapToInt(Integer::parseInt)
				.max()				
				.ifPresent(System.out::println);

		// notice mapToObject
		IntStream.range(1, 4)
				.mapToObj(i -> "a" + i)
				.forEach(System.out::println);

	}

}
