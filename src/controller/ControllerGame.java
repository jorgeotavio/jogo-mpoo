package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import model.Flecha;
import model.Camada;
import model.Sprite;
import view.TelaErro;
import view.TelaGame;

public class ControllerGame implements Runnable{

	private BufferedImage[] sprites;
	private BufferedImage tela;
	private Sprite heroi;
	private Camada camada1, camada2, camada3;
	private int FPS = 5;
	private boolean emJogo;
	private TelaGame telaGame;

	public ControllerGame() {
		telaGame = new TelaGame();

		heroi = new Sprite("img/heroi/heroi.png", 1, 4, 4, telaGame.getWidth()/2, telaGame.getHeight()/2);
		sprites = heroi.getSprites();

		telaGame.addKeyListener(new ControllerHeroi(heroi));

		try {
			camada1 = new Camada(15, 20, 32, 32, "img/mapa/camada01.png", "img/mapa/camada01.txt");
			camada2 = new Camada(15, 20, 32, 32, "img/mapa/camada02.png", "img/mapa/camada02.txt");
			camada3 = new Camada(15, 20, 32, 32, "img/mapa/camada01.png", "img/mapa/camada03.txt");
		} catch (IOException e) {
			e.printStackTrace();
			new TelaErro();
		}

		emJogo = true;

		camada1.montarMapa(640, 480);
		camada2.montarMapa(640, 480);
		camada3.montarMapa(640, 480);

		telaGame.setVisible(true);
	}

	public void paint(Graphics g) {
		
		if (emJogo) {
			
			tela.getGraphics().drawImage(camada1.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camada2.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camada3.camada, 0, 0,telaGame);
			
			List<Flecha> flechas = heroi.getFlechas();
			flechas.forEach(f->tela.getGraphics().drawImage(f.getImagem(), f.getPosX(), f.getPosY(), telaGame));
			
			tela.getGraphics().drawImage(sprites[heroi.getAparencia()], heroi.getPosX(), heroi.getPosY(), null);
			
			Graphics2D g2d = (Graphics2D) telaGame.getGraphics();
			g2d.drawImage(tela, 0, 0, null);
		}
	
	}

	@Override
	public void run() {
		tela = new BufferedImage(640, 480, BufferedImage.TYPE_4BYTE_ABGR);
		
		while (true) {
			
			try {
				
				List<Flecha> flechas = heroi.getFlechas();
				for (Flecha f: flechas ){
					if (f.isVisible()) {
						f.mexer();
					}else {
						flechas.remove(f);
					}
				}
				
				paint(telaGame.getGraphics());
				Thread.sleep(500/FPS);

			}catch (Exception e) {

			}

		}

	}

}