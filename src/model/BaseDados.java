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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class BaseDados {

	private static XStream xStream = new XStream(new Dom4JDriver());
	private static File dadosFile = new File("res/dados.xml");
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static File pontuacoesFile = new File("res/pontuacoes.txt");
	private static ArrayList<String[]> pontuacoes = BaseDados.getPontuacoes();

	public static boolean salvarPlayer(Player player) {

		xStream.alias("Player", Objeto.class);
		try {
			ArrayList<Player> playersArquivo = BaseDados.lerArquivo();

			boolean existe = false;

			for(Player p: playersArquivo) {
				if(p.getName().equalsIgnoreCase(player.getName())) {
					p.setPoints(player.getPoints());					
					existe = true;
				}
			}

			if(!existe) players.add(player);

			OutputStream stream = new FileOutputStream(dadosFile);
			xStream.toXML(players, stream);
			stream.close();
			return true;

		} catch (IOException e) {
			return false;
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
	}

	public static ArrayList<String[]> getPontuacoes() {
		
		ArrayList<String[]> pontuacoes = new ArrayList<String[]>();
		ArrayList<String> linhasArquivo = new ArrayList<String>();

		InputStream is;
		try {
			is = new FileInputStream(pontuacoesFile);

			BufferedReader br = new BufferedReader (new InputStreamReader (is));
			String linha="";

			try {
				while ((linha = br.readLine()) != null)
					linhasArquivo.add(linha);				
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int i=0; i < linhasArquivo.size(); i++) {

				StringTokenizer token = new StringTokenizer(linhasArquivo.get(i), ",");

				String[] dados = new String[3];
				
				int j=0;
				
				while(token.hasMoreElements()) {
					dados[j] = token.nextToken();
					j++;
				}
				pontuacoes.add(dados);
			}
			return pontuacoes;
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	public static void gravarPontuacao(Player player) {
		
		pontuacoes = BaseDados.getPontuacoes();
	
		boolean gravou = false;
		
		try {

			FileWriter arq = new FileWriter(pontuacoesFile);
			BufferedWriter gravarArq = new BufferedWriter(arq);
			
			for(String[] p: pontuacoes) {

				if(p[0].equalsIgnoreCase(player.getName())) {
					
					if(Integer.parseInt(p[1]) < player.getPoints()) {
						gravarArq.write(player.getName()+","+Integer.toString(player.getPoints())+",1");
					}else {
						gravarArq.write(player.getName()+","+p[1]+",1");
					}
					gravou=true;
				} else 
					gravarArq.write(p[0]+","+p[1]+","+p[2]);
				gravarArq.newLine();
			}

			if (!gravou) {
				gravarArq.write(player.getName()+","+Integer.toString(player.getPoints())+",1");
				gravarArq.newLine();
			}
			gravarArq.close();
			pontuacoes = BaseDados.getPontuacoes();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Player> lerArquivo() {
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
