package main;

import java.io.FileNotFoundException;

import view.TelaGame;

public class Main {
	public static void main(String[] args) {
		
		TelaGame controll;
		try {
			controll = new TelaGame();
			controll.run();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
