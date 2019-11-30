package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class BaseDados {

	private static XStream xStream = new XStream(new Dom4JDriver());
	private static File dadosFile = new File("res/dados.xml");
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<String[]> pontuacoes;

	public static boolean salvarPlayer(Player player) {
		players = new ArrayList<Player>();
		xStream.alias("Player", Objeto.class);
		try {
			ArrayList<Player> playersArquivo = BaseDados.getPlayers();

			boolean gravou = false;

			for(Player p: playersArquivo) {
				if(p.getName().equalsIgnoreCase(player.getName())) {
					p.setPoints(player.getPoints());
					gravou = true;
				}else {
					players.add(p);
				}
			}

			if(!gravou) players.add(player);

			OutputStream stream = new FileOutputStream(dadosFile);
			xStream.toXML(players, stream);
			stream.close();
			return true;

		} catch (IOException e) {
			return false;
		}
	}
	
	public static boolean atualizarPlayer(Player player) {
		
		players = new ArrayList<Player>();
		
		xStream.alias("Player", Objeto.class);
		try {
			ArrayList<Player> playersArquivo = BaseDados.getPlayers();

			boolean gravou = false;

			for(Player p: playersArquivo) {
				if(p.getName().equalsIgnoreCase(player.getName())) {
					p.setPoints(player.getPoints());
					gravou = true;
				}
				players.add(p);
			}

			if(!gravou) players.add(player);

			OutputStream stream = new FileOutputStream(dadosFile);
			xStream.toXML(players, stream);
			stream.close();
			return true;

		} catch (IOException e) {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Player> getPlayers() {
		if (dadosFile.exists()) {
			try {
				InputStream stream = new FileInputStream(dadosFile);
				ArrayList<Player> playersArquivo = (ArrayList<Player>) xStream.fromXML(stream);
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return playersArquivo;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<Player>();
	}

}
