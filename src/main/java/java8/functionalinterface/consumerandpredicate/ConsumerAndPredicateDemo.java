package java8.functionalinterface.consumerandpredicate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import java8.models.Person;

public class ConsumerAndPredicateDemo {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("John", "Smith"), new Person("IG", "Nagrath"), new Person("Joseph", "Administer"),
				new Person("RS", "Khurmi"), new Person("Gorakh", "Prashad"), new Person("E", "Popov"),
				new Person("R", "Malvino"));
		
		// sort all elements		
		Collections.sort(people, (a,b) -> a.getFirstName().compareTo(b.getFirstName()));
		
		// use a predicate and consumer to print all persons in people
		performOperation(people, p -> true, p -> System.out.println(p) );
		
		System.out.println("\n\n");
		// use a predicate and consumer to print Only those persons who have their last names start with P
		performOperation(people, p -> p.getLastName().startsWith("P"), p -> System.out.println(p) );

	}

	private static void performOperation(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p : people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			}
		}
		
	}

}
