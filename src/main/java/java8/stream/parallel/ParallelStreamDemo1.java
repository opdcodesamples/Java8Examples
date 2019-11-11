package java8.stream.parallel;

import java.util.Arrays;

class ParallelStreamDemo1 {

	public ParallelStreamDemo1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Arrays.asList("a1", "a2", "b1", "c2", "c1").
		parallelStream().
		filter(s -> {
			System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
			return true;
		}).
		map(s -> {
			System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
			return s.toUpperCase();
		}).
		forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));

	}

}
