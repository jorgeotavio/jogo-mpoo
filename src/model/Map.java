package model;

import java.util.ArrayList;

public class Map {
	
	private boolean activated;
	private ArrayList<Camada> camadas;
	private ArrayList<Objeto> objetos;

	public Map(ArrayList<Camada> camadas) {
		this.activated = false;
		this.camadas = camadas;
		this.objetos = new ArrayList<Objeto>();;
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

	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(ArrayList<Objeto> itens) {
		this.objetos = itens;
	}
	
}
