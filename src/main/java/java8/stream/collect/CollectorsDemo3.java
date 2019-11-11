package java8.stream.collect;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class CollectorsDemo3 {

	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(
				new Person("Max", 18), 
				new Person("Peter", 23), 
				new Person("Pamela", 23),
				new Person("David", 12));
		
		 List<Person> filtered =
				 persons
				 .stream()
				 .filter(p -> p.name.startsWith("P"))
				 .collect(Collectors.toList());
		 System.out.println("Filtering Person by letter 'P'...");
		 System.out.println(filtered);
		 
		 // grouping by 
		 Map<Integer, List<Person>> personsByAge = persons
				 .stream()
				 .collect(Collectors.groupingBy(p -> p.age));
		 System.out.println("Grouping by Person age...");
		 System.out.println(personsByAge);
		 
		 // averaging
		 Double averageAge = persons
				 .stream()
				 .collect(Collectors.averagingInt(p -> p.age));
		 System.out.println("Average: " + averageAge);
		 
		 
		 IntSummaryStatistics ageSummary =
				 persons
				 .stream()
				 .collect(Collectors.summarizingInt(p -> p.age));
		 System.out.println("Summary: " + ageSummary);
		 
		 System.out.println("Creating a phrase.. " );
		 String phrase = persons
				 .stream()
				 .filter(p -> p.age >= 18)
				 .map(p -> p.name)
				 .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
		 System.out.println(phrase);
		 
		 // mapping 
		 /* 
		  * 
		  * */
		 System.out.println("Mapping people.. " );
		 Map<Integer, String> map = persons
				 .stream()
				 .collect(Collectors.toMap(
				 p -> p.age,
				 p -> p.name,
				 (name1, name2) -> name1 + ";" + name2));
		 System.out.println(map);

		
	}

}
