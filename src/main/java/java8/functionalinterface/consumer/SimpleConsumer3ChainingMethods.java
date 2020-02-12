package java8.functionalinterface.consumer;

import java.util.function.Consumer;

class SomeResource {
	
	public SomeResource performActionOne() {		
		System.out.println("performing action: 1");
		return this;
	}
	
	public SomeResource performActionTwo() {		
		System.out.println("performing action: 2");
		return this;
	}
	
	public SomeResource performActionThree() {		
		System.out.println("performing action: 3");
		return this;
	}
	
	private void closeResource() {		
		System.out.println("closing resource");		
	}
	
	
	public static void performAllActions(Consumer<SomeResource> consumer) {
		System.out.println("Processing Resource...");
		
		SomeResource resource  = new SomeResource();
		try {
			consumer.accept(resource);
		}finally {
			resource.closeResource();
		}
		
		
	}
	

}


public class SimpleConsumer3ChainingMethods {
	
	public static void main (String[] args) {
		System.out.println("Start ...");
		SomeResource.performAllActions(a -> a.performActionOne()
											.performActionTwo()
											.performActionThree());
	}

}
