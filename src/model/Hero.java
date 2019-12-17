package model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Rectangle;
import java.util.HashMap;

public class Hero {

	private String nome;
	private Sprite sprite;
	private int velocidade = 2;
	private String direcao;
	private HashMap<String, Integer> comandos;
	private int vida = 100;
	private Inventary inventary;
	private Rectangle retangulo;
	private AudioClip pegarObjeto;
	private boolean congelar = false;

	public Hero(String nome, Sprite sprite, HashMap<String, Integer> comandos) {
		this.sprite = sprite;
		this.comandos = comandos;
		this.nome = nome;
		this.inventary = new Inventary();
		this.pegarObjeto = Applet.newAudioClip(Som.class.getResource("/sounds/pegar_objeto.wav"));
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
	
	public void somPegandoObjeto() {
		this.pegarObjeto.play();
	}

	public Sprite getSprite() {
		return this.sprite;
	}

	public Rectangle getRetangulo() {
		this.retangulo = new Rectangle(this.sprite.getPosX()+5, this.sprite.getPosY()+25, 
										this.sprite.getLargura()/2, this.sprite.getAltura()/6);
		return retangulo;
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
		if(vida <= 100 && vida >= 0)
			this.vida = vida;
	}

	public Inventary getInventary() {
		return inventary;
	}

	public String getNome() {
		return nome;
	}

	public boolean isCongelar() {
		return congelar;
	}

	public void setCongelar(boolean congelar) {
		this.congelar = congelar;
	}
}
