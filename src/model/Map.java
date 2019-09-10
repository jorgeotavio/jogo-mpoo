package model;

import java.util.ArrayList;

public class Map {
	private ArrayList<Player> players;
	private ArrayList<Layer> layers;
	private ArrayList<Enemy> enemies;

	public Map(ArrayList<Player> players, ArrayList<Layer> layers, ArrayList<Enemy> enemies) {
		this.players = players;
		this.layers = layers;
		this.enemies = enemies;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public ArrayList<Layer> getLayers() {
		return layers;
	}

	public void setLayers(ArrayList<Layer> layers) {
		this.layers = layers;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}
	
	
	
	
}
