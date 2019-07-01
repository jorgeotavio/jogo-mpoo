package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Bala;
import model.Sprite;

public class ControllerHeroi extends KeyAdapter implements Runnable {
	
	private int up, down, left, right;
	private Sprite heroi;
	private int velocidade=2;
	
	public ControllerHeroi(Sprite heroi) {
		this.heroi = heroi;
	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode()== KeyEvent.VK_SHIFT) {
			this.velocidade = 4;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			heroi.setAparencia(0);
			heroi.atirar(new Bala(heroi.getPosX()+heroi.getLargura()/3, 
					heroi.getPosY() + heroi.getAltura()/6));
		}

		if (e.getKeyCode()==KeyEvent.VK_UP){
			heroi.setPosY(heroi.getPosY()-velocidade);
			switch (up) {
			case 0:
				heroi.setAparencia(0);
				break;
			case 1:
				heroi.setAparencia(4);
				break;
			case 2:
				heroi.setAparencia(8);
				break;
			case 3:
				heroi.setAparencia(12);
				break;
			}
			if (up==3) up=0;
			else up++;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN){
			heroi.setPosY(heroi.getPosY()+velocidade);
			switch (down) {
			case 0:
				heroi.setAparencia(2);
				break;
			case 1:
				heroi.setAparencia(6);
				break;
			case 2:
				heroi.setAparencia(10);
				break;
			case 3:
				heroi.setAparencia(14);
				break;
			}
			if (down==3) down=0;
			else down++;
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT){
			heroi.setPosX(heroi.getPosX()-velocidade);
			switch (left) {
			case 0:
				heroi.setAparencia(3);
				break;
			case 1:
				heroi.setAparencia(7);
				break;
			case 2:
				heroi.setAparencia(11);
				break;
			case 3:
				heroi.setAparencia(15);
				break;
			}
			if (left==3) left=0;
			else left++;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT){
			heroi.setPosX(heroi.getPosX()+velocidade);
			switch (right) {
			case 0:
				heroi.setAparencia(1);
				break;
			case 1:
				heroi.setAparencia(5);
				break;
			case 2:
				heroi.setAparencia(9);
				break;
			case 3:
				heroi.setAparencia(13);
				break;
			}
			if (right==3) right=0;
			else right++;			
		}


	}

	@Override
	public void run() {
		
	}

}
