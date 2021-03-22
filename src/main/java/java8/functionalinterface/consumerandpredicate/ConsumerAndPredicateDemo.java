package java8.functionalinterface.consumerandpredicate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java8.models.Person;

public class ConsumerAndPredicateDemo {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("John", "Smith"), 
				new Person("IG", "Nagrath"), 
				new Person("Joseph", "Administer"),
				new Person("RS", "Khurmi"), 
				new Person("Gorakh", "Prashad"), 
				new Person("E", "Popov"),
				new Person("R", "Malvino"));
		
		// sort all elements		
		Collections.sort(people, (a,b) -> a.getFirstName().compareTo(b.getFirstName()));
		
		// use a predicate and consumer to print all persons in people
		people.stream().forEach(p -> System.out.println(p) );
		
		System.out.println("\n\n");
		// use a predicate and consumer to print Only those persons who have their last names start with P
		people.stream().filter(p -> p.getLastName().startsWith("P")).forEach(p -> System.out.println(p) );
		
	}

}
