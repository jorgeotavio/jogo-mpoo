package model;

public class ModelPlayer {
	
	private String name;
	private String password;
	private ModelHero hero;
	private int points;
	
	public ModelPlayer(String name, String password, ModelHero hero) {
		this.name = name;
		this.password = password;
		this.hero = hero;
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

	public ModelHero getHero() {
		return hero;
	}

	public void setHero(ModelHero hero) {
		this.hero = hero;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}
