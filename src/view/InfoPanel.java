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
	private JLabel pontosLabel;

	public InfoPanel() throws IOException {
		setLayout(null);
		font = new Font("Impact", Font.PLAIN, 20);		
		
		pontosLabel = new JLabel();
		pontosLabel.setBounds(10, 0, 200, 100);
		pontosLabel.setForeground(new Color(255,255,255));
		pontosLabel.setFont(new Font("Impact", Font.PLAIN, 15));
		
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
		
		add(pontosLabel);
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
		
		String pontos = "<html>";
		for (String[] p: pontuacoes) {
			pontos += "Jogador: " +p[0] + "-> Pontos: "+p[1]+"<br/>";
		}
		pontosLabel.setText(pontos);
	
	}

	public void setTempo(int tempo) {
		this.tempoLabel.setText(Integer.toString(tempo));
	}
}
