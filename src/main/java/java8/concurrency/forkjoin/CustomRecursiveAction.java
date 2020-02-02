package java8.concurrency.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

public class CustomRecursiveAction extends RecursiveAction {

	
	private static final long serialVersionUID = 1L;
	private String workload =  "";
	private static final int THRESHOLD = 4;
	
	private static Logger logger = Logger.getAnonymousLogger();
	
	public CustomRecursiveAction(String workload) {
		this.workload = workload;
	}
	
	private List<CustomRecursiveAction> createSubtasks() {
		List<CustomRecursiveAction> subtasks = new ArrayList<>();
		
		String subTaskOne = workload.substring(0, workload.length()/2);
		String subTaskTwo = workload.substring(workload.length()/2);
		
		System.out.println("subTaskOne: " + subTaskOne);
		System.out.println("subTaskTwo: " + subTaskTwo);
		
		subtasks.add(new CustomRecursiveAction(subTaskOne));
		subtasks.add(new CustomRecursiveAction(subTaskTwo));
		
		return subtasks;
		
	}
	
	@Override
	protected void compute() {
		
		if(workload.length() > THRESHOLD) {
			ForkJoinTask.invokeAll(createSubtasks());
		} else {
			process(workload);
		}
	}
	
	private void process(String workload) {
		String result = workload.toUpperCase();
		
		logger.info("this result (" + result + ") was processed by " + Thread.currentThread().getName());
	}

}
