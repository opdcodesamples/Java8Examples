package java8.test;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java8.models.Employee;
import java8.models.EmployeeGenerator;

public class EmployeeStreamOps {
	
	private static final String NEWLINE = "\n\n";

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(EmployeeGenerator.getEmployeeArray());
		System.out.println("All Employees in Collection: \n");
		for(Employee e : employees){
			System.out.println(e);
		}		
		
		// Employees Filtered by Name: John
		System.out.println(NEWLINE);
		System.out.println("Employees Filtered by Name: John"  );
		List<Employee> employeesByNameAndAge = 
				employees.stream()
						.filter(e -> e != null)	
						.filter(e -> "John".equals(e.getName()))
						.filter(e -> e.getAge() > 30)
						.collect(Collectors.toList());
		
		System.out.println(employeesByNameAndAge);
				
		// Employees Sorted by Names in descending order
		System.out.println(NEWLINE);
		System.out.println("Employees Sorted by Names in descending order"  );
		employees.stream()
				.filter(e -> e != null)	
				.sorted(Comparator.comparing(Employee::getName).reversed())
				.forEach(System.out::println);
		
		// Employees Sorted by Name in descending order AND Age in ascending order
		System.out.println(NEWLINE);
		System.out.println("Employees Sorted by Name in descending order AND Age in ascending order"  );
		employees.stream()
				.filter(e -> e != null)	
				.sorted(Comparator.comparing(Employee::getName).reversed()
						.thenComparing(Comparator.comparingInt(Employee::getAge)))
				.forEach(System.out::println);
		
		// Set of Employee Names in ascending order
		System.out.println(NEWLINE);
		System.out.println("Set of Employee Names in ascending order (broken) ???????????????"  );
		employees.stream()
				.filter(e -> e != null)	
				.map(Employee::getName)
				.sorted()
				.collect(Collectors.toSet())
				
				.forEach(System.out::println);
		
		// Employee Names in a single (Joining) String
				System.out.println(NEWLINE);
				System.out.println("Employee Names in a single (Joining) String"  );
				System.out.println(
							employees.stream()
									.filter(e -> e != null)	
									.map(Employee::getName)
									.sorted()
									.collect(Collectors.joining(", ", "Names are: ", ".")));
		
		// Employee Salary increased by 10%
		System.out.println(NEWLINE);
		System.out.println("Employee Salary increased by 10%"  );
		employees.stream()
				.filter(e -> e != null)	
				.map(e -> { e.setSalary(e.getSalary() * 1.1); return e;})
				.forEach(System.out::println);
		
		// Employee Partitioned by Salary (above and below 100000)
		System.out.println(NEWLINE);
		System.out.println("Employee Partitioned by Salary (above and below 100000)"  );
		Map<Boolean,List<Employee>> empMapBySal = 
				employees.stream()
						.filter(e -> e != null)	
						.collect(Collectors
								.partitioningBy(e -> e.getSalary() >= 100000));

		System.out.println(empMapBySal);
				
		// Employees Grouped by Names
		System.out.println(NEWLINE);
		System.out.println("Employees Grouped by Names"  );
		Map<String,List<Employee>> empMapByName = 
				employees.stream()
						.filter(e -> e != null)	
						.collect(Collectors
								.groupingBy(Employee::getName));
		System.out.println(empMapByName);
		
		
		// Employees Grouped by Names, capturing (Mapping) only Age
		System.out.println(NEWLINE);
		System.out.println("Employees Grouped by Names, capturing (Mapping) only Age"  );
		Map<String,List<Integer>> empNameMapByAge = 
				employees.stream()
						.filter(e -> e != null)	
						.collect(Collectors
								.groupingBy(Employee::getName,
											Collectors.mapping(Employee::getAge, Collectors.toList())
											));
		System.out.println(empNameMapByAge);
		
		
		// Map of Employee Age and Names
		System.out.println(NEWLINE);
		System.out.println("Map of Employee Age and Names"  );
		Map<Integer,String> empAgeMapByName = 
				employees.stream()
						.filter(e -> e != null)	
						.collect(Collectors.toMap(
											Employee::getAge,
											Employee::getName, 
											(e1,e2) -> e1 + ", " + e2
											)
								);
		
		System.out.println(empAgeMapByName);
		
		// create a map by age and employee objects

	}

}
