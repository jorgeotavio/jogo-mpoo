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
	}

	public void atualizarPontuacao(ArrayList<Player> players) {
		players.forEach((player) -> {
			this.pontuacoes.get(players.indexOf(player)).setText(Integer.toString(player.getPoints()));
		});
	}

	public void cadastrarLabels(ArrayList<Player> players) {
		for (int i = 0; i < players.size();i++) {
			JLabel pontosLabel = new JLabel();
			pontosLabel.setBounds(10, i*10, 100, 100);
			pontuacoes.add(pontosLabel);
		}

		pontuacoes.forEach((pontuacao) -> {
			pontuacao.setForeground(new Color(255,255,255));
			add(pontuacao);
		});
	}

}
