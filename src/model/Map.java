package model;

import java.util.ArrayList;

public class Map {
	
	private ArrayList<Camada> camadas;
	private ArrayList<ObjetoNoMapa> objetos;
	private String objetivoMapa;
	private int totalObjetosValidos;

	public Map() {
		this.objetos = new ArrayList<ObjetoNoMapa>();
	}
	
	public Map(ArrayList<Camada> camadas) {
		this.camadas = camadas;
		this.objetos = new ArrayList<ObjetoNoMapa>();
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

	public ArrayList<ObjetoNoMapa> getObjetos() {
		return objetos;
	}

	public void setObjetos(ArrayList<ObjetoNoMapa> itens) {
		this.objetos = itens;
	}

	public String getObjetivoMapa() {
		return objetivoMapa;
	}

	public void setObjetivoMapa(String objetivoMapa) {
		this.objetivoMapa = objetivoMapa;
	}

	public int getTotalObjetosValidos() {
		return totalObjetosValidos;
	}

	public void setTotalObjetosValidos(int totalObjetosValidos) {
		this.totalObjetosValidos = totalObjetosValidos;
	}
}
