package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Destrutor;
import model.Hero;
import model.Map;
import model.Objeto;
import model.Player;

public class GamePanel extends JPanel{
	
	private static final long serialVersionUID = 3027613679265920713L;
	private Hero[] heros = new Hero[2];
	private ArrayList<Map> maps;
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setFont(new Font("Impact", Font.PLAIN, 12));
		
		maps.forEach((map)->{
			
			if (!map.isActivated()) return;
			
			map.getCamadas().forEach((camada)->{
				g2d.drawImage(camada.getCamada(), 0, 0, this);
			});
			
			map.getObjetos().forEach((item)->{
				g2d.drawString("+"+item.getPontos(), item.getPosX()-5, item.getPosY()-5);
				g2d.drawImage(item.getImagem(), item.getPosX(), item.getPosY(), this);
			});
		});
		
		for (int i = 0; i<heros.length; i++) {
			BufferedImage[] sprites = heros[i].getSprite().getSprites();
			
			g2d.drawString(heros[i].getNome(), heros[i].getSprite().getPosX(), heros[i].getSprite().getPosY()-8);
			g2d.drawRect(heros[i].getSprite().getPosX(), heros[i].getSprite().getPosY()-5, 25, 5);
			g2d.fillRect(heros[i].getSprite().getPosX(), heros[i].getSprite().getPosY()-5, heros[i].getVida()/4, 5);
			g2d.drawImage(sprites[heros[i].getSprite().getAparencia()], 
					heros[i].getSprite().getPosX(), heros[i].getSprite().getPosY(), this);
			
			Destrutor.destroyer(sprites);
		}
		
		for (int i = 0; i<heros.length; i++) {
			for(Objeto objeto: heros[i].getInventary().getItems()){
				g2d.drawString(objeto.getNome(), 30, 8);
				g2d.drawImage(objeto.getImagem(), 40, 30, this);
			}
		}
		
		g2d.dispose();
	}
	
	public ArrayList<Map> getMaps() {
		return maps;
	}

	public void setMaps(ArrayList<Map> maps) {
		this.maps = maps;
	}

	public Hero[] getHeros() {
		return heros;
	}

	public void setHeros(Hero[] heros) {
		this.heros = heros;
	}
}
