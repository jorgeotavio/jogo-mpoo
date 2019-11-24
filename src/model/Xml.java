package model;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class Xml {

	private ArrayList<Player> players;
	private XStream xStream;
	private File file;

	public Xml() {
		
		xStream = new XStream(new Dom4JDriver());
		xStream.alias("Player", Objeto.class);
		
		file = new File("res/dados.xml");
		players = new ArrayList<>();
	}

	public void salvar(Player player) {
		
		players.add(player);

		try {
			if (!file.exists())
				file.createNewFile();
			else {
				file.delete();
				file.createNewFile();
			}
			
			OutputStream stream = new FileOutputStream(file);
			xStream.toXML(players, stream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Player> ler()
	{
		try {
			if (!file.exists())
				file.createNewFile();
			else {
				return (ArrayList<Player>) xStream.fromXML(file);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
		
	}

	public ArrayList<Player> getObjects() {
		return players;
	}

	public void setObjects(ArrayList<Player> players) {
		this.players = players;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
}