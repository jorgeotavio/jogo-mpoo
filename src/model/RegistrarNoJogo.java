package model;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.sun.glass.events.KeyEvent;

import view.ViewGame;

public class RegistrarNoJogo {

	public static void registerMap( ViewGame viewGame) {
		try {
			Camada mapa1_camada1 = new Camada(30, 40, 16, 16, "img/mapa/tileset.png", "img/mapa/mapa_3va/mapa_1_camada_1.txt");
			Camada mapa1_camada2 = new Camada(30, 40, 16, 16, "img/mapa/tileset.png",  "img/mapa/mapa_3va/mapa_1_camada_2.txt");
			Camada mapa1_camada3 = new Camada(30, 40, 16, 16, "img/mapa/tileset.png", "img/mapa/mapa_3va/mapa_1_camada_3.txt");

			mapa1_camada2.setCamadaColisao(true);

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
			viewGame.getGamePanel().getMaps().forEach(map->map.getCamadas().forEach(camada->camada.montarMapa(640, 480)));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Objeto> gerarNumeros(Camada camada){
		
		if (camada == null || !camada.isCamadaColisao()) return new ArrayList<Objeto>();
		
		Random random = new Random();
		ArrayList<Objeto> objetosNumeros = new ArrayList<Objeto>();
		
		while(objetosNumeros.size() < 50) {
			
			int posX = random.nextInt(608)+16;
			int posY = random.nextInt(448)+16;
			
			Objeto objetoNumero = new Objeto(Integer.toString(random.nextInt(100)), posX, posY, 10);
			
			boolean intersectou = false;
			
			for(Rectangle rect: camada.getRectsColisao()) {				
				if (objetoNumero.getRetangulo().intersects(rect)) {
					intersectou = true;
					break;
				}
			}
			
			if(!intersectou) objetosNumeros.add(objetoNumero);
		}

		return objetosNumeros;
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

		Sprite sprite = new Sprite("img/sprites/heroina_2.png", 2, 6, 4, 40, 20);
		HashMap<String, Integer> comandos1 = new HashMap<String, Integer>();
		comandos1.put("UP", KeyEvent.VK_UP);
		comandos1.put("DOWN", KeyEvent.VK_DOWN);
		comandos1.put("LEFT", KeyEvent.VK_LEFT);
		comandos1.put("RIGHT", KeyEvent.VK_RIGHT);
		Hero hero = new Hero("Player 1",sprite, comandos1);

		Sprite sprite2 = new Sprite("img/sprites/heroina__.png", 2, 6, 4, 20, 40);
		HashMap<String, Integer> comandos2 = new HashMap<String, Integer>();
		comandos2.put("UP", KeyEvent.VK_W);
		comandos2.put("DOWN", KeyEvent.VK_S);
		comandos2.put("LEFT", KeyEvent.VK_A);
		comandos2.put("RIGHT", KeyEvent.VK_D);
		Hero hero2 = new Hero("Player 2", sprite2, comandos2);

		Hero[] heros = new Hero[2];
		heros[0] = hero;
		heros[1] = hero2;

		return heros;
	}

}
