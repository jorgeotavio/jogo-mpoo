package model;

import java.util.ArrayList;

import view.ViewGame;

public class Map {
	
	private boolean activated;
	private ArrayList<Camada> camadas;

	public Map(ArrayList<Camada> camadas) {
		this.activated = false;
		this.camadas = camadas;
	}
	
	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public ArrayList<Camada> getCamadas() {
		return camadas;
	}

	public void setCamadas(ArrayList<Camada> camadas) {
		this.camadas = camadas;
	}
	
}
