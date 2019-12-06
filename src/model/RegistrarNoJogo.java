package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.sun.glass.events.KeyEvent;

import view.ViewGame;

public class RegistrarNoJogo {

	public static void registerMap( ViewGame viewGame) {
		try {
			Camada mapa1_camada1 = new Camada(23, 42, 16, 16, "img/mapa/tileset.png", "img/mapa/mapa_novo/camada_01.txt");
			Camada mapa1_camada2 = new Camada(23, 42, 16, 16, "img/mapa/tileset.png",  "img/mapa/mapa_novo/camada_02.txt");
			Camada mapa1_camada3 = new Camada(23, 42, 16, 16, "img/mapa/tileset.png", "img/mapa/mapa_novo/camada_03.txt");
			
			mapa1_camada3.setCamadaColisao(true);

			ArrayList<Camada> camadas = new ArrayList<Camada>();

			camadas.add(mapa1_camada1);
			camadas.add(mapa1_camada2);
			camadas.add(mapa1_camada3);

			Map mapa = new Map(camadas);
			mapa.setActivated(true);
			
			Map mapa2 = new Map(camadas);
			mapa2.setActivated(false);

			ArrayList<Map> maps = new ArrayList<Map>();
			maps.add(mapa);
			maps.add(mapa2);

			viewGame.getGamePanel().setMaps(maps);
			viewGame.getGamePanel().getMaps().forEach(map->map.getCamadas().forEach(camada->camada.montarMapa(680, 380)));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Objeto> gerarFrutas() {
		Random random = new Random();
		ArrayList<Objeto> itens = new ArrayList<Objeto>();
		
		String[] arquivos = new String[3];
		arquivos[0] = "img/objetos/frutas/maca_item.png";
		arquivos[1] = "img/objetos/frutas/melancia_item.png";
		arquivos[2] = "img/objetos/frutas/banana_item.png";
		
		String[] frutas = new String[3];
		frutas[0] = "Maçã";
		frutas[1] = "Melancia";
		frutas[2] = "Banana";
		
		int[] pontos = new int[3];
		pontos[0] = 10;
		pontos[1] = 30;
		pontos[2] = 15;
		
		int totalItems = 30;
		
		int[][] coordenadas = new int[totalItems][2];
		
		for (int i = 0; i<totalItems; i++) {
			for (int j = 0 ;j <= 1 ; j++) {
				
				if (j == 0) coordenadas[i][j] =  random.nextInt(450)+100;
				else coordenadas[i][j] = random.nextInt(250)+50;
			
			}
			int index = random.nextInt(3);
			itens.add(new Objeto(frutas[index], arquivos[index],coordenadas[i][0], coordenadas[i][1], pontos[index]));
		}
		
		return itens;
	}
	
	public static Hero[] gerarHerois() {

		Player player = new Player("NomePlayer1");
		Sprite sprite = new Sprite("img/sprites/heroina_2.png", 2, 6, 4, 26, 250);
		HashMap<String, Integer> comandos1 = new HashMap<String, Integer>();
		comandos1.put("UP", KeyEvent.VK_UP);
		comandos1.put("DOWN", KeyEvent.VK_DOWN);
		comandos1.put("LEFT", KeyEvent.VK_LEFT);
		comandos1.put("RIGHT", KeyEvent.VK_RIGHT);
		Hero hero = new Hero("Joana",sprite, comandos1);
		hero.setPlayer(player);
		
		Player player2 = new Player("NomePlayer2");
		Sprite sprite2 = new Sprite("img/sprites/heroina__.png", 2, 6, 4, 24, 200);
		HashMap<String, Integer> comandos2 = new HashMap<String, Integer>();
		comandos2.put("UP", KeyEvent.VK_W);
		comandos2.put("DOWN", KeyEvent.VK_S);
		comandos2.put("LEFT", KeyEvent.VK_A);
		comandos2.put("RIGHT", KeyEvent.VK_D);
		Hero hero2 = new Hero("Judith", sprite2, comandos2);
		hero2.setPlayer(player2);;

		Hero[] heros = new Hero[2];
		heros[0] = hero;
		heros[1] = hero2;

		return heros;
	}

}
