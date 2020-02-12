package java8.stream.reduce;

import java.awt.Color;
import java.util.function.Function;
import java.util.stream.Stream;


class Camera {
	
	private Function<Color,Color> filter;
	
	@SuppressWarnings("unchecked")
	public Camera(Function<Color,Color>... filters) {
		setFilters(filters);
	}
	
	@SuppressWarnings("unchecked")
	public void setFilters(Function<Color,Color>... filters) {
		filter = Stream.of(filters)
				//.reduce(color -> color, (filter1, filter2) -> filter1.andThen(filter2));
				// color -> color : Function.identity()
				// (filter1, filter2) -> filter1.andThen(filter2) : Function::andThen
				.reduce(Function.identity(), Function::andThen);
		
	}

	public Color snap(Color input) {
		return filter.apply(input);
	}
}

@SuppressWarnings("unchecked")
public class Sample {

	public static void printSnap(Camera camera) {
		System.out.println(camera.snap(new Color(125,125,125)));
	}
	
	public static void main(String[] args) {
		printSnap(new Camera());
		printSnap(new Camera(Color::brighter));
		printSnap(new Camera(Color::darker));
		printSnap(new Camera(Color::brighter, Color::darker));

	}

}

