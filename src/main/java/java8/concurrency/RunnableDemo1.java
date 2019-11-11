package java8.concurrency;

import java.util.concurrent.TimeUnit;

class RunnableDemo1 {

	public RunnableDemo1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Runnable runnable = () -> {
			try {
				String name = Thread.currentThread().getName();
				System.out.println("Foo " + name);
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Bar " + name);
			}

			catch (InterruptedException e) {
				e.printStackTrace();
			}

		};
		Thread thread = new Thread(runnable);
		thread.start();

	}

}
