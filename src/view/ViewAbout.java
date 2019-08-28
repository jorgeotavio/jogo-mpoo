package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewAbout extends JFrame {
	private JLabel descriptionLabel;
	private JButton backButton;
	
	public ViewAbout() {
		setSize(400, 400);
		setLocationRelativeTo(null);
		setLayout(null);
		setUndecorated(true);
		
		descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(165, 100, 150, 10);
		
		backButton = new JButton("Back");
		backButton.setBounds(165, 350, 80, 30);
		
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
