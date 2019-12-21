package model;

import java.util.ArrayList;

public class MathGame {

	public static boolean verificarNumero(int numero, String tipo) {
		switch (tipo) {
		case "PARES":
			return verificarPar(numero);
		case "IMPARES":
			return !verificarPar(numero);
		case "PRIMOS":
			return verificarPrimo(numero);
		default:
			return false;
		}
	}
	
	public static int totalDeObjetivosValidos(ArrayList<ObjetoNoMapa> objetos) {
		int total = 0;
		for (ObjetoNoMapa obj: objetos) if(obj.isObjetivo()) total ++;
		return total;
	}

	public static boolean verificarPrimo(int numero) {
		for (int j = 2; j < numero; j++) {
			if (numero % j == 0)
				return false;   
		}
		return true;
	}

	public static boolean verificarPar(int numero) {
		if (numero % 2 == 0) 
			return true; 

		return false;
	}
}
