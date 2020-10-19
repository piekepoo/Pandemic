package nl.sogyo.pandemic.domain;

import java.util.List;

import nl.sogyo.pandemic.domain.MainChar;
import nl.sogyo.pandemic.domain.TextArray;

public class Game {
	MainChar maincharacter;
	int gameState;
	int lockdownLevel;
	int cycle;
	SQLDatabaseConnection DatabaseConnection;
	List<String> dataBaseList;
	TextArray textArray;
	
		public Game() {
			gameState = 0;
			lockdownLevel = 0;
			this.DatabaseConnection = new SQLDatabaseConnection();
			int cycle = 0;
		}

	 public void startGame() {
		  System.out.println(this.startCycle());
	 }
	
	 public void setPlayerInfo(String name, int age) {
		 this.maincharacter = new MainChar(name, age);
	 }
	 
	 public MainChar getMainChar() {
		  return this.maincharacter;
	 }
		
	 public TextArray getTextArray() {
		 return textArray;	 
	 }
	 
	 public TextArray startCycle() {
		cycle += 1;
		List<String> dataBaseList = DatabaseConnection.getData("select * from eventFlow where id = " + cycle + ";");
	//	System.out.println(dataBaseList.get(0));
		this.textArray = new TextArray(dataBaseList);
	    return textArray;
	}

	
	public void evaluateAnswer(String event, int answer) {
		if (cycle == 1) {
			if (event.equals("GoToWork")) {
				if (answer == 1) { // Met OV
					this.maincharacter.socialIncrease(2);
					this.maincharacter.virusIncrease(5);
					this.maincharacter.earnMoney(100);

				}
				else if (answer == 2) { // Met fiets
					this.maincharacter.socialDecrease(2);
					this.maincharacter.virusIncrease(3);
					this.maincharacter.earnMoney(100);

				}
			}
			else if (event.equals("AfterWork")) {
				if (answer == 1) {
					this.maincharacter.socialDecrease(5);
					this.maincharacter.virusDecrease(1);
				}
				else if (answer == 2) {
					this.maincharacter.socialDecrease(5);
					this.maincharacter.virusDecrease(1);;
				}
			}
		}
		else if (cycle == 2) {
			if (event.equals("GoToWork")) {
				if (answer == 1) { // Met OV
					this.maincharacter.socialIncrease(2);
					this.maincharacter.virusIncrease(5);
					this.maincharacter.earnMoney(100);

				}
				else if (answer == 2) { // Met fiets
					this.maincharacter.socialDecrease(2);
					this.maincharacter.virusIncrease(3);
					this.maincharacter.earnMoney(100);
				}
			}
			else if (event.equals("AfterWork")) {
				if (answer == 1) {
					this.maincharacter.socialIncrease(5);
					this.maincharacter.virusIncrease(5);
					this.maincharacter.spendMoney(50);

				}
				else if (answer == 2) {
					this.maincharacter.socialDecrease(3);
					this.maincharacter.virusDecrease(2);
				}
			}					
		}
		else if (cycle == 3) {
			if (event.equals("GoToWork")) {
				if (answer == 1) { // Met OV
					this.maincharacter.socialIncrease(2);
					this.maincharacter.virusIncrease(5);
					this.maincharacter.earnMoney(50);
				}
				else if (answer == 2) { // Met fiets
					this.maincharacter.socialDecrease(2);
					this.maincharacter.virusIncrease(3);
					this.maincharacter.earnMoney(100);
				}
			}
			else if (event.equals("AfterWork")) {
				if (answer == 1) {
					this.maincharacter.socialDecrease(3);
					this.maincharacter.virusIncrease(3);
					this.maincharacter.spendMoney(80);
					this.maincharacter.buyToiletPaper(8);
				}
				else if (answer == 2) {
					this.maincharacter.socialIncrease(1);
					this.maincharacter.virusIncrease(3);
					this.maincharacter.spendMoney(10);
					this.maincharacter.buyToiletPaper(1);

				}
			}					
		}
		else if (cycle == 4) {
			if (event.equals("GoToWork")) {
				if (answer == 1) { // Met OV
					this.maincharacter.socialIncrease(1);
					this.maincharacter.virusIncrease(2);
					this.maincharacter.earnMoney(100);
					this.maincharacter.useToiletPaper(1);
				}
				else if (answer == 2) { // Met fiets
					this.maincharacter.socialIncrease(2);
					this.maincharacter.virusIncrease(5);
					this.maincharacter.earnMoney(100);
				}
			}
			else if (event.equals("AfterWork")) {
				if (answer == 1) {
					this.maincharacter.socialIncrease(5);
					this.maincharacter.virusIncrease(5);
					this.maincharacter.spendMoney(100);
				}
				else if (answer == 2) {
					this.maincharacter.socialDecrease(3);
					this.maincharacter.virusIncrease(2);
				}
			}					
		}
		else if (cycle == 5) {
			if (event.equals("GoToWork")) {
				if (answer == 1) { // Met OV
					this.maincharacter.socialIncrease(1);
					this.maincharacter.virusIncrease(3);
					this.maincharacter.earnMoney(100);
				}
				else if (answer == 2) { // Met fiets
					this.maincharacter.socialDecrease(5);
					this.maincharacter.virusDecrease(2);
					this.maincharacter.earnMoney(100);
				}
			}
			else if (event.equals("AfterWork")) {
				if (answer == 1) {
					this.maincharacter.socialDecrease(3);
					this.maincharacter.virusDecrease(1);
				}
				else if (answer == 2) {
					this.maincharacter.socialDecrease(3);
					this.maincharacter.virusDecrease(1);
				}
			}					
		}
	}
}


