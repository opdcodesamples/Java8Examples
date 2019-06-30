package java8.codility.tests;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {
	private static int solution(int[] A) {
		System.out.println("Ignoring below list...");

		List<Integer> listWithFullBlownComparator = Arrays.stream(A).boxed().sorted(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {				
				return o1 - o2;
			}			
		}).collect(Collectors.toList());
		
		/*
		 * Problem statement:
		 * When an array of primitives is given and some processing or analysis is required on that array..
		 * 
		 * 1) First convert the primitive array to a List. Also define how you want to sort the list elements
		 * 2) Arrays -> Stream -> Boxed -> Sorted -> Collect
		 * 
		 */
		
		List<Integer> list = Arrays.stream(A).boxed().sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());
		System.out.println("list: " + list);
		Set<Integer> set = new TreeSet<>(list);
		
		System.out.println("set: " + set);

		Integer reference = 1000001;
		Integer missing = 1000001;
		for (Integer i : set) {			
			
			if (reference == 1000001) {
				reference = i;
			} else {
				if (i == reference + 1) {
					reference = i;
				} else {
					missing = reference + 1;
					break;
				}
			}
			System.out.println("i: " + i + ", reference: " + reference);

		}
		
		// when missing hasn't changed, then the next value is after the last reference
		if (missing == 1000001) {
			missing = ++reference;
		}
		// if missing is less then 0 then return 1 as required by the program requirements.
		if (missing <= 0) {
			missing = 1;
		}
		return missing;
	}

	public static void main(String[] a) {
		//[1, 3, 6, 4, 1, 2] or [-3,-2]
		int[] testArray = new int[] {1, 3, 6, 4, 1, 2};
		int returnVal = solution(testArray);
		System.out.println("returnVal: " + returnVal);
	}
}
