package com.boulderdash.principal;

import java.awt.Color;

import javax.swing.JOptionPane;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.Highscore;
import com.boulderdash.entradasalida.OpcionesES;
import com.boulderdash.interfaz.Gui;

public class Juego{
	/**
	 * Programa principal con los movimientos que Rockford
	 * realizará en los niveles 1 y 2.
	 * @param args .
	 */
	public static void main(String args[]){

		OpcionesES.importarOpciones();
		Gui.getInstancia();
		Audio.titulo();
		Audio.musicaMenu();
		Highscore high = new Highscore("",0,0);
		Gui.getInstancia().getNuevoHighscore().menuNuevoHighscore(high);

	}	
}