package java8.stream.parallel;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamDemo3 {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
		
		Timeit.code(() -> System.out.println(
				// Regular Stream
				numbers.stream().filter(n -> n %2 ==0)
								.mapToInt(ParallelStreamDemo3::compute)
								.sum()
								
				));
		
		List<Integer>numbers2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
		
		Timeit.code(() -> System.out.println(
				// Parallel Stream
				numbers2.parallelStream().filter(n -> n %2 ==0)
								.mapToInt(ParallelStreamDemo3::compute)
								.sum()
								
				));
	}
	
	public static Integer compute(Integer integer) {
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		return integer * 2;
	}

}

class Timeit {
	public static void code(Runnable block) {
		long start = System.nanoTime();
		
		try {
			block.run();
		}
		finally {
			long end = System.nanoTime();
			System.out.println("Time taken in Seconds: " + (end -start)/1.0e9);
		}
	}
}