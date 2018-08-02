package java8.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class ExecutorDemo2 {

	public ExecutorDemo2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(5);
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}

		};

		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);
		
		System.out.println("future done? " + future.isDone());
		Integer result = 0;
		try {
			//result = future.get();
			result = future.get(1, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}else {
				System.err.println("executor already finished execution...");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}
		System.out.print("result: " + result);

	}

}
