package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import model.Hero;

public class ControllerHero extends ControllerMovel implements KeyListener {

	private Hero hero;
	private HashMap<Integer, Boolean> keyPool;

	public ControllerHero(Hero hero) {
		this.hero = hero;
		keyPool = new HashMap<Integer, Boolean>();
	}

	public void atualizaHero() {
		
		if (hero.isCongelar()) return;
		
		if (keyPool.get(hero.getComandos().get(UP)) != null && keyPool.get(hero.getComandos().get(RIGHT)) != null) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVelocidade());
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVelocidade());
			hero.setDirecao(UPRIGHT);
			atualizarAparencia(UPRIGHT);
			
		}else if (keyPool.get(hero.getComandos().get(UP)) != null && keyPool.get(hero.getComandos().get(LEFT)) != null) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVelocidade());
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVelocidade());
			hero.setDirecao(UPLEFT);
			atualizarAparencia(UPLEFT);
		
		}else if (keyPool.get(hero.getComandos().get(DOWN)) != null && keyPool.get(hero.getComandos().get(RIGHT)) != null) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVelocidade());
			hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVelocidade());
			hero.setDirecao(DOWNRIGHT);
			atualizarAparencia(DOWNRIGHT);
		
		}else if (keyPool.get(hero.getComandos().get(DOWN)) != null && keyPool.get(hero.getComandos().get(LEFT)) != null) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVelocidade());
			hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVelocidade());
			hero.setDirecao(DOWNLEFT);
			atualizarAparencia(DOWNLEFT);
		
		}else if (keyPool.get(hero.getComandos().get(UP)) != null) {
			hero.getSprite().setPosY(hero.getSprite().getPosY()-hero.getVelocidade());
			hero.setDirecao(UP);
			atualizarAparencia(UP);
		
		}else if (keyPool.get(hero.getComandos().get(DOWN)) != null) {
			hero.getSprite().setPosY(hero.getSprite().getPosY()+hero.getVelocidade());
			hero.setDirecao(DOWN);
			atualizarAparencia(DOWN);
		
		}else if (keyPool.get(hero.getComandos().get(LEFT)) != null) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()-hero.getVelocidade());
			hero.setDirecao(LEFT);
			atualizarAparencia(LEFT);
		
		}else if (keyPool.get(hero.getComandos().get(RIGHT)) != null) {
			hero.getSprite().setPosX(hero.getSprite().getPosX()+hero.getVelocidade());
			hero.setDirecao(RIGHT);
			atualizarAparencia(RIGHT);
		}
	}

	public void atualizarAparencia(String direcao) {
		if (direcao == UP) {
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

		if(direcao == DOWN) {
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

		if ( direcao == LEFT) {
			switch (left) {
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
			if (left==2) left=0;
			else left++;
		}

		if (direcao == RIGHT) {
			switch (right) {
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
			
			if (right==2) right=0;
			else right++;
		}

		if (direcao == UPRIGHT) {
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

		if (direcao == UPLEFT) {
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

		if (direcao == DOWNRIGHT) {
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

		if (direcao == DOWNLEFT) {
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

	public HashMap<Integer, Boolean> getKeyPool() {
		return keyPool;
	}

	public void setKeyPool(HashMap<Integer, Boolean> keyPool) {
		this.keyPool = keyPool;
	}
}
