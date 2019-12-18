package model;

import java.util.ArrayList;

public class Map {
	
	private ArrayList<Camada> camadas;
	private ArrayList<Objeto> objetos;
	private String objetivoMapa;

	public Map(ArrayList<Camada> camadas) {
		this.camadas = camadas;
		this.objetos = new ArrayList<Objeto>();;
 	}
	
	public Camada getCamadaColisao() {
		for(Camada camada: camadas) {
			if(camada.isCamadaColisao())
				return camada;
		}
		return null;
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

	public String getObjetivoMapa() {
		return objetivoMapa;
	}

	public void setObjetivoMapa(String objetivoMapa) {
		this.objetivoMapa = objetivoMapa;
	}
}
