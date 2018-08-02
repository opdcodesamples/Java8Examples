package java8.stream.flatmap;

import java.util.Arrays;

class TechnologyGroup {
	private String techName;
	private String[] techMembers;
	
	public TechnologyGroup(String techName, String[] techMembers){
		this.techName = techName;
		this.techMembers = techMembers;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String[] getTechMembers() {
		return techMembers;
	}

	public void setTechMembers(String[] techMembers) {
		this.techMembers = techMembers;
	}

	@Override
	public String toString() {
		return "TechnologyGroup [techName=" + techName + ", techMembers=" + Arrays.toString(techMembers) + "]";
	}

}
