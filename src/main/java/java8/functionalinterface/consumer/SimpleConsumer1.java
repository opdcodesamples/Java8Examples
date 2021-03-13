package java8.functionalinterface.consumer;


import java.util.function.Consumer;

class SimpleConsumer1 {

	public static void main(String[] args) {		

		Consumer<String> consumer = (name) -> System.out.println(String.format("name is : %s", name));;		
		consumer.accept("alpha");
		consumer.accept("beta");
		consumer.accept("gamma");
		
		System.out.println("Not so clean way of doing it..");
		// below is also correct but is not as clean as above
		SimpleConsumer1 consumerDemo = new SimpleConsumer1();
		Consumer<String> consumer2 = consumerDemo::showConsumer;
		consumer2.accept("alpha");
		consumer2.accept("beta");
		consumer2.accept("gamma");
	}

	
	private void showConsumer(String name) {
        System.out.println(String.format("name is : %s", name));
	}	
}
