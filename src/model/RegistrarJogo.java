package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.glass.events.KeyEvent;

import view.GamePanel;
import view.ViewGame;

public class RegistrarJogo {
	
	private static ViewGame viewGame = new ViewGame();
	
	public static void registerMap() {
		try {
			Camada mapa1_camada1 = new Camada(23, 42, 16, 16, "img/mapa/tileset.png", "img/mapa/mapa_novo/camada_01.txt");
			Camada mapa1_camada2 = new Camada(23, 42, 16, 16, "img/mapa/tileset.png",  "img/mapa/mapa_novo/camada_02.txt");
			Camada mapa1_camada3 = new Camada(23, 42, 16, 16, "img/mapa/tileset.png", "img/mapa/mapa_novo/camada_03.txt");
			
			mapa1_camada3.setCamadaColisao(true);
			
			ArrayList<Camada> camadas = new ArrayList<Camada>();

			camadas.add(mapa1_camada1);
			camadas.add(mapa1_camada2);
			camadas.add(mapa1_camada3);
			
			Objeto objeto1 = new Objeto("maca", "img/itens/maca_item.png", 200, 200);
			Objeto objeto2 = new Objeto("banana", "img/itens/banana_item.png", 300, 200);
			Objeto objeto3 = new Objeto("melancia", "img/itens/melancia_item.png", 350, 100);
			Objeto objeto4 = new Objeto("maca", "img/itens/maca_item.png", 500, 140);
			Objeto objeto5 = new Objeto("melancia", "img/itens/melancia_item.png", 130, 250);
			
			ArrayList<Objeto> itens = new ArrayList<Objeto>();
			itens.add(objeto1);
			itens.add(objeto2);
			itens.add(objeto3);
			itens.add(objeto4);
			itens.add(objeto5);
			
			Map mapa = new Map(camadas, itens);
			mapa.setActivated(true);
			
			Map mapa2 = new Map(camadas, itens);
			mapa2.setActivated(false);

			ArrayList<Map> maps = new ArrayList<Map>();
			maps.add(mapa);
			maps.add(mapa2);
			
			RegistrarJogo.viewGame.getGamePanel().setMaps(maps);
			RegistrarJogo.viewGame.getGamePanel().getMaps().forEach(map->map.getCamadas().forEach(camada->camada.montarMapa(680, 380)));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void registerPlayer() {

		Player player = new Player("Joao");
		Sprite sprite = new Sprite("img/sprites/heroina_2.png", 2, 6, 4, 26, 250);
		HashMap<String, Integer> comandos1 = new HashMap<String, Integer>();
		comandos1.put("UP", KeyEvent.VK_UP);
		comandos1.put("DOWN", KeyEvent.VK_DOWN);
		comandos1.put("LEFT", KeyEvent.VK_LEFT);
		comandos1.put("RIGHT", KeyEvent.VK_RIGHT);
		Hero hero = new Hero(sprite, comandos1);
		player.setHero(hero);
		
		Player player2 = new Player("Maria");
		Sprite sprite2 = new Sprite("img/sprites/heroina__.png", 2, 6, 4, 24, 200);
		HashMap<String, Integer> comandos2 = new HashMap<String, Integer>();
		comandos2.put("UP", KeyEvent.VK_W);
		comandos2.put("DOWN", KeyEvent.VK_S);
		comandos2.put("LEFT", KeyEvent.VK_A);
		comandos2.put("RIGHT", KeyEvent.VK_D);
		Hero hero2 = new Hero(sprite2, comandos2);
		player2.setHero(hero2);
		
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player);
		players.add(player2);
		
//		Xml xml = new Xml();		
//		xml.salvar(player);
//		xml.salvar(player2);
//		ArrayList<Player> players = xml.ler();
		
		viewGame.getGamePanel().setPlayers(players);
		viewGame.getInfoPanel().cadastrarLabels(players);
	}

	public static ViewGame getViewGame() {
		return viewGame;
	}
}
