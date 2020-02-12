package java8.stream.reduce;

import java.util.Arrays;
import java.util.List;

class ReduceDemo1 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("1","2","3","4");
		
		String result = names.stream().reduce("Here is the String: ", String::concat);
		
		System.out.println(result);
		
		// adding integers by using reduce
		List<Integer> numberList1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
		Integer sum = numberList1.stream().reduce(0,(a,b) -> Integer.sum(a, b));
		System.out.println("Sum: " + sum);
		
		// adding integers by using method reference
		List<Integer> numberList2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
		Integer sum2 = numberList2.stream().reduce(0,Integer::sum);
		System.out.println("Sum2: " + sum2);
		
		// adding integers by converting stream to integer stream
		List<Integer> numberList3 = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
		Integer sum3 = numberList3.stream().mapToInt(a -> a).sum();
		System.out.println("Sum3: " + sum3);
		

	}
	
		

}
