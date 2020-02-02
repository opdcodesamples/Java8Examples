package java8.functionalinterface;

import java8.models.Person;

@FunctionalInterface
interface PersonFactory<P extends Person> {
	// will return instance of type P
	P construct(String firstName, String lastName);
}
