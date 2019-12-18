package view;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel[] pontos = new JLabel[2];
	private JLabel[] invent = new JLabel[2];
	
	public InfoPanel() throws IOException {
		setLayout(new GridLayout(4,3));		
		
		JLabel labelPlayer = new JLabel(" Player");
		JLabel pontosLabel1 = new JLabel("P1");
		JLabel pontosLabel2 = new JLabel("P2");
		JLabel labelPontos = new JLabel("Pontos");
		pontos[0] = new JLabel("0");
		pontos[1] = new JLabel("0");
		JLabel labelInventario = new JLabel("Invent.");
		invent[0] = new JLabel("0");
		invent[1] = new JLabel("0");
		
		add(labelPlayer);
		add(pontosLabel1);
		add(pontosLabel2);
		add(labelPontos);
		add(pontos[0]);
		add(pontos[1]);
		add(labelInventario);
		add(invent[0]);
		add(invent[1]);
	}

	public JLabel[] getPontos() {
		return pontos;
	}

	public JLabel[] getInvent() {
		return invent;
	}

}
