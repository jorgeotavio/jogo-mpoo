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
		viewMenu.getStartSoloButton().addActionListener(this);
		viewMenu.getAboutButton().addActionListener(this);
		viewMenu.getLeaveButton().addActionListener(this);
		viewMenu.getTutorialButton().addActionListener(this);
		viewAbout.getBackButton().addActionListener(this);
		viewTutorial.getBackButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == viewMenu.getLeaveButton()) System.exit(0);

		if (e.getSource() == viewMenu.getStartSoloButton()) {
			this.viewMenu.setVisible(false);
			gameThread = new Thread(new ControllerGame(this.viewGame, this.viewMenu));
			gameThread.start();
		}

		if (e.getSource() == viewMenu.getAboutButton()) {
			viewAbout.setVisible(true);
			viewMenu.setVisible(false);
		}
		
		if (e.getSource() == viewMenu.getTutorialButton()) {
			viewTutorial.setVisible(true);
			viewMenu.setVisible(false);
		}
		
		if (e.getSource() == viewAbout.getBackButton()) {
			viewAbout.setVisible(false);
			viewMenu.setVisible(true);
		}
		
		if (e.getSource() == viewTutorial.getBackButton()){
			viewTutorial.setVisible(false);
			viewMenu.setVisible(true);
		}

	}
}
