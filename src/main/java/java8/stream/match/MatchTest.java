package java8.stream.match;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

class MatchTest {

	public static void main(String[] args) {
		
		List<String> nameList = Arrays.asList("John","Albert","Osmand","Diamond","James","Peter","Desmond","Robert","Samuel");
		System.out.println("\n Unsorted list: " + nameList);
		
		boolean hasRequiredName = nameList.stream().anyMatch((s) -> s.equals("Desmond"));
		System.out.println("\n Name found: " + hasRequiredName);

		
		hasRequiredName = nameList.stream().anyMatch((s) -> s.equals("Jerry"));
		System.out.println("\n Name found: " + hasRequiredName);
		
		// similarly we have allMatch, noneMatch
		
		// searching a specific name within a list
		Optional<String> optional = nameList.stream().filter((s) -> s.equals("Osmand")).findAny();
		if(optional.isPresent()) {
			System.out.println("\n Stream has the name we searched: " + optional.get());
		}else {
			System.out.println("\n Stream doesn't have the name we searched: " );
		}
		
		String sentence = "Although he studied Agrucultural Engineering in his academics, Osmand honed the craft of software development. He challenged himself throughout his life and kept-on going.";
		
		// searching a specific name within a sentence from a list of names
		Optional<String> matchingName = nameList.stream().filter(sentence::contains).findAny();
		if(matchingName.isPresent()) {
			System.out.println("\n Sentence has at least one name from the list: " + matchingName.get());
		}else {
			System.out.println("\n Sentence doesn't have any name from the list.. " );
		}
		
		Consumer<String> consumer = MatchTest::printname;
		
		nameList.stream().filter(sentence::contains).findAny().ifPresent(consumer);

	}
	
	private static void printname(String name) {
		System.out.println("name is : " + name);
	}

}
