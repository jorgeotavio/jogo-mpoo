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
		viewMenu.getStartSoloButton().addActionListener(this);
		viewMenu.getStartDuoButton().addActionListener(this);
		viewMenu.getAboutButton().addActionListener(this);
		viewMenu.getLeaveButton().addActionListener(this);
		
		viewAbout.getBackButton().addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewMenu.getStartSoloButton()) {
			//
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
