package pandemic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CycleTest {

	@Test // Test if pit has 4 beads.
	public void firstTest() {
		Cycle cycleTest = new Cycle();
		cycleTest.setPaper();
		int actual = cycleTest.getPaper().length();
		int expected = 11;
    	assertEquals(expected, actual);	
	}
}
