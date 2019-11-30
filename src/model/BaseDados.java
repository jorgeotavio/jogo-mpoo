package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class BaseDados {

	private static XStream xStream = new XStream(new Dom4JDriver());
	private static File dadosFile = new File( "res/players.xml");

	public static boolean salvarPlayer(Player player) {

		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<Player> playersArquivo = BaseDados.getPlayers();

		boolean gravou = false;

		for(Player p: playersArquivo) {
			if(p.getName().equalsIgnoreCase(player.getName())) {
				p.setPoints(player.getPoints());
				gravou = true;
			}
			else players.add(p);
		}

		if(!gravou) players.add(player);

		try {

			OutputStream stream = new FileOutputStream(dadosFile);
			xStream.toXML(players, stream);
			stream.close();

			Destrutor.destroyer(players);
			Destrutor.destroyer(playersArquivo);

			return true;

		} catch (IOException e) {
			return false;
		}
	}

	public static boolean atualizarPlayer(Player player) {

		ArrayList<Player> players = new ArrayList<Player>();;

		xStream.alias("Player", Player.class);
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

		xStream.alias("Player", Player.class);

		if (dadosFile.exists()) {
			try {
				InputStream stream = new FileInputStream(dadosFile);
				ArrayList<Player> playersArquivo = (ArrayList<Player>) xStream.fromXML(stream);
				stream.close();
				return playersArquivo;
			} catch (Exception e) {
				return new ArrayList<Player>(); 
			}
		}
		return new ArrayList<Player>();
	}

}
