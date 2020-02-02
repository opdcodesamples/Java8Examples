package java8.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo {
	
	public static void main(String[] a) {
		CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("abcdefghijklmnopqrstuvwxyz");
		
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		forkJoinPool.execute(customRecursiveAction);
	}

}
