package com.boulderdash.audio;

import java.io.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.boulderdash.principal.Mapa;

public class Audio {

	private static Clip clip = null;
	
	public static void musica() 
    { 
		try 
		{
			   File fileExp = new File("./Audio/Levels/Level " + Mapa.getInstancia().getNivelActual() + ".wav");
			   clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(fileExp));
			   clip.start();
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}

    }
	
	public static void musicaMenu() 
    {   
		try 
		{
			   File fileExp = new File("./Audio/Theme_Song.wav");
			   clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(fileExp));
			   clip.start();
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
    }
	
	public static void pararMusica(){
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
}
