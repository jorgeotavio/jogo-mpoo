package main;

import controller.ControllerMenu;
import model.RegistrarNoJogo;
import model.Som;
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