package java8.models;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class EmployeeGenerator {
	
	private static Employee[] employeeArray;
	
	static {		
		
		employeeArray = new Employee[] {
				new Employee("Ben",44, 90000, Calendar.getInstance()),
				new Employee("Richard",39, 130000, Calendar.getInstance()),
				new Employee("Richard",30, 120000, Calendar.getInstance()),
				new Employee("Mat",45, 125000, Calendar.getInstance()),
				new Employee("Larry",27, 65000, Calendar.getInstance()),
				new Employee("John",24, 75000, Calendar.getInstance()),
				new Employee("John",44, 73000, Calendar.getInstance()),
				new Employee("Jack",44, 90000, Calendar.getInstance()),
				new Employee("Toby",32, 140000, Calendar.getInstance()),
				new Employee("Jack",42, 120000, Calendar.getInstance()),
				new Employee("Toby",30, 120000, Calendar.getInstance()),
				null
				
		};
		
		for(Employee emp : employeeArray) {
			if(emp != null) {
				if("Noel".equals(emp.getName())) {
					emp.getJoiningDate().add(Calendar.MONTH, -9);
					
				}else if("Samuel".equals(emp.getName())) {
					emp.getJoiningDate().add(Calendar.MONTH, -30);
					
				}else if("Ankur".equals(emp.getName())) {
					emp.getJoiningDate().add(Calendar.MONTH, -34);
					
				}else if("Kalam".equals(emp.getName())) {
					emp.getJoiningDate().add(Calendar.MONTH, -18);
					
				}else if("Larry".equals(emp.getName())) {
					emp.getJoiningDate().add(Calendar.MONTH, -9);
					
				}else if("John".equals(emp.getName())) {
					emp.getJoiningDate().add(Calendar.MONTH, -9);
					
				}else if("India".equals(emp.getName())) {
					emp.getJoiningDate().add(Calendar.MONTH, -7);
					
				}else if("Chandra".equals(emp.getName())) {
					emp.getJoiningDate().add(Calendar.MONTH, -9);
					
				}else if("Samuel".equals(emp.getName())) {
					emp.getJoiningDate().add(Calendar.MONTH, -30);
					
				}else if("Talat".equals(emp.getName())) {
					emp.getJoiningDate().add(Calendar.MONTH, -35);
					
				}else if("Jag".equals(emp.getName())) {
					emp.getJoiningDate().add(Calendar.MONTH, -5);
					
				}
			}
		}
		
	}
	
	public static Employee[] getEmployeeArray() {
		return employeeArray;
	}
	
	public static Map<String,Employee> getEmployeeMap() {
		Map<String,Employee> employeeMap = new HashMap<String,Employee>();
		
		for(Employee emp : employeeArray) {
			if(emp != null) {
				employeeMap.put(emp.getName(), emp);
			}else {
				employeeMap.put(null, emp);
			}
		}
		return employeeMap;
	}
	
	public static String[] getStringArray() {
		String[] names = {"Samuel","Talat","Kalam","India","Larry","John","Ankur","Chandra","Noel","Jag"};
		return names;
	}

}
