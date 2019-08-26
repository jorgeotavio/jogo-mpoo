package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewAbout;
import view.ViewMenu;

public class ControllerMenu implements ActionListener{
	
	private ViewMenu viewMenu;
	private ViewAbout viewAbout;
	
	public ControllerMenu(ViewMenu telaMenu) {
		this.viewMenu = telaMenu;
		this.viewMenu.setVisible(true);
		viewAbout = new ViewAbout();
		controll();
	}
	
	public void controll() {
		viewMenu.getStartButton().addActionListener(this);
		viewMenu.getAboutButton().addActionListener(this);
		viewMenu.getLeaveButton().addActionListener(this);
		
		viewAbout.getBackButton().addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewMenu.getStartButton()) {
			//
		}
		
		if(e.getSource() == viewMenu.getLeaveButton()) {
			System.exit(0);
		}
		
		if(e.getSource() == viewMenu.getAboutButton()) {
			viewAbout.setVisible(true);
		}
		
		if(e.getSource() == viewAbout.getBackButton()) {
			viewAbout.setVisible(false);
		}
		
	}
	
}
