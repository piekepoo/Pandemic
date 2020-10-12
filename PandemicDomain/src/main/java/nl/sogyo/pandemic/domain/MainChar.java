package main.java.nl.sogyo.pandemic.domain;

public class MainChar {
	
	String name;
	int agegroup;
	boolean isInfected;
	String socialNeed;
	String virusVulnerability;
	int socialMeter;
	int chanceOfVirus;
	int money;
	
	public MainChar(String nameChar, int age) {
		name = nameChar;
		if(age > 50) {
			socialNeed = "low";
			virusVulnerability = "high";
		}
		else if(age < 30) {
			socialNeed = "high";
			virusVulnerability = "low";
		}
		else {
			socialNeed = "medium";
			virusVulnerability = "medium";	
		}
		agegroup = age;
		isInfected = false;
		socialMeter = 50;
		chanceOfVirus = 0;
		int money = 0;
	}
	
	private String getName() {
		return name;	
	}
	

	


}
