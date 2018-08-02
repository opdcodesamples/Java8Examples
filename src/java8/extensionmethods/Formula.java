package java8.extensionmethods;

interface Formula {
	double calculate(int a);
	
	// Note: default methods are allowed only in interfaces..
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
