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
				+ "números do tipo solicitado nas fases, se pegar algum número,<br/>"
				+ "de tipo diferente perderá vida, e se zerar você será <br/>"
				+ "congelado naquela fase, esperando até a próxima. :(<br/>"
				+ "- Para controlar os personagens serão respectivamente.<br/>"
				+ "<hr/>"
				+ "<div style='font-size: 16;'>Player 1: </div><br/>"
				+ "			Seta cima-frente <br/>"
				+ "			Seta baixo-Trás <br/> "
				+ "			Seta direita-Direita<br/>"
				+ "			Seta esquerda-Esquerda <br/>"
				+ "			SHIFT - Pegar objeto"
				+ "<hr/>"
				+ "<div style='font-size: 16;'>Player 2: </div><br/> "
				+ "			 W-frente <br/> "
				+ "			 S-Trás <br/> "
				+ "			 F-Direita <br/> "
				+ "			 A-Esquerda <br/>"
				+ "			 SPACE - Pegar objeto"
				+ "<hr/>"
				
				);
		descriptionLabel.setBounds(150, 10, 500, 400);
		
		backButton = new ButtonCustom("Back");
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

