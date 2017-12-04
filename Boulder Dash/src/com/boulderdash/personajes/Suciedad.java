package com.boulderdash.personajes;

import javax.swing.ImageIcon;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;

/**
 * Clase utilizada para modelizar a la suciedad
 */
public class Suciedad extends Personaje {
	
	private static ImageIcon icono = new ImageIcon("Texturas/dirt.gif");
	
	public Suciedad(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return true;
	}

	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.DIRT);
	}

	@Override
	public ImageIcon getGraficos() {
		return icono;
	}
}
