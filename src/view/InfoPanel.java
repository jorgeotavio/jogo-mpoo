package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Hero;
import model.Player;
import model.Pontuacao;

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
		setLayout(new GridLayout(4,1));
		tempoLabel = new JLabel("tempo");
		add(tempoLabel);
	}

	public void setTempo(int tempo) {
		this.tempoLabel.setText(Integer.toString(tempo));
	}
}
