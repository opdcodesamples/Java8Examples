package java8.functionalinterface.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8.models.Employee;
import java8.sorting.employee.EmployeeGenerator;

public class UpdatingListElementsByConsumer {
	
	public static void main(String[] args) {
		
		List<Employee> employeees = Arrays.asList(EmployeeGenerator.getEmployeeArray());
		
		Stream<Employee> employeeStreamBefore = employeees.stream();
		// print each employee salary
		List<String> employeSalaryBefore = employeeStreamBefore.filter(e-> e!=null).map(e -> "In map operation " + e.getName() + "'s salary= " + e.getSalary()).collect(Collectors.toList());
		
		// notice that this statement will be printed first as termination operation is not yet invoked on stream
		System.out.println("\n\n\n Printing List"); 
		employeSalaryBefore.forEach(System.out::println);
		
		
		
		Consumer<Employee> consumer = (e) -> {
			e.setSalary(Math.round(e.getSalary() + e.getSalary() * .2));
			System.out.println("In Consumer Updated salary: " + e.getName() + " => " + e.getSalary());
		};
		
		
		
		
		Stream<Employee> employeeStreamAfter = employeees.stream();
		// print each employee salary
		
		System.out.println("\n\n\n Printing through Consumer");
		employeeStreamAfter.filter(e-> e!=null).forEach(consumer::accept);
		
		
		Function<Employee,Employee> increaseSalary = (e) ->  {
			
			e.setSalary(Math.round(e.getSalary() + e.getSalary() * .2));
			return e;
		};
		
		System.out.println("\n\n\n Printing after applying Function ");
		List<Employee> employeSalaryAfter = employeees.stream().filter(e-> e!=null).map(increaseSalary::apply).collect(Collectors.toList());
		employeSalaryAfter.forEach(System.out::println);
	}
	
	
}
