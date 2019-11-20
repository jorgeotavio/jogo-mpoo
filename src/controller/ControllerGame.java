package controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import model.Camada;
import model.Map;
import model.Player;
import view.ViewGame;

public class ControllerGame implements Runnable, KeyListener {

	private ViewGame viewGame;
	private ArrayList<Rectangle> retangulosColisao;
	private ArrayList<ControllerHero> controllersHero;
	private boolean pausado = false;

	public ControllerGame(ViewGame viewGame) {

		this.viewGame = viewGame;
		this.viewGame.setVisible(true);
		this.viewGame.addKeyListener(this);
		controllersHero = new ArrayList<ControllerHero>();

		ArrayList<Player> players = this.viewGame.getGamePanel().getPlayers();

		for (Player player: players) {
			ControllerHero ch = new ControllerHero(player.getHero(), players.indexOf(player));
			controllersHero.add(ch);
			viewGame.addKeyListener(ch);
		}

	}

	public void checarColisoes(ArrayList<Map> maps, ArrayList<Player> players) {

		for(Map map: maps) {

			if(!map.isActivated())
				continue;

			for(Camada camada: map.getCamadas()) {

				if(!camada.isCamadaColisao()) 
					continue;

				for (Rectangle rectangle : camada.getRectsColisao()) {
					for(Player player: players) {
						if(rectangle.intersects(player.getHero().getRetangulo())) {
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

	public boolean isPausado() {
		return pausado;
	}

	public void setPausado(boolean pausado) {
		this.pausado = pausado;
	}

	@Override
	public void run() {
		while ( true ) {

			if (!pausado) {

				checarColisoes(viewGame.getGamePanel().getMaps(), viewGame.getGamePanel().getPlayers());

				for(ControllerHero ch: controllersHero) {
					ch.atualizaHero();
				}
				this.viewGame.getGamePanel().repaint();
			}

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			this.pausado = !pausado;
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
