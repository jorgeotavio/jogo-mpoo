package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewAbout extends JFrame {
	private JLabel descriptionLabel;
	private JButton backButton;
	
	public ViewAbout() {
		setSize(300, 300);
		setLocationRelativeTo(null);
		setLayout(null);
		setUndecorated(true);
		
		descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(100, 100, 150, 10);
		
		backButton = new JButton("Back");
		backButton.setBounds(100, 250, 80, 30);
		
		add(descriptionLabel);
		add(backButton);
		
		setVisible(false);
	}

	public JLabel getDescriptionLabel() {
		return descriptionLabel;
	}

	public JButton getBackButton() {
		return backButton;
	}
	
	
	
}
