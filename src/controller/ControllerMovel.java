package controller;

import model.Sprite;

public abstract class ControllerMovel {
	
	protected int up, down, left, right;
	protected Sprite sprite;
	protected int velocidade=4;
	protected static final int VELOCIDADE = 2;
	protected static final int ALTURA_TELA = 130;
	protected static final int LARGURA_TELA = 610;
	
}
