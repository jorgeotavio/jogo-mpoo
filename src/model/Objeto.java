package model;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Objeto {

	private String name;
	private BufferedImage imagem;
	private int posX, posY;
	private boolean capturado;
	
	public Objeto(String name, String file, int posX, int posY) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.capturado = false;
		
		try {
			this.imagem = ImageIO.read(new File(file));
		}catch(Exception e ) {
			e.printStackTrace();
		}
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
		return new Rectangle(this.posX, this.posY, this.imagem.getWidth(), this.imagem.getHeight());
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
	
}