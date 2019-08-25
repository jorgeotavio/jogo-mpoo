package main;

import controller.ControllerMenu;
import view.ViewMenu;

public class Main {

	public static void main(String[] args) {
		ViewMenu telaMenu = new ViewMenu();
		ControllerMenu cm = new ControllerMenu(telaMenu);
	}

}
