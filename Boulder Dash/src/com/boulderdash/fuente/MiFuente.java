package com.boulderdash.fuente;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Clase utilizada para modelizar la fuente del texto usado en el juego
 */
public class MiFuente {
	
	private static Font fuente = null;	   
	private static InputStream myStream = null;
	{
	
	}
	
	public static Font getFuente(int size)
	{
		try {
			myStream = new BufferedInputStream(new FileInputStream("src/com/boulderdash/fuente/OptimusPrinceps.ttf"));
			fuente = Font.createFont(Font.TRUETYPE_FONT, myStream );
	        fuente = fuente.deriveFont(Font.BOLD, size);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fuente;
	}

}
