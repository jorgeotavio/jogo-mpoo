package view;

import java.util.ArrayList;

import javax.swing.JFrame;

import model.ModelEnemy;
import model.ModelHero;
import model.ModelMap;
import model.ModelPlayer;

public class ViewGame extends JFrame{
	
	private ArrayList<ModelHero> heros; 
	private ArrayList<ModelEnemy> enemies;
	private ArrayList<ModelPlayer> players;
	private ArrayList<ModelMap> maps;
	
	public ViewGame(ArrayList<ModelHero> heros, ArrayList<ModelEnemy> enemies, ArrayList<ModelPlayer> players, ArrayList<ModelMap> maps) {
		this.heros = heros;
		this.enemies = enemies;
		this.players = players;
		this.maps = maps;
		
	}
	
	
}
