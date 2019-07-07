package view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TelaInicio extends JFrame{

	public TelaInicio() {
		criarTela();
	}
	
	public void criarTela() {
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
	}
}
