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

public class Sprite extends Movel{

	private BufferedImage spriteSheet;
	private BufferedImage[] sprites;
	private int aparencia;
	private List<Flecha> flechas;

	public Sprite(String arquivo, int aparencia, int columns, int rows, int posX, int posY) {
		try {
			spriteSheet = ImageIO.read(new File(arquivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.aparencia=aparencia;

		flechas = new ArrayList<Flecha>();

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

	public void mexer() {	
		int up = 0;
		this.setPosY(this.getPosY()-4);

		if (this.getPosY() < 100) {
			this.setVisible(false);
		}

		switch (up) {
		case 0:
			this.setAparencia(3);
			break;
		case 1:
			this.setAparencia(7);
			break;
		case 2:
			this.setAparencia(11);
			break;
		}

		if (up==2) up=0; else up++;
	}

	
	public List<Flecha> getFlechas(){
		return flechas;
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

	@Override
	public int getPosX() {
		return posX;
	}

	@Override
	public void setPosX(int posX) {
		this.posX = posX;
	}

	@Override
	public int getPosY() {
		return posY;
	}

	@Override
	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(posX, posY, largura-17, altura-17);
	}

	@Override
	public int getAltura() {
		return altura;
	}

	@Override
	public int getLargura() {
		return largura;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public Image getImagem() {
		return imagem;
	}

}
