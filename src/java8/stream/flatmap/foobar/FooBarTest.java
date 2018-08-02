package java8.stream.flatmap.foobar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class FooBarTest {

	public FooBarTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		List<Foo> foos = new ArrayList<>();
		IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));

		// create bars
		foos.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

		foos.stream().flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));
	}

}
