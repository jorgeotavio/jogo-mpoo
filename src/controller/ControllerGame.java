package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Bala;
import model.Sprite;
import view.TelaGame;

public class ControllerGame extends KeyAdapter {

	TelaGame telaGame;
	Sprite personagem;
	int up, down, left, right;
	int velocidade = 2;

	public ControllerGame(TelaGame telaGame,  Sprite personagem) {
		this.telaGame = telaGame;
		this.personagem = personagem;
	}

	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode()== KeyEvent.VK_SHIFT) {
			this.velocidade = 4;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			personagem.setAparencia(0);
			personagem.atirar(new Bala(personagem.getPosX()+personagem.getLargura()/3, 
					personagem.getPosY() + personagem.getAltura()/6));
		}

		if (e.getKeyCode()==KeyEvent.VK_UP){
			personagem.setPosY(personagem.getPosY()-velocidade);
			switch (up) {
			case 0:
				personagem.setAparencia(0);
				break;
			case 1:
				personagem.setAparencia(4);
				break;
			case 2:
				personagem.setAparencia(8);
				break;
			case 3:
				personagem.setAparencia(12);
				break;
			}
			if (up==3) up=0;
			else up++;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN){
			personagem.setPosY(personagem.getPosY()+velocidade);
			switch (down) {
			case 0:
				personagem.setAparencia(2);
				break;
			case 1:
				personagem.setAparencia(6);
				break;
			case 2:
				personagem.setAparencia(10);
				break;
			case 3:
				personagem.setAparencia(14);
				break;
			}
			if (down==3) down=0;
			else down++;
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT){
			personagem.setPosX(personagem.getPosX()-velocidade);
			switch (left) {
			case 0:
				personagem.setAparencia(3);
				break;
			case 1:
				personagem.setAparencia(7);
				break;
			case 2:
				personagem.setAparencia(11);
				break;
			case 3:
				personagem.setAparencia(15);
				break;
			}
			if (left==3) left=0;
			else left++;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT){
			personagem.setPosX(personagem.getPosX()+velocidade);
			switch (right) {
			case 0:
				personagem.setAparencia(1);
				break;
			case 1:
				personagem.setAparencia(5);
				break;
			case 2:
				personagem.setAparencia(9);
				break;
			case 3:
				personagem.setAparencia(13);
				break;
			}
			if (right==3) right=0;
			else right++;			
		}


	}


}