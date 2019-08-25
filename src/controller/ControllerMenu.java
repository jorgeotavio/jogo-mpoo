package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewMenu;

public class ControllerMenu implements ActionListener{
	
	private ViewMenu telaMenu;
	
	public ControllerMenu(ViewMenu telaMenu) {
		this.telaMenu = telaMenu;
		this.telaMenu.setVisible(true);
		controll();
	}
	
	public void controll() {
		telaMenu.getLeaveButton().addActionListener(this);
		telaMenu.getStartButton().addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaMenu.getStartButton()) {
			//
		}
		
		if(e.getSource() == telaMenu.getLeaveButton()) {
			System.exit(0);
		}
		
	}
	
}
