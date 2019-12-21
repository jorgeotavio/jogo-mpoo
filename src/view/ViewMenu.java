package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewMenu extends AbstractView{

	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	private JButton startButton, leaveButton, tutorialButton, aboutButton;
	private JPanel panelButtons;
	
	public ViewMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelButtons = new JPanel();
		panelButtons.setLayout(null);
		panelButtons.setBounds(0, 0, this.getWidth()/2, this.getHeight());
		
		titleLabel = new JLabel("Olhe os Números");
		titleLabel.setFont(pixellari.deriveFont(Font.TRUETYPE_FONT, 45));
		titleLabel.setBounds(70, 50, 700, 50);
		
		startButton = new ButtonCustom("Iniciar");
		startButton.setFont(pixellari.deriveFont(Font.TRUETYPE_FONT, 20));
		startButton.setLocation(100, 200);
		
		tutorialButton = new ButtonCustom("Tutorial");
		tutorialButton.setFont(pixellari.deriveFont(Font.TRUETYPE_FONT, 20));
		tutorialButton.setLocation(100, 250);
		
		aboutButton = new ButtonCustom("Sobre");
		aboutButton.setFont(pixellari.deriveFont(Font.TRUETYPE_FONT, 20));
		aboutButton.setLocation(100, 300);
		
		leaveButton = new ButtonCustom("Sair");
		leaveButton.setFont(pixellari.deriveFont(Font.TRUETYPE_FONT, 20));
		leaveButton.setLocation(100, 350);
		
		panelButtons.add(titleLabel);
		panelButtons.add(startButton);
		panelButtons.add(tutorialButton);
		panelButtons.add(aboutButton);
		panelButtons.add(leaveButton);
		add(panelButtons);
		
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
