package com.boulderdash.audio;

import java.io.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.boulderdash.principal.CoordinadorDeEventos;

public class Audio {

	public static void musica(){
		try 
		{
			   File file = new File("./Audio/Theme_Song.wav");
			   Clip clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(file));
			   clip.start();
			   
			   Thread.sleep(clip.getMicrosecondLength());
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
	}
	
	
	
	public static void explosion()
	{
		try 
		{
			   File fileExp = new File("./Audio/Explosion.wav");
			   Clip clipExp = AudioSystem.getClip();
			   clipExp.open(AudioSystem.getAudioInputStream(fileExp));
			   clipExp.start();
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
			   Clip clipExp = AudioSystem.getClip();
			   clipExp.open(AudioSystem.getAudioInputStream(fileExp));
			   clipExp.start();
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
			   Clip clipExp = AudioSystem.getClip();
			   clipExp.open(AudioSystem.getAudioInputStream(fileExp));
			   clipExp.start();
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
			   Clip clipExp = AudioSystem.getClip();
			   clipExp.open(AudioSystem.getAudioInputStream(fileExp));
			   clipExp.start();
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
			   Clip clipExp = AudioSystem.getClip();
			   clipExp.open(AudioSystem.getAudioInputStream(fileExp));
			   clipExp.start();
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
	}
	
	public static void muerte() //Solo para la muerte definitiva
	{
		try 
		{
			   File fileExp = new File("./Audio/Death.wav");
			   Clip clipExp = AudioSystem.getClip();
			   clipExp.open(AudioSystem.getAudioInputStream(fileExp));
			   clipExp.start();
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
	}
}
