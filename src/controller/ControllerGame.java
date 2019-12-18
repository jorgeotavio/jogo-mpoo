package controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import model.Objeto;
import model.BaseDados;
import model.Camada;
import model.Hero;
import model.Map;
import model.Player;
import model.RegistrarNoJogo;
import view.ViewGame;
import view.ViewDialogo;

public class ControllerGame implements Runnable, KeyListener, ActionListener {

	private ViewGame viewGame;
	private ViewDialogo viewDialogo;
	private boolean pausado = false;
	private boolean gameOver = false;
	private boolean gameWin = false;
	private int duracaoObjetivo = 30;
	private int tempoDecorrido;
	private Timer timer;
	private ArrayList<Map> maps;
	private ArrayList<Hero> heros;

	public ControllerGame(ViewGame viewGame) {
		this.viewGame = viewGame;
		this.viewGame.addKeyListener(this);
		this.viewGame.setVisible(true);

		this.viewDialogo = new ViewDialogo();
		this.viewDialogo.addKeyListener(this);

		this.maps = viewGame.getGamePanel().getMaps();
		this.heros = new ArrayList<Hero>();

		novoJogo();

	}

	public void novoJogo() {
		
		gameOver = false;
		gameWin = false;

		Hero[] novosHeros = RegistrarNoJogo.gerarHerois();

		this.viewGame.getGamePanel().setHeros(novosHeros);

		this.heros.clear();
		this.heros.add(novosHeros[0]);
		this.heros.add(novosHeros[1]);
		
		for(Map map: viewGame.getGamePanel().getMaps()) {
			if(map.isActivated()) {
				map.setObjetos(RegistrarNoJogo.gerarNumeros(map.getCamadaColisao()));
				break;
			}
		}

		for (int i = 0; i< novosHeros.length; i++){
			ControllerHero ch = new ControllerHero(novosHeros[i]);
			viewGame.addKeyListener(ch);
		}

		//		iniciarTimerObjetivo();
	}

	public void iniciarTimerObjetivo() {

		tempoDecorrido = 0;

		timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {

				if(viewDialogo.isVisible()) return;

				tempoDecorrido += 1;
				viewGame.getInfoPanel().setTempo(tempoDecorrido);
				if(tempoDecorrido >= duracaoObjetivo) {
					viewDialogo.setMensagem("<html>O tempo esgotou!<br/> GAME OVER!");
					viewDialogo.setVisible(true);
				}
			}
		};

		timer.scheduleAtFixedRate(timerTask, 10, 1000);
	}

	public void checarColisoes() {
		for(Map map :maps){
			if(!map.isActivated())
				break;
			for(Rectangle rectangle: map.getCamadaColisao().getRectsColisao()){
				for(Hero hero: heros) {
					if(rectangle.intersects(hero.getRetangulo()))
						hero.parar();
				};
			}
		}
	}

	public void checarObjetivos() {

		for(Map map :maps){

			if(!map.isActivated()) break;

			//			if (map.getObjetos().size() == 0 && !gameWin) {
			//				heros.forEach(hero -> BaseDados.atualizarPontuacao(hero.getPlayer(), 1));
			//				this.viewDialogo.setMensagem("<html>Parabéns!!<br/>Vocês ganharam!!");
			//				this.viewDialogo.setVisible(true);
			//				break;
			//			}

			for(Objeto objeto: map.getObjetos()){
				for(Hero hero: heros){
					if(objeto.getRetangulo().intersects(hero.getRetangulo())) {
						hero.getInventary().add(objeto);
						hero.somPegandoObjeto();
						hero.setVida(hero.getVida()+10);
						objeto.setCapturado(true);
					}
				}

				if(objeto.isCapturado()) {
					map.getObjetos().remove(objeto);
					break;
				}
			}
		}
	}

	public void limparComandos() {
		if (viewDialogo.isVisible()) {
			for (KeyListener kl: viewGame.getKeyListeners()) {
				if(kl instanceof ControllerHero)
					((ControllerHero) kl).getKeyPool().clear();
			}
		}
	}

	@Override
	public void run() {
		while (true) {

			try {Thread.sleep(50);} catch (InterruptedException e) {e.printStackTrace();}

			checarColisoes();
			checarObjetivos();

			for (KeyListener kl: viewGame.getKeyListeners()) {
				if(kl instanceof ControllerHero) {
					((ControllerHero) kl).atualizaHero();
				}
			}
			this.viewGame.getGamePanel().repaint();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (!gameOver && !gameWin) {
				pausado = !pausado;
				viewDialogo.setMensagem("JOGO PAUSADO!");
				viewDialogo.setVisible(pausado);				
			}else if(gameOver || gameWin){ 
				timer.cancel();
				timer.purge();
				viewDialogo.setVisible(false);
				novoJogo();
			}
		}

		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			timer.cancel();
			timer.purge();
			viewDialogo.setVisible(false);
			novoJogo();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
