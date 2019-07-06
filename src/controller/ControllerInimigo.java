package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Sprite;

public class ControllerInimigo {

	private Sprite inimigo;
	private static final int VELOCIDADE = 2;
	private static final int LARGURA_TELA = 500;
	private int[][] coordenadas = new int[50][2];
	private List<Sprite> inimigos;
	
	public ControllerInimigo() {
		inicializarInimigos();
	}
	
	public void mexer() {
		inimigo.setPosY(inimigo.getPosY()-VELOCIDADE); 
		if (inimigo.getPosX() > LARGURA_TELA) {
			inimigo.setVisible(false);
		}
	}
	

	public void inicializarInimigos() {
		
		inimigos = new ArrayList<Sprite>();
		
		Random random = new Random();

		for (int i = 0; i<50; i++) {
			for (int j = 0 ;j <= 1 ; j++) {
				if (j == 0)
					coordenadas[i][j] = random.nextInt(600)+100;
				else
					coordenadas[i][j] = random.nextInt(800)+400;
			}
			inimigos.add(new Sprite("img/heroi/personagem.png", 0, 6, 4, coordenadas[i][0], coordenadas[i][1]));
		}
	}

	public Sprite getInimigo() {
		return inimigo;
	}

	public void setInimigo(Sprite inimigo) {
		this.inimigo = inimigo;
	}

	public int[][] getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(int[][] coordenadas) {
		this.coordenadas = coordenadas;
	}

	public List<Sprite> getInimigos() {
		return inimigos;
	}

	public void setInimigos(List<Sprite> inimigos) {
		this.inimigos = inimigos;
	}
	
	
}
