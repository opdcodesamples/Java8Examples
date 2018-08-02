package java8.functionalinterface;

interface PersonFactory<P extends Person> {
	
	P create(String firstName, String lastName);
}
