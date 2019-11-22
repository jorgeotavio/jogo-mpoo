package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Player;

public class InfoPanel extends JPanel {
	
	private ArrayList<JLabel> pontuacoes;
	
	public InfoPanel() {
		setLayout(null);
		pontuacoes = new ArrayList<JLabel>();
		
		JLabel pontosPlayer1 = new JLabel();
		pontosPlayer1.setBounds(10, 10, 100, 100);
		
		JLabel pontosPlayer2 = new JLabel();
		pontosPlayer2.setBounds(10, 30, 100,100);
		
		pontuacoes.add(pontosPlayer1);
		pontuacoes.add(pontosPlayer2);
		
		pontuacoes.forEach((pontuacao) -> {
			pontuacao.setForeground(new Color(255,255,255));
			add(pontuacao);
		});
	}

	public void atualizarPontuacao(ArrayList<Player> players) {
		players.forEach((player) -> {
			this.pontuacoes.get(players.indexOf(player)).setText(Integer.toString(player.getPoints()));
		});
	}

}
