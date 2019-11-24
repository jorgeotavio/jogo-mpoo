package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.ViewAbout;
import view.ViewGame;
import view.ViewMenu;

public class ControllerMenu implements ActionListener, MouseListener{
	
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
