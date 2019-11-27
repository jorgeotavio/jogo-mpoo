package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class BaseDados {
	private static ArrayList<Data> dados = new ArrayList<>();
	private static XStream xStream = new XStream(new Dom4JDriver());
	private static File file = new File("res/dados.xml");

	public static void atualizar(Player player) {
		xStream.alias("Player", Objeto.class);

		try {
			if (file.exists()) {
				dados = BaseDados.getAllPlayers();
				file.delete();
			}

			for(Data p: dados){
				if(p.nome.equalsIgnoreCase((player.getName()))) {
					dados.set(dados.indexOf(p), new Data(player.getName(), player.getPoints()));
					break;
				}

			}

			file.createNewFile();
			OutputStream stream = new FileOutputStream(file);
			xStream.toXML(dados, stream);
			stream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static class Data{
		
		private String nome;
		private int pontuaca;
		
		public Data(String nome, int pontuacao) {
			this.nome = nome;
			this.pontuaca = pontuacao;
		}
	}
	
	public static void salvar(Player player) {

		xStream.alias("Player", Objeto.class);

		try {
			if (file.exists()) {
				dados = BaseDados.getAllPlayers();
				file.delete();
			} else {
				file.createNewFile();
			}

			dados.add(new Data(player.getName(), player.getPoints()));
			file.createNewFile();

			OutputStream stream = new FileOutputStream(file);
			xStream.toXML(dados, stream);
			stream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Data> getAllPlayers()
	{
		if (file.exists())
			return (ArrayList<Data>) xStream.fromXML(file);
		return new ArrayList<Data>();

	}

	@SuppressWarnings("unchecked")
	public static Player getPlayer(String nick)
	{
		if (file.exists()) {
			ArrayList<Player> players = (ArrayList<Player>) xStream.fromXML(file);
		}

		return null;

	}
}
