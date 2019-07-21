package controller;

import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.util.List;

import model.Flecha;
import model.Mapa;
import model.Sprite;
import view.TelaGame;

public class ControllerGame2 extends KeyAdapter implements Runnable {
	
	private TelaGame telaGame;
	private BufferedImage tela;
	private Mapa mapa;
	public ControllerGame2(TelaGame telaGame) {
		
		this.telaGame = telaGame;
		mapa = new Mapa(telaGame, null, null);
		telaGame.addKeyListener(new ControllerHeroi(telaGame.getHeroi()));
		telaGame.setVisible(true);
		
	}
	
	public void animacoes() {

		List<Flecha> flechas = 	telaGame.getHeroi().getFlechas();
		for (Flecha f: flechas ){
			if (f.isVisible()) {
				f.mexer();
			}else {
				flechas.remove(f);
			}
		}

//		for (Sprite s: inimigos){
//			if (s.isVisible()) {
//				controllerInimigo.mexer(s);
//			}else {
//				controllerInimigo.mexer(s);
//				controllerInimigo.getInimigos().remove(s);
//			}
//		}
	}
	
	@Override
	public void run() {
		
		while ( true ) {
			animacoes();
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
