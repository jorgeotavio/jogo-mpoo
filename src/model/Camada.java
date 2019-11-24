package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

public class Camada{
	private int mapa[][];
	private BufferedImage camada;
	private BufferedImage tileSet;
	private int mapaWidth;
	private int mapaHeight;
	private int tileWidth;
	private int tileHeight;
	ArrayList<Rectangle> rectsColisao;
	private boolean camadaColisao;

	public Camada(int mapaWidth, int mapaHeight, int tileWidth, int tileHeight, String img, String arquivo) throws IOException {
		this.mapaWidth=mapaWidth;
		this.mapaHeight=mapaHeight;
		this.tileWidth=tileWidth;
		this.tileHeight=tileHeight;
		mapa = new int[mapaWidth][mapaHeight];
		mapa = carregaMatriz(mapa, arquivo);
		tileSet = ImageIO.read(new File(img));
		this.camadaColisao = false;
	}

	public int[][] carregaMatriz(int[][] matz, String arquivo) throws IOException {
		ArrayList<String> linhasMatrizCamada = new ArrayList<String>();
		InputStream is = new FileInputStream(new File(arquivo));
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader (new InputStreamReader (is));
		String linha="";

			while ((linha = br.readLine()) != null){
				linhasMatrizCamada.add(linha);
			}
			
			int j = 0;
			for (int i = 0; i < linhasMatrizCamada.size(); i++) {
				StringTokenizer token = new StringTokenizer(linhasMatrizCamada.get(i), ",");

				while (token.hasMoreElements()) {
					matz[i][j] = Integer.parseInt(token.nextToken());
					j++;
				}
				j = 0;
			}
			
		return matz;
	}

	public void montarMapa(int lar, int alt) {

		camada = new BufferedImage(lar, alt, BufferedImage.TYPE_4BYTE_ABGR);
		camada.createGraphics();

		int tile;
		int tileRow;
		int tileCol;
		int colunasTileSet=tileSet.getWidth()/tileWidth;
		
		for (int i = 0; i < mapaWidth; i++) {
			for (int j = 0; j < mapaHeight; j++) {
				tile = (mapa[i][j] > 0) ? (mapa[i][j]) : 0;
				tileRow = (tile / (colunasTileSet)) | 0;
				tileCol = (tile % (colunasTileSet)) | 0;
				camada.getGraphics().drawImage(tileSet, (j * tileHeight), (i * tileWidth), (j * tileHeight) + tileHeight,
						(i * tileWidth) + tileWidth, (tileCol * tileHeight), (tileRow * tileWidth),
						(tileCol * tileHeight) + tileHeight, (tileRow * tileWidth) + tileWidth, null);
			}
		}
	}
	
	public ArrayList<Rectangle> colisoes() {
		ArrayList<Rectangle> rectsColisao = new ArrayList<>();
		for (int i = 0; i < mapaWidth; i++) {
			for (int j = 0; j < mapaHeight; j++) {
				if(mapa[i][j] > 0) {
					rectsColisao.add(new Rectangle( (j * tileWidth), (i * tileWidth), tileWidth, tileWidth));
				}
			}
		}
		return rectsColisao;
	}

	public boolean isCamadaColisao() {
		return camadaColisao;
	}

	public void setCamadaColisao(boolean camadaColisao) {
		this.rectsColisao = camadaColisao ? colisoes() : null;
		this.camadaColisao = camadaColisao;
	}

	public ArrayList<Rectangle> getRectsColisao() {
		return rectsColisao;
	}

	public BufferedImage getCamada() {
		return camada;
	}
	
}