package pandemic;

import pandemic.MainCharacter;

public class Game {
	
	MainCharacter maincharacter;
	int gameState;
	int lockdownLevel;
	static Cycle cycle;
	
	public Game(Cycle cyc) {
		this.cycle = new Cycle();
	}
	
	public static void main(String[] args) {
		Game game = new Game(cycle);
		game.cycle.showPaper();

	}

}
