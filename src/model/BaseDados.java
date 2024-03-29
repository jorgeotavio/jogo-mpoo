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
	private static File pontuacoesFile = new File("pontuacoes.xml");
	
	public static void atualizarPontuacao(Hero hero, double idPartida) {
		
		ArrayList<Pontuacao> pontuacoes = new ArrayList<Pontuacao>();
		xStream.alias("Pontuacao", Pontuacao.class);
		
		try {
			ArrayList<Pontuacao> pontuacoesArquivo = BaseDados.getPontuacoes();

			boolean gravou = false;

			for(Pontuacao p: pontuacoesArquivo) {
				if(p.getIdPartida() == idPartida && p.getNomePlayer().equalsIgnoreCase(hero.getNome())) {
					if(p.getPontos() < hero.getPontos()) {
						p.setPontos(hero.getPontos());
						p.setTotalInventario(hero.getInventary().size());
					}
					gravou = true;
				}
				pontuacoes.add(p);
			}

			if(!gravou) pontuacoes.add(new Pontuacao(hero, idPartida));

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
	
	@SuppressWarnings("unchecked")
	public static int getPontuacao(int indexHero, double idPartida) {

		xStream.alias("Pontuacao", Pontuacao.class);

		if (pontuacoesFile.exists()) {
			try {
				InputStream stream = new FileInputStream(pontuacoesFile);
				ArrayList<Pontuacao> pontuacaoArquivo = (ArrayList<Pontuacao>) xStream.fromXML(stream);
				stream.close();
				Destrutor.destroyer(stream);
				return pontuacaoArquivo.get(indexHero).getPontos();
			} catch (Exception e) {
				return 0; 
			}
		}
		return 0;
	}

}
