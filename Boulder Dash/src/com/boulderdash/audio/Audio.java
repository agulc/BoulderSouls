package com.boulderdash.audio;

import java.io.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.boulderdash.principal.Mapa;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Audio {

	private static AudioPlayer MGP = AudioPlayer.player;
	private static ContinuousAudioDataStream loop = null;
	private static AudioStream BGM;
	
	public static void musica() 
    {       

        AudioData MD;
        
        try
        {
            InputStream test = new FileInputStream("./Audio/Levels/Level " + Mapa.getInstancia().getNivelActual() + ".wav");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            loop = new ContinuousAudioDataStream(BGM.getData());

        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
        	System.out.print(error.toString());
        }
        MGP.start(loop);

    }
	
	public static void pararMusica(){
		AudioPlayer.player.stop(BGM);
		AudioPlayer.player.stop(loop);
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
			   Audio.pararMusica();
			   File fileExp = new File("./Audio/OmaeWa.wav");
			   Clip clipExp = AudioSystem.getClip();
			   clipExp.open(AudioSystem.getAudioInputStream(fileExp));
			   clipExp.start();
			   Thread.sleep(4500);
		} 
		catch (Exception e) 
		{
			   System.err.println(e.getMessage());
		}
	}
}
