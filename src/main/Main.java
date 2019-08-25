package main;

import controller.ControllerMenu;
import view.TelaMenu;

public class Main {

	public static void main(String[] args) {
		TelaMenu telaMenu = new TelaMenu();
		ControllerMenu cm = new ControllerMenu(telaMenu);
	}

}
