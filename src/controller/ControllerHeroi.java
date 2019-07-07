package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Flecha;
import model.Sprite;

public class ControllerHeroi extends ControllerMovel implements KeyListener {
	
	public ControllerHeroi(Sprite heroi) {
		this.sprite = heroi;
	}
	
	public void parar() {
		
		if (sprite.getPosX() > 610) {
			sprite.setPosX(610);
		}
		
		if (sprite.getPosX() <1 ) {
			sprite.setPosX(1);
		}
		
		if (sprite.getPosY() > 430) {
			sprite.setPosY(430);
		}
		
		if (sprite.getPosY() < 130 ) {
			sprite.setPosY(130);
		}
	}
	
	public void atira() {
		sprite.getFlechas().add((new Flecha(sprite.getPosX()+sprite.getLargura()/3, 
				sprite.getPosY() + sprite.getAltura()/6)));
	}
	
	public void keyPressed(KeyEvent e) {
		parar();
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			sprite.setAparencia(2);
			atira();
		}
		
		if (e.getKeyCode()==KeyEvent.VK_UP){
			sprite.setPosY(sprite.getPosY()-velocidade);
			switch (up) {
			case 0:
				sprite.setAparencia(0);
				break;
			case 1:
				sprite.setAparencia(4);
				break;
			case 2:
				sprite.setAparencia(8);
				break;
			case 3:
				sprite.setAparencia(12);
				break;
			}
			if (up==3) up=0;
			else up++;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN){
			sprite.setPosY(sprite.getPosY()+velocidade);
			switch (down) {
			case 0:
				sprite.setAparencia(2);
				break;
			case 1:
				sprite.setAparencia(6);
				break;
			case 2:
				sprite.setAparencia(10);
				break;
			case 3:
				sprite.setAparencia(14);
				break;
			}
			if (down==3) down=0;
			else down++;
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT){
			sprite.setPosX(sprite.getPosX()-velocidade);
			switch (left) {
			case 0:
				sprite.setAparencia(3);
				break;
			case 1:
				sprite.setAparencia(7);
				break;
			case 2:
				sprite.setAparencia(11);
				break;
			case 3:
				sprite.setAparencia(15);
				break;
			}
			if (left==3) left=0;
			else left++;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT){
			sprite.setPosX(sprite.getPosX()+velocidade);
			switch (right) {
			case 0:
				sprite.setAparencia(1);
				break;
			case 1:
				sprite.setAparencia(5);
				break;
			case 2:
				sprite.setAparencia(9);
				break;
			case 3:
				sprite.setAparencia(13);
				break;
			}
			if (right==3) right=0;
			else right++;			
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
