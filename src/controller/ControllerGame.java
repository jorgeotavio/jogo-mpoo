package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.prism.paint.Stop;

import model.Flecha;
import model.Player;
import model.Camada;
import model.Sprite;
import view.ExibirMensagem;
import view.TelaErro;
import view.TelaGame;
import view.TelaInicio;

public class ControllerGame extends KeyAdapter implements Runnable {

	private int tentativas;
	private Player player;
	private ControllerInimigo controllerInimigo;
	private BufferedImage[] spritesHeroi, spritesInimigo, spritesPontuacao;
	private BufferedImage tela;
	private Sprite heroi, pontuacao;
	private Camada camada1, camada2, camada3, camada4, camadaInicio, camadaTexto, camadaOver;
	private int FPS = 5;
	protected static boolean perdeu, emJogo, ganhou, inicio;
	private TelaGame telaGame;
	private List<Sprite> inimigos;


	public void controll() {

		player = new Player();

		telaGame = new TelaGame();


		heroi = new Sprite("img/sprites/heroi.png", 1, 4, 4, telaGame.getWidth()/2, telaGame.getHeight()/2);
		spritesHeroi = heroi.getSprites();

		pontuacao  = new Sprite("img/sprites/pontuacao.png", 0, 4,5, 0, 0);
		spritesPontuacao = pontuacao.getSprites();

		controllerInimigo = new ControllerInimigo();
		inimigos = controllerInimigo.getInimigos();

		telaGame.addKeyListener(this);

		try {

			camada1 = new Camada(15, 20, 32, 32, "img/mapa/chipset.png", "img/mapa/camada01.txt");
			camada2 = new Camada(15, 20, 32, 32, "img/mapa/castelo.png", "img/mapa/camada02.txt");
			camada3 = new Camada(15, 20, 32, 32, "img/mapa/chipset.png", "img/mapa/camada03.txt");
			camada4 = new Camada(15, 20, 32, 32, "img/mapa/chipset.png", "img/mapa/painel.txt");
			camadaInicio = new Camada(15, 20, 32, 32, "img/mapa/chipset.png", "img/sistema/camadaInicio.txt");
			camadaTexto = new Camada(15, 20, 32, 32, "img/sistema/texto.png", "img/sistema/texto.txt");
			camadaOver = new Camada(15, 20, 32, 32, "img/sistema/game_over.png", "img/sistema/game_over.txt");

		} catch (IOException e) {
			e.printStackTrace();
			new TelaErro();
		}

		inicio = true;
		emJogo = false;
		perdeu = false;
		ganhou = false;

		camada1.montarMapa(640, 480);
		camada2.montarMapa(640, 480);
		camada3.montarMapa(640, 480);
		camada4.montarMapa(640, 480);
		camadaInicio.montarMapa(640, 480);
		camadaTexto.montarMapa(640, 480);
		camadaOver.montarMapa(640, 480);

		telaGame.setVisible(true);
	}

	public void paint(Graphics g) {

		if (inicio && tentativas == 0) {

			tela.getGraphics().drawImage(camada1.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camada2.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camada3.camada, 0, 0,telaGame);

			tela.getGraphics().drawImage(camadaInicio.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camadaTexto.camada, 0, 0,telaGame);

		}

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
			tela.getGraphics().drawImage(spritesPontuacao[pontuacao.getAparencia()], pontuacao.getPosX(), pontuacao.getPosY(), null);
		}

		if (inicio && tentativas > 0) {
			tela.getGraphics().drawImage(camada1.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camada2.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camada3.camada, 0, 0,telaGame);

			tela.getGraphics().drawImage(camadaInicio.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camadaOver.camada, 0, 0,telaGame);

		}

		if (ganhou) {
			tela.getGraphics().drawImage(camada1.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camada2.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camada3.camada, 0, 0,telaGame);

			tela.getGraphics().drawImage(camadaInicio.camada, 0, 0,telaGame);
			tela.getGraphics().drawImage(camadaOver.camada, 0, 0,telaGame);
		}

		Graphics2D g2d = (Graphics2D) telaGame.getGraphics();
		g2d.drawImage(tela, 0, 0, null);

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			emJogo = true;
			inicio = false;
			perdeu = false;
			telaGame.addKeyListener(new ControllerHeroi(heroi));
		}
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
				inicio = false;
				ganhou = false;
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
				controllerInimigo.mexer(s);
				controllerInimigo.getInimigos().remove(s);
			}
		}
	}


	@Override
	public void run() {
		tentativas = 0;
		tela = new BufferedImage(640, 480, BufferedImage.TYPE_4BYTE_ABGR);
		controll();
		while (true) {
			if (perdeu) {
				tentativas+=1;
				controll();

			}
			if (ganhou) {
				controll();
				
			}
			else {
				try {
					animacoes(); 
					paint(telaGame.getGraphics());
					Thread.sleep(500/FPS);
					checarColisoes();
					pontuacao.setAparencia(player.getPontuacao());
					if (perdeu) {
						emJogo = false;
						telaGame.addKeyListener(this);
					}

				}catch (Exception e) {

				}
			}
		}

	}

}