package java8.stream.flatmap.foobar;

import java.util.ArrayList;
import java.util.List;

class Car {
	final String name;
	final List<Wheel> wheels = new ArrayList<>();

	Car(String name) {
		this.name = name;
	}
}
