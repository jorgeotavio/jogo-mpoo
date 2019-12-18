package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewMenu extends AbstractView{

	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	private JButton startButton, leaveButton, tutorialButton, aboutButton;
	
	public ViewMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleLabel = new JLabel("See The Moon");
		titleLabel.setBounds(210, 150, 500, 10);
		
		startButton = new ButtonCustom("Start");
		startButton.setBounds(210, 200, 80, 30);
		
		tutorialButton = new ButtonCustom("Tutorial");
		tutorialButton.setBounds(210, 300, 80, 30);
		
		aboutButton = new ButtonCustom("About");
		aboutButton.setBounds(210, 350, 80, 30);
		
		leaveButton = new ButtonCustom("Leave");
		leaveButton.setBounds(210, 400, 80, 30);
		
		add(titleLabel);
		add(startButton);
		add(tutorialButton);
		add(aboutButton);
		add(leaveButton);
		
		setVisible(false);
	}

	public JButton getStartSoloButton() {
		return startButton;
	}

	public JButton getLeaveButton() {
		return leaveButton;
	}

	public JButton getTutorialButton() {
		return tutorialButton;
	}

	public JButton getAboutButton() {
		return aboutButton;
	}
}
