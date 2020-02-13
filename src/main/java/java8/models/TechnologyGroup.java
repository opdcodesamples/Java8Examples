package java8.models;

import java.util.List;

public class TechnologyGroup {
	private String techName;
	private List<String> techMembers;
	
	public TechnologyGroup(String techName, List<String> techMembers){
		this.techName = techName;
		this.techMembers = techMembers;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public List<String> getTechMembers() {
		return techMembers;
	}

	public void setTechMembers(List<String> techMembers) {
		this.techMembers = techMembers;
	}

	@Override
	public String toString() {
		return "TechnologyGroup [techName=" + techName + ", techMembers=" + techMembers + "]";
	}

}
