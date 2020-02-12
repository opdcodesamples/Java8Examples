package java8.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
	private static int solution(int[] A) {
		
		//Ignoring below list
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
		
		Set<Integer> numberSet = Arrays.stream(A).boxed().sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toSet());
		
		System.out.println("numberSet: " + numberSet);

		Integer refNum = 1000001;
		Integer missing = 1000001;
		for (Integer number : numberSet) {			
			
			if (refNum == 1000001) {
				refNum = number;
			} else {
				if (number == refNum + 1) {
					refNum = number;
				} else {
					missing = refNum + 1;
					break;
				}
			}
			//System.out.println("number: " + number + ", refNum: " + refNum);

		}
		
		// when missing hasn't changed, then the next value is after the last reference
		if (missing == 1000001) {
			missing = ++refNum;
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
		System.out.println("Missing Number in set of Positive Numbers: " + returnVal);
		
		testArray = new int[] {-7, -8, -6, -4, -1, 2,-2};
		returnVal = solution(testArray);
		System.out.println("Missing Number in set of Positive and Negative Numbers: " + returnVal);
	}
}
