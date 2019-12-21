package model;

public class Pontuacao {

	private String nomePlayer;
	private int pontos;
	private int totalInventario;
	private double idPartida;
	
	public Pontuacao(Hero hero, double idPartida) {
		this.nomePlayer = hero.getNome();
		this.totalInventario = hero.getInventary().size();
		this.pontos = hero.getPontos();
		this.idPartida = idPartida;
	}

	public String getNomePlayer() {
		return nomePlayer;
	}

	public void setNomePlayer(String nomePlayer) {
		this.nomePlayer = nomePlayer;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public double getIdPartida() {
		return idPartida;
	}

	public int getTotalInventario() {
		return totalInventario;
	}

	public void setTotalInventario(int totalInventario) {
		this.totalInventario = totalInventario;
	}
	
}
