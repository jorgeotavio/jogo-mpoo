package model;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class Movel {
	
	protected int posX, posY;
	protected int altura, largura;
	protected boolean visible;
	protected Image imagem;
	
	public abstract Rectangle getBounds();
	public abstract int getPosY();
	public abstract int getPosX();
	public abstract void setPosY(int posY);
	public abstract void setPosX(int posX);
	public abstract int getAltura();
	public abstract int getLargura();
	public abstract boolean isVisible();
	public abstract void setVisible(boolean visible);
	public abstract Image getImagem();

}
