package main;

import controller.ControllerMenu;
import model.RegistrarJogo;
import view.ViewGame;
import view.ViewMenu;

public class Main {

	public static void main(String[] args) {
		
		ViewGame viewGame = new ViewGame();
		
		RegistrarJogo registrarJogo = new RegistrarJogo(viewGame);
		registrarJogo.registerMap();
		registrarJogo.getViewGame().montarCamadas();
		registrarJogo.registerPlayer();
		ViewMenu viewMenu = new ViewMenu();
		
		ControllerMenu cm = new ControllerMenu(viewMenu ,registrarJogo.getViewGame());
		
	}

}
