package model;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;

import view.ViewGame;

public class RegistrarJogo {
	
	private ArrayList<Map> maps;
	private ViewGame viewGame;

	public RegistrarJogo( ViewGame viewGame ) {
		this.viewGame = viewGame;
	}
	
	public void registerMap() {
		
		ArrayList<Camada> camadas = new ArrayList<Camada>();
		
		try {
			Camada camada1 = new Camada(15, 20, 32, 32, "img/mapa/chipset.png", "img/mapa/camada01.txt");
			Camada camada2 = new Camada(15, 20, 32, 32, "img/mapa/castelo.png",  "img/mapa/camada02.txt");

			camadas.add(camada1);
			camadas.add(camada2);

			Map mapa = new Map(camadas);
			mapa.setActivated(true);

			ArrayList<Map> maps = new ArrayList<Map>();
			maps.add(mapa);
			
			this.viewGame.setMaps(maps);
			this.viewGame.getMaps().forEach(map->map.getCamadas().forEach(camada->camada.montarMapa(680, 480)));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void registerPlayer() {
		
		Player player = new Player("Joao");
		
		Sprite sprite = new Sprite("img/sprites/heroi.png", 3, 4, 4, 100, 100);
		Hero hero = new Hero(sprite);
		
		Rectangle2D.Float r = new Rectangle2D.Float(0,0, viewGame.getWidth()-1,viewGame.getHeight()-1);
		hero.setRetangulo(r);
		player.setHero(hero);
		
		ArrayList<Player> players =  new ArrayList<Player>();
		players.add(player);
		
		viewGame.setPlayers(players);
		
	}

	public ViewGame getViewGame() {
		return viewGame;
	}

	public void setViewGame(ViewGame viewGame) {
		this.viewGame = viewGame;
	}

}
