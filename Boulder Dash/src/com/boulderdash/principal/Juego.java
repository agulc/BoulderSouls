package com.boulderdash.principal;
import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.OpcionesES;
import com.boulderdash.interfaz.Gui;

/**
 * Clase principal, con ella se cargan las opciones y se inicializan los paneles del gui
 */
public class Juego{
	/**
	 * Programa principal
	 * @param args .
	 */
	public static void main(String args[]){

		OpcionesES.importarOpciones();
		Gui.getInstancia();
		Audio.titulo();
		Audio.musicaMenu();
		
	}	
}