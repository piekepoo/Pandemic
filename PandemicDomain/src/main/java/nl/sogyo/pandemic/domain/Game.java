package main.java.nl.sogyo.pandemic.domain;

import java.util.List;

import main.java.nl.sogyo.pandemic.domain.MainChar;

public class Game {
	MainChar maincharacter;
	int gameState;
	int lockdownLevel;
	int cycle;
	SQLDatabaseConnection DatabaseConnection;
	
		public Game() {
			gameState = 0;
			lockdownLevel = 0;
			this.DatabaseConnection = new SQLDatabaseConnection();
			int cycle = 0;
		}

	 public void startGame() {
		  System.out.println(this.startCycle());
	 }
	
	 private void setPlayerInfo(String name, int age) {
		 this.maincharacter = new MainChar(name, age);
	 }
		
	private List<String> startCycle() {
		cycle += 1;
		List<String> dataBaseList = DatabaseConnection.getData("select * from eventFlow where id = " + cycle + ";");
	    return dataBaseList;
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


