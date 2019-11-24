package model;

import java.util.ArrayList;

public class Inventary {
	
	private ArrayList<Objeto> items;
	
	public Inventary() {
		this.items = new ArrayList<Objeto>();
	}

	public ArrayList<Objeto> getItems() {
		return items;
	}

	public void setItems(ArrayList<Objeto> items) {
		this.items = items;
	}
	
}
