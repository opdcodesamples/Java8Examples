package java8.streamoperations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8.models.Employee;
import java8.models.Parent;
import java8.sorting.employee.EmployeeGenerator;

public class ConvertListOfOneTypeToAnother {

	public static void main(String[] args) {
		// Convert names to upper case
		Stream<Employee> employeeStream = Arrays.stream(EmployeeGenerator.getEmployeeArray());
		List<String> employees = employeeStream.filter(o-> o!=null).map((e) -> e.getName().toUpperCase()).collect(Collectors.toList());
		employees.forEach(System.out::println);
		System.out.println("\n\n\n");
		
		// Convert list of one type to another
		List<Employee> employeeList = Arrays.asList(EmployeeGenerator.getEmployeeArray());
		List<Parent> parentList = employeeList.stream().filter(o-> o!=null).map((e) -> {
			Parent p = new Parent();
			p.setName(e.getName());
			return p;
		}).collect(Collectors.toList());
		
		parentList.forEach(System.out::println);
		System.out.println("\n\n\n");
	}

}
