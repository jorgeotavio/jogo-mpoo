package view;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class AbstractView extends JFrame{
	
	protected Font pixellari;
	
	public AbstractView() {
		try {
			pixellari = Font.createFont(Font.TRUETYPE_FONT, 
					getClass().getClassLoader().getResourceAsStream("fontes/pixellari.ttf"));
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		pixellari = pixellari .deriveFont(Font.PLAIN, 20);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(pixellari);
        
		setSize(840, 480);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
