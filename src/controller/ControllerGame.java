package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import model.Objeto;
import model.BaseDados;
import model.Map;
import model.Player;
import model.RegistrarNoJogo;
import view.ViewGame;
import view.ViewPause;

public class ControllerGame implements Runnable, KeyListener {

	private ViewGame viewGame;
	private ViewPause viewPause;
	private boolean pausado = false;
	private boolean gameOver = false;
	private boolean gameWin = false;
	private int tempo;
	private Timer timer;

	public ControllerGame(ViewGame viewGame) {
		this.viewGame = viewGame;
		this.viewGame.addKeyListener(this);
		this.viewGame.setVisible(true);
		this.viewPause = new ViewPause();
		viewPause.addKeyListener(this);
		novoJogo();
	}

	public void novoJogo() {
		
		ArrayList<Player> players = BaseDados.getPlayers();
		
//		RegistrarNoJogo.registerPlayer(viewGame);
		
		this.viewGame.getGamePanel().setPlayers(players);
		this.viewGame.getInfoPanel().setRecordes(BaseDados.getPontuacoes());
		
		RegistrarNoJogo.registerMap(viewGame);
		
		this.viewGame.getGamePanel().getPlayers().forEach((player) -> {
			ControllerHero ch = new ControllerHero(player.getHero());
			viewGame.addKeyListener(ch);
		});
		registrarTempo();
	}

	public void registrarTempo() {	
		tempo = 0;

		timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {

				viewGame.getGamePanel().getPlayers().forEach((p)->{
					p.getHero().setVida(p.getHero().getVida()-5);
				});
				tempo += 1;
				viewGame.getInfoPanel().setTempo(tempo);
				if(tempo > 30) gameOver = true;
			}
		};

		timer.scheduleAtFixedRate(timerTask, 10, 1000);
	}


	public void checarColisoes() {
		ArrayList<Map> maps = viewGame.getGamePanel().getMaps();
		ArrayList<Player> players = viewGame.getGamePanel().getPlayers();
		for(Map map :maps){

			if(!map.isActivated())
				break;

			map.getCamadas().forEach((camada) -> {

				if(!camada.isCamadaColisao())
					return;

				camada.getRectsColisao().forEach((rectangle) ->{
					players.forEach((player)->{
						if(rectangle.intersects(player.getHero().getRetangulo()))
							player.getHero().parar();
					});
				});
			});
		};
	}

	public void checarObjetivos() {
		ArrayList<Map> maps = viewGame.getGamePanel().getMaps();
		ArrayList<Player> players = viewGame.getGamePanel().getPlayers();
		
		for(Map map :maps){

			if(!map.isActivated()) break;

			if (map.getItens().size() == 0) {
				players.forEach(player -> BaseDados.atualizarPontuacao(player, 1));
				gameWin = true;
			}

			for(Objeto item: map.getItens()){
				for(Player player: players){
					if(item.getRetangulo().intersects(player.getHero().getRetangulo())) {
						player.getInventary().getItems().add(item);
						player.setPoints(player.getPoints()+10);
						player.getHero().setVida(player.getHero().getVida()+10);
						item.setCapturado(true);
					}
				}

				if(item.isCapturado()) {
					map.getItens().remove(item);
					break;
				}
			}

		};
	}

	public boolean isPausado() {
		return pausado;
	}

	public void setPausado(boolean pausado) {
		this.pausado = pausado;
	}

	@Override
	public void run() {
		while ( true ) {
			
			try {Thread.sleep(50);} catch (InterruptedException e) {e.printStackTrace();}
			
			if (pausado) {
				for (KeyListener kl: viewGame.getKeyListeners()) {
					if(kl instanceof ControllerHero) {
						((ControllerHero) kl).getKeyPool().clear();
					}
				}
				continue;
			}
			
			if (gameWin) {
				timer.cancel();
				timer.purge();
				gameWin = false;
				novoJogo();
			}

			if (gameOver) {
				
			}
			
			checarColisoes();
			checarObjetivos();

			for (KeyListener kl: viewGame.getKeyListeners()) {
				if(kl instanceof ControllerHero) {
					((ControllerHero) kl).atualizaHero();
				}
			}

			this.viewGame.getInfoPanel().atualizarPontuacao(viewGame.getGamePanel().getPlayers());
			this.viewGame.getGamePanel().repaint();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			pausado = !pausado;
			viewPause.setVisible(pausado);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
