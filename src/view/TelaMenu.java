package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	private JButton startButton, leaveButton;
	
	public TelaMenu() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleLabel = new JLabel("See The Moon");
		titleLabel.setBounds(210, 150, 500, 10);
		
		startButton = new JButton("Iniciar");
		startButton.setBounds(210, 200, 80, 30);

		leaveButton = new JButton("Sair");
		leaveButton.setBounds(210, 250, 80, 30);
		
		add(titleLabel);
		add(startButton);
		add(leaveButton);
		
		setVisible(false);
		
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getStartButton() {
		return startButton;
	}

	public JButton getLeaveButton() {
		return leaveButton;
	}
	
	
	
}
