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
			CoordinadorDeEventos.detenerTemporizador();
			   File fileExp = new File("./Audio/OmaeWa.wav");
			   Clip clipExp = AudioSystem.getClip();
			   clipExp.open(AudioSystem.getAudioInputStream(fileExp));
			   clipExp.start();
			   System.out.println("Sleeps");
			   Thread.sleep(4100);
			   CoordinadorDeEventos.iniciarTemporizador();
			   clipExp.stop();
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
	}
	
	public static void title()
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
}
