package com.boulderdash.entradasalida;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.boulderdash.audio.Audio;
import com.boulderdash.principal.Comportamiento;

/**
 * Se encarga de cargar y guardar las opciones de configuracion a archivos de texto
 */
public class OpcionesES {

	/**
	 * Devuelve la primera linea del archivo con el nombre recibido
	 */
	private static String leer(String nombreArchivo) 
	{
		try
		{
			BufferedReader buffReader = new BufferedReader(new FileReader("./Archivos/" + nombreArchivo + ".txt"));
		    String linea;
		    linea = buffReader.readLine();
		    buffReader.close();
		    
		    return linea;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Sobreescribe el string recibido en el archivo con el nombre recibido
	 */
	private static void escribir(String nombreArchivo, String mensaje)
	{
		try
		{
			PrintWriter writer = new PrintWriter(("./Archivos/" + nombreArchivo + ".txt"), "UTF-8");
			
			writer.write(mensaje); 
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Chequea los archivos ya que las opciones son persistentes
	 */
	public static void importarOpciones()
	{
		Comportamiento.setMuerteExtra(getMuerteExtra());

		Audio.setMusicaActivada(getMusica());

		Comportamiento.setPiedrasConInercia(getPiedrasConInercia());
		
		MejorPuntuacion.setCantidadAMostrar(getElementosAMostrar());
	}

	/**
	 * Chequea el archivo de piedras con inercia, y devuelve si debe activarlo o no
	 */
	public static boolean getPiedrasConInercia ()
	{
		return (leer("PiedrasConInercia").compareToIgnoreCase("true") == 0);
	}
	
	/**
	 * Guarda en el archivo si la opcion esta activada o no
	 */
	public static void setPiedrasConInercia (boolean bool)
	{
		escribir("PiedrasConInercia", ((Boolean)bool).toString());
	}
	
	/**
	 * Chequea el archivo de muerte, y devuelve si debe activarlo o no
	 */
	public static boolean getMuerteExtra ()
	{
		return (leer("MuerteExtra").compareToIgnoreCase("true") == 0);
	}
	
	/**
	 * Guarda en el archivo si la opcion esta activada o no
	 */
	public static void setMuerteExtra (boolean bool)
	{
		escribir("MuerteExtra", ((Boolean)bool).toString());
	}
	
	/**
	 * Chequea el archivo de nivel, y devuelve el nivel actual
	 */
	public static int getNivel ()
	{
		return Integer.parseInt(leer("Nivel"));
	}
	
	/**
	 * Guarda en el archivo el nivel elegido
	 */
	public static void setNivel (int nivel)
	{
		escribir("Nivel", ((Integer)nivel).toString());
	}
	
	/**
	 * Chequea el archivo de musica, y devuelve si debe activarlo o no
	 */
	public static boolean getMusica ()
	{
		return (leer("Musica").compareToIgnoreCase("true") == 0);
	}
	
	/**
	 * Guarda en el archivo si la opcion esta activada o no
	 */
	public static void setMusica (boolean bool)
	{
		escribir("Musica", ((Boolean)bool).toString());
	}
	
	
	/**
	 * Chequea el archivo de elementos a mostrar, y devuelve la cantidad a mostrar
	 */
	public static int getElementosAMostrar ()
	{
		return Integer.parseInt(leer("Elementos"));
	}
	
	
	/**
	 * Guarda en el archivo la cantidad de elementos a mostrar
	 */
	public static void setElementosAMostrar (int elementos)
	{
		System.out.println("Se introduce " + elementos + " elementos");
		escribir("Elementos", ((Integer)elementos).toString());
	}
}
