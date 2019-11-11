package java8.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest {

	public static void main(String[] args) {
		String nullStr = null;
		String[] someStrArray = new String[] { "45", "32", "31.9", "1", "4", "6", "321", "123", nullStr };
		
		// this is not the right way of converting string to numbers
		List<String> strNumbers = Arrays.stream(someStrArray).filter(o -> o != null)
				.sorted(Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER))
				.collect(Collectors.toList());
		System.out.println("string numbers: " + strNumbers);
		
		
		class MyStringUtil {
			public String absValue(String string){
				if(string.contains(".")) {
					return string.substring(0, string.indexOf("."));
				} else {
					return string;
				}
				
			}
		}
		
		MyStringUtil myStringUtil = new MyStringUtil();
		
		// this is an acceptable way to convert string to integers
		List<Integer> intNumbers = Arrays.stream(someStrArray).filter(o -> o != null)
				.map(myStringUtil::absValue)
				.map(Integer::parseInt)
				.sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
		System.out.println("Int numbers: " + intNumbers);
		
		
	}
	
	

}

