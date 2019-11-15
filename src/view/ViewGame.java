package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JLabel;

import model.Camada;
import model.Enemy;
import model.Item;
import model.Map;
import model.Player;

@SuppressWarnings("serial")
public class ViewGame extends AbstractView{

	private ArrayList<Enemy> enemies;
	private ArrayList<Player> players;
	private ArrayList<Map> maps;
	private BufferedImage tela;
	
	public ViewGame() {
		
		JLabel label = new JLabel("teste");
		label.setBounds(10, 10, 100, 100);
		add(label);
		
		tela = new BufferedImage(640, 480, BufferedImage.TYPE_4BYTE_ABGR);
		
		setVisible(false);
	}
	

	public void paint(Graphics g) {	
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		g2d.drawImage(tela, 0, 0, null);
		
		
		for (Map map: maps) {
			
			if (!map.isActivated()) continue;
			
			for (Camada camada: map.getCamadas()) {
				tela.getGraphics().drawImage(camada.getCamada(), 0, 0, this);
			}
			
			for (Item item: map.getItens()) {
				tela.getGraphics().drawImage(item.getImagem(), 50, 50, this);
			}
		}
		
		for(Player player: this.players) {
			BufferedImage[] sprites = player.getHero().getSprite().getSprites();
			tela.getGraphics().drawImage(sprites[player.getHero().getSprite().getAparencia()], 
					player.getHero().getSprite().getPosX(), player.getHero().getSprite().getPosY(), this);
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
