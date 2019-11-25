package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import model.Objeto;
import model.Map;
import model.Player;
import model.RegistrarJogo;
import view.ViewGame;

public class ControllerGame implements Runnable, KeyListener {

	private ViewGame viewGame;
	private boolean pausado = false;
	private boolean gameOver = false;
	private boolean gameWin = false;
	private int tempo = 0;
	private Timer timer;

	public ControllerGame() {
		this.viewGame = RegistrarJogo.getViewGame();
		this.viewGame.addKeyListener(this);
		this.viewGame.setVisible(true);
		novoJogo();
	}

	public void novoJogo() {
		
		RegistrarJogo.registerMap();
		RegistrarJogo.registerPlayer();
		
		ArrayList<Player> players = viewGame.getGamePanel().getPlayers();
		
		players.forEach((player) -> {
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
				viewGame.getGamePanel().getPlayers().forEach((player)->{
					player.getHero().setVida(player.getHero().getVida()-5);
				});
				tempo += 1;
				viewGame.getInfoPanel().setTempo(tempo);
				if(tempo > 30) gameOver = true;
			}
		};

		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}


	public void checarColisoes(ArrayList<Map> maps, ArrayList<Player> players) {

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

	public void checarObjetivos(ArrayList<Map> maps, ArrayList<Player> players) {
		for(Map map :maps){

			if(!map.isActivated()) break;

			if (map.getItens().size() == 0) gameWin = true;

			for(Objeto item: map.getItens()){
				for(Player player: players){
					
					if(item.getRetangulo().intersects(player.getHero().getRetangulo())) {
						player.getInventary().getItems().add(item);
						player.setPoints(10);
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

			if (gameWin) {
				timer.cancel();
				gameWin = false;
				novoJogo();
			}

			if (gameOver) {
								
			}

			if (!pausado) {
				checarColisoes(viewGame.getGamePanel().getMaps(), viewGame.getGamePanel().getPlayers());
				checarObjetivos(viewGame.getGamePanel().getMaps(), viewGame.getGamePanel().getPlayers());

				for (KeyListener kl: viewGame.getKeyListeners()) {
					if(kl instanceof ControllerHero) {
						((ControllerHero) kl).atualizaHero();
					}
				}

				this.viewGame.getInfoPanel().atualizarPontuacao(viewGame.getGamePanel().getPlayers());
				this.viewGame.getGamePanel().repaint();
			}

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			pausado = !pausado;

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
