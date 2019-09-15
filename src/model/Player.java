package model;

public class Player {
	
	private String name;
	private String password;
	private Hero hero;
	private int points;
	private Inventary inventary;
	
	public Player(String name, String password, Hero hero, Inventary inventary) {
		this.name = name;
		this.password = password;
		this.hero = hero;
		this.inventary = inventary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setPoints(int points) {
		this.points = points;
	}

	public Inventary getInventary() {
		return inventary;
	}

	public void setInventary(Inventary inventary) {
		this.inventary = inventary;
	}
	
}
