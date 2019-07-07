package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Sprite;

public class ControllerInimigo extends ControllerMovel{

	private int[][] coordenadas = new int[50][2];
	private List<Sprite> inimigos;
	private String inimigo1, inimigo2, inimigo3;
	
	public ControllerInimigo() {
		inimigo1 = "img/sprites/inimigo1.png";
		inimigo2 = "img/sprites/inimigo2.png";
		inimigo3 = "img/sprites/inimigo3.png";
		inicializarInimigos();
	}
	
	public void mexer(Sprite inimigo) {	
		
		inimigo.setPosY(inimigo.getPosY()-VELOCIDADE); 
		
		switch (up) {
		case 0:
			inimigo.setAparencia(3);
			break;
		case 1:
			inimigo.setAparencia(7);
			break;
		case 2:
			inimigo.setAparencia(11);
			break;
		}
		
		if (up==1) up=0; else up++;
		
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
					coordenadas[i][j] = random.nextInt(1000)+470;
			}
			if (i%2 == 0)
				inimigos.add(new Sprite(inimigo1, 3, 3, 4, coordenadas[i][0], coordenadas[i][1]));
			else if (i%3 == 0)
				inimigos.add(new Sprite(inimigo2, 3, 3, 4, coordenadas[i][0], coordenadas[i][1]));
			else 
				inimigos.add(new Sprite(inimigo3, 3, 3, 4, coordenadas[i][0], coordenadas[i][1]));
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
