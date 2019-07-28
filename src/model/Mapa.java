package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import view.TelaErro;
import view.TelaGame;

public class Mapa {	

	private TelaGame telaGame;	
	private Sprite heroi, pontuacao;
	private Camada camada1, camada2, camada3, camada4;
	private List<Sprite> inimigos;
	private int[][] coordenadas = new int[20][2];
	private String inimigo1, inimigo2, inimigo3;


	public Mapa(TelaGame telaGame, Sprite heroi, Sprite heroi2) {
		
		this.telaGame = telaGame;
		
		inimigo1 = "img/sprites/inimigo1.png";
		inimigo2 = "img/sprites/inimigo2.png";
		inimigo3 = "img/sprites/inimigo3.png";
		inicializarInimigos();

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

	public void inicializarInimigos() {

		inimigos = new ArrayList<Sprite>();

		Random random = new Random();

		for (int i = 0; i<20; i++) {
			for (int j = 0 ;j <= 1 ; j++) {
				if (j == 0)
					coordenadas[i][j] = random.nextInt(380)+120;
				else
					coordenadas[i][j] = random.nextInt(800)+470;
			}
			if (i%2 == 0)
				inimigos.add(new Sprite(inimigo1, 3, 3, 4, coordenadas[i][0], coordenadas[i][1]));
			else if (i%3 == 0)
				inimigos.add(new Sprite(inimigo2, 3, 3, 4, coordenadas[i][0], coordenadas[i][1]));
			else 
				inimigos.add(new Sprite(inimigo3, 3, 3, 4, coordenadas[i][0], coordenadas[i][1]));
			
		telaGame.setInimigos(inimigos);
		}
	}

}
