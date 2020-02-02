package java8.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortingTest {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sunil","Ramesh","Ganesh","Mahesh","Durgesh","Bhavesh","Gyanesh","Jignesh","Balu");
		System.out.println("Unsorted list: " + names);
		
		// with type declaration
		names.sort(String::compareTo);
		System.out.println("Sorted list: " + names);
		
		// without type declaration
		List<String> names2 = Arrays.asList("Garima","Ruchi","Prabha","Ekta","Prachi","Arti","Bharti","Nisha","Tina");
		System.out.println("Unsorted list: " + names2);
		
		names2.sort(Comparator.reverseOrder());
		System.out.println("Sorted list: " + names2);
		
	}

}
