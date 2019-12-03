package view;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ViewTutorial extends AbstractView{
	private JLabel descriptionLabel;
	private JButton backButton;
	
	public ViewTutorial() {
		
		descriptionLabel = new JLabel(
				"<html>"
				+ "<div style='font-size: 20;'>Tutorial </div><br/> "
				+ "Nesse jogo você terá que pegar o máximo de <br/>"
				+ "frutas possível, em um determinado periodo de tempo,<br/>"
				+ "para controlar as irmâs serão respectivamente.<br/>"
				+ "<hr/>"
				+ "<div style='font-size: 16;'>Judith: </div><br/> "
				+ "			 W-frente <br/> "
				+ "			 S-Trás <br/> "
				+ "			 F-Direita <br/> "
				+ "			 A-Esquerda"
				+ "<hr/>"
				+ "<div style='font-size: 16;'>Joana: </div><br/>"
				+ "			Seta cima-frente <br/>"
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

