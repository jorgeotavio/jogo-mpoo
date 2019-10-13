package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import model.Hero;
import view.ViewGame;

public class ControllerHero extends ControllerMovel implements KeyListener {

	private Hero hero;
	private Hero hero2;
	private HashMap<Integer, Boolean> keyPool;
	private int tipoPlayer;
	
	public ControllerHero(Hero hero, int tipoPlayer) {
		this.hero = hero;
		this.tipoPlayer = tipoPlayer;
		keyPool = new HashMap<Integer, Boolean>();
	}
	
	public void atualizaHero() {
		
		if (keyPool.get(KeyEvent.VK_UP) != null && tipoPlayer ==0) {
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVELOCIDADE());
			hero.setDirecao("up");
        }
        
		if (keyPool.get(KeyEvent.VK_DOWN) != null && tipoPlayer ==0) {
        	hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVELOCIDADE());
			hero.setDirecao("down");
        }
        
        if (keyPool.get(KeyEvent.VK_LEFT) != null && tipoPlayer ==0) {
        	hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVELOCIDADE());
			hero.setDirecao("left");
        }
        
        if (keyPool.get(KeyEvent.VK_RIGHT) != null && tipoPlayer ==0) {
        	hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVELOCIDADE());
			hero.setDirecao("right");
        }
        
        if (keyPool.get(KeyEvent.VK_W) != null && tipoPlayer ==1) {
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVELOCIDADE());
			hero.setDirecao("up");
        }
        
		if (keyPool.get(KeyEvent.VK_S) != null && tipoPlayer ==1) {
        	hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVELOCIDADE());
			hero.setDirecao("down");
        }
        
        if (keyPool.get(KeyEvent.VK_A) != null && tipoPlayer ==1) {
        	hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVELOCIDADE());
			hero.setDirecao("left");
        }
        
        if (keyPool.get(KeyEvent.VK_D) != null && tipoPlayer ==1) {
        	hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVELOCIDADE());
			hero.setDirecao("right");
        }
        
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyPool.put(e.getKeyCode(), true);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyPool.remove(e.getKeyCode());
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Hero getHero2() {
		return hero2;
	}

	public void setHero2(Hero hero2) {
		this.hero2 = hero2;
	}
	
}
