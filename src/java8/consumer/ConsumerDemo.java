package java8.consumer;


import java.util.function.Consumer;

class ConsumerDemo {

	public static void main(String[] args) {

		Consumer<String> consumer = ConsumerDemo::showConsumer;
		
		consumer.accept("alpha");
		consumer.accept("beta");
		consumer.accept("gamma");

	}
	
	private static void showConsumer(String name) {
        System.out.println(String.format("name is : %s", name));

	}	

}
