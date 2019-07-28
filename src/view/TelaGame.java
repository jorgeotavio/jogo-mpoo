package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JFrame;

import controller.ControllerInimigo;
import model.Camada;
import model.Flecha;
import model.Player;
import model.Sprite;

@SuppressWarnings("serial")
public class TelaGame extends JFrame {
	
	private int tentativas;
	private Player player;
	private ControllerInimigo controllerInimigo;
	private BufferedImage[] spritesHeroi, spritesInimigo, spritesPontuacao;
	private BufferedImage tela;
	private Sprite heroi, pontuacao;
	private Camada camada1, camada2, camada3, camada4, camadaInicio, camadaTexto, camadaOver;
	private int FPS = 5;
	protected static boolean perdeu, emJogo, ganhou, inicio;
	private List<Sprite> inimigos;
	
	public TelaGame() {
		setSize(640, 480);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(false);
		tela = new BufferedImage(640, 480, BufferedImage.TYPE_4BYTE_ABGR);
	}
	
	public void paint(Graphics g) {
		
		tela.getGraphics().drawImage(camada1.camada, 0, 0, this); 
		tela.getGraphics().drawImage(camada2.camada, 0, 0, this);
		tela.getGraphics().drawImage(camada3.camada, 0, 0, this);
		tela.getGraphics().drawImage(camada4.camada, 0, 0, this);

		List<Flecha> flechas = heroi.getFlechas();
		flechas.forEach(f->tela.getGraphics().drawImage(f.getImagem(), f.getPosX(), f.getPosY(), this));
		
		tela.getGraphics().drawImage(spritesHeroi[heroi.getAparencia()], heroi.getPosX(), heroi.getPosY(), null);

		for (int i = 0; i < inimigos.size(); i++) {
			Sprite in = inimigos.get(i);
			spritesInimigo = in.getSprites();
			tela.getGraphics().drawImage(spritesInimigo[in.getAparencia()], in.getPosX(), in.getPosY(), null);

		}
		
//		tela.getGraphics().drawImage(spritesPontuacao[pontuacao.getAparencia()], pontuacao.getPosX(), pontuacao.getPosY(), null);
		
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		g2d.drawImage(tela, 0, 0, null);
		
	}

	public int getTentativas() {
		return tentativas;
	}

	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ControllerInimigo getControllerInimigo() {
		return controllerInimigo;
	}

	public void setControllerInimigo(ControllerInimigo controllerInimigo) {
		this.controllerInimigo = controllerInimigo;
	}

	public BufferedImage[] getSpritesHeroi() {
		return spritesHeroi;
	}

	public void setSpritesHeroi(BufferedImage[] spritesHeroi) {
		this.spritesHeroi = spritesHeroi;
	}

	public BufferedImage[] getSpritesInimigo() {
		return spritesInimigo;
	}

	public void setSpritesInimigo(BufferedImage[] spritesInimigo) {
		this.spritesInimigo = spritesInimigo;
	}

	public BufferedImage[] getSpritesPontuacao() {
		return spritesPontuacao;
	}

	public void setSpritesPontuacao(BufferedImage[] spritesPontuacao) {
		this.spritesPontuacao = spritesPontuacao;
	}

	public BufferedImage getTela() {
		return tela;
	}

	public void setTela(BufferedImage tela) {
		this.tela = tela;
	}

	public Sprite getHeroi() {
		return heroi;
	}

	public void setHeroi(Sprite heroi) {
		this.heroi = heroi;
	}

	public Sprite getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Sprite pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Camada getCamada1() {
		return camada1;
	}

	public void setCamada1(Camada camada1) {
		this.camada1 = camada1;
	}

	public Camada getCamada2() {
		return camada2;
	}

	public void setCamada2(Camada camada2) {
		this.camada2 = camada2;
	}

	public Camada getCamada3() {
		return camada3;
	}

	public void setCamada3(Camada camada3) {
		this.camada3 = camada3;
	}

	public Camada getCamada4() {
		return camada4;
	}

	public void setCamada4(Camada camada4) {
		this.camada4 = camada4;
	}

	public Camada getCamadaInicio() {
		return camadaInicio;
	}

	public void setCamadaInicio(Camada camadaInicio) {
		this.camadaInicio = camadaInicio;
	}

	public Camada getCamadaTexto() {
		return camadaTexto;
	}

	public void setCamadaTexto(Camada camadaTexto) {
		this.camadaTexto = camadaTexto;
	}

	public static boolean isPerdeu() {
		return perdeu;
	}

	public static void setPerdeu(boolean perdeu) {
		TelaGame.perdeu = perdeu;
	}

	public static boolean isEmJogo() {
		return emJogo;
	}

	public static void setEmJogo(boolean emJogo) {
		TelaGame.emJogo = emJogo;
	}

	public static boolean isGanhou() {
		return ganhou;
	}

	public static void setGanhou(boolean ganhou) {
		TelaGame.ganhou = ganhou;
	}

	public static boolean isInicio() {
		return inicio;
	}

	public static void setInicio(boolean inicio) {
		TelaGame.inicio = inicio;
	}

	public List<Sprite> getInimigos() {
		return inimigos;
	}

	public void setInimigos(List<Sprite> inimigos) {
		this.inimigos = inimigos;
	}
	
	
}
