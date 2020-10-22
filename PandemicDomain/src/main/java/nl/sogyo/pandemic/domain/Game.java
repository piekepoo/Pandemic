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
	int totalScore; 
	Ranklist ranklist;

	public Game() {
		gameState = 0;
		lockdownLevel = 0;
		this.DatabaseConnection = new SQLDatabaseConnection();
		int cycle = 0;
	}

	public void startGame() {
		this.startCycle();
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

	public int getCycle() {
		return cycle;	 
	}
	
	public Ranklist getRanks() {
		return ranklist;	 
	}

	public Ranklist enterScore(String name, int score) {
		DatabaseConnection.setData("INSERT INTO Ranklist (name, score) VALUES ('" + name +  "', '" + score + "');", 2);
		List<String> dataBaseList = DatabaseConnection.getData("select name, score from Ranklist ORDER BY score DESC LIMIT 10;", 2);
		this.ranklist = new Ranklist(dataBaseList);
		return ranklist;
		
	}
	
	public int calculateScore() {
		int total = (int) (maincharacter.getMoney() + maincharacter.getSocialNeed() + maincharacter.getAmountToiletPaper());
		return total;
	}
	
	public TextArray startCycle() {
		this.maincharacter.getVirusChance();
		if (this.maincharacter.AmInfected()) { // if player is infected, get data for end of game.
			List<String> dataBaseList = DatabaseConnection.getData("select * from eventFlow where id = 100;", 14);
			dataBaseList.set(1, ("Day " + (this.cycle + 1)));
			this.textArray = new TextArray(dataBaseList);
		}
		else {
			cycle += 1; // Otherwise, start new day/cycle
			List<String> dataBaseList = DatabaseConnection.getData("select * from eventFlow where id = " + cycle + ";", 14);
			this.textArray = new TextArray(dataBaseList);
		}
		return textArray;
	}


	public void evaluateAnswer(String event, int answer) {
		if (!maincharacter.getSickness()) { // Continue if player not infected
			if (cycle == 1) {

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
						this.maincharacter.socialDecrease(5);
						this.maincharacter.virusDecrease(1);
					}
					else if (answer == 2) {
						this.maincharacter.socialDecrease(5);
						this.maincharacter.virusDecrease(1);;
					}
				}
			}
			else if (cycle == 3) {
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
			else if (cycle == 4) {
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

			else if (cycle == 5) {
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
			else if (cycle == 6) {
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
}


