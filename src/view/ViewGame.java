package view;

import java.io.IOException;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ViewGame extends AbstractView{
	
	private GamePanel gamePanel;
	private JLabel pontos;
	private InfoPanel infoPanel;
	
	public ViewGame() {
		this.gamePanel = new GamePanel();
		this.gamePanel.setBounds(0, 0, 640, 480);
		gamePanel.setFont(pixellari);
		
		try {
			this.infoPanel = new InfoPanel();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		infoPanel.setFont(pixellari);
		infoPanel.setBounds(640, 0, 200, 480);
		
		add(gamePanel);
		add(infoPanel);
		
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
