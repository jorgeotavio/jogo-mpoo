package view;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ViewAbout extends AbstractView{
	private JLabel descriptionLabel;
	private JButton backButton;
	
	public ViewAbout() {
		
		descriptionLabel = new JLabel("<html><div style='font-size: 16; padding: 10px'>"
				+ "Jogo feito pelo aluno, <br/>"
				+ "Jorge Luiz Otávio da Silva Brito,<br/>"
				+ "para a cadeira de Mpoo, da UAST-UFRPE.<br/>"
				+ "Professor: Rico D'Emery</div>");
		descriptionLabel.setBounds(50, -30, 300, 300);
		
		backButton = new JButton("Back");
		backButton.setBounds(165, 250, 80, 30);
		
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
