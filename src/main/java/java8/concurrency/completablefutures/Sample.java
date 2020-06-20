package java8.concurrency.completablefutures;

import java.util.concurrent.CompletableFuture;

public class Sample {

	public static int compute() {
		System.out.println("In compute() thread: " + Thread.currentThread());
		return 2;
	}
	
	public static CompletableFuture<Integer> create() {
		System.out.println("In create() thread: " + Thread.currentThread());
		return CompletableFuture.supplyAsync(() -> compute());
	}
	
	public static void printIt(int value) {
		System.out.println("In printIt() thread: " + Thread.currentThread());
		System.out.println("value: " + value);
	}
	
	public static void main(String[] args) {
		System.out.println("In main() thread: " + Thread.currentThread());
		create().thenAccept(data -> printIt(data));

	}

}
