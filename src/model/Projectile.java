package model;

public class Projectile extends Sprite implements Mobile{

	public Projectile(String file, int appearance, int columns, int rows, int posX, int posY) {
		super(file, appearance, columns, rows, posX, posY);
		// TODO Auto-generated constructor stub
	}

	public void mexer() {
		this.setPosY(this.getPosY()+5);
	}

}
