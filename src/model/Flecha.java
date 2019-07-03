package model;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Flecha extends Movel {

	private static final int LARGURA_TELA = 500;
	private static final int VELOCIDADE = 20;

	public Flecha(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;

		ImageIcon referencia = new ImageIcon("img/acessorios/flecha.png");
		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);

		visible = true;
	}
	
	public void mexer() {
		this.posY += VELOCIDADE;
		if (this.posX > LARGURA_TELA) {
			visible = false;
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(posX, posY, largura, altura);
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
	
	@Override
	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public void setPosX(int posX) {
		this.posX = posX;
	}

}