package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Map;
import model.Player;

public class GamePanel extends JPanel{
	
	private static final long serialVersionUID = 3027613679265920713L;
	private Player[] players = new Player[2];
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
		
		for (int i = 0; i<players.length; i++) {
			BufferedImage[] sprites = players[i].getHero().getSprite().getSprites();
			g2d.drawString(players[i].getName(), players[i].getHero().getSprite().getPosX(), players[i].getHero().getSprite().getPosY()-8);
			g2d.drawRect(players[i].getHero().getSprite().getPosX(), players[i].getHero().getSprite().getPosY()-5, 25, 5);
			g2d.fillRect(players[i].getHero().getSprite().getPosX(), players[i].getHero().getSprite().getPosY()-5, players[i].getHero().getVida()/4, 5);
			g2d.drawImage(sprites[players[i].getHero().getSprite().getAparencia()], 
					players[i].getHero().getSprite().getPosX(), players[i].getHero().getSprite().getPosY(), this);
			sprites = null;
			System.gc();
		}
		g2d.dispose();
	}
	
	public ArrayList<Map> getMaps() {
		return maps;
	}

	public void setMaps(ArrayList<Map> maps) {
		this.maps = maps;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
}
