package model;

import java.awt.geom.Rectangle2D;
import java.util.List;

public class Hero {
	
	private List<Projectile> projectiles;
	private Sprite sprite;
	private Rectangle2D retangulo;
	
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


	public Rectangle2D getRetangulo() {
		return retangulo;
	}


	public void setRetangulo(Rectangle2D retangulo) {
		this.retangulo = retangulo;
	}

	
}
