package java8.test;


import java.util.Arrays;
import java.util.List;

import java8.models.Employee;
import java8.models.EmployeeGenerator;

public class EmployeeStreamOps {

	public static void main(String[] args) {
		// filter employees by name and age
		// sort employees
		// get a set of employee names
		// increase employee salary by 10%
		// partition employee by salary (above and below 100000)
		// group employees by names
		// Join employee names
		// create a map by age and employee names
		// create a map by age and employee objects

	}
	
	
	private static List<Employee> getEmployees() {
		
		List<Employee> employees = Arrays.asList(EmployeeGenerator.getEmployeeArray());
		
		
		return null;
	}

}
