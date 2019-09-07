package view;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Enemy;
import model.Hero;
import model.Map;
import model.Player;

public class ViewGame extends JFrame{
	
	private ArrayList<Hero> heros; 
	private ArrayList<Enemy> enemies;
	private ArrayList<Player> players;
	private ArrayList<Map> maps;
	
	public ViewGame(ArrayList<Hero> heros, ArrayList<Enemy> enemies, ArrayList<Player> players, ArrayList<Map> maps) {
		this.heros = heros;
		this.enemies = enemies;
		this.players = players;
		this.maps = maps;
		
	}
	
	public void paint(Graphics g) {
		
	}
}
