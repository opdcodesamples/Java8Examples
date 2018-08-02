package java8.stream.aggregation;

import java.util.Arrays;
import java.util.OptionalDouble;

class MovingAverageDemo {

	public MovingAverageDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] numbers = new int[] {20,22,24,25,23,26,28,26,29,27,28,30,27,29,28};
		
		OptionalDouble average = Arrays.stream(numbers).boxed().limit(10).mapToInt((a) -> a).average();
		
		OptionalDouble average2 = Arrays.stream(numbers).boxed().limit(10).mapToInt(Integer::new).average();
		
		
		if(average.isPresent()) {
			double startingAvg =  average.getAsDouble();
			System.out.println("Average of first 10: " + startingAvg);
			int skipCount = 1;
			for(int i = 10; i <numbers.length; ++ i) {
				OptionalDouble averageMoving = Arrays.stream(numbers).boxed().skip(skipCount++).limit(10).mapToInt((a) -> a).average();
				if(averageMoving.isPresent()) {
					double movingAvg =  averageMoving.getAsDouble();
					System.out.println("Moving Average of next 10: " + movingAvg);
				}
			}
		}
		

	}

}
