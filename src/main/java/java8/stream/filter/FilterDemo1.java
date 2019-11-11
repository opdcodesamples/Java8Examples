package java8.stream.filter;

import java.util.stream.Stream;

class FilterDemo1 {

	public static void main(String[] args) {
		
		// This will not print anything..
		long count = Stream.of("Alpha","Beta", "Gamma").filter(name -> {
			System.out.println("name is : " + name);
			return true;
		}).count();
		
		System.out.println(count);

	}

}
