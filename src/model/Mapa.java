package model;

import java.io.IOException;

import view.TelaErro;
import view.TelaGame;

public class Mapa {	
	
	private TelaGame telaGame;	
	private Sprite heroi, pontuacao;
	private Camada camada1, camada2, camada3, camada4;
	
	
	public Mapa(TelaGame telaGame, Sprite heroi, Sprite heroi2) {
		
		this.telaGame = telaGame;
		
		try {

			camada1 = new Camada(15, 20, 32, 32, "img/mapa/chipset.png", "img/mapa/camada01.txt");
			camada2 = new Camada(15, 20, 32, 32, "img/mapa/castelo.png", "img/mapa/camada02.txt");
			camada3 = new Camada(15, 20, 32, 32, "img/mapa/chipset.png", "img/mapa/camada03.txt");
			camada4 = new Camada(15, 20, 32, 32, "img/mapa/chipset.png", "img/mapa/painel.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		heroi = new Sprite("img/sprites/heroi.png", 1, 4, 4, telaGame.getWidth()/2, telaGame.getHeight()/2);

		pontuacao  = new Sprite("img/sprites/pontuacao.png", 0, 4,5, 0, 0);
		
		telaGame.setHeroi(heroi);
		telaGame.setSpritesHeroi(heroi.getSprites());
		telaGame.setPontuacao(pontuacao);
		telaGame.setCamada1(camada1);
		telaGame.setCamada2(camada2);
		telaGame.setCamada3(camada3);
		telaGame.setCamada4(camada4);
		telaGame.getCamada1().montarMapa(640, 480);
		telaGame.getCamada2().montarMapa(640, 480);
		telaGame.getCamada3().montarMapa(640, 480);
		telaGame.getCamada4().montarMapa(640, 480);
	}

}
