package controller;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.util.List;

import model.Flecha;
import model.Mapa;
import model.Sprite;
import view.TelaGame;

public class ControllerGame implements Runnable {
	
	private TelaGame telaGame;
	private Mapa mapa;
	
	public ControllerGame(TelaGame telaGame) {
		
		this.telaGame = telaGame;
		mapa = new Mapa(telaGame, null, null);
		telaGame.addKeyListener(new ControllerHeroi(telaGame.getHeroi()));
		telaGame.setVisible(true);
		
	}
	
	public void animacoes() {

		for (Flecha f: telaGame.getHeroi().getFlechas()){
			if (f.isVisible()) {
				f.mexer();
			}else {
				telaGame.getHeroi().getFlechas().remove(f);
			}
		}
		
		for (Sprite s: telaGame.getInimigos()){
			if (s.isVisible()) {
				s.mexer();
			}else {
				telaGame.getInimigos().remove(s);
			}
		}
	}
	
	public void checarColisoes() {
		Rectangle formaHeroi = telaGame.getHeroi().getBounds();
		Rectangle formaInimigo;
		Rectangle formaFlecha;

		for (int i = 0; i < telaGame.getInimigos().size(); i++) {

			Sprite tempInimigo = telaGame.getInimigos().get(i);
			formaInimigo = tempInimigo.getBounds();

			if (formaHeroi.intersects(formaInimigo)) {
				telaGame.getHeroi().setVisible(false);
				tempInimigo.setVisible(false);
			}
		}


		for (int i = 0; i < telaGame.getHeroi().getFlechas().size(); i++) {
			Flecha tempFlecha = telaGame.getHeroi().getFlechas().get(i);
			formaFlecha = tempFlecha.getBounds();

			for (int j = 0; j < telaGame.getInimigos().size(); j++) {
				Sprite tempInimigo = telaGame.getInimigos().get(j);
				formaInimigo = tempInimigo.getBounds();

				if (formaFlecha.intersects(formaInimigo)) {
					tempInimigo.setVisible(false);
					tempFlecha.setVisible(false);
//					telaGame.getPlayer().setPontuacao(telaGame.getPlayer().getPontuacao()+1);
				}
			}
		}
	}
	
	@Override
	public void run() {
		
		while ( true ) {
			animacoes();
			checarColisoes();
			telaGame.repaint();
			try {
				Thread.sleep(500/5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
