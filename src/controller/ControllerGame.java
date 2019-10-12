package controller;

import java.awt.Rectangle;
import java.util.ArrayList;

import model.Camada;
import model.Hero;
import model.Map;
import model.Player;
import view.ViewGame;
import view.ViewTutorial;

public class ControllerGame implements Runnable {

	private ViewGame viewGame;
	private ArrayList<Rectangle> retangulosColisao;

	public ControllerGame(ViewGame viewGame) {
		this.viewGame = viewGame;
		this.viewGame.setVisible(true);

		ArrayList<Player> players = this.viewGame.getPlayers();
		for (Player player: players) {
			viewGame.addKeyListener(new ControllerHero(player.getHero()));
		}
	}

	public void checarColisoes(ArrayList<Map> maps, ArrayList<Player> players) {
		for(Map map: maps) {
			for(Camada camada: map.getCamadas()) {
				if(camada.isCamadaColisao()) {
					for (Rectangle rectangle : camada.getRectsColisao()) {
						for(Player player: players) {
							
							if(rectangle.intersects(player.getHero().getRetangulo()))
								player.getHero().parar();
						}
					}
				}
			}
		}
	}

	public ArrayList<Rectangle> getRetangulosColisao() {
		return retangulosColisao;
	}

	public void setRetangulosColisao(ArrayList<Rectangle> retangulosColisao) {
		this.retangulosColisao = retangulosColisao;
	}

	@Override
	public void run() {
		while ( true ) {
			
			checarColisoes(viewGame.getMaps(), viewGame.getPlayers());
			
			this.viewGame.repaint();			
			
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
