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

	private List<Player> players;
	private XStream xStream;
	private File file;

	public Xml() {

		xStream = new XStream(new Dom4JDriver());
		xStream.alias("Player", Player.class);
		
		file = new File("res/players.xml");
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
	public List<Player> ler()
	{
		try {
			if (!file.exists())
				file.createNewFile();
			else {
				return (List<Player>) xStream.fromXML(file);				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
//	public static void main(String[] args) {
//		
//		Xml xml = new Xml();
//		
//		xml.setQuestaos(xml.ler());
//		
//		xml.salvar(new Questao(1, 1, 2));
//		xml.salvar(new Questao(2, 2, 4));
//		
//		System.out.println(xml.ler());
//		
//	}
	
	

}
