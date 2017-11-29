package com.boulderdash.audio;

import java.io.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.boulderdash.principal.Mapa;

public class Audio {

	private static Clip clip = null;
	
	private static boolean musicaActivada = true;
	
	public static void musica() 
    { 
		if (musicaActivada)
		{
			try 
			{
				File fileExp;
				if (Mapa.getInstancia().getNivelActual() < 6)
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
	
	public static void pararMusica(){
		if (clip != null)
			clip.stop();
	}
	
	
	
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

	public static boolean getMusicaActivada() {
		return musicaActivada;
	}

	public static void setMusicaActivada(boolean bool) {
		System.out.println("Audio: " + bool);
		musicaActivada = bool;
	}
}
