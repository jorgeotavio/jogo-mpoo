package controller;

import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;

import model.Mapa;
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

	@Override
	public void run() {
		
//		tela = new BufferedImage(640, 480, BufferedImage.TYPE_4BYTE_ABGR);
//		telaGame.setTela(this.tela);
		
		while ( true ) {
			telaGame.repaint();
		}
		
	}

}
