package java8.functionalinterface.consumer;


import java.util.function.Consumer;

class SimpleConsumer1 {

	public static void main(String[] args) {
		
		SimpleConsumer1 consumerDemo = new SimpleConsumer1();
		Consumer<String> consumer = consumerDemo::showConsumer;		
		consumer.accept("alpha");
		consumer.accept("beta");
		consumer.accept("gamma");
	}
	
	
	
	private void showConsumer(String name) {
        System.out.println(String.format("name is : %s", name));
	}	

}
