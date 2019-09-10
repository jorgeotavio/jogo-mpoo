package model;

import java.util.List;

public class Hero extends Sprite implements Mobile, Runnable{
	
	private List<Projectile> projectiles;
	
	public Hero(String file, int appearance, int columns, int rows, int posX, int posY) {
		super(file, appearance, columns, rows, posX, posY);
	}
	
	public void mexer() {	
		int up = 0;
		this.setPosY(this.getPosY()-4);

		if (this.getPosY() < 100) {
			this.setVisible(false);
		}

		switch (up) {
		case 0:
			this.setAppearance(3);
			break;
		case 1:
			this.setAppearance(7);
			break;
		case 2:
			this.setAppearance(11);
			break;
		}

		if (up==2) up=0; else up++;
	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	public void setProjectiles(List<Projectile> projectiles) {
		this.projectiles = projectiles;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
