package java8.concurrency.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class Sample3 {

	public static ForkJoinPool fjp = new ForkJoinPool(10);
	
	public static void process(CompletableFuture<Integer> future) {
		
		System.out.println("In process() thread: " + Thread.currentThread());
		sleep(1000);
		
		future.
		exceptionally(throwable -> handle(throwable)).
		thenApply(data -> data * 2).
		thenAccept(System.out::println).
		thenRun(() -> {  runIt() ; } ).
		thenRun(() -> {  runIt() ; } );
	}
	
	public static int handle(Throwable t) {
		return 300;
	}
	
	public static void runIt() {
		sleep(1000);
		System.out.println("In runIt() thread: " + Thread.currentThread());
		System.out.println("Complete...");
	}
	
	public static void main(String[] args) {
		System.out.println("In main() thread: " + Thread.currentThread());
		
		// No Async Processing
		CompletableFuture<Integer> future = new CompletableFuture<>();
		process(future);
		
		//future.complete(45);
		future.completeExceptionally(new RuntimeException("Something went wrong.."));
		System.out.println("In main() thread complete..");
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
