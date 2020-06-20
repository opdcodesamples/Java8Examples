package java8.streamoperations;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import java8.models.Employee;
import java8.models.EmployeeGenerator;

public class ParallelStream {
	
	private static final String NEWLINE = "\n\n";

	public static void main(String[] args) {	
		
		System.out.println("No. of Processors: " + Runtime.getRuntime().availableProcessors());
		
		List<Employee> employees = Arrays.asList(EmployeeGenerator.getEmployeeArray());
		
		// Print Employees using Parallel stream
		System.out.println(NEWLINE);
		System.out.println("Print Employees using Parallel stream"  );
		employees.stream()
				.parallel()
				.filter(e -> e != null)
				.forEach(e -> printIt(e));
		
		
		// Adding Employee Ages plus my Age using Reduce in parallel stream (>>>>>>>> incorrect identity)
		int myAge = 25;
		System.out.println(NEWLINE);
		System.out.println("Adding Employee Ages plus my Age using Reduce in parallel stream (>>>>>>>> incorrect identity)"  );
		System.out.println(
		employees.stream()
				.parallel()
				.filter(e -> e != null)
				.map(e -> e.getAge())
				.reduce(myAge, (total, age) -> Integer.sum(total, age)));
		
		// Adding Employee Ages plus my Age using Reduce in parallel stream (correct identity)
		System.out.println(NEWLINE);
		System.out.println("Adding Employee Ages plus my Age using Reduce in parallel stream (correct identity)"  );
		System.out.println(
		employees.stream()
				.parallel()
				.filter(e -> e != null)
				.map(e -> e.getAge())
				.reduce(0, (total, age) -> Integer.sum(total, age)) + myAge);

	}
	
	public static void printIt(Employee e) {
		//sleep(2);
		System.out.println("In printIt.. " + Thread.currentThread());
		System.out.println(e);
	}
	
	private static boolean sleep(long time) {
		try {
			TimeUnit.SECONDS.sleep(time);
			return true;
			
		}catch (InterruptedException e) {
			return false;
		}
	}

}
