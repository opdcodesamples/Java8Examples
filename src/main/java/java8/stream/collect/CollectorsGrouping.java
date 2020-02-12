package java8.stream.collect;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java8.models.Person;

class CollectorsGrouping {

	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(
				new Person("Max", 18), 
				new Person("Peter", 23), 
				new Person("Pamela", 23),
				new Person("David", 12));
		
		 List<Person> filtered =
				 persons
				 .stream()
				 .filter(p -> p.getFirstName().startsWith("P"))
				 .collect(Collectors.toList());
		 System.out.println("Filtering people by letter 'P'...");
		 System.out.println(filtered);
		 
		 // grouping by 
		 Map<Integer, List<Person>> personsByAge = persons
				 .stream()
				 .collect(Collectors.groupingBy(Person::getAge));
		 System.out.println("\n\nGrouping people by age...");
		 System.out.println(personsByAge);
		 
		 // averaging
		 Double averageAge = persons
				 .stream()
				 .collect(Collectors.averagingInt(Person::getAge));
		 System.out.println("\n\nAverage age: " + averageAge);
		 
		 
		 IntSummaryStatistics ageSummary =
				 persons
				 .stream()
				 .collect(Collectors.summarizingInt(Person::getAge));
		 System.out.println("\n\nSummarizing age: " + ageSummary);
		 
		 System.out.println("\n\nCreating a phrase.. " );
		 String phrase = persons
				 .stream()
				 .filter(p -> p.getAge() >= 18)
				 .map(p -> p.getFirstName())
				 .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
		 System.out.println(phrase);
		 
		 // mapping 
		 /* 
		  * 
		  * */
		 System.out.println("\n\nMapping people by age (using toMap).. " );
		 Map<Integer, String> map = persons
				 .stream()
				 .collect(Collectors.toMap(
				 p -> p.getAge(),
				 p -> p.getFirstName(),
				 (name1, name2) -> name1 + ";" + name2));
		 System.out.println(map); 
		 
		 
		 List<Person> persons2 = Arrays.asList(
					new Person("Max", 18), 
					new Person("Peter", 23), 
					new Person("Pamela", 23),
					new Person("David", 12));
		 
		 System.out.println("\n\nMapping people by age (using groupingBy).. " );
		 
		 Map<Integer, List<String>> map2 = persons2
				 .stream()
				 .collect(Collectors.groupingBy(Person::getAge, 
								 				Collectors.mapping(
								 						Person::getFirstName, 
								 						Collectors.toList())));
		 System.out.println(map2);

		
	}

}
