package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewAbout;
import view.ViewGame;
import view.ViewMenu;
import view.ViewTutorial;

public class ControllerMenu implements ActionListener{
	
	private ViewMenu viewMenu;
	private ViewAbout viewAbout;
	private Thread gameThread;
	private ViewGame viewGame;
	private ViewTutorial viewTutorial;
	
	public ControllerMenu(ViewMenu telaMenu, ViewGame viewGame) {
		this.viewMenu = telaMenu;
		this.viewMenu.setVisible(true);
		this.viewGame = viewGame;
		viewAbout = new ViewAbout();
		viewTutorial = new ViewTutorial();
		controll();
	}
	
	public void controll() {
		
		viewMenu.getStartSoloButton().addActionListener((e)-> {
			this.viewMenu.setVisible(false);
			
			gameThread = new Thread(
				new ControllerGame(this.viewGame)
			);
			gameThread.start();
		});

		viewMenu.getAboutButton().addActionListener((e) -> {
			viewAbout.setVisible(true);
			viewMenu.setVisible(false);
		});

		viewMenu.getLeaveButton().addActionListener((e) -> {
			System.exit(0);
		});
		
		viewMenu.getTutorialButton().addActionListener((e) -> {
			viewTutorial.setVisible(true);
			viewMenu.setVisible(false);
		});

		viewAbout.getBackButton().addActionListener((e)->{
			viewAbout.setVisible(false);
			viewMenu.setVisible(true);
		});
		
		viewTutorial.getBackButton().addActionListener((e)->{
			viewTutorial.setVisible(false);
			viewMenu.setVisible(true);
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//
	}

	public ViewMenu getViewMenu() {
		return viewMenu;
	}

	public void setViewMenu(ViewMenu viewMenu) {
		this.viewMenu = viewMenu;
	}

	public ViewAbout getViewAbout() {
		return viewAbout;
	}

	public void setViewAbout(ViewAbout viewAbout) {
		this.viewAbout = viewAbout;
	}
}
