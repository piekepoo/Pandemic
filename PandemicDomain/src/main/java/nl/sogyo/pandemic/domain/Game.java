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

	
	public void evaluateAnswer(String event, int answernumber) {
		if (cycle == 1) {
			if (event.equals("GoToWork")) {
				if (answernumber == 1) { // Met OV
					System.out.println("socialNeed decreasing");
				}
				else if (answernumber == 2) { // Met fiets
					System.out.println("socialNeed increasing");
				}
			}
			else if (event.equals("AfterWork")) {
				if (answernumber == 1) {
					System.out.println("socialNeed decreasing");
				}
				else if (answernumber == 2) {
					System.out.println("socialNeed decreasing");
				}
			}
		//cycle 2
		
		}
		
		
	}
}
//	public Game(Cycle cyc) {
//		this.cycle = new Cycle();
//	}


