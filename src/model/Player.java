package model;

public class Player {
	
	private String name;
	private Hero hero;
	private int points;
	private Inventary inventary;
	
	public Player(String name) {
		this.name = name;
		inventary = new Inventary();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int point) {
		point = (point*50)/100;
		this.points += point;
	}

	public Inventary getInventary() {
		return inventary;
	}

	public void setInventary(Inventary inventary) {
		this.inventary = inventary;
	}
	
}
