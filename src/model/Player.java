package model;

public class Player {
	
	private String name;
	private Hero hero;
	private int points;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getNome() {
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

	public int getPontos() {
		return points;
	}

	public void setPoints(int point) {
		this.points = point;
	}
}
