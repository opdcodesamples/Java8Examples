package java8.stream.flatmap.foobar;

import java.util.ArrayList;
import java.util.List;

class Foo {
	final String name;
	final List<Bar> bars = new ArrayList<>();

	Foo(String name) {
		this.name = name;
	}
}
