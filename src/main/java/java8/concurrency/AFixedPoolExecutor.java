package java8.concurrency;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class AFixedPoolExecutor {

	public AFixedPoolExecutor() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Callable<Integer> task = () -> {
			try {
				String threadName = Thread.currentThread().getName();
				System.out.println("This is Thread#2 " + threadName);
				TimeUnit.SECONDS.sleep(10);
				System.out.println("Thread#2 has completed Task");
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("Thread#2 interrupted", e);
			}

		};

		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);
		
		while (!future.isDone()) {
			System.out.println("Thread#2 still in progress..");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		try {
			//result = future.get();
			Integer result = future.get(1, TimeUnit.SECONDS);
			System.out.println("Thread#2 result: " + result);
			
			executor.shutdown();
			executor.awaitTermination(15, TimeUnit.SECONDS);
			System.out.println("After awaiting termination...");
			
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			
			e.printStackTrace();
		}
		finally {
			if (!executor.isTerminated()) {
				System.err.println("Couldn't terminate as there are unfinished tasks");
			}else {
				System.err.println("Executor successfully finished execution...");
			}
			List<Runnable> awaitingExecTasks = executor.shutdownNow();
			System.out.println("awaitingExecTasks: " + awaitingExecTasks);
			System.out.println("shutdown finished");
		}
		

	}

}
