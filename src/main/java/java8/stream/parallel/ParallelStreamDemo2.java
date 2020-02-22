package java8.stream.parallel;

import java.util.concurrent.ForkJoinPool;

class ParallelStreamDemo2 {

	public ParallelStreamDemo2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		System.out.println("No. of Processors: " + Runtime.getRuntime().availableProcessors());
		
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println("Parallel threads: " + commonPool.getParallelism()); 
		System.out.println("Note that main thread (which is not dedicated in parallelism) can also join parallel processing when it's available\nSo effectively we have " + (commonPool.getParallelism() + 1) + " threads to work with"); 

	}

}
