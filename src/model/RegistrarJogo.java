package model;

import java.io.IOException;
import java.util.ArrayList;

import view.GamePanel;
import view.ViewGame;

public class RegistrarJogo {
	
	private ViewGame viewGame;
	
	public RegistrarJogo( ViewGame viewGame) {
		this.viewGame = viewGame;
	}
	
	public void registerMap() {
		
		
		try {
			//Camada mapa1_camada1 = new Camada(15, 20, 32, 32, "img/mapa/tileset.png", "img/mapa/mapa01_camada01.txt");
			//Camada mapa1_camada2 = new Camada(15, 20, 32, 32, "img/mapa/tileset.png",  "img/mapa/mapa01_camada_colisao.txt");
			Camada mapa1_camada1 = new Camada(23, 42, 16, 16, "img/mapa/tileset.png", "img/mapa/mapa_novo/camada_01.txt");
			Camada mapa1_camada2 = new Camada(23, 42, 16, 16, "img/mapa/tileset.png",  "img/mapa/mapa_novo/camada_02.txt");
			Camada mapa1_camada3 = new Camada(23, 42, 16, 16, "img/mapa/tileset.png", "img/mapa/mapa_novo/camada_03.txt");
			
			mapa1_camada3.setCamadaColisao(true);
			
			ArrayList<Camada> camadas = new ArrayList<Camada>();

			camadas.add(mapa1_camada1);
			camadas.add(mapa1_camada2);
			camadas.add(mapa1_camada3);
			
			Item item1 = new Item("porção", 10, "img/acessorios/flecha.png");
			
			ArrayList<Item> itens = new ArrayList<Item>();
			itens.add(item1);
			
			Map mapa = new Map(camadas, itens);
			mapa.setActivated(true);
			
			Map mapa2 = new Map(camadas, itens);
			mapa2.setActivated(false);

			ArrayList<Map> maps = new ArrayList<Map>();
			maps.add(mapa);
			maps.add(mapa2);
			
			
			this.viewGame.getGamePanel().setMaps(maps);
			this.viewGame.getGamePanel().getMaps().forEach(map->map.getCamadas().forEach(camada->camada.montarMapa(680, 380)));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void registerPlayer() {

//		Xml xml = new Xml();
		
		Player player = new Player("Joao");
		Player player2 = new Player("Maria");
		
		
		Sprite sprite = new Sprite("img/sprites/heroina.png", 5, 6, 4, 30, 250);
		Sprite sprite2 = new Sprite("img/sprites/heroi3.png", 5, 6, 4, 50, 250);
		
		Hero hero = new Hero(sprite);
		Hero hero2 = new Hero(sprite2);
		
		player.setHero(hero);
		player2.setHero(hero2);
		
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player);
		players.add(player2);
//		ArrayList<Player> players = xml.ler();
		
//		xml.salvar(player);
//		xml.salvar(player2);
		
		this.viewGame.getGamePanel().setPlayers(players);
		
	}

	public ViewGame getViewGame() {
		return viewGame;
	}

	public void setViewGame(ViewGame viewGame) {
		this.viewGame = viewGame;
	}

}
