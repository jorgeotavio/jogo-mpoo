package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import model.Flecha;
import model.Player;
import model.Camada;
import model.Sprite;
import view.TelaErro;
import view.TelaGame;

public class ControllerGame implements Runnable{
	
	private Player player;
	private ControllerInimigo controllerInimigo;
	private BufferedImage[] spritesHeroi, spritesInimigo;
	private BufferedImage tela;
	private Sprite heroi;
	private Camada camada1, camada2, camada3, camada4;
	private int FPS = 5;
	protected static boolean perdeu, emJogo, ganhou;
	private TelaGame telaGame;
	private List<Sprite> inimigos;
	
	public ControllerGame() {
		
		player = new Player();
		
		telaGame = new TelaGame();
		
		heroi = new Sprite("img/sprites/heroi.png", 1, 4, 4, telaGame.getWidth()/2, telaGame.getHeight()/2);
		spritesHeroi = heroi.getSprites();

		controllerInimigo = new ControllerInimigo();
		inimigos = controllerInimigo.getInimigos();

		telaGame.addKeyListener(new ControllerHeroi(heroi));

		try {

			camada1 = new Camada(15, 20, 32, 32, "img/mapa/chipset.png", "img/mapa/camada01.txt");
			camada2 = new Camada(15, 20, 32, 32, "img/mapa/castelo.png", "img/mapa/camada02.txt");
			camada3 = new Camada(15, 20, 32, 32, "img/mapa/chipset.png", "img/mapa/camada03.txt");
			camada4 = new Camada(15, 20, 32, 32, "img/mapa/chipset.png", "img/mapa/painel.txt");
		} catch (IOException e) {
			e.printStackTrace();
			new TelaErro();
		}

		emJogo = true;
		perdeu = false;
		ganhou = false;

		camada1.montarMapa(640, 480);
		camada2.montarMapa(640, 480);
		camada3.montarMapa(640, 480);
		camada4.montarMapa(640, 480);

		telaGame.setVisible(true);
	}

	public void paint(Graphics g) {
		
		if (emJogo) {
			
			tela.getGraphics().drawImage(camada1.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camada2.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camada3.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camada4.camada, 0, 0,telaGame);

			List<Flecha> flechas = heroi.getFlechas();
			flechas.forEach(f->tela.getGraphics().drawImage(f.getImagem(), f.getPosX(), f.getPosY(), telaGame));

			tela.getGraphics().drawImage(spritesHeroi[heroi.getAparencia()], heroi.getPosX(), heroi.getPosY(), null);

			if (inimigos.size() == 0) {
				ganhou = true;
				emJogo = false;
			}	
			
			for (int i = 0; i < inimigos.size(); i++) {
				Sprite in = inimigos.get(i);
				spritesInimigo = in.getSprites();
				tela.getGraphics().drawImage(spritesInimigo[in.getAparencia()], in.getPosX(), in.getPosY(), null);

			}

		}
		
		if (perdeu) {
			
		}
		
		if (ganhou) {
			
		}
		
		Graphics2D g2d = (Graphics2D) telaGame.getGraphics();
		g2d.drawImage(tela, 0, 0, null);

	}


	public void checarColisoes() {
		Rectangle formaHeroi = heroi.getBounds();
		Rectangle formaInimigo;
		Rectangle formaFlecha;
		
		for (int i = 0; i < inimigos.size(); i++) {

			Sprite tempInimigo = inimigos.get(i);
			formaInimigo = tempInimigo.getBounds();

			if (formaHeroi.intersects(formaInimigo)) {
				heroi.setVisible(false);
				tempInimigo.setVisible(false);
				emJogo = false;
				perdeu = true;
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
					player.setPontuacao(player.getPontuacao()+1);
				}
			}
		}
	}
	
	public void animacoes() {
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
				controllerInimigo.mexer(s);
			}else {
				controllerInimigo.getInimigos().remove(s);
			}
		}
	}

	@Override
	public void run() {
		tela = new BufferedImage(640, 480, BufferedImage.TYPE_4BYTE_ABGR);
		while (true) {

			try {
				animacoes(); 
				paint(telaGame.getGraphics());
				Thread.sleep(500/FPS);
				checarColisoes();
			}catch (Exception e) {

			}

		}

	}

}