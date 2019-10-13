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
	private ArrayList<ControllerHero> controllersHero;

	public ControllerGame(ViewGame viewGame) {
		
		this.viewGame = viewGame;
		this.viewGame.setVisible(true);
		
		controllersHero = new ArrayList<ControllerHero>();
		
		ArrayList<Player> players = this.viewGame.getPlayers();
		
		for (Player player: players) {
			ControllerHero ch = new ControllerHero(player.getHero(), players.indexOf(player));
			controllersHero.add(ch);
			viewGame.addKeyListener(ch);
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
			
			for(ControllerHero ch: controllersHero) {
				ch.atualizaHero();
			}
			
			this.viewGame.repaint();	
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
