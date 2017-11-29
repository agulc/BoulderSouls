package com.boulderdash.entradasalida;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.boulderdash.audio.Audio;
import com.boulderdash.principal.Comportamiento;

public class OpcionesES { //Se encarga de cargar y guardar las opciones de configuracion a archivos de texto

	private static String leer(String nombreArchivo) //devuelve la primera linea del archivo con el nombre recibido
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
	
	
	private static void escribir(String nombreArchivo, String mensaje) //Escribe el string recibido en el archivo con el nombre recibido
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
	
	
	public static void importarOpciones()
	{
		Comportamiento.setMuerteExtra(getMuerteExtra());

		Audio.setMusicaActivada(getMusica());

		Comportamiento.setPiedrasConInercia(getPiedrasConInercia());
		
		MejorPuntuacion.setCantidadAMostrar(getElementosAMostrar());
	}

	
	
	
	
	
	

	//Piedras
	public static boolean getPiedrasConInercia ()
	{
		return (leer("PiedrasConInercia").compareToIgnoreCase("true") == 0);
	}
	
	public static void setPiedrasConInercia (boolean bool)
	{
		escribir("PiedrasConInercia", ((Boolean)bool).toString());
	}
	
	
	
	//Muerte
	public static boolean getMuerteExtra ()
	{
		return (leer("MuerteExtra").compareToIgnoreCase("true") == 0);
	}
	
	public static void setMuerteExtra (boolean bool)
	{
		escribir("MuerteExtra", ((Boolean)bool).toString());
	}
	
	
	
	//Nivel
	public static int getNivel ()
	{
		return Integer.parseInt(leer("Nivel"));
	}
	
	public static void setNivel (int nivel)
	{
		escribir("Nivel", ((Integer)nivel).toString());
	}
	
	
	 
	//Musica
	public static boolean getMusica ()
	{
		return (leer("Musica").compareToIgnoreCase("true") == 0);
	}
	
	public static void setMusica (boolean bool)
	{
		escribir("Musica", ((Boolean)bool).toString());
	}
	
	
	
	///Elementos
	public static int getElementosAMostrar ()
	{
		return Integer.parseInt(leer("Elementos"));
	}
	
	
	public static void setElementosAMostrar (int elementos)
	{
		System.out.println("Se introduce " + elementos + " elementos");
		escribir("Elementos", ((Integer)elementos).toString());
	}
}
