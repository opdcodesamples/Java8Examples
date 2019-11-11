package java8.concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ExecutorDemo1 {

	public ExecutorDemo1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
			
			try {
				TimeUnit.SECONDS.sleep(10);
				System.out.println("Task completed..");
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		});

		try {
			System.out.println("attempting to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(1, TimeUnit.SECONDS);
			System.out.println("after awaiting termination...");
			
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
