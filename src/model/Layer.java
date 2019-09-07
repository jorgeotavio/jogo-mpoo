package model;

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

public class Layer{
	public  int map[][];
	public  BufferedImage camada;
	private BufferedImage tileSet;
	private int mapWidth;
	private int mapHeight;
	private int tileWidth;
	private int tileHeight;

	public Layer(int mapWidth, int mapHeight, int tileWidth, int tileHeight, String img, String file) throws IOException {
		this.mapWidth=mapWidth;
		this.mapHeight=mapHeight;
		this.tileWidth=tileWidth;
		this.tileHeight=tileHeight;
		map = new int[mapWidth][mapHeight];
		map = loadMatrix(map, file);
		
		tileSet = ImageIO.read(new File(img));
	}

	public int[][] loadMatrix(int[][] matz, String file) throws IOException {
		ArrayList<String> linhasMatrizCamada = new ArrayList<String>();
		InputStream is = new FileInputStream(new File(file));
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

	public void mountMap(int lar, int alt) {

		camada = new BufferedImage(lar, alt, BufferedImage.TYPE_4BYTE_ABGR);
		camada.createGraphics();

		int tile;
		int tileRow;
		int tileCol;
		int colunasTileSet=tileSet.getWidth()/tileWidth;
		
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				tile = (map[i][j] != 0) ? (map[i][j]) : 0;
				tileRow = (tile / (colunasTileSet)) | 0;
				tileCol = (tile % (colunasTileSet)) | 0;
				camada.getGraphics().drawImage(tileSet, (j * tileHeight), (i * tileWidth), (j * tileHeight) + tileHeight,
						(i * tileWidth) + tileWidth, (tileCol * tileHeight), (tileRow * tileWidth),
						(tileCol * tileHeight) + tileHeight, (tileRow * tileWidth) + tileWidth, null);
			}
		}
	}
}