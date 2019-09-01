package model;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import controller.ControllerGame;

public class Sprite{
	
	private int width, heigth;
	private int posX, posY;
	private BufferedImage spriteSheet;
	private BufferedImage[] sprites;
	private int appearance;
	private boolean visible;
	protected Image imagem;
	
	public Sprite(String arquivo, int appearance, int columns, int rows, int posX, int posY) {
		try {
			spriteSheet = ImageIO.read(new File(arquivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.appearance=appearance;

		this.width = spriteSheet.getWidth()/columns;
		this.heigth = spriteSheet.getHeight()/rows;

		this.posX=posX;
		this.posY=posY;

		visible = true;

		sprites = new BufferedImage[columns * rows];
		for(int i = 0; i < columns; i++) {
			for(int j = 0; j < rows; j++) {
				sprites[(i * rows) + j] = spriteSheet.getSubimage(i * width, j * heigth, width, heigth);
			}
		}
	}


	public BufferedImage[] getSprites() {
		return this.sprites;
	}

	public int getAparencia() {
		return this.appearance;
	}

	public void setAparencia(int aparencia) {
		this.appearance = aparencia;
	}

	public int getPosX() {
		return this.posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Rectangle getBounds() {
		return new Rectangle(posX, posY, width-17, heigth-17);
	}

	public int getAltura() {
		return this.heigth;
	}

	public int getLargura() {
		return this.width;
	}

	public boolean isVisible() {
		return this.visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Image getImagem() {
		return imagem;
	}

}
