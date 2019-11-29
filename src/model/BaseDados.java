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
	private static File file = new File("res/dados.xml");
	private static ArrayList<Player> players = BaseDados.lerArquivo();
	
	public static boolean atualizar(Player player) {
		
		for(Player p: players){
			if(p.getName().equalsIgnoreCase((player.getName()))) {
				p.setPoints(player.getPoints());
				return true;
			}
		}

		return false;
	}

	public static void salvarPlayer(Player player) {
		
		ArrayList<Player> novosPlayers = BaseDados.lerArquivo();
		
		xStream.alias("Player", Objeto.class);

		try {
			
			if (file.exists()) file.delete();
			
			file.createNewFile();
			
			novosPlayers.add(player);

			OutputStream stream = new FileOutputStream(file);
			xStream.toXML(novosPlayers, stream);
			stream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void salvarPlayers(ArrayList<Player> players) {
		
		ArrayList<Player> playersArquivo = BaseDados.lerArquivo();
		
		for(Player p1: playersArquivo) {
			for(Player p2: players) {
				if(p1.getName().equalsIgnoreCase(p2.getName())) {
					System.out.println(p1.getPoints());
					p1.setPoints(p2.getPoints());
					System.out.println(p1.getPoints());
					p1.getInventary().setItems(p2.getInventary().getItems());
					System.out.println(p2.getInventary().getItems().size());
					salvarPlayer(p1);
				}
			}
		}
		//System.out.println(playersArquivo.size());
		
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Player> lerArquivo() {
		if (file.exists()) {
			try {
				InputStream stream = new FileInputStream(file);
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
	
	public static ArrayList<Player> getPlayers() {
		return players;
	}	
}
