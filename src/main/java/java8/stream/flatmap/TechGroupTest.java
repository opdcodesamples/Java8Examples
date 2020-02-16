package java8.stream.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
		
		//foos.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

		//foos.stream().flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));
		
		techGroupList.forEach(tg -> IntStream.range(0, tg.getTechMembers().size())
				.forEach(i -> System.out.println(tg.getTechName() + " - tech member: " + tg.getTechMembers().get(i))));
		
		//techGroupList.stream().map(tg -> tg.getTechMembers().stream().iterator(). );
		
		
		
		 
		System.out.println("Technology Group: " + technologyGroup); 
		//System.out.println("Technology Group: " + technologyGroup1); 

	}

}
