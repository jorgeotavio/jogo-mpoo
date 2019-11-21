package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import model.Hero;

public class ControllerHero extends ControllerMovel implements KeyListener {

	private Hero hero;
	private HashMap<Integer, Boolean> keyPool;
	private HashMap<String, Integer> comandos;
	private int tipoPlayer;

	public ControllerHero(Hero hero, int tipoPlayer) {
		this.hero = hero;
		this.tipoPlayer = tipoPlayer;
		keyPool = new HashMap<Integer, Boolean>();
		comandos =  this.hero.getComandos();
	}

	public void atualizaHero() {
		if (keyPool.get(comandos.get("UP")) != null && keyPool.get(comandos.get("RIGHT")) != null) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVELOCIDADE());
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVELOCIDADE());
			hero.setDirecao("upRight");
			atualizarAparencia("upRight");
			
		}else if (keyPool.get(comandos.get("UP")) != null && keyPool.get(comandos.get("LEFT")) != null) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVELOCIDADE());
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVELOCIDADE());
			hero.setDirecao("upLeft");
			atualizarAparencia("upLeft");
		
		}else if (keyPool.get(comandos.get("DOWN")) != null && keyPool.get(comandos.get("RIGHT")) != null) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVELOCIDADE());
			hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVELOCIDADE());
			hero.setDirecao("downRight");
			atualizarAparencia("downRight");
		
		}else if (keyPool.get(comandos.get("DOWN")) != null && keyPool.get(comandos.get("LEFT")) != null) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVELOCIDADE());
			hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVELOCIDADE());
			hero.setDirecao("downLeft");
			atualizarAparencia("downLeft");
		
		}else if (keyPool.get(comandos.get("UP")) != null) {
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVELOCIDADE());
			hero.setDirecao("up");
			atualizarAparencia("up");
		
		}else if (keyPool.get(comandos.get("DOWN")) != null) {
			hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVELOCIDADE());
			hero.setDirecao("down");
			atualizarAparencia("down");
		
		}else if (keyPool.get(comandos.get("LEFT")) != null) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVELOCIDADE());
			hero.setDirecao("left");
			atualizarAparencia("left");
		
		}else if (keyPool.get(comandos.get("RIGHT")) != null) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVELOCIDADE());
			hero.setDirecao("right");
			atualizarAparencia("right");
		}
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
