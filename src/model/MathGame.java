package model;

public class MathGame {
	
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
