package controller;

import view.ViewGame;

public class ControllerGame implements Runnable {
	
	private ViewGame viewGame;
	
	public ControllerGame(ViewGame viewGame) {
		this.viewGame = viewGame;
		this.viewGame.setVisible(true);
		
	}

	@Override
	public void run() {
		while ( true ) {
			this.viewGame.repaint();
			try {
				Thread.sleep(500/5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
