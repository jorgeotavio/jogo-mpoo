package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Sprite;

public class ControllerInimigo {

	private static final int VELOCIDADE = 4;
	private static final int ALTURA_TELA = 130;
	private int[][] coordenadas = new int[50][2];
	private List<Sprite> inimigos;
	
	public ControllerInimigo() {
		inicializarInimigos();
	}
	
	public void mexer(Sprite inimigo) {	
		inimigo.setPosY(inimigo.getPosY()-VELOCIDADE); 
		
		if (inimigo.getPosY() < ALTURA_TELA) {
			inimigo.setVisible(false);
			ControllerGame.perdeu = true;
			ControllerGame.emJogo = false;
		}
	}
	
	public void inicializarInimigos() {
		
		inimigos = new ArrayList<Sprite>();
		
		Random random = new Random();

		for (int i = 0; i<50; i++) {
			for (int j = 0 ;j <= 1 ; j++) {
				if (j == 0)
					coordenadas[i][j] = random.nextInt(380)+120;
				else
					coordenadas[i][j] = random.nextInt(1000)+400;
			}
			inimigos.add(new Sprite("img/heroi/personagem.png", 0, 6, 4, coordenadas[i][0], coordenadas[i][1]));
		}
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
