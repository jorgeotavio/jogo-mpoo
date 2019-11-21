package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewAbout;
import view.ViewGame;
import view.ViewMenu;

public class ControllerMenu implements ActionListener{
	
	private ViewMenu viewMenu;
	private ViewAbout viewAbout;
	private ViewGame viewGame;
	
	public ControllerMenu(ViewMenu telaMenu, ViewGame viewGame) {
		this.viewMenu = telaMenu;
		this.viewMenu.setVisible(true);
		this.viewGame = viewGame;
		viewAbout = new ViewAbout();
		controll();
	}
	
	public void controll() {
		
		viewMenu.getStartSoloButton().addActionListener((e)-> {
			this.viewMenu.setVisible(false);
			new Thread(
				new ControllerGame(this.viewGame)
			).start();
		});

		viewMenu.getAboutButton().addActionListener((e) -> {
			viewAbout.setVisible(true);
			viewMenu.setVisible(false);
		});

		viewMenu.getLeaveButton().addActionListener((e) -> {
			System.exit(0);
		});

		viewAbout.getBackButton().addActionListener((e)->{
			viewAbout.setVisible(false);
			viewMenu.setVisible(true);
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//
	}
	
}
