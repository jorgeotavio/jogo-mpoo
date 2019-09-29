package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	private int larguraPersonagem, alturaPersonagem;

	protected BufferedImage personagem;
	protected int largura, altura;
	protected int linhas, colunas;
	private int posX, posY;
	private BufferedImage[] sprites;
	private int aparencia;
	private boolean visible;

	public Sprite(int aparencia, int largura, int altura, int colunas, int linhas, int x, int y, String endereco) 
			throws IOException {

		try {
			
			this.personagem = ImageIO.read(getClass().getClassLoader().getResourceAsStream(endereco));
			this.aparencia = aparencia;
			this.largura = largura;
			this.altura = altura;

			this.linhas = colunas;
			this.colunas = linhas;
			this.posX = x;
			this.posY = y;
			
			this.visible = true;
			
			sprites = new BufferedImage[colunas * linhas];

			for (int i = 0; i < colunas; i++) {
				for (int j = 0; j < linhas; j++) {
					sprites[(i * linhas) + j] = personagem.getSubimage(i * (largura/colunas), 
							j * (altura/linhas), largura/colunas, altura/linhas);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel carregar a Sprite");
		}

		larguraPersonagem = sprites[0].getWidth();
		alturaPersonagem = sprites[0].getHeight();
	}

	public BufferedImage getPersonagem() {
		return personagem;
	}


	public int getAparencia() {
		return aparencia;
	}

	public void setAparencia(int aparencia) {
		this.aparencia = aparencia;
	}

	public BufferedImage[] getSprites() {
		return sprites;
	}

	public int getLarguraPersonagem() {
		return larguraPersonagem;
	}

	public int getAlturaPersonagem() {
		return alturaPersonagem;
	}

	public Rectangle getBounds() {
		return new Rectangle(posX+5, posY+5, larguraPersonagem-10, alturaPersonagem-10);
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
}