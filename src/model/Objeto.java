package model;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public class Objeto {

	private String name;
	private BufferedImage imagem;
	private int posX, posY;
	private boolean capturado;
	private Rectangle retangulo;
	private int pontos;

	public Objeto(String name, String file, int posX, int posY, int pontos) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.pontos = pontos;
		this.capturado = false;
		
		this.retangulo = new Rectangle(posX, posY, 16, 16);
		
		try {
			this.imagem = ImageIO.read(new File(file));
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}

	public Objeto(String name, int posX, int posY, int pontos) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.pontos = pontos;
		this.capturado = false;
		this.retangulo = new Rectangle(posX, posY, 16, 16);
	}

	public String getNome() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public BufferedImage getImagem() {
		return imagem;
	}

	public Rectangle getRetangulo() {
		return retangulo;
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

	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

}
