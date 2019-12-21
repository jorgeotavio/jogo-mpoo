package model;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RegistrarNoJogo {
	
	public static Map mapa = new Map();
	public static String tileSet = "tileset.png";
	
	public static Map criarMapa(int fase) {
		String objetivo;
		String mapLocation;
		
		switch (fase) {
		case 2:
			objetivo = "IMPARES";
			mapLocation = "mapa_2";
			break;
		case 3:
			objetivo = "PRIMOS";
			mapLocation = "mapa_1";
			break;
		default:
			objetivo = "PARES";
			mapLocation = "mapa_1";
			break;
		}

		try {
			Camada camada1 = new Camada(30, 40, 16, 16, tileSet, mapLocation+"/camada_1.txt");
			Camada camada2 = new Camada(30, 40, 16, 16, tileSet,  mapLocation+"/camada_2.txt");

			camada2.setCamadaColisao(true);

			ArrayList<Camada> camadas = new ArrayList<Camada>();

			camadas.add(camada1);
			camadas.add(camada2);

			for (Camada camada: camadas) {
				camada.montarMapa(640, 480);
			}
			
			mapa.setCamadas(camadas);
			mapa.setObjetos(RegistrarNoJogo.gerarNumeros(objetivo, camada2));
			mapa.setTotalObjetosValidos(MathGame.totalDeObjetivosValidos(mapa.getObjetos()));
			mapa.setObjetivoMapa(objetivo);
			
			return mapa;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<ObjetoNoMapa> gerarNumeros(String tipo, Camada camada){

		if (camada == null || !camada.isCamadaColisao()) return new ArrayList<ObjetoNoMapa>();

		Random random = new Random();
		ArrayList<ObjetoNoMapa> objetosNoMapa = new ArrayList<ObjetoNoMapa>();

		ObjetoNoMapa objetoNoMapa;
		int totalCongeladores=4;
		
		while(objetosNoMapa.size() < 20) {

			int posX = random.nextInt(608)+16;
			int posY = random.nextInt(448)+16;
			int numero = random.nextInt(100);

			if (objetosNoMapa.size()<totalCongeladores) 
				objetoNoMapa= new ObjetoNoMapa(posX, posY);				
			else
				objetoNoMapa= new ObjetoNoMapa(Integer.toString(numero), posX, posY, 10, MathGame.verificarNumero(numero, tipo));				
			boolean intersectou = false;

			for(Rectangle rect: camada.getRectsColisao()) {				
				if (objetoNoMapa.getRetangulo().intersects(rect)) {
					intersectou = true;
					break;
				}
			}

			for(ObjetoNoMapa obj: objetosNoMapa) {				
				if (objetoNoMapa.getRetangulo().intersects(obj.getRetangulo())) {
					intersectou = true;
					break;
				}
			}

			if(!intersectou) objetosNoMapa.add(objetoNoMapa);
		}
		return objetosNoMapa;
	}

	public static Hero[] gerarHerois() {

		Sprite sprite = new Sprite("sprites/heroina.png", 2, 6, 4, 40, 20);
		HashMap<String, Integer> comandos1 = new HashMap<String, Integer>();
		comandos1.put("UP", KeyEvent.VK_UP);
		comandos1.put("DOWN", KeyEvent.VK_DOWN);
		comandos1.put("LEFT", KeyEvent.VK_LEFT);
		comandos1.put("RIGHT", KeyEvent.VK_RIGHT);
		comandos1.put("PEGAR", KeyEvent.VK_SHIFT);
		Hero hero = new Hero("Player 1",sprite, comandos1);

		Sprite sprite2 = new Sprite("sprites/heroina2.png", 2, 6, 4, 20, 40);
		HashMap<String, Integer> comandos2 = new HashMap<String, Integer>();
		comandos2.put("UP", KeyEvent.VK_W);
		comandos2.put("DOWN", KeyEvent.VK_S);
		comandos2.put("LEFT", KeyEvent.VK_A);
		comandos2.put("RIGHT", KeyEvent.VK_D);
		comandos2.put("PEGAR", KeyEvent.VK_SPACE);
		Hero hero2 = new Hero("Player 2", sprite2, comandos2);

		Hero[] heros = new Hero[2];
		heros[0] = hero;
		heros[1] = hero2;

		return heros;
	}

}
