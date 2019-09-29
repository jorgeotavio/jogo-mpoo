package model;

import java.util.List;

public class Hero implements Runnable{
	
	private List<Projectile> projectiles;
	private Sprite sprite;
	
	public Hero(Sprite sprite) {
		
		this.sprite = sprite;
	
	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	public void setProjectiles(List<Projectile> projectiles) {
		this.projectiles = projectiles;
	}
	
	public Sprite getSprite() {
		return sprite;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
