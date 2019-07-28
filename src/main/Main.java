package main;

import controller.ControllerGame;
import controller.ControllerGame;
import view.TelaGame;

public class Main {

	public static void main(String[] args) {
		
		TelaGame tg = new TelaGame();
		
		ControllerGame cg2 = new ControllerGame(tg);
		cg2.run();
	
	}
	
}
