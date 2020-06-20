package java8.concurrency.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class Sample2 {

	public static ForkJoinPool fjp = new ForkJoinPool(10);
	
	public static int compute() {
		System.out.println("In compute() thread: " + Thread.currentThread());
		return 2;
	}
	
	public static CompletableFuture<Integer> create() {
		System.out.println("In create() thread: " + Thread.currentThread());
		return CompletableFuture.supplyAsync(() -> compute(), fjp);
	}
	
	public static void printIt(int value) {
		System.out.println("In printIt() thread: " + Thread.currentThread());
		System.out.println("value: " + value);
	}
	
	public static void main(String[] args) {
		System.out.println("In main() thread: " + Thread.currentThread());
		
		CompletableFuture<Integer> future = create();
		sleep(2000);
		
		future.
		thenApply(data -> data * 2).
		thenApply(data -> data + 12).
		thenAccept(data -> printIt(data)).
		
		thenRun(() -> System.out.println("All done..")).
		thenRun(() -> System.out.println("Not really..")).
		thenRun(() -> System.out.println("still more.."));
		;
		
		sleep(1000);

	}
	
	private static boolean sleep(long time) {
		try {
			Thread.sleep(time);
			return true;
		} catch (InterruptedException e) {
			return false;
		}
	}

}
