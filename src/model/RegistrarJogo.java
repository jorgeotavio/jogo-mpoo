package model;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			Camada camada1 = new Camada(15, 20, 32, 32, "img/mapa/tileset.png", "img/mapa/mapa01_camada01.txt");
			Camada camada2 = new Camada(15, 20, 32, 32, "img/mapa/tileset.png",  "img/mapa/mapa01_camada_colisao.txt");
			
			camada2.colisoes();
			camada2.setCamadaColisao(true);
			
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

//		Xml xml = new Xml();
//		
		Player player = new Player("Joao");
//		Player player2 = new Player("Maria");
//		
//		
		Sprite sprite = new Sprite("img/sprites/heroi.png", 3, 4, 4, 300, 200);
//		Sprite sprite2 = new Sprite("img/sprites/heroi.png", 3, 4, 4, 200, 200);
//		
		Hero hero = new Hero(sprite);
//		Hero hero2 = new Hero(sprite2);
//		
		player.setHero(hero);
//		player2.setHero(hero2);
		
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player);
//		ArrayList<Player> players = xml.ler();
		
//		xml.salvar(player);
//		xml.salvar(player2);
		
		viewGame.setPlayers(players);
		
	}

	public ViewGame getViewGame() {
		return viewGame;
	}

	public void setViewGame(ViewGame viewGame) {
		this.viewGame = viewGame;
	}

}
