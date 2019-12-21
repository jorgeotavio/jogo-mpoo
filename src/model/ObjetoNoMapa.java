package model;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public class ObjetoNoMapa {

	private String name;
	private BufferedImage imagem;
	private int posX, posY;
	private boolean capturado;
	private Rectangle retangulo;
	private int pontos;
	private boolean objetivo;
	private boolean congelaInimigo;

	public ObjetoNoMapa(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.capturado = false;	
		this.retangulo = new Rectangle(posX, posY, 16, 16);
		this.congelaInimigo = true;
	}

	public ObjetoNoMapa(String name, int posX, int posY, int pontos, boolean objetivo) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.objetivo = objetivo;
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
	
	public boolean isObjetivo() {
		return objetivo;
	}

	public boolean isCongelaInimigo() {
		return congelaInimigo;
	}

	public void setCongelaInimigo(boolean congelaInimigo) {
		this.congelaInimigo = congelaInimigo;
	}
}
