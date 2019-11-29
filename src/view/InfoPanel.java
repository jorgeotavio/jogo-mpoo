package view;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Player;

public class InfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JLabel> pontosTempoReal;
	private JLabel tempoLabel;
	private Font font;

	public InfoPanel() throws IOException {
		
		setLayout(null);
		font = new Font("Impact", Font.PLAIN, 20);		
		
		pontosTempoReal = new ArrayList<JLabel>();
		
		JLabel player1Label = new JLabel();
		player1Label.setBounds(195, 10, 100, 20);
		player1Label.setForeground(new Color(255,255,255));
		player1Label.setFont(font);
		pontosTempoReal.add(player1Label);

		JLabel player2Label = new JLabel();
		player2Label.setBounds(195*2, 10, 100, 20);
		player2Label.setForeground(new Color(255,255,255));
		player2Label.setFont(font);
		pontosTempoReal.add(player2Label);

		tempoLabel = new JLabel();
		tempoLabel.setBounds(320, 50, 100, 20);
		tempoLabel.setFont(font);
		add(tempoLabel);

		add(player1Label);
		add(player2Label);
	}

	public void atualizarPontuacao(ArrayList<Player> players) {
		for(int i=0; i < pontosTempoReal.size(); i++) {
			this.pontosTempoReal.get(i).setText(players.get(i).getName()+": "+Integer.toString(players.get(i).getPoints()));
		}
	}

	public void cadastrarLabels(ArrayList<String[]> pontuacoes) {

		for (String[] p: pontuacoes) {
			JLabel pontosLabel = new JLabel();
			pontosLabel.setText("Jogador: " +p[0] + " Pontos "+p[1]);
			pontosLabel.setBounds(10, 10*(pontuacoes.indexOf(p)+1), 200, 100);
			pontosLabel.setFont(new Font("Impact", Font.PLAIN, 10));
			add(pontosLabel);
		}
	}
	
	public void carregarPontuacoes(ArrayList<Player> pontuacoes) {
		pontuacoes.forEach((pontuacao) -> {
			
		});
	}

	public void setTempo(int tempo) {
		this.tempoLabel.setText(Integer.toString(tempo));
	}
}
