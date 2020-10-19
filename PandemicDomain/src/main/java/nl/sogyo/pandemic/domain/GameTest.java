//package main.java.nl.sogyo.pandemic.domain;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//class GameTest {
//
//	@Test
//	void testDatabase() {
//		Game newgame = new Game();
//		TextArray textArray = newgame.startCycle();
//		String actual = textArray.getButtonsPaper();
//		String expected = "OK";
//    	assertEquals(expected, actual);	
//	}
//
//	@Test
//	void testGameAnswer() {
//		Game newgame = new Game();
//		newgame.setPlayerInfo("name", 25);
//		newgame.startGame();
//		newgame.evaluateAnswer("AfterWork", 1);
//		double actual = newgame.getMainChar().getSocialNeed();
//		double expected = 42.5;
//    	assertEquals(expected, actual);	
//	}
//	
//	void testGameAnswer2() {
//		Game newgame = new Game();
//		newgame.setPlayerInfo("name", 25);
//		newgame.startGame();
//		newgame.evaluateAnswer("AfterWork", 1);
//		double actual = newgame.getMainChar().getVirusChance();
//		double expected = 0;
//    	assertEquals(expected, actual);	
//	}	
//}
