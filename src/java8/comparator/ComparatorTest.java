package java8.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest {

	public static void main(String[] args) {
		String nullStr = null;
		String[] someStrArray = new String[] {"45", "32", "31", "1","4", "6","321", "123",nullStr};
		
		List<String> strNumbers = Arrays.stream(someStrArray).filter(o -> o != null).sorted(Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER)).collect(Collectors.toList());
		System.out.println("string numbers: " + strNumbers);
	}

}
