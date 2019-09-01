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
	
	private int largura, altura;
	private int posX, posY;
	private BufferedImage spriteSheet;
	private BufferedImage[] sprites;
	private int aparencia;
	private boolean visible;
	protected Image imagem;

	public Sprite(String arquivo, int aparencia, int columns, int rows, int posX, int posY) {
		try {
			spriteSheet = ImageIO.read(new File(arquivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.aparencia=aparencia;

		this.largura = spriteSheet.getWidth()/columns;
		this.altura = spriteSheet.getHeight()/rows;

		this.posX=posX;
		this.posY=posY;

		visible = true;

		sprites = new BufferedImage[columns * rows];
		for(int i = 0; i < columns; i++) {
			for(int j = 0; j < rows; j++) {
				sprites[(i * rows) + j] = spriteSheet.getSubimage(i * largura, j * altura, largura, altura);
			}
		}
	}


	public BufferedImage[] getSprites() {
		return this.sprites;
	}

	public int getAparencia() {
		return this.aparencia;
	}

	public void setAparencia(int aparencia) {
		this.aparencia = aparencia;
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
		return new Rectangle(posX, posY, largura-17, altura-17);
	}

	public int getAltura() {
		return this.altura;
	}

	public int getLargura() {
		return this.largura;
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
