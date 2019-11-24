package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	private int posX, posY;
	private int altura, largura;
	private boolean visible;
	private Image imagem;
	private BufferedImage spriteSheet;
	private BufferedImage[] sprites;
	private int aparencia;

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
		return sprites;
	}

	public int getAparencia() {
		return aparencia;
	}

	public void setAparencia(int aparencia) {
		this.aparencia = aparencia;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getAltura() {
		return altura;
	}

	public int getLargura() {
		return largura;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Image getImagem() {
		return imagem;
	}

}