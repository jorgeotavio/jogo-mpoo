package view;

import java.awt.Color;

import javax.swing.JButton;

public class ButtonTeste extends JButton{
	
	public ButtonTeste(String titulo) {
		super(titulo);
		setBackground(new Color(234, 234, 134));
		setForeground(new Color(255,255,255));
		setBorderPainted(false);
		setSize(200, 50);
	}
}
