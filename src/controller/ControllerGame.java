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
	private double duracaoObjetivo = 30;
	private double tempoDecorrido;
	private Timer timer;

	public ControllerGame(ViewGame viewGame) {
		this.viewGame = viewGame;
		this.viewGame.addKeyListener(this);
		this.viewGame.setVisible(true);
		this.viewDialogo = new ViewDialogo();
		this.viewDialogo.addKeyListener(this);
		
		novoJogo();
	}

	public void novoJogo() {
		
		Player[] players = RegistrarNoJogo.gerarPlayers();

		this.viewGame.getGamePanel().setPlayers(players);
		this.viewGame.getInfoPanel().setRecordes(BaseDados.getPontuacoes());

		for(Map map: viewGame.getGamePanel().getMaps()) {
			if(map.isActivated()) {
				map.setObjetos(RegistrarNoJogo.gerarFrutas());
				break;
			}
		}

		for (int i = 0; i< players.length; i++){
			ControllerHero ch = new ControllerHero(players[i].getHero());
			viewGame.addKeyListener(ch);
		}
		
		iniciarTimerObjetivo();
	}

	public void iniciarTimerObjetivo() {
		
		tempoDecorrido = 0;
		
		timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				
				if(viewDialogo.isVisible()) return;
				
				tempoDecorrido += 0.1;
				viewGame.getInfoPanel().setTempo(tempoDecorrido);
				if(tempoDecorrido >= duracaoObjetivo) {
					gameOver = true;
					viewDialogo.setMensagem("<html>O tempo esgotou!<br/> GAME OVER!");
					viewDialogo.setVisible(true);
				}
			}
		};

		timer.scheduleAtFixedRate(timerTask, 10, 100);
	}


	public void checarColisoes() {
		ArrayList<Map> maps = viewGame.getGamePanel().getMaps();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(viewGame.getGamePanel().getPlayers()[0]);
		players.add(viewGame.getGamePanel().getPlayers()[1]);
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
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(viewGame.getGamePanel().getPlayers()[0]);
		players.add(viewGame.getGamePanel().getPlayers()[1]);

		for(Map map :maps){

			if(!map.isActivated()) break;

			if (map.getObjetos().size() == 0 && !gameWin) {
				players.forEach(player -> BaseDados.atualizarPontuacao(player, 1));
				this.viewDialogo.setMensagem("<html>Parabéns!!<br/>Vocês ganharam!!");
				this.viewDialogo.setVisible(true);
				gameWin = true;
				break;
			}

			for(Objeto item: map.getObjetos()){
				for(Player player: players){
					if(item.getRetangulo().intersects(player.getHero().getRetangulo())) {
						player.getHero().getInventary().getItems().add(item);
						player.setPoints(player.getPoints()+item.getPontos());
						player.getHero().setVida(player.getHero().getVida()+10);
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
		while ( true ) {

			try {Thread.sleep(50);} catch (InterruptedException e) {e.printStackTrace();}

			if (viewDialogo.isVisible()) {
				for (KeyListener kl: viewGame.getKeyListeners()) {
					if(kl instanceof ControllerHero) {
						((ControllerHero) kl).getKeyPool().clear();
					}
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

			this.viewGame.getInfoPanel().atualizarPontuacao(viewGame.getGamePanel().getPlayers());
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
				gameOver = false;
				gameWin = false;
				novoJogo();
			}
		}

		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			gameOver = false;
			gameWin = false;
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
