package java8.stream.parallel;

import java.util.concurrent.ForkJoinPool;

class ParallelStreamDemo2 {

	public ParallelStreamDemo2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 ForkJoinPool commonPool = ForkJoinPool.commonPool();
		 System.out.println(commonPool.getParallelism()); 

	}

}
