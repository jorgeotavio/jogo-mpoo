package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Flecha;
import model.Camada;
import model.Sprite;
import view.TelaErro;
import view.TelaGame;

public class ControllerGame implements Runnable{

	private BufferedImage[] spritesHeroi, spritesInimigo;
	private BufferedImage tela;
	private Sprite heroi, inimigo;
	private Camada camada1, camada2, camada3;
	private int FPS = 5;
	private boolean emJogo;
	private TelaGame telaGame;
	private List<Sprite> inimigos;
	private int[][] coordenadas = new int[50][2];

	public ControllerGame() {
		iniciarCoordenadas();
		telaGame = new TelaGame();
		
		heroi = new Sprite("img/heroi/heroi.png", 1, 4, 4, telaGame.getWidth()/2, telaGame.getHeight()/2);
		spritesHeroi = heroi.getSprites();
		
		inicializarInimigos();
		
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
			
			tela.getGraphics().drawImage(spritesHeroi[heroi.getAparencia()], heroi.getPosX(), heroi.getPosY(), null);
			
			
			for (int i = 0; i < inimigos.size(); i++) {
				Sprite in = inimigos.get(i);
				spritesInimigo = in.getSprites();
				tela.getGraphics().drawImage(spritesInimigo[in.getAparencia()], in.getPosX(), in.getPosY(), null);
  
 			}
			
			
			Graphics2D g2d = (Graphics2D) telaGame.getGraphics();
			g2d.drawImage(tela, 0, 0, null);
		}
	
	}
	
	public void iniciarCoordenadas() {
		
		Random random = new Random();
		
		for (int i = 0; i<50; i++) {
			for (int j = 0 ;j <= 1 ; j++) {
				if (j == 0)
					coordenadas[i][j] = random.nextInt(600)+100;
				else
					coordenadas[i][j] = random.nextInt(800)+400;
			}
		}
	}
	
	public void inicializarInimigos() {
		inimigos = new ArrayList<Sprite>();
		for (int i=0;i<50;i++) {
			inimigos.add(new Sprite("img/heroi/personagem.png", 0, 6, 4, coordenadas[i][0], coordenadas[i][1]));
		}
	}
	
	public void checarColisoes() {
		Rectangle formaNave = heroi.getBounds();
		Rectangle formaInimigo;
		Rectangle formaFlecha;

		for (int i = 0; i < inimigos.size(); i++) {

			Sprite tempInimigo = inimigos.get(i);
			formaInimigo = tempInimigo.getBounds();

			if (formaNave.intersects(formaInimigo)) {
				heroi.setVisible(false);
				tempInimigo.setVisible(false);
				emJogo = false;
			}
		}

		List<Flecha> flechas = heroi.getFlechas();

		for (int i = 0; i < flechas.size(); i++) {
			Flecha tempFlecha = flechas.get(i);
			formaFlecha = tempFlecha.getBounds();

			for (int j = 0; j < inimigos.size(); j++) {
				Sprite tempInimigo = inimigos.get(j);
				formaInimigo = tempInimigo.getBounds();

				if (formaFlecha.intersects(formaInimigo)) {
					tempInimigo.setVisible(false);
					tempFlecha.setVisible(false);
				}
			}
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
				
				for (Sprite s: inimigos){
					if (s.isVisible()) {
						s.mexer();
					}else {
						inimigos.remove(s);
					}
				}
				paint(telaGame.getGraphics());
				Thread.sleep(500/FPS);
				checarColisoes();
			}catch (Exception e) {

			}

		}

	}

}