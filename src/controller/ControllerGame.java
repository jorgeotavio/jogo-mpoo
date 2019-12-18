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
import view.Mensagem;
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
		atualizarFase();
		System.gc();
	}

	public void atualizarFase() {
		addNovosHeros();
		if(maps.size() > 0) {
			this.map = maps.get(0);
			viewGame.getGamePanel().setMap(map);;			
		}
		Mensagem.exibir("O objetivo dessa fase é: "+map.getObjetivoMapa());
	}

	public void addNovosHeros() {
		novosHeros = RegistrarNoJogo.gerarHerois();
		atualizarComandosGame();
		this.viewGame.getGamePanel().setHeros(novosHeros);
		this.heros = new ArrayList<Hero>();
		this.heros.add(novosHeros[0]);
		this.heros.add(novosHeros[1]);
	}

	public void atualizarComandosGame() {
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

	public void atualizarDadosHero(Hero hero, Objeto objeto) {

		if(objeto.isObjetivo()) {
			hero.getInventary().add(objeto);
			hero.setVida(hero.getVida()+10);			
		} else {
			hero.setVida(hero.getVida()-10);						
		}
		viewGame.getInfoPanel().
		getInvent()[heros.indexOf(hero)].setText(Integer.toString(hero.getInventary().size()));
		hero.somPegandoObjeto();
		objeto.setCapturado(true);
	}

	public void checarObjetivos() {

		if(map.getObjetos().size() == 0 && maps.size() > 1) {
			maps.remove(0);
			atualizarFase();
			return;
		}

		for(Objeto objeto: map.getObjetos()){
			for(Hero hero: heros){
				if(objeto.getRetangulo().intersects(hero.getRetangulo()) && 
						hero.getControllerHero().getKeyPool().get(hero.getComandos().get("PEGAR")) != null) {
					atualizarDadosHero(hero, objeto);
				}
			}

			if(objeto.isCapturado()) {
				map.getObjetos().remove(objeto);
				break;
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
