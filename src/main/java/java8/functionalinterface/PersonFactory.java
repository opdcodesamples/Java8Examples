package java8.functionalinterface;

interface PersonFactory<P extends Person> {
	// will return instance of type P
	P construct(String firstName, String lastName);
}
