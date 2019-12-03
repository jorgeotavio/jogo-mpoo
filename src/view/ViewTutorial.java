package view;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ViewTutorial extends AbstractView{
	private JLabel descriptionLabel;
	private JButton backButton;
	
	public ViewTutorial() {
		
		descriptionLabel = new JLabel(
				"<html><div style='font-size: 16; padding: 10px'>"
				+ "Nesse jogo você terá que pegar o máximo de <br/>"
				+ "frutas possível, em um determinado periodo de tempo,<br/>"
				+ "para controlar as irmâs serão respectivamente.<br/>"
				+ "<hr/>"
				+ "Judith -> W-frente <br/> "
				+ "			 S-Trás <br/> "
				+ "			 F-Direita <br/> "
				+ "			 A-Esquerda"
				+ "<hr/>"
				+ "Joana -> Seta cima-frente <br/>"
				+ "			Seta baixo-Trás <br/> "
				+ "			Seta direita-Direita<br/>"
				+ "			Seta esquerda-Esquerda"
				+ "<hr/>"
				);
		descriptionLabel.setBounds(150, 10, 500, 400);
		
		backButton = new JButton("Back");
		backButton.setBounds(270, 400, 80, 30);
		
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

