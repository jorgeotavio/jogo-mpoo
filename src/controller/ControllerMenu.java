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
		viewMenu.getStartSoloButton().addActionListener(this);
		viewMenu.getStartDuoButton().addActionListener(this);
		viewMenu.getAboutButton().addActionListener(this);
		viewMenu.getLeaveButton().addActionListener(this);
		
		viewAbout.getBackButton().addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewMenu.getStartSoloButton()) {
			
			this.viewMenu.setVisible(false);
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					new ControllerGame(viewGame).run();
				}
			}).start();
		}
		
		if(e.getSource() == viewMenu.getStartDuoButton()) {
			//
		}
		
		if(e.getSource() == viewMenu.getAboutButton()) {
			viewAbout.setVisible(true);
			viewMenu.setVisible(false);
		}
		
		if(e.getSource() == viewAbout.getBackButton()) {
			viewAbout.setVisible(false);
			viewMenu.setVisible(true);
		}
		
		if(e.getSource() == viewMenu.getLeaveButton()) {
			System.exit(0);
		}
		
	}
	
}
