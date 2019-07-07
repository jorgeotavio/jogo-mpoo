package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class TelaPerdeu extends JFrame {

	private JPanel panel;
	private JLabel label;
	
	public TelaPerdeu() {
		
		setUndecorated(true);
		setSize(400, 200);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		label = new JLabel(new ImageIcon("img/tela_perdeu.png"));
		label.setSize(400, 200);
		panel.add(label);
		
		setVisible(false);
	}
}