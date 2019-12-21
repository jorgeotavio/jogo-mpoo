package controller;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import model.ObjetoNoMapa;
import model.BaseDados;
import model.Hero;
import model.Map;
import model.RegistrarNoJogo;
import view.ViewGame;
import view.ViewMenu;
import view.Mensagem;

public class ControllerGame implements Runnable {

	private ViewGame viewGame;
	private ViewMenu viewMenu;
	private Map map;
	private ArrayList<Hero> heros;
	private int faseAtual = 1;
	private int totalDeFases = 3;
	private double idPartida;
	private Random random;
	private boolean terminou = false;
	Hero[] novosHeros;

	public ControllerGame(ViewGame viewGame, ViewMenu viewMenu) {
		this.viewGame = viewGame;
		
		this.viewGame.getInfoPanel().getBotaoMenu().addActionListener((e) -> {;
			viewGame.setVisible(false);
			viewMenu.setVisible(true);
		});
		
		this.viewGame.setVisible(true);
		this.viewMenu = viewMenu;
		random = new Random();
		idPartida = random.nextDouble();
		updateFase();
	}

	public void updateFase() {
		if(faseAtual == totalDeFases+1) {
			switch(Mensagem.confirmar(maiorPontuacao())) {
			case 0:
				faseAtual = 1;
				break;
			default:
				terminou=true;
				idPartida = random.nextDouble();
				this.viewMenu.setVisible(true);
				this.viewGame.setVisible(false);
				return;
			}
		}

		atualizarHeros();
		atualizarMap();
	}

	public String maiorPontuacao() {
		Hero heroVencedor = heros.get(0);
		for(Hero hero: heros) {
			if(hero.getPontos()>heroVencedor.getPontos())
				heroVencedor = hero;
		}
		return heroVencedor.getNome();
	}

	public void atualizarHeros() {
		if(faseAtual > 1) 
			for(Hero hero: heros) {
				BaseDados.atualizarPontuacao(hero, idPartida);
			}

		novosHeros = RegistrarNoJogo.gerarHerois();
		atualizarComandosGame();

		this.viewGame.getGamePanel().setHeros(novosHeros);
		this.heros = new ArrayList<Hero>();
		this.heros.add(novosHeros[0]);
		this.heros.add(novosHeros[1]);

		for (int i =0; i< heros.size() ; i++) {
			if (faseAtual>1)
				heros.get(i).setPontos(BaseDados.getPontuacao(i, idPartida));
			else
				atualiarDadosHero(heros.get(i));
		}
	}

	public void atualizarMap() {
		this.map = RegistrarNoJogo.criarMapa(faseAtual);
		this.viewGame.getGamePanel().setMap(map);
		viewGame.getInfoPanel().getMissaoDescLabel().setText("<html>Pegue os "+this.map.getObjetivoMapa());
	}

	public void atualizarComandosGame() {
		for (int i = 0; i < viewGame.getKeyListeners().length; i++)
			viewGame.removeKeyListener(viewGame.getKeyListeners()[i]);

		for (int i = 0; i< novosHeros.length; i++){
			ControllerHero ch = new ControllerHero(novosHeros[i]);
			viewGame.addKeyListener(ch);
		}
	}

	public void checarColisoes() {
		for(Rectangle rectangle: map.getCamadaColisao().getRectsColisao()){
			for(Hero hero: heros) {
				if(rectangle.intersects(hero.getRetangulo()))
					hero.parar();
			};
		}
	}

	public void atualizarHero(Hero hero, ObjetoNoMapa objeto) {
		if(objeto.isObjetivo()) {
			hero.getInventary().add(objeto);
			hero.setVida(hero.getVida()+25);
			hero.addPontos(objeto.getPontos());
			map.setTotalObjetosValidos(map.getTotalObjetosValidos()-1);
		}else if(!objeto.isCongelaInimigo()){
			hero.setVida(hero.getVida()-25);						
		}
		atualiarDadosHero(hero);
		hero.somPegandoObjeto();
		objeto.setCapturado(true);
	}

	public void atualiarDadosHero(Hero hero) {
		viewGame.getInfoPanel().
		getInvent()[heros.indexOf(hero)].setText(Integer.toString(hero.getInventary().size()));
		viewGame.getInfoPanel().
		getPontos()[heros.indexOf(hero)].setText(Integer.toString(hero.getPontos()));
	}

	public void checarObjetivos() {

		for(ObjetoNoMapa objeto: map.getObjetos()){
			for(Hero hero: heros){
				if(objeto.getRetangulo().intersects(hero.getRetangulo()) && 
						hero.getControllerHero().getKeyPool().get(hero.getComandos().get("PEGAR")) != null) {

					atualizarHero(hero, objeto);
					
					if(objeto.isCongelaInimigo()){
						int index = heros.indexOf(hero);
						if(index+1 == heros.size())
							heros.get(index-1).ficarCongelado();
						else
							heros.get(index+1).ficarCongelado();
						break;
					}
				}
			}

			if(objeto.isCapturado()) {
				map.getObjetos().remove(objeto);
				break;
			}
		}

		if(map.getTotalObjetosValidos() == 0) {
			faseAtual++;
			updateFase();
		}
	}

	@Override
	public void run() {
		while (true) {
			if(terminou) break;

			checarColisoes();
			checarObjetivos();

			for (Hero hero: heros) {
				hero.getControllerHero().atualizaHero();
			}

			this.viewGame.getGamePanel().repaint();
			try {Thread.sleep(50);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}

}
