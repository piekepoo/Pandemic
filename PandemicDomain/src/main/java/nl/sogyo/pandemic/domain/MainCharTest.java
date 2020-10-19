//package main.java.nl.sogyo.pandemic.domain;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//class MainCharTest {
//
//	@Test 
//	public void socialNeedIncreaseYoung() {
//		MainChar maincharacter = new MainChar("Peter", 22);
//		maincharacter.socialIncrease(5.0);
//		double actual = maincharacter.getSocialNeed();
//		double expected = 55.0;
//    	assertEquals(expected, actual);	
//	}
//	
//	@Test 
//	public void socialNeedIncreaseOld() {
//		MainChar maincharacter = new MainChar("Peter", 51);
//		maincharacter.socialIncrease(5.0);
//		double actual = maincharacter.getSocialNeed();
//		double expected = 55.0;
//    	assertEquals(expected, actual);	
//	}
//	
//	@Test 
//	public void socialNeedDecreaseYoung() {
//		MainChar maincharacter = new MainChar("Peter", 22);
//		maincharacter.socialDecrease(5.0);
//		double actual = maincharacter.getSocialNeed();
//		double expected = 42.5;
//    	assertEquals(expected, actual);	
//	}
//	
//	@Test 
//	public void socialNeedDecreaseOld() {
//		MainChar maincharacter = new MainChar("Peter", 51);
//		maincharacter.socialDecrease(5.0);
//		double actual = maincharacter.getSocialNeed();
//		double expected = 46.25;
//    	assertEquals(expected, actual);	
//	}
//	
//	
//	@Test 
//	public void virusIncreaseYoung() {
//		MainChar maincharacter = new MainChar("Peter", 22);
//		maincharacter.virusIncrease(5.0);
//		double actual = maincharacter.getVirusChance();
//		double expected = 3.75;
//    	assertEquals(expected, actual);	
//	}
//	
//	@Test 
//	public void virusIncreaseOld() {
//		MainChar maincharacter = new MainChar("Peter", 51);
//		maincharacter.virusIncrease(5.0);
//		double actual = maincharacter.getVirusChance();
//		double expected = 7.5;
//    	assertEquals(expected, actual);	
//	}
//	
//	@Test 
//	public void virusDecreaseYoung() {
//		MainChar maincharacter = new MainChar("Peter", 22);
//		maincharacter.virusDecrease(5.0);
//		double actual = maincharacter.getVirusChance();
//		double expected = 0.0;
//    	assertEquals(expected, actual);	
//	}
//	
//	@Test 
//	public void virusDecreaseOld() {
//		MainChar maincharacter = new MainChar("Peter", 51);
//		maincharacter.virusDecrease(5.0);
//		double actual = maincharacter.getVirusChance();
//		double expected = 0.0;
//    	assertEquals(expected, actual);	
//	}
//}
