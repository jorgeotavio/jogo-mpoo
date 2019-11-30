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

import sun.security.krb5.internal.crypto.Des;

public class BaseDados {

	private static XStream xStream = new XStream(new Dom4JDriver());
	private static File dadosFile = new File( "res/players.xml");
	private static File pontuacoesFile = new File("res/pontuacoes.xml");
	
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
			Destrutor.destroyer(player);
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
				Destrutor.destroyer(stream);
				return playersArquivo;
			} catch (Exception e) {
				return new ArrayList<Player>(); 
			}
		}
		return new ArrayList<Player>();
	}
	
	@SuppressWarnings("unchecked")
	public static Player[] getPlayersSelecionados() {

		xStream.alias("Player", Player.class);
		Player[] players = new Player[2];
		if (dadosFile.exists()) {
			try {
				InputStream stream = new FileInputStream(dadosFile);
				ArrayList<Player> playersArquivo = (ArrayList<Player>) xStream.fromXML(stream);
				stream.close();
				players[0] = playersArquivo.get(0);
				players[1] = playersArquivo.get(1);
				
				Destrutor.destroyer(stream);
			} catch (Exception e) {
			}
		}
		return players;
	}
	
	public static void atualizarPontuacao(Player player, int idMap) {
		
		ArrayList<Pontuacao> pontuacoes = new ArrayList<Pontuacao>();
		xStream.alias("Pontuacao", Pontuacao.class);
		
		try {
			ArrayList<Pontuacao> pontuacoesArquivo = BaseDados.getPontuacoes();

			boolean gravou = false;

			for(Pontuacao p: pontuacoesArquivo) {
				if(p.getNomePlayer().equalsIgnoreCase(player.getName())) {
					if(p.getPontos() < player.getPoints())
						p.setPontos(player.getPoints());
					gravou = true;
				}
				pontuacoes.add(p);
			}

			if(!gravou) pontuacoes.add(new Pontuacao(player, idMap));

			OutputStream stream = new FileOutputStream(pontuacoesFile);
			xStream.toXML(pontuacoes, stream);
			stream.close();
			Destrutor.destroyer(pontuacoesArquivo);
			Destrutor.destroyer(pontuacoes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Pontuacao> getPontuacoes() {

		xStream.alias("Pontuacao", Pontuacao.class);

		if (pontuacoesFile.exists()) {
			try {
				InputStream stream = new FileInputStream(pontuacoesFile);
				ArrayList<Pontuacao> pontuacaoArquivo = (ArrayList<Pontuacao>) xStream.fromXML(stream);
				stream.close();
				Destrutor.destroyer(stream);
				return pontuacaoArquivo;
			} catch (Exception e) {
				return new ArrayList<Pontuacao>(); 
			}
		}
		return new ArrayList<Pontuacao>();
	}

}
