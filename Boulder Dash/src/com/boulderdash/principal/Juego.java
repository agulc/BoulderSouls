package com.boulderdash.principal;
import com.boulderdash.audio.Audio;
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
		
	}	
}