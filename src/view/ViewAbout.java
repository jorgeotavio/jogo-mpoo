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
		
		descriptionLabel = new JLabel("<html>Jogo feito pelo aluno: <br/>"
				+ "Jorge Luiz Otávio da Silva Brito,<br/> "
				+ "para a cadeira "
				+ "de Mpoo, da UAST-UFRPE.<br/>"
				+ "Professor: Rico D'Emery");
		descriptionLabel.setBounds(90, 10, 300, 300);
		
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
