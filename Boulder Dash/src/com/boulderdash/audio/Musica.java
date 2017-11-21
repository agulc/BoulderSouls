package com.boulderdash.audio;

import java.io.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.audio.*;

public class Musica {
	public static void musica(){
		try {
			   File file = new File("hola.wav");
			   Clip clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(file));
			   clip.start();
			   Thread.sleep(clip.getMicrosecondLength());
			  } catch (Exception e) {
			   System.err.println(e.getMessage());
			  }
	}
}
