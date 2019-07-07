package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TelaInicio extends JFrame{
	
	private JButton iniciarButton, sairButtton;
	
	private JPanel panel;
	
	public TelaInicio() {
		criarTela();
	}
	
	public void criarTela() {
		
		setSize(640, 480);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		
		panel = new JPanel();
		panel.setBounds(0, 0, this.getWidth(), this.getHeight());
		getContentPane().add(panel);
		panel.setLayout(null);
		
		iniciarButton = new JButton("Iniciar");
		iniciarButton.setBounds(panel.getWidth()/3+40, panel.getHeight()/3-10, 100, 25);
		
		sairButtton = new JButton("Sair");
		sairButtton.setBounds(panel.getWidth()/3+40, panel.getHeight()/2-60, 100, 25);
		
		panel.add(iniciarButton);
		panel.add(sairButtton);
		
	}

	public JButton getIniciarButton() {
		return iniciarButton;
	}

	public void setIniciarButton(JButton iniciarButton) {
		this.iniciarButton = iniciarButton;
	}

	public JButton getSairButtton() {
		return sairButtton;
	}

	public void setSairButtton(JButton sairButtton) {
		this.sairButtton = sairButtton;
	}
	
	
}
