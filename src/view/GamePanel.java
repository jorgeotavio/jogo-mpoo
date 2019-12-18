package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Camada;
import model.Destrutor;
import model.Hero;
import model.Map;
import model.Objeto;
import model.Player;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = 3027613679265920713L;
	private Hero[] heros = new Hero[2];
	private Map map;

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setFont(new Font("Impact", Font.PLAIN, 12));
		g2d.setColor (new Color(68, 8, 8));

		for(Camada camada: map.getCamadas()){
			g2d.drawImage(camada.getCamada(), 0, 0, this);
		}

		for(Objeto objeto: map.getObjetos()){
			g2d.draw(objeto.getRetangulo());					
			g2d.drawString(objeto.getNome(), objeto.getPosX()+3, objeto.getPosY()+13);
		}

		for (int i = 0; i<heros.length; i++) {
			BufferedImage[] sprites = heros[i].getSprite().getSprites();
			g2d.drawString(heros[i].getNome(), heros[i].getSprite().getPosX(), heros[i].getSprite().getPosY()-8);
			g2d.drawRect(heros[i].getSprite().getPosX(), heros[i].getSprite().getPosY()-5, 25, 5);
			g2d.fillRect(heros[i].getSprite().getPosX(), heros[i].getSprite().getPosY()-5, heros[i].getVida()/4, 5);
			g2d.drawImage(sprites[heros[i].getSprite().getAparencia()], 
					heros[i].getSprite().getPosX(), heros[i].getSprite().getPosY(), this);
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
}
