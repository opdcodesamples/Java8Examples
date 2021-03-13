package java8.concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ASingleThreadExecutor {

	public ASingleThreadExecutor() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		String mainThread = Thread.currentThread().getName();
		System.out.println("This is Thread#1 " + mainThread);
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			
			String threadName = Thread.currentThread().getName();
			System.out.println("This is Thread#2 " + threadName);
			
			try {
				TimeUnit.SECONDS.sleep(10);
				System.out.println("Thread#2 has completed Task");
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("Thread#2 interrupted", e);
			}
		});

		try {
			System.out.println("Attempting to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(15, TimeUnit.SECONDS);
			System.out.println("After awaiting termination...");
			
		} catch (Exception e) {
			System.err.println("tasks interrupted");
			
		} finally {
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
