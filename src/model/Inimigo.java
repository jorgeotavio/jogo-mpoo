package model;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

import main.Main;

public class Inimigo extends Movel{
	
	private static final int ALTURA_TELA = 640;
	private static final int VELOCIDADE = 2;
	
	public Inimigo(int posX, int posY) {
		
		this.posX = posX;
		this.posY = posY;
		
		ImageIcon ref;
		
		ref = new ImageIcon(Main.class.getResource("/img/acessorios/flecha.png"));
		
		imagem = ref.getImage();
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
		
		visible = true;
	
	}
	
	public void mexer() {
		if (this.posY < 0) {
			this.posY = ALTURA_TELA;
		} else {
			this.posY -= VELOCIDADE;
		}
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.posX, this.posY, largura, altura);
	}

	@Override
	public int getPosY() {
		return posY;
	}

	@Override
	public int getPosX() {
		return posX;
	}

	@Override
	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public void setPosX(int posX) {
		this.posX = posX;
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
