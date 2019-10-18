package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import model.Hero;
import view.ViewGame;

public class ControllerHero extends ControllerMovel implements KeyListener {

	private Hero hero;
	private HashMap<Integer, Boolean> keyPool;
	private int tipoPlayer;

	public ControllerHero(Hero hero, int tipoPlayer) {
		this.hero = hero;
		this.tipoPlayer = tipoPlayer;
		keyPool = new HashMap<Integer, Boolean>();
	}

	public boolean atualizaHero() {
		if (keyPool.get(KeyEvent.VK_UP) != null && keyPool.get(KeyEvent.VK_RIGHT) != null && tipoPlayer ==0) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVELOCIDADE());
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVELOCIDADE());
			hero.setDirecao("diagonalUpRight");
			atualizarAparencia("upRight");
			return true;
		}

		if (keyPool.get(KeyEvent.VK_UP) != null && keyPool.get(KeyEvent.VK_LEFT) != null && tipoPlayer ==0) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVELOCIDADE());
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVELOCIDADE());
			hero.setDirecao("diagonalUpLeft");
			atualizarAparencia("upLeft");
			return true;
		}

		if (keyPool.get(KeyEvent.VK_DOWN) != null && keyPool.get(KeyEvent.VK_RIGHT) != null && tipoPlayer ==0) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVELOCIDADE());
			hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVELOCIDADE());
			hero.setDirecao("diagonalDownRight");
			atualizarAparencia("downRight");
			return true;
		}

		if (keyPool.get(KeyEvent.VK_DOWN) != null && keyPool.get(KeyEvent.VK_LEFT) != null && tipoPlayer ==0) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVELOCIDADE());
			hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVELOCIDADE());
			hero.setDirecao("diagonalDownLeft");
			atualizarAparencia("downLeft");
			return true;
		}

		if (keyPool.get(KeyEvent.VK_UP) != null && tipoPlayer ==0) {
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVELOCIDADE());
			hero.setDirecao("up");
			atualizarAparencia("up");
		}

		if (keyPool.get(KeyEvent.VK_DOWN) != null && tipoPlayer ==0 ) {
			hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVELOCIDADE());
			hero.setDirecao("down");
			atualizarAparencia("down");
		}

		if (keyPool.get(KeyEvent.VK_LEFT) != null && tipoPlayer ==0) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVELOCIDADE());
			hero.setDirecao("left");
			atualizarAparencia("left");
		}

		if (keyPool.get(KeyEvent.VK_RIGHT) != null && tipoPlayer ==0) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVELOCIDADE());
			hero.setDirecao("right");
			atualizarAparencia("right");
		}

		if (keyPool.get(KeyEvent.VK_W) != null && keyPool.get(KeyEvent.VK_D) != null && tipoPlayer ==1) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVELOCIDADE());
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVELOCIDADE());
			hero.setDirecao("diagonalUpRight");
			atualizarAparencia("upRight");
			return true;
		}

		if (keyPool.get(KeyEvent.VK_W) != null && keyPool.get(KeyEvent.VK_A) != null && tipoPlayer ==1) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVELOCIDADE());
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVELOCIDADE());
			hero.setDirecao("diagonalUpLeft");
			atualizarAparencia("upLeft");
			return true;
		}

		if (keyPool.get(KeyEvent.VK_S) != null && keyPool.get(KeyEvent.VK_D) != null && tipoPlayer ==1) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVELOCIDADE());
			hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVELOCIDADE());
			hero.setDirecao("diagonalDownRight");
			atualizarAparencia("downRight");
			return true;
		}

		if (keyPool.get(KeyEvent.VK_S) != null && keyPool.get(KeyEvent.VK_A) != null && tipoPlayer ==1) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVELOCIDADE());
			hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVELOCIDADE());
			hero.setDirecao("diagonalDownLeft");
			atualizarAparencia("downLeft");
			return true;
		}

		if (keyPool.get(KeyEvent.VK_W) != null && tipoPlayer ==1) {
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVELOCIDADE());
			hero.setDirecao("up");
			atualizarAparencia("up");
		}

		if (keyPool.get(KeyEvent.VK_S) != null && tipoPlayer ==1) {
			hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVELOCIDADE());
			hero.setDirecao("down");
			atualizarAparencia("down");
		}

		if (keyPool.get(KeyEvent.VK_A) != null && tipoPlayer ==1) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVELOCIDADE());
			hero.setDirecao("left");
			atualizarAparencia("left");
		}

		if (keyPool.get(KeyEvent.VK_D) != null && tipoPlayer ==1) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVELOCIDADE());
			hero.setDirecao("right");
			atualizarAparencia("right");
		}

		return false;

	}

	public void atualizarAparencia(String direcao) {
		if (direcao == "up") {			
			switch (up) {
			case 0:
				hero.getSprite().setAparencia(3);
				break;
			case 1:
				hero.getSprite().setAparencia(7);
				break;
			case 2:
				hero.getSprite().setAparencia(11);
				break;
			}
			if (up==2) up=0;
			else up++;
		}

		if(direcao == "down") {			
			switch (down) {
			case 0:
				hero.getSprite().setAparencia(0);
				break;
			case 1:
				hero.getSprite().setAparencia(4);
				break;
			case 2:
				
				hero.getSprite().setAparencia(8);
				break;
			}

			if (down==2) down=0;
			else down++;
		}

		if ( direcao == "right") {			
			switch (left) {
			case 0:
				hero.getSprite().setAparencia(2);
				break;
			case 1:
				hero.getSprite().setAparencia(6);
				break;
			case 2:
				hero.getSprite().setAparencia(10);
				break;
			}
			if (left==2) left=0;
			else left++;
		}

		if (direcao == "left") {			
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
			}
			if (right==2) right=0;
			else right++;			
		}
		
		if (direcao == "upRight") {			
			switch (upRight) {
			case 0:
				hero.getSprite().setAparencia(15);
				break;
			case 1:
				hero.getSprite().setAparencia(19);
				break;
			case 2:
				hero.getSprite().setAparencia(23);
				break;
			}
			if (upRight==2) upRight=0;
			else upRight++;			
		}
		
		if (direcao == "upLeft") {			
			switch (upLeft) {
			case 0:
				hero.getSprite().setAparencia(13);
				break;
			case 1:
				hero.getSprite().setAparencia(17);
				break;
			case 2:
				hero.getSprite().setAparencia(21);
				break;
			}
			if (upLeft==2) upLeft=0;
			else upLeft++;			
		}
		
		if (direcao == "downRight") {			
			switch (downRight) {
			case 0:
				hero.getSprite().setAparencia(14);
				break;
			case 1:
				hero.getSprite().setAparencia(18);
				break;
			case 2:
				hero.getSprite().setAparencia(22);
				break;
			}
			if (downRight==2) downRight=0;
			else downRight++;			
		}
		
		if (direcao == "downLeft") {			
			switch (downLeft) {
			case 0:
				hero.getSprite().setAparencia(12);
				break;
			case 1:
				hero.getSprite().setAparencia(16);
				break;
			case 2:
				hero.getSprite().setAparencia(20);
				break;
			}
			if (downLeft==2) downLeft=0;
			else downLeft++;			
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

}
