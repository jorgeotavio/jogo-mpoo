package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.Camada;
import model.Destrutor;
import model.Hero;
import model.Map;
import model.ObjetoNoMapa;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = 3027613679265920713L;
	private Hero[] heros = new Hero[2];
	private Map map;
	private Font font;

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setFont(font.deriveFont(Font.PLAIN, 15));

		for(Camada camada: map.getCamadas()){
			g2d.drawImage(camada.getCamada(), 0, 0, this);
		}

		for(ObjetoNoMapa objeto: map.getObjetos()){
			if(objeto.isCongelaInimigo()) {
				g2d.fillOval(objeto.getRetangulo().x, objeto.getRetangulo().y, objeto.getRetangulo().width, objeto.getRetangulo().height);
			}else {
				g2d.drawString(objeto.getNome(), objeto.getPosX(), objeto.getPosY()+13);
				g2d.draw(objeto.getRetangulo());				
			}
		}

		for (int i = 0; i<heros.length; i++) {
			BufferedImage[] sprites = heros[i].getSprite().getSprites();
			g2d.setColor(new Color(0, 0, 0));
			g2d.drawString(heros[i].getNome(), heros[i].getSprite().getPosX()-10, heros[i].getSprite().getPosY()-8);
			g2d.drawRect(heros[i].getSprite().getPosX(), heros[i].getSprite().getPosY()-5, 25, 5);
			g2d.fillRect(heros[i].getSprite().getPosX(), heros[i].getSprite().getPosY()-5, heros[i].getVida()/4, 5);
			g2d.drawImage(sprites[heros[i].getSprite().getAparencia()], 
					heros[i].getSprite().getPosX(), heros[i].getSprite().getPosY(), this);
			
			g2d.setColor(new Color(166, 0, 0));
			
			if(heros[i].isCongelar()) {
				g2d.drawString("STOP"+Integer.toString(heros[i].getTempoCongelado()), heros[i].getSprite().getPosX()-10, heros[i].getSprite().getPosY()+45);
			}
			
			Destrutor.destroyer(sprites);
		}

		g2d.dispose();
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Hero[] getHeros() {
		return heros;
	}

	public void setHeros(Hero[] heros) {
		this.heros = heros;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}
}
