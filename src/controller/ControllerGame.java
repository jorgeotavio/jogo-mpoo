package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import model.Objeto;
import model.BaseDados;
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
//		this.viewGame.getInfoPanel().setRecordes(BaseDados.getPontuacoes());

//		for(Map map: viewGame.getGamePanel().getMaps()) {
//			if(map.isActivated()) {
//				map.setObjetos(RegistrarNoJogo.gerarFrutas());
//				break;
//			}
//		}
		
		this.heros.clear();
		this.heros.add(viewGame.getGamePanel().getHeros()[0]);
		this.heros.add(viewGame.getGamePanel().getHeros()[1]);
		
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
		ArrayList<Map> maps = viewGame.getGamePanel().getMaps();
		ArrayList<Hero> heros = new ArrayList<Hero>();
		heros.add(viewGame.getGamePanel().getHeros()[0]);
		heros.add(viewGame.getGamePanel().getHeros()[1]);
		
		for(Map map :maps){

			if(!map.isActivated())
				break;

			map.getCamadas().forEach((camada) -> {

				if(!camada.isCamadaColisao())
					return;

				camada.getRectsColisao().forEach((rectangle) ->{
					heros.forEach((hero)->{
						if(rectangle.intersects(hero.getRetangulo()))
							hero.parar();
					});
				});
			});
		};
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

			for(Objeto item: map.getObjetos()){
				for(Hero hero: heros){
					if(item.getRetangulo().intersects(hero.getRetangulo())) {
						hero.getInventary().getItems().add(item);
						hero.somPegandoObjeto();
						hero.getPlayer().setPoints(hero.getPlayer().getPontos()+item.getPontos());
						hero.setVida(hero.getVida()+10);
						item.setCapturado(true);
					}
				}

				if(item.isCapturado()) {
					map.getObjetos().remove(item);
					break;
				}
			}

		};
	}

	@Override
	public void run() {
		while (true) {

			try {Thread.sleep(50);} catch (InterruptedException e) {e.printStackTrace();}

			if (viewDialogo.isVisible()) {
				for (KeyListener kl: viewGame.getKeyListeners()) {
					if(kl instanceof ControllerHero)
						((ControllerHero) kl).getKeyPool().clear();
				}
				continue;
			}

			checarColisoes();
			checarObjetivos();

			for (KeyListener kl: viewGame.getKeyListeners()) {
				if(kl instanceof ControllerHero) {
					((ControllerHero) kl).atualizaHero();
				}
			}

//			this.viewGame.getInfoPanel().atualizarPontuacao(viewGame.getGamePanel().getHeros());
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
