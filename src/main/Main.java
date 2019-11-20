package main;

import controller.ControllerMenu;
import model.RegistrarJogo;
import model.Xml;
import view.GamePanel;
import view.ViewGame;
import view.ViewMenu;

public class Main {

	public static void main(String[] args) {
		
		GamePanel gp = new GamePanel();
		ViewGame viewGame = new ViewGame(gp);
		
		RegistrarJogo registrarJogo = new RegistrarJogo(viewGame);
		registrarJogo.registerMap();
		registrarJogo.registerPlayer();
		
		ViewMenu viewMenu = new ViewMenu();
		
		ControllerMenu cm = new ControllerMenu(viewMenu ,registrarJogo.getViewGame());
		
	}

}
