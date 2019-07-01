package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;

import controller.ControllerHeroi;
import model.Bala;
import model.Camada;
import model.Sprite;

public class TelaGame extends JFrame implements Runnable{

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	
	private BufferedImage[] sprites;
	private BufferedImage tela;
	private Sprite heroi;
	private Camada camada1, camada2;
	private int FPS = 5;
	private boolean emJogo;

	public TelaGame() throws FileNotFoundException {
		setSize(320, 320);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new TelaErro();

		try {
			camada1 = new Camada(10, 10, 32, 32, "img/mapa/Camada1.png", "img/mapa/camada1.txt");
			camada2 = new Camada(10, 10, 32, 32, "img/mapa/Camada11.png", "img/mapa/camada11.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		heroi = new Sprite("img/heroi/heroi.png", 1, 4, 4, this.getWidth()/2, this.getHeight()/2);

		sprites = heroi.getSprites();

		camada1.montarMapa(320, 320);
		camada2.montarMapa(320, 320);
		addKeyListener(new ControllerHeroi(heroi));
		
//		addKeyListener(new ControllerGame(this, heroi));

		emJogo = true;

		setVisible(true);
	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) this.getGraphics();
		g2d.drawImage(tela, 0, 0, null);

		if(emJogo) {
			tela.getGraphics().drawImage(camada1.camada, 0, 0, null);

			tela.getGraphics().drawImage(camada2.camada, 0, 0, null);

			List<Bala> balas = heroi.getBalas();

			for (int i = 0; i < balas.size(); i++) {
				Bala b = (Bala) balas.get(i);
				tela.getGraphics().drawImage(b.getImagem(), b.getPosX(), b.getPosY(), this);
			}
			
			tela.getGraphics().drawImage(sprites[heroi.getAparencia()] , heroi.getPosX(), heroi.getPosY(), null);
		}
	}

	@Override
	public void run() {
		tela = new BufferedImage(640, 640, BufferedImage.TYPE_4BYTE_ABGR);
		
		while (true) {
			try {
				List<Bala> balas2 = heroi.getBalas();

				for (int i = 0; i < balas2.size(); i++) {
					Bala b = (Bala) balas2.get(i);

					if (b.isVisible()) {
						b.mexer();
					} else {
						balas2.remove(i);
					}
				}
				repaint();
				Thread.sleep(500/FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
