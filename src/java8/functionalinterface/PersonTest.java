package java8.functionalinterface;

class PersonTest {

	public static void main(String[] args) {
		// Old way of creating person through anonymous class
/*		PersonFactory<Person> personFactory = new PersonFactory<Person>() {
			
			public Person create(String firstName, String lastName) {				
				return new Person(firstName,lastName);
			}
			
		};*/
		
		// creating person through functional interface
		PersonFactory<Person> personFactory = Person::new;
		
		Person person = personFactory.create("Osmand", "Das");
		System.out.println("Person is: " + person.getFirstName());
	}

}
