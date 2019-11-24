package model;

import java.awt.Rectangle;
import java.util.HashMap;

public class Hero {

	private Sprite sprite;
	private int velocidade = 2;
	private String direcao;
	private HashMap<String, Integer> comandos;
	private int vida = 100;

	public Hero(Sprite sprite, HashMap<String, Integer> comandos) {
		this.sprite = sprite;
		this.comandos = comandos;
	}

	public void parar() {
		switch(direcao) {
		
		case "UP":
			this.sprite.setPosY(sprite.getPosY()+velocidade);
			break;
		
		case "DOWN":
			this.sprite.setPosY(sprite.getPosY()-velocidade);
			break;
		
		case "LEFT":
			this.sprite.setPosX(sprite.getPosX()+velocidade);
			break;
		
		case "RIGHT":
			this.sprite.setPosX(sprite.getPosX()-velocidade);
			break;

		case "UPRIGHT":
			this.sprite.setPosX(sprite.getPosX()-velocidade);
			this.sprite.setPosY(sprite.getPosY()+velocidade);
			break;
			
		case "UPLEFT":
			this.sprite.setPosX(sprite.getPosX()+velocidade);
			this.sprite.setPosY(sprite.getPosY()+velocidade);
			break;

		case "DOWNRIGHT": 
			this.sprite.setPosX(sprite.getPosX()-velocidade);
			this.sprite.setPosY(sprite.getPosY()-velocidade);
			break;

		case "DOWNLEFT": 
			this.sprite.setPosX(sprite.getPosX()+velocidade);
			this.sprite.setPosY(sprite.getPosY()-velocidade);
			break;
			
		}
	}

	public Sprite getSprite() {
		return this.sprite;
	}

	public Rectangle getRetangulo() {
		return new Rectangle(this.sprite.getPosX()+5, this.sprite.getPosY()+25, 
				this.sprite.getLargura()/2, this.sprite.getAltura()/6);
	}

	public int getVelocidade() {
		return velocidade;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public HashMap<String, Integer> getComandos() {
		return comandos;
	}

	public void setComandos(HashMap<String, Integer> comandos) {
		this.comandos = comandos;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		if(this.vida<100)
			this.vida = vida;
	}

}
