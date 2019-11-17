package view;

import javax.swing.JLabel;


@SuppressWarnings("serial")
public class ViewGame extends AbstractView{
	
	private GamePanel gamePanel;
	private JLabel pontos;
	
	public ViewGame(GamePanel gamePanel) {
		
		this.gamePanel = gamePanel;
		
		this.gamePanel.setBounds(0, 0, 680, 380);
		
		
		pontos = new JLabel("Pontos: ");
		pontos.setBounds(100, 400, 100, 100);
		
		add(pontos);
		add(gamePanel);
		
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
		this.pontos.setText(Integer.toString(pontos));;
	}

}
