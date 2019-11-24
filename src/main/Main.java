package main;

import controller.ControllerMenu;
import model.RegistrarJogo;
import model.Xml;
import view.GamePanel;
import view.ViewGame;
import view.ViewMenu;

public class Main {

	public static void main(String[] args) {

		ViewGame viewGame = new ViewGame();
		
		ViewMenu viewMenu = new ViewMenu();

		ControllerMenu cm = new ControllerMenu(viewMenu, viewGame);
		
	}

}
