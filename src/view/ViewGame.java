package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Camada;
import model.Enemy;
import model.Map;
import model.Player;

public class ViewGame extends JFrame{

	private ArrayList<Enemy> enemies;
	private ArrayList<Player> players;
	private ArrayList<Map> maps;
	private BufferedImage tela;

	public ViewGame() {
		setSize(640, 480);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(false);
		
		tela = new BufferedImage(640, 480, BufferedImage.TYPE_4BYTE_ABGR);

	}
	

	public void paint(Graphics g) {	
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		g2d.drawImage(tela, 0, 0, null);
		
		for (Map map: maps) {
			
			if (!map.isActivated())
				continue;
			
			for (Camada camada: map.getCamadas()) {
				tela.getGraphics().drawImage(camada.camada, 0, 0, this); 
			}
		}
		
		for(Player player: this.players) {
			
			BufferedImage[] sprites = player.getHero().getSprite().getSprites();
			tela.getGraphics().drawImage(sprites[player.getHero().getSprite().getAparencia()], 
					player.getHero().getSprite().getPosX(), player.getHero().getSprite().getPosY(), this); 			
			
			g2d.setColor(Color.RED);
			g2d.draw(player.getHero().getRetangulo());
		}
		
	}

	public ArrayList<Map> getMaps() {
		return maps;
	}

	public void setMaps(ArrayList<Map> maps) {
		this.maps = maps;
	}

	public BufferedImage getTela() {
		return tela;
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
