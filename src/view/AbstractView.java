package view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class AbstractView extends JFrame{
	
	public AbstractView() {
		setSize(840, 480);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
