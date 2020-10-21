package nl.sogyo.pandemic.domain;

public class MainChar {
	
	String name;
	int agegroup;
	boolean isInfected;
	String socialNeed;
	String virusVulnerability;
	double socialMeter;
	double chanceOfVirus;
	int money;
	int toiletPaper;
	
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
		int money = 100;
	}
	
	public String getName() {
		return name;	
	}
	public int getAgegroup() {
		return agegroup;	
	}
	
	public double getSocialNeed() {
		return socialMeter;	
	}
	
	public double getVirusChance() {
		return chanceOfVirus;	
	}
	
	public double getMoney() {
		return money;	
	}
	
	public void earnMoney(double number) {
		this.money += number;
	}
	
	public double getAmountToiletPaper() {
		return toiletPaper;	
	}
	
	public void buyToiletPaper(double number) {
		this.toiletPaper += number;
	}
	
	public void useToiletPaper(double number) {
		this.toiletPaper -= number;
	}
	
	public void spendMoney(double number) {
		this.money -= number;
	}
	
	public void socialIncrease(double number) {
			this.socialMeter += number;
			if(this.socialMeter > 100) {
				this.socialMeter = 100;
			}
	}
	
	public void socialDecrease(double number) {
		switch (socialNeed){
		case "high":
			this.socialMeter -= (number * 1.5);
		    break;
		case "medium":
			this.socialMeter -= number;
		    break;
		case "low":
			this.socialMeter -= (number * 0.75);
		    break;
		}
		if(this.socialMeter < 0) {
			this.socialMeter = 0;
		}
	}
	
	public void virusIncrease(double number) {
		switch (virusVulnerability){
		case "high":
			this.chanceOfVirus += (number * 1.5);
		    break;
		  case "medium":
			this.chanceOfVirus += number;
		    break;
		  case "low":
			this.chanceOfVirus += (number * 0.75);
		    break;
		    
		}
		if(this.chanceOfVirus > 100) {
			this.chanceOfVirus = 100;
		}
	}
	
	public void virusDecrease(double number) {
		this.chanceOfVirus -= number;
		if(this.chanceOfVirus < 0) {
			this.chanceOfVirus = 0;
		}
	}

	public boolean AmInfected() {
		int random = (int)(Math.random() * 100 + 1);
		double infection = (100 - this.chanceOfVirus);
		if(random > infection) {
			this.isInfected = true;
		}
		return isInfected;
	}
	
	public boolean getSickness() {
		return isInfected;
	}
}
