package main;

import controller.ControllerGame;
import controller.ControllerGame2;
import view.TelaGame;

public class Main {

	public static void main(String[] args) {
		
//		ControllerGame cg = new ControllerGame();
//		cg.run();
		
		TelaGame tg = new TelaGame();
		
		ControllerGame2 cg2 = new ControllerGame2(tg);
		cg2.run();
	
	}
	
}
