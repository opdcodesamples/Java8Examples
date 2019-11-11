package java8.stream.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class TechGroupTest {

	public static void main(String[] args) {
		List<TechnologyGroup> techGroupList = new ArrayList<>();
		
		techGroupList.add(new TechnologyGroup("Java", new String[]{"Osmand","Daniel","Rob","Joe"}));
		techGroupList.add(new TechnologyGroup(".Net", new String[]{"Nandan","Daniel","Rob","Joe","Sandeep"}));
		techGroupList.add(new TechnologyGroup("Node", new String[]{"Osmand","Vineet"}));
		techGroupList.add(new TechnologyGroup("Oracle", new String[]{"Osmand","Anuj","Prashant", "Amit"}));
		
		List<String> technologyGroup = techGroupList.
				stream().
				map(TechnologyGroup::getTechMembers).
				flatMap(Arrays::stream).
				distinct().
				sorted().
				collect(Collectors.toList());
		
		System.out.println("Technology Group: " + technologyGroup);

	}

}
