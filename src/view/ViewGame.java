package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Enemy;
import model.Layer;
import model.Map;
import model.Player;

public class ViewGame extends JFrame{
	
	private ArrayList<Enemy> enemies;
	private ArrayList<Player> players;
	private ArrayList<Map> maps;
	private BufferedImage tela;
	
	public ViewGame(ArrayList<Map> maps, ArrayList<Enemy> enemies, ArrayList<Player> players) {
		this.enemies = enemies;
		this.players = players;
		this.maps = maps;
		
		tela = new BufferedImage(640, 480, BufferedImage.TYPE_4BYTE_ABGR);
	}
	
	public void paint(Graphics g) {
		
		for (Map map: maps) {
			
			if (!map.isActivated())
				continue;
			
			for (Layer layer: map.getLayers()) {
				tela.getGraphics().drawImage(layer.camada, 0, 0, this); 
			}
		}
		
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		g2d.drawImage(tela, 0, 0, null);
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

	public void setTela(BufferedImage tela) {
		this.tela = tela;
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
