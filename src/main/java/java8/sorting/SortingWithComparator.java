package java8.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8.models.Employee;
import java8.sorting.employee.EmployeeGenerator;

public class SortingWithComparator {

	public static void main(String[] args) {
		
		String[] names = EmployeeGenerator.getStringArray();
		// obtain a stream through Arrays
		Stream<String> stream = Arrays.stream(names);
		stream.sorted((n1,n2) -> n1.compareTo(n2)).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("\n\n\n");
		
		// sort objects
		Stream<Employee> employeeStream = Arrays.stream(EmployeeGenerator.getEmployeeArray());
		// sorting based on salary
		employeeStream.filter(o-> o!= null).sorted(Comparator.comparing(Employee::getSalary)).map(e -> e.getName() + " gets " + e.getSalary()).collect(Collectors.toList()).forEach(System.out::println);;
		System.out.println("\n\n\n");
		
		// filter objects based on salary
		employeeStream = Arrays.stream(EmployeeGenerator.getEmployeeArray());
		List<String> result = employeeStream.filter(o-> o!= null).filter(e -> (e.getSalary() > 90000 && e.getAge() > 30 && e.getAge() < 40)).sorted(Comparator.comparing(Employee::getSalary)).map(e -> e.getName() + " is just "  + e.getAge() + " years old but gets " + e.getSalary()).collect(Collectors.toList());
		result.stream().forEach(System.out::println);
		System.out.println("\n\n\n");
		
		// filter findAny orElse
		employeeStream = Arrays.stream(EmployeeGenerator.getEmployeeArray());
		Employee matchingEmployee = employeeStream.filter(o-> o!= null).filter(e -> (e.getSalary() > 90000 && e.getAge() > 30 && e.getAge() < 40)).findAny().orElse(null);
		System.out.println("We got the matching employee: " + matchingEmployee);
		System.out.println("\n\n\n");
		
		// filter map objects
		
		Map<String,Employee> employeeMap = EmployeeGenerator.getEmployeeMap();
		employeeMap.entrySet().stream().forEach((Map.Entry<String,Employee> k) -> System.out.println("MapKey: " + k.getKey() + "\n") );
	}

}
