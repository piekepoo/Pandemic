package nl.sogyo.pandemic.domain;

import nl.sogyo.pandemic.domain.Game;
import nl.sogyo.pandemic.domain.MainChar;

public class StartGame {
	
public static void main(String[] args) {
//	Game newgame = new Game();
//	newgame.setPlayerInfo("Sam", 22);
//	newgame.startGame();
//	newgame.evaluateAnswer("GoToWork", 2);
//	System.out.println(newgame.maincharacter.getSocialNeed());
	
	Game newgame = new Game();
	newgame.setPlayerInfo("name", 25);
	newgame.startGame();
	newgame.evaluateAnswer("AfterWork", 1);
	double actual = newgame.getMainChar().getSocialNeed();
	double expected = 40;
	System.out.println(actual + " " + expected);
	

	}
  
}