package model;

public class Player {
	
	private String nome;
	private int pontuacao;
	private boolean vencedor;
	
	public Player(String nome) {
		this.nome = nome;
		pontuacao = 0;
		vencedor = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public boolean isVencedor() {
		return vencedor;
	}

	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}
	
	
}
