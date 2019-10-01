package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Hero;
import view.ViewGame;

public class ControllerHero extends ControllerMovel implements KeyListener {
	
	private Hero hero;
	
	public ControllerHero(Hero hero) {
		// TODO Auto-generated constructor stub
		
		this.hero = hero;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			hero.getSprite().setAparencia(2);
		}
		
		if (e.getKeyCode()==KeyEvent.VK_UP){
			hero.getSprite().setPosY(hero.getSprite().getPosY()-VELOCIDADE);
			switch (up) {
			case 0:
				hero.getSprite().setAparencia(0);
				break;
			case 1:
				hero.getSprite().setAparencia(4);
				break;
			case 2:
				hero.getSprite().setAparencia(8);
				break;
			case 3:
				hero.getSprite().setAparencia(12);
				break;
			}
			if (up==3) up=0;
			else up++;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN){
			hero.getSprite().setPosY(hero.getSprite().getPosY()+VELOCIDADE);
			switch (down) {
			case 0:
				hero.getSprite().setAparencia(2);
				break;
			case 1:
				hero.getSprite().setAparencia(6);
				break;
			case 2:
				hero.getSprite().setAparencia(10);
				break;
			case 3:
				hero.getSprite().setAparencia(14);
				break;
			}
			if (down==3) down=0;
			else down++;
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT){
			hero.getSprite().setPosX(hero.getSprite().getPosX()-VELOCIDADE);
			switch (left) {
			case 0:
				hero.getSprite().setAparencia(3);
				break;
			case 1:
				hero.getSprite().setAparencia(7);
				break;
			case 2:
				hero.getSprite().setAparencia(11);
				break;
			case 3:
				hero.getSprite().setAparencia(15);
				break;
			}
			if (left==3) left=0;
			else left++;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT){
			hero.getSprite().setPosX(hero.getSprite().getPosX()+VELOCIDADE);
			switch (right) {
			case 0:
				hero.getSprite().setAparencia(1);
				break;
			case 1:
				hero.getSprite().setAparencia(5);
				break;
			case 2:
				hero.getSprite().setAparencia(9);
				break;
			case 3:
				hero.getSprite().setAparencia(13);
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
