package controller;

import java.util.ArrayList;

import model.Player;
import view.ViewGame;

public class ControllerGame implements Runnable {
	
	private ViewGame viewGame;
	
	public ControllerGame(ViewGame viewGame) {
		this.viewGame = viewGame;
		this.viewGame.setVisible(true);
		
		ArrayList<Player> players = this.viewGame.getPlayers();
		for (Player player: players) {
			viewGame.addKeyListener(new ControllerHero(player.getHero()));
		}
	}

	@Override
	public void run() {
		while ( true ) {
			
			this.viewGame.repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
