package java8.stream.map;

import java.util.Arrays;
import java.util.List;

class MapDemo1 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sunil","Ramesh","Ganesh","Mahesh","Durgesh","Bhavesh","Gyanesh","Jignesh","Balu");
		System.out.println("\n Unsorted list: " + names);
		
		System.out.println("\n sorted list in upper case"); 
		names.stream().map(String::toUpperCase).sorted(String::compareTo).forEach(System.out::println);

	}

}
