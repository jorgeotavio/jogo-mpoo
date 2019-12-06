package model;

public class Pontuacao {

	private String nomePlayer;
	private int pontos;
	private int idMap;
	
	public Pontuacao(Player player, int idMap) {
		this.nomePlayer = player.getNome();
		this.pontos = player.getPontos();
		this.idMap = idMap;
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

	public int getIdMap() {
		return idMap;
	}

	public void setIdMap(int idMap) {
		this.idMap = idMap;
	}
	
}
