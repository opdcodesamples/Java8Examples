package java8.stream.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CollectorsToList {

	public static void main(String[] args) {
		// Stream.of(1,2,3) is same as Arrays.asList(1,2,3).stream

		List<Integer> numberList =
				Stream.of(10, 40, 20, 60, 80, 0, 80, 30, 40).
				filter(value -> value > 18).
				sorted().
				sequential().
				map(Integer::new).
				distinct().
				collect(Collectors.toCollection(ArrayList::new));
		
		
		List<Integer> numberListTwo =
				Stream.of(10, 40, 20, 60, 80, 0, 80, 30, 40).
				filter(value -> value > 18).
				sorted().
				sequential().
				map(Integer::new).
				distinct().
				collect(Collectors.toList());
		
		System.out.println("numberList: " + numberList.toString());
		System.out.println("" + numberListTwo.toString());

	}

}
