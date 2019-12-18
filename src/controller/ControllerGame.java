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
import model.Hero;
import model.Map;
import model.RegistrarNoJogo;
import view.ViewGame;
import view.ViewDialogo;

public class ControllerGame implements Runnable, KeyListener, ActionListener {

	private ViewGame viewGame;
	private ViewDialogo viewDialogo;
	private int duracaoObjetivo = 30;
	private int tempoDecorrido;
	private Timer timer;
	private ArrayList<Map> maps;
	private ArrayList<Hero> heros;
	Hero[] novosHeros;

	public ControllerGame(ViewGame viewGame) {
		this.viewGame = viewGame;
		this.viewGame.setVisible(true);

		this.viewDialogo = new ViewDialogo();
		this.viewDialogo.addKeyListener(this);

		novoJogo();
	}

	public void novoJogo() {
		RegistrarNoJogo.allMaps(this.viewGame);

		novosHeros = RegistrarNoJogo.gerarHerois();
		this.viewGame.getGamePanel().setHeros(novosHeros);

		this.heros = new ArrayList<Hero>();
		this.heros.add(novosHeros[0]);
		this.heros.add(novosHeros[1]);

		this.maps = viewGame.getGamePanel().getMaps();
		
		addKeylistersGame();
		iniciarTimerObjetivo();
		
		System.gc();
	}
	
	public void addKeylistersGame() {
		for (int i = 0; i < viewGame.getKeyListeners().length; i++)
			viewGame.removeKeyListener(viewGame.getKeyListeners()[i]);
		
		for (int i = 0; i< novosHeros.length; i++){
			ControllerHero ch = new ControllerHero(novosHeros[i]);
			viewGame.addKeyListener(ch);
		}		
		viewGame.addKeyListener(this);
	
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
