package view;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ViewGame extends AbstractView{
	
	private GamePanel gamePanel;
	private JLabel pontos;
	private InfoPanel infoPanel;
	
	public ViewGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.gamePanel = new GamePanel();
		this.gamePanel.setBounds(0, 0, 640, 480);
		
//		try {
//			this.infoPanel = new InfoPanel();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		infoPanel.setBackground(new Color(179, 84,21));
//		infoPanel.setBounds(1, 369, 638, 110);
		
		add(gamePanel);
//		add(infoPanel);
		
		setVisible(false);
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public JLabel getPontos() {
		return pontos;
	}

	public void setPontuacao(int pontos) {
		this.pontos.setText(Integer.toString(pontos));
	}

	public InfoPanel getInfoPanel() {
		return infoPanel;
	}

	public void setInfoPanel(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
	}
}
