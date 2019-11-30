package model;

public class Destrutor {
	public static void destroyer(Object obj){
		obj = null;
		System.gc();
	}
}