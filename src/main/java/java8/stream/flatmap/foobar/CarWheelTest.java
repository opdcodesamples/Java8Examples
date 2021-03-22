package java8.stream.flatmap.foobar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class CarWheelTest {

	public CarWheelTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		List<Car> cars = new ArrayList<>();
		IntStream.range(1, 5).forEach(i -> cars.add(new Car("Car" + i)));

		// create wheels
		cars.forEach(car -> IntStream.range(1, 5).forEach(i -> car.wheels.add(new Wheel("Wheel Brand" + i + " <- " + car.name))));

		cars.stream().flatMap(car -> car.wheels.stream()).forEach(wheel -> System.out.println(wheel.wheelBrand));
	}

}
