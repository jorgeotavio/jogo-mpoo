package model;

public class Item {
	private String name;
	private int quantity;
	
	public Item(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public int getQuantidade() {
		return quantity;
	}

	public void setQuantidade(int quantity) {
		this.quantity = quantity;
	}

}
