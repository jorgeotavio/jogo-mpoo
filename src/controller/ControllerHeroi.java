package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Flecha;
import model.Sprite;

public class ControllerHeroi extends KeyAdapter implements Runnable {
	
	private int up, down, left, right;
	private Sprite heroi;
	private int velocidade=4;

	public ControllerHeroi(Sprite heroi) {
		this.heroi = heroi;
	}
	
	public void parar() {
		
		if (heroi.getPosX() > 610) {
			heroi.setPosX(610);
		}
		
		if (heroi.getPosX() <1 ) {
			heroi.setPosX(1);
		}
		
		if (heroi.getPosY() > 430) {
			heroi.setPosY(430);
		}
		
		if (heroi.getPosY() < 130 ) {
			heroi.setPosY(130);
		}
	}
	
	public void atira() {
		heroi.atirar(new Flecha(heroi.getAltura() + heroi.getLargura(), heroi.getPosY() + heroi.getAltura()/3));
	}
	
	public void keyPressed(KeyEvent e) {
		
		parar();
		
		if (e.getKeyCode()== KeyEvent.VK_SHIFT) {
			this.velocidade = 4;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			heroi.setAparencia(2);
			heroi.atirar(new Flecha(heroi.getPosX()+heroi.getLargura()/3, 
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
