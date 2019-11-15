package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JLabel;

import model.Camada;
import model.Enemy;
import model.Item;
import model.Map;
import model.Player;

@SuppressWarnings("serial")
public class ViewGame extends AbstractView{
	
	private GamePanel gamePanel;
	
	public ViewGame(GamePanel gamePanel) {
		
		this.gamePanel = gamePanel;
		
		this.gamePanel.setBounds(0, 0, 680, 380);
		
		JLabel label = new JLabel("teste");
		label.setBounds(100, 400, 100, 100);
		add(label);
		add(gamePanel);
		
		setVisible(false);
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

}
