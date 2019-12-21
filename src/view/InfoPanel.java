package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel[] pontos = new JLabel[2];
	private JLabel[] pegou = new JLabel[2];
	private JLabel missaoLabel;
	private JLabel missaoDescLabel;
	private Font font;
	private JPanel panelDados;
	private JButton botaoMenu;
	
	public InfoPanel() throws IOException {
		setLayout(null);
		setBackground(new Color(253, 228,127));

		panelDados = new JPanel();
		panelDados.setBounds(0,0,200,300);
		panelDados.setLayout(new GridLayout(3,3));
		panelDados.setBackground(new Color(253, 228,127));
		
		JLabel labelPlayer = new JLabel(" Player:");
		labelPlayer.setFont(font.deriveFont(Font.BOLD, 15));
		JLabel pontosLabel1 = new JLabel("p1");
		pontosLabel1.setFont(font.deriveFont(Font.TRUETYPE_FONT, 20));
		JLabel pontosLabel2 = new JLabel("p2");
		pontosLabel2.setFont(font.deriveFont(Font.TRUETYPE_FONT, 20));
		
		JLabel labelPontos = new JLabel(" Pontos:");
		labelPontos.setFont(font.deriveFont(Font.BOLD, 15));
		
		pontos[0] = new JLabel("0");
		pontos[0].setFont(font.deriveFont(Font.TRUETYPE_FONT, 20));
		pontos[1] = new JLabel("0");
		pontos[1].setFont(font.deriveFont(Font.TRUETYPE_FONT, 20));
		
		JLabel labelInventario = new JLabel(" Pegou:");
		labelInventario.setFont(font.deriveFont(Font.BOLD, 15));
		
		pegou[0] = new JLabel("0");
		pegou[0].setFont(font.deriveFont(Font.TRUETYPE_FONT, 20));
		pegou[1] = new JLabel("0");
		pegou[1].setFont(font.deriveFont(Font.TRUETYPE_FONT, 20));
		
		missaoLabel = new JLabel(" Missão");
		missaoLabel.setFont(font.deriveFont(Font.BOLD, 15));
		missaoLabel.setBounds(55, 300, 100, 100);
		
		missaoDescLabel = new JLabel();
		missaoDescLabel.setFont(font.deriveFont(Font.BOLD, 15));
		missaoDescLabel.setBounds(30, 350, 200, 100);
		
		botaoMenu = new ButtonCustom("< Voltar");
		botaoMenu.setBounds(40, 430, 100, 30);
		botaoMenu.setFocusable(false);
		
		panelDados.add(labelPlayer);
		panelDados.add(pontosLabel1);
		panelDados.add(pontosLabel2);
		panelDados.add(labelPontos);
		panelDados.add(pontos[0]);
		panelDados.add(pontos[1]);
		panelDados.add(labelInventario);
		panelDados.add(pegou[0]);
		panelDados.add(pegou[1]);
		add(missaoLabel);
		add(missaoDescLabel);
		add(panelDados);
		add(botaoMenu);
	}

	public JLabel[] getPontos() {
		return pontos;
	}

	public JLabel[] getInvent() {
		return pegou;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public JLabel getMissaoDescLabel() {
		return missaoDescLabel;
	}

	public JButton getBotaoMenu() {
		return botaoMenu;
	}

}
