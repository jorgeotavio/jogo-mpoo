package model;

import java.util.ArrayList;

import view.ViewGame;

public class Map {
	
	private boolean activated;
	private ArrayList<Layer> layers;

	public Map(ArrayList<Layer> layers) {
		activated = false;
		this.layers = layers;
	}
	
	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public ArrayList<Layer> getLayers() {
		return layers;
	}

	public void setLayers(ArrayList<Layer> layers) {
		this.layers = layers;
	}
	
}
