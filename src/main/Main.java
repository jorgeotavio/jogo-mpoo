package main;

import controller.ControllerMenu;
import model.BaseDados;
import model.RegistrarNoJogo;
import view.ViewGame;
import view.ViewMenu;

public class Main {

	public static void main(String[] args) {
		
		ViewGame viewGame = new ViewGame();
		ViewMenu viewMenu = new ViewMenu();
		
		RegistrarNoJogo.registerMap(viewGame);
		
		new ControllerMenu(viewMenu, viewGame);
		
	}

}
