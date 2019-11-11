package java8.streamoperations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8.streamoperations.data.EmployeeGenerator;
import java8.streamoperations.models.Employee;

public class UpdatingListOfObjectsByUsingConsumer {
	
	public static void main(String[] args) {
		
		List<Employee> employeees = Arrays.asList(EmployeeGenerator.getEmployeeArray());
		
		Stream<Employee> employeeStreamBefore = employeees.stream();
		// print each employee salary
		List<String> employeSalaryBefore = employeeStreamBefore.filter(e-> e!=null).map(e -> e.getName() + "'s salary= " + e.getSalary()).collect(Collectors.toList());
		employeSalaryBefore.forEach(System.out::println);
		
		System.out.println("\n\n\n");
		
		Consumer<Employee> consumer = (e) -> {
			System.out.println("current salary: " + e.getName() + " => " + e.getSalary());
			e.setSalary(Math.round(e.getSalary() + e.getSalary() * .2));
		};
		
		Stream<Employee> employeeStreamAfter = employeees.stream();
		// print each employee salary
		employeeStreamAfter.filter(e-> e!=null).forEach(consumer::accept);
		System.out.println("\n\n\n");
		List<String> employeSalaryAfter = employeees.stream().filter(e-> e!=null).map(e -> e.getName() + "'s salary= " + e.getSalary()).collect(Collectors.toList());
		employeSalaryAfter.forEach(System.out::println);
	}
	
	private void increaseSalary(Employee e) {
		System.out.println("current salary: " + e.getName() + " => " + e.getSalary());
		e.setSalary(Math.round(e.getSalary() + e.getSalary() * .2));
	}
}
