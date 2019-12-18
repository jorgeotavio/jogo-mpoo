package model;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.sun.glass.events.KeyEvent;

import view.ViewGame;

public class RegistrarNoJogo {

	public static void allMaps( ViewGame viewGame) {
		ArrayList<Map> maps = new ArrayList<Map>();
		maps.add(criarMapa1());
		viewGame.getGamePanel().setMaps(maps);
	}
	
	public static Map criarMapa1() {
		try {
			Camada camada1 = new Camada(30, 40, 16, 16, "tileset.png", "mapa_1/camada_1.txt");
			Camada camada2 = new Camada(30, 40, 16, 16, "tileset.png",  "mapa_1/camada_2.txt");
			Camada camada3 = new Camada(30, 40, 16, 16, "tileset.png", "mapa_1/camada_3.txt");

			camada2.setCamadaColisao(true);

			ArrayList<Camada> camadas = new ArrayList<Camada>();

			camadas.add(camada1);
			camadas.add(camada2);
			camadas.add(camada3);

			for (Camada camada: camadas) {
				camada.montarMapa(640, 480);
			}

			Map mapa = new Map(camadas);
			mapa.setActivated(true);
			mapa.setObjetos(RegistrarNoJogo.gerarNumeros("primos", camada2));
			
			mapa.setObjetivoMapa("Pegar todos os números Primos!");
			
			return mapa;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Map criarMapa2() {
		try {
			Camada camada1 = new Camada(30, 40, 16, 16, "tileset.png", "mapa_2/camada_1.txt");
			Camada camada2 = new Camada(30, 40, 16, 16, "tileset.png",  "mapa_2/camada_2.txt");

			camada2.setCamadaColisao(true);

			ArrayList<Camada> camadas = new ArrayList<Camada>();

			camadas.add(camada1);
			camadas.add(camada2);

			for (Camada camada: camadas) {
				camada.montarMapa(640, 480);
			}

			Map mapa = new Map(camadas);
			mapa.setActivated(true);
			mapa.setObjetos(RegistrarNoJogo.gerarNumeros( "pares", camada2));
			
			mapa.setObjetivoMapa("Pegar todos os números pares!");
			
			return mapa;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}	

	public static ArrayList<Objeto> gerarNumeros(String tipo, Camada camada){

		if (camada == null || !camada.isCamadaColisao()) return new ArrayList<Objeto>();

		Random random = new Random();
		ArrayList<Objeto> objetosNumeros = new ArrayList<Objeto>();

		while(objetosNumeros.size() < 50) {

			int posX = random.nextInt(608)+16;
			int posY = random.nextInt(448)+16;
			int numero = random.nextInt(100);

			Objeto objetoNumero = new Objeto(Integer.toString(numero), posX, posY, 10, MathGame.verificarNumero(numero, tipo));

			boolean intersectou = false;

			for(Rectangle rect: camada.getRectsColisao()) {				
				if (objetoNumero.getRetangulo().intersects(rect)) {
					intersectou = true;
					break;
				}
			}

			for(Objeto obj: objetosNumeros) {				
				if (objetoNumero.getRetangulo().intersects(obj.getRetangulo())) {
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

		Sprite sprite = new Sprite("sprites/heroina.png", 2, 6, 4, 40, 20);
		HashMap<String, Integer> comandos1 = new HashMap<String, Integer>();
		comandos1.put("UP", KeyEvent.VK_UP);
		comandos1.put("DOWN", KeyEvent.VK_DOWN);
		comandos1.put("LEFT", KeyEvent.VK_LEFT);
		comandos1.put("RIGHT", KeyEvent.VK_RIGHT);
		Hero hero = new Hero("Player 1",sprite, comandos1);

		Sprite sprite2 = new Sprite("sprites/heroina2.png", 2, 6, 4, 20, 40);
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
