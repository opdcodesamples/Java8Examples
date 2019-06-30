package java8.consumer;


import java.util.function.Consumer;

class ConsumerDemo {

	public static void main(String[] args) {
		
		ConsumerDemo consumerDemo = new ConsumerDemo();
		Consumer<String> consumer = consumerDemo::showConsumer;		
		consumer.accept("alpha");
		consumer.accept("beta");
		consumer.accept("gamma");
	}
	
	
	
	private void showConsumer(String name) {
        System.out.println(String.format("name is : %s", name));
	}	

}
