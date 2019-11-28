package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class BaseDados {
	
	private static XStream xStream = new XStream(new Dom4JDriver());
	private static File file = new File("res/dados.xml");
	private static ArrayList<Player> players = BaseDados.getPlayers();
	
	public static boolean atualizar(Player player) {
		
		xStream.alias("Player", Objeto.class);
		
		for(Player p: players){
			if(p.getName().equalsIgnoreCase((player.getName()))) {
				p.setPoints(player.getPoints());
				return true;
			}
		}

		return false;
	}

	public static void salvar(Player player) {

		xStream.alias("Player", Objeto.class);

		try {
			
			if (file.exists()) file.delete();
			else file.createNewFile();

			if (!BaseDados.atualizar(player))
				players.add(player);

			OutputStream stream = new FileOutputStream(file);
			xStream.toXML(players, stream);
			stream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Player> getPlayers() {
		if (file.exists())
			return (ArrayList<Player>) xStream.fromXML(file);
		return new ArrayList<Player>();
	}	
}
