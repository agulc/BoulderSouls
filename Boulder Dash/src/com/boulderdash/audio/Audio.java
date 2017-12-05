package com.boulderdash.audio;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.boulderdash.principal.Mapa;

/**
 * Clase que contiene todos los metodos para la musica del juego y efectos.
 */
public class Audio {

	private static Clip clip = null;
	
	private static boolean musicaActivada = true;
	
	/**
	 * Utilizado para inicializar la musica del nivel, dependiendo del nivel elegido, y ponerla en loop.
	 */
	public static void musica() 
    { 
		if (musicaActivada)
		{
			try 
			{
				File fileExp;
				if (Mapa.getInstancia().getNivelActual() < 6) //Por cuestiones de peso de los archivos, las canciones se repiten a partir del nivel 6
					fileExp = new File("./Audio/Levels/Level " + Mapa.getInstancia().getNivelActual() + ".wav");
				else
					fileExp = new File("./Audio/Levels/Level " + (Mapa.getInstancia().getNivelActual()-5) + ".wav");
				
				   clip = AudioSystem.getClip();
				   clip.open(AudioSystem.getAudioInputStream(fileExp));
				   clip.loop(Clip.LOOP_CONTINUOUSLY);
			} 
			catch (Exception e) 
			{
				   System.err.println(e.getMessage());
			}
		}
    }
	
	/**
	 * Utilizado para inicializar la musica del menu y ponerla en loop.
	 */
	public static void musicaMenu() 
    {   
		if (musicaActivada)
		{
			try 
			{
				   File fileExp = new File("./Audio/Theme_Song.wav");
				   clip = AudioSystem.getClip();
				   clip.open(AudioSystem.getAudioInputStream(fileExp));
				   clip.loop(Clip.LOOP_CONTINUOUSLY);
			} 
			catch (Exception e) 
			{
				   System.err.println(e.getMessage());
			}
		}
    }
	
	/**
	 * Permite parar la musica, ya sea la del nivel o la del menu.
	 */
	public static void pararMusica(){
		if (clip != null)
			clip.stop();
	}
	
	
	/**
	 * Ejecuta el audio de la explosion 1 vez.
	 */
	public static void explosion()
	{
		try 
		{
			   File fileExp = new File("./Audio/Explosion.wav");
			   Clip clipAux = AudioSystem.getClip();
			   clipAux.open(AudioSystem.getAudioInputStream(fileExp));
			   clipAux.start();
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Ejecuta el audio de juntar un diamante 1 vez.
	 */
	public static void item()
	{
		try 
		{
			   File fileExp = new File("./Audio/PickUpItem.wav");
			   Clip clipAux = AudioSystem.getClip();
			   clipAux.open(AudioSystem.getAudioInputStream(fileExp));
			   clipAux.start();
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Ejecuta un audio al inicializar el juego, que dice boulder dash en japones, una unica vez.
	 */
	public static void titulo()
	{
		try 
		{
			   File fileExp = new File("./Audio/Title.wav");
			   Clip clipAux = AudioSystem.getClip();
			   clipAux.open(AudioSystem.getAudioInputStream(fileExp));
			   clipAux.start();
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Ejecuta un audio de victoria, al entrar a la puerta de salida y pasar de nivel o ganar el juego.
	 */
	public static void victoria()
	{
		try 
		{
			   File fileExp = new File("./Audio/Victory.wav");
			   Clip clipAux = AudioSystem.getClip();
			   clipAux.open(AudioSystem.getAudioInputStream(fileExp));
			   clipAux.start();
			   Thread.sleep(1000);
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Ejecuta un audio cuando la puerta se abre, al juntar los diamantes necesarios.
	 */
	public static void puertaAbierta()
	{
		try 
		{
			   File fileExp = new File("./Audio/DoorOpened.wav");
			   Clip clipAux = AudioSystem.getClip();
			   clipAux.open(AudioSystem.getAudioInputStream(fileExp));
			   clipAux.start();
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Ejecuta un audio relacionado con la muerte especial.
	 */
	public static void muerteExtra() 
	{
		try 
		{
			   Audio.pararMusica();
			   File fileExp = new File("./Audio/OmaeWa.wav");
			   Clip clipAux = AudioSystem.getClip();
			   clipAux.open(AudioSystem.getAudioInputStream(fileExp));
			   clipAux.start();
			   Thread.sleep(4500);
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Ejecuta el audio de muerte de dark souls.
	 */
	public static void hasMuerto() //Para la ventana con el mensaje
	{
		try 
		{
			   Audio.pararMusica();
			   File fileExp = new File("./Audio/Has Muerto.wav");
			   Clip clipAux = AudioSystem.getClip();
			   clipAux.open(AudioSystem.getAudioInputStream(fileExp));
			   clipAux.start();
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Devuelve si la musica esta sonando o no.
	 */
	public static boolean getMusicaActivada() {
		return musicaActivada;
	}

	
	public static void setMusicaActivada(boolean bool) {
		System.out.println("Audio: " + bool);
		musicaActivada = bool;
	}
}
