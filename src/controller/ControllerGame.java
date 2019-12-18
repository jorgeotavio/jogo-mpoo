package controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import model.Objeto;
import model.Hero;
import model.Map;
import model.RegistrarNoJogo;
import view.ViewGame;
import view.ViewDialogo;

public class ControllerGame implements Runnable, KeyListener, ActionListener {

	private ViewGame viewGame;
	private ViewDialogo viewDialogo;
	private ArrayList<Map> maps;
	private Map map;
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
		this.maps = RegistrarNoJogo.allMaps();

		novosHeros = RegistrarNoJogo.gerarHerois();

		addKeylistersGame();

		this.viewGame.getGamePanel().setHeros(novosHeros);

		this.heros = new ArrayList<Hero>();
		this.heros.add(novosHeros[0]);
		this.heros.add(novosHeros[1]);

		avancarMapa();

		System.gc();
	}

	public void avancarMapa() {
		for (int i = 0; i < maps.size(); i++) {
			if(maps.get(i).isActivated()) {
				this.map = maps.get(i);
				viewGame.getGamePanel().setMap(map);;
			}
		}
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

	public void checarColisoes() {
		for(Rectangle rectangle: map.getCamadaColisao().getRectsColisao()){
			for(Hero hero: heros) {
				if(rectangle.intersects(hero.getRetangulo()))
					hero.parar();
			};
		}
	}

	public void checarObjetivos() {

		if(map.getObjetos().size() == 0) {
			map.setActivated(false);
			int index = maps.indexOf(map);
			maps.get(index+1).setActivated(true);
			avancarMapa();
			return;
		}

		for(Objeto objeto: map.getObjetos()){
			for(Hero hero: heros){
				if(objeto.getRetangulo().intersects(hero.getRetangulo()) && hero.getControllerHero().getKeyPool().get(hero.getComandos().get("PEGAR")) != null) {
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

			checarColisoes();
			checarObjetivos();

			for (Hero hero: heros) {
				hero.getControllerHero().atualizaHero();
			}

			this.viewGame.getGamePanel().repaint();
			try {Thread.sleep(50);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
		}

		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
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
