package java8.streamoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java8.models.TechnologyGroup;

class TechGroupTest {

	public static void main(String[] args) {
		List<TechnologyGroup> techGroupList = new ArrayList<>();
		
		techGroupList.add(new TechnologyGroup("Java", Arrays.asList("Osmand","Daniel","Rob","Joe")));
		techGroupList.add(new TechnologyGroup(".Net", Arrays.asList("Nandan","Daniel","Rob","Joe","Sandeep")));
		techGroupList.add(new TechnologyGroup("Node", Arrays.asList("Osmand","Vineet")));
		techGroupList.add(new TechnologyGroup("Oracle", Arrays.asList("Osmand","Anuj","Prashant", "Amit")));
		
		
		List<String> technologyGroup = techGroupList.
				stream().
				map(TechnologyGroup::getTechMembers).
				flatMap(techmembers -> techmembers.stream()).
				distinct().
				sorted().
				collect(Collectors.toList());
		
		System.out.println(technologyGroup);
		
		Map<String, List<String>> identityMap = new HashMap<>();
		
		System.out.println(
				techGroupList
				.stream()
				.reduce(
						identityMap, 
						(accumulatorMap, tg ) -> accumulator(accumulatorMap, tg), 
						(toBeCombinedMap1,toBeCombinedMap2) -> combiner(toBeCombinedMap1, toBeCombinedMap2) 
						)
				);
		
		
		/*
		System.out.println(techGroupList.stream().reduce(
					identityMap, 
					(accumulatorMap, tg ) ->  
					tg.getTechMembers()
					.stream()
					.reduce( 
							accumulatorMap, 
							(map, name) ->  { return accumulatorMap.containsKey(name)? 
											accumulatorMap.get(name).add(tg.getTechName()) :  
											accumulatorMap.put(name, Arrays.asList(tg.getTechName())); })
							 , 
					(toBeCombinedMap1,toBeCombinedMap2) -> combiner(toBeCombinedMap1, toBeCombinedMap2) )
				);
		
		*/

	}
	
	public static Map<String, List<String>> accumulator(Map<String, List<String>> accumulatorMap, TechnologyGroup tg) {
		
		System.out.println("in accumulator ......... " + accumulatorMap);
		
		for(String name: tg.getTechMembers()) {
			if(accumulatorMap.containsKey(name)) {
				accumulatorMap.get(name).add(tg.getTechName());
			} else {
				List<String> technologies = new ArrayList<>();
				technologies.add(tg.getTechName());
				accumulatorMap.put(name,technologies);
			}
		}
		
		return accumulatorMap;
	}
	
	public static Map<String, List<String>> combiner(Map<String, List<String>> toBeCombinedMap1, Map<String, List<String>> toBeCombinedMap2) {
		return null;
	}

}
