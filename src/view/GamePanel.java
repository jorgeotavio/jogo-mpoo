package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Enemy;
import model.Map;
import model.Player;

public class GamePanel extends JPanel{
	
	private static final long serialVersionUID = 3027613679265920713L;
	private ArrayList<Enemy> enemies;
	private ArrayList<Player> players;
	private ArrayList<Map> maps;
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		
		maps.forEach((map)->{
			
			if (!map.isActivated()) return;
			
			map.getCamadas().forEach((camada)->{
				g2d.drawImage(camada.getCamada(), 0, 0, this);
			});
			
			map.getItens().forEach((item)->{
				g2d.drawImage(item.getImagem(), item.getPosX(), item.getPosY(), this);
			});
		});
		
		this.players.forEach((player)->{
			
			BufferedImage[] sprites = player.getHero().getSprite().getSprites();
			
			g2d.drawString(player.getName(), player.getHero().getSprite().getPosX(), player.getHero().getSprite().getPosY()-8);
			
			g2d.drawRect(player.getHero().getSprite().getPosX(), player.getHero().getSprite().getPosY()-5, 25, 5);
			
			g2d.fillRect(player.getHero().getSprite().getPosX(), player.getHero().getSprite().getPosY()-5, player.getHero().getVida()/4, 5);			
			
			g2d.drawImage(sprites[player.getHero().getSprite().getAparencia()], 
					player.getHero().getSprite().getPosX(), player.getHero().getSprite().getPosY(), this);
			sprites = null;
			System.gc();
		});
		g2d.dispose();
	}
	
	public ArrayList<Map> getMaps() {
		return maps;
	}

	public void setMaps(ArrayList<Map> maps) {
		this.maps = maps;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
}
