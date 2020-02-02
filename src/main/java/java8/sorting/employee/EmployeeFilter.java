package java8.sorting.employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeFilter {

	public static void main(String[] args) {
		String[] names = EmployeeGenerator.getStringArray();
		Stream<String> stream = Arrays.stream(names);
		stream.forEach(System.out::println);
		System.out.println("\n\n\n");
		
		names = EmployeeGenerator.getStringArray();
		String[] namescopy = new String[names.length + 2];
		String nullString = null;
		String emptyString = "";
		System.arraycopy(names, 0, namescopy, 0, names.length);
		namescopy[names.length] = nullString;
		namescopy[namescopy.length -1] = emptyString;
		
		List<String> namescopyList = Arrays.asList(namescopy);
		namescopyList.stream().forEach(name -> System.out.println("name: " + name));
		System.out.println("\n\n\n");
		namescopyList = namescopyList.stream().filter(name -> name != null && !"".equals(name.trim())).sorted((a,b) -> a.compareTo(b)).collect(Collectors.toList());
		namescopyList.stream().forEach(name -> System.out.println("name: " + name));
	}

}
