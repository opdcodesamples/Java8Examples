package java8.models;

import java.text.DecimalFormat;
import java.util.Calendar;

public class Employee {
	
	private String name;
	private int age;
	private double salary;
	private Calendar joiningDate;
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public Employee() {
		
	}
	
	public Employee(String name, int age, double salary, Calendar joiningDate) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Calendar getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Calendar joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((joiningDate == null) ? 0 : joiningDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (joiningDate == null) {
			if (other.joiningDate != null)
				return false;
		} else if (!joiningDate.equals(other.joiningDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + df.format(salary) + ", joiningDate=" + joiningDate.getTime() + "]";
	}
	
	

}
