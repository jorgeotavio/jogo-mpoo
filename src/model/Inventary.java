package model;

import java.util.ArrayList;

public class Inventary {
	
	private ArrayList<Item> items;
	
	public Inventary(ArrayList<Item> items) {
		this.items = items;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
}
