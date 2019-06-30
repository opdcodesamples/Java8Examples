package java8.streamoperations;

import java.util.Arrays;
import java.util.OptionalDouble;

public class CalculateMovingAverage {

	public static void main(String[] args) {
		double[] studentMarks = new double[] {78.99,89.89,43.32,65.99,88.33,78.23,56.23,43.55,99.34,34.44,89.33,100,91.33,77.22,44.89,22.78};
		System.out.println("No. of elements: " + studentMarks.length);
		int skipCount = 0;
		for(int i=0;  studentMarks.length - i >= 10 ; ++i) {
			OptionalDouble optional = Arrays.stream(studentMarks).skip(skipCount++).limit(10).boxed().mapToDouble(o->o).average();
			if(optional.isPresent()) {
				System.out.println(i + ") Average: "  + optional.getAsDouble());
			}
		}

	}

}
