package model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Som {
	private static URL url = Som.class.getResource("/sounds/pegar_objeto.wav");
	public static AudioClip pegarObjeto = Applet.newAudioClip(url);
}
