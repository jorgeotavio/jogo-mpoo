package model;

import java.util.ArrayList;

import view.ViewGame;

public class Map {
	
	private boolean activated;
	private ArrayList<Camada> camadas;
	private ArrayList<Objeto> itens;

	public Map(ArrayList<Camada> camadas, ArrayList<Objeto> itens) {
		this.activated = false;
		this.camadas = camadas;
		this.itens = itens;
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

	public ArrayList<Objeto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Objeto> itens) {
		this.itens = itens;
	}
	
}
