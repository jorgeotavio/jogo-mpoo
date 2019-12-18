package view;

import java.awt.Color;

import javax.swing.JButton;

public class ButtonCustom extends JButton{
	
	public ButtonCustom(String titulo) {
		super(titulo);
		setBackground(new Color(63, 60, 197));
		setForeground(new Color(255,255,255));
		setBorderPainted(false);
		setSize(200, 50);
	}
}
