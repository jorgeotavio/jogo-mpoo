package model;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Item {

	private String name;
	private int quantity;
	private BufferedImage imagem;

	public Item(String name, int quantity, String file) {
		this.name = name;
		this.quantity = quantity;

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

	public int getQuantidade() {
		return quantity;
	}

	public void setQuantidade(int quantity) {
		this.quantity = quantity;
	}
	
	public BufferedImage getImagem() {
		return imagem.getSubimage(0, 0, 19, 35);
	}

}
